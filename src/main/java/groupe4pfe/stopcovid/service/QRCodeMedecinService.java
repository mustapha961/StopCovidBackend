package groupe4pfe.stopcovid.service;

import groupe4pfe.stopcovid.Utils.FCMService;
import groupe4pfe.stopcovid.dto.response.QRCodesMedecinResponse;
import groupe4pfe.stopcovid.dto.response.ScanResponse;
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

            before = now.minus(Duration.ofHours(1));
            Instant after = now.plus(Duration.ofHours(1));

            List<ScanQRCodeEtablissement> scanQRCodeEtablissementList2 = scanQRCodeEtablissementRepository
                    .findAllByLieuInAndDateEntreeBetween(lieuVisitesDuCitoyen,Date.from(before),Date.from(after));

            List<Citoyen> citoyensANotifier = scanQRCodeEtablissementList2.stream()
                    .map(scanQRCode -> scanQRCode.getCitoyen())
                    .distinct()
                    .collect(Collectors.toList());

            citoyensANotifier.forEach(c -> c.setEtat(EtatCitoyen.POTENTIELLEMENT_MALADE));
            citoyensANotifier.remove(citoyen);
            citoyenRepository.saveAll(citoyensANotifier);
            citoyen.setEtat(EtatCitoyen.MALADE);
            citoyen = citoyenRepository.save(citoyen);
            List<String> tokensDevices = citoyensANotifier.stream().map(c->c.getDeviceToken()).collect(Collectors.toList());
            System.out.println(citoyensANotifier);
            fcmService.sendNotifications(tokensDevices);
            return citoyen;

        }

        throw new UnauthorizeException("Vous n' y avez pas accés");
    }


}
