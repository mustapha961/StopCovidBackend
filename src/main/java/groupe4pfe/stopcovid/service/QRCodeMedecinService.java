package groupe4pfe.stopcovid.service;

import groupe4pfe.stopcovid.Utils.FCMService;
import groupe4pfe.stopcovid.dto.response.QRCodesMedecinResponse;
import groupe4pfe.stopcovid.exceptions.QRCodeMedecinException;
import groupe4pfe.stopcovid.exceptions.QrCodeAlreadyScannedException;
import groupe4pfe.stopcovid.exceptions.UnauthorizeException;
import groupe4pfe.stopcovid.model.*;
import groupe4pfe.stopcovid.model.indentities.ScanQrCodeMedecinIndentity;
import groupe4pfe.stopcovid.repository.CitoyenRepository;
import groupe4pfe.stopcovid.repository.QRCodeMedecinRepository;
import groupe4pfe.stopcovid.repository.ScanQRCodeEtablissementRepository;
import groupe4pfe.stopcovid.repository.ScanQRCodeMedecinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Duration;
import java.time.Instant;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class QRCodeMedecinService {

    @Autowired
    private QRCodeMedecinRepository qRCodeMedecinRepository;
    @Autowired
    private ScanQRCodeMedecinRepository scanQRCodeMedecinRepository;
    @Autowired
    private ScanQRCodeEtablissementRepository scanQRCodeEtablissementRepository;
    @Autowired
    private CitoyenRepository citoyenRepository;
    @Autowired
    private AuthService authService;
    @Autowired
    private FCMService fcmService;


    @Transactional
    public List<QRCodesMedecinResponse> addQRCodesMedecin(String nbrQRCode){
        List<QRCodesMedecinResponse> listQRCodes = new ArrayList<QRCodesMedecinResponse>();
        Medecin medecin = authService.getCurrentMedecin();
        if(medecin != null) {
            for (int i = 0; i < Integer.parseInt(nbrQRCode); i++) {
                String contenu = UUID.randomUUID().toString();
                QRCodeMedecin QRCodeMedecin = new QRCodeMedecin(medecin, contenu);
                qRCodeMedecinRepository.save(QRCodeMedecin);
                QRCodesMedecinResponse QRCodeResponse = new QRCodesMedecinResponse(contenu);
                listQRCodes.add(QRCodeResponse);
            }
            return listQRCodes;
        }
        throw new QRCodeMedecinException("Vous n'avez pas le droit de réaliser ce type d'action");
    }

    @Transactional
    public QRCodeMedecin getQrCodeMedecinFromQrCode(String qrCode){
        return qRCodeMedecinRepository.findByContenu(qrCode).orElse(null);
    }

    @Transactional
    public Citoyen scanQrCodeMedecin(QRCodeMedecin qrCodeMedecin){
        Citoyen citoyen = authService.getCurrentCitoyen();
        if(citoyen != null){
            ScanQrCodeMedecinIndentity scanQrCodeMedecinIndentity = new ScanQrCodeMedecinIndentity(citoyen,qrCodeMedecin);
            if(scanQRCodeMedecinRepository.findByScanQrCodeMedecinIndentity(scanQrCodeMedecinIndentity) != null)
                throw new QrCodeAlreadyScannedException("QR code déjà utilisé veuillez en scanner un autre");

            scanQRCodeMedecinRepository.save(new ScanQRCodeMedecin(scanQrCodeMedecinIndentity, new Date()));
            Instant now = Instant.now(); //current date
            Instant before = now.minus(Duration.ofDays(10));
            Date dateBefore = Date.from(before);
            List<ScanQRCodeEtablissement> scanQRCodeEtablissementList = scanQRCodeEtablissementRepository
                    .findAllByCitoyenAndDateEntreeAfter(citoyen,dateBefore);

            List<Lieu> lieuVisitesDuCitoyen = scanQRCodeEtablissementList.stream()
                    .map(scanQRCode -> scanQRCode.getLieu() )
                    .collect(Collectors.toList());


            List<ScanQRCodeEtablissement> scanQRCodeEtablissementList2 = scanQRCodeEtablissementRepository
                    .findAllByLieuIn(lieuVisitesDuCitoyen);

            List<Citoyen> citoyensANotifier = new ArrayList<Citoyen>();

            for(ScanQRCodeEtablissement scanEtaContamine : scanQRCodeEtablissementList){
                for(ScanQRCodeEtablissement scanEta : scanQRCodeEtablissementList2){
                    if(scanEta.getLieu().equals(scanEtaContamine.getLieu())){
                        if(aEteEnContact(scanEta.getDate_entree(),scanEtaContamine.getDate_entree())){
                            citoyensANotifier.add(scanEta.getCitoyen());
                        }
                    }
                }
            }

            citoyensANotifier.remove(citoyen);
            citoyensANotifier.forEach(c -> c.setEtat(EtatCitoyen.POTENTIELLEMENT_MALADE));
            citoyenRepository.saveAll(citoyensANotifier);
            citoyen.setEtat(EtatCitoyen.MALADE);
            citoyen = citoyenRepository.save(citoyen);
            List<String> tokensDevices = citoyensANotifier.stream().map(c->c.getDeviceToken()).collect(Collectors.toList());


            if(tokensDevices.size() > 0)
                fcmService.sendNotifications(tokensDevices);
            return citoyen;
        }

        throw new UnauthorizeException("Vous n' y avez pas accés");
    }

    private boolean aEteEnContact(Date d1, Date d2) {
        long difference_In_Time = d2.getTime() - d1.getTime();
        if(difference_In_Time <=0 ){
            Date temp = d1;
            d1 = d2;
            d2 = temp;
            difference_In_Time = d2.getTime() - d1.getTime();
        }
        long difference_In_Hours = (difference_In_Time / (1000 * 60 * 60)) % 24;
        long difference_In_Days = (difference_In_Time / (1000 * 60 * 60 * 24)) % 365;
        if(difference_In_Days <= 10 && difference_In_Hours <=1)
            return true;
        return false;
    }


}
