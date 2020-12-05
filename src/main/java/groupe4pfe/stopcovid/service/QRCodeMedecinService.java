package groupe4pfe.stopcovid.service;

import groupe4pfe.stopcovid.dto.response.QRCodesMedecinResponse;
import groupe4pfe.stopcovid.exceptions.QRCodeMedecinException;
import groupe4pfe.stopcovid.exceptions.UnauthorizeException;
import groupe4pfe.stopcovid.model.Medecin;
import groupe4pfe.stopcovid.model.QRCodeMedecin;
import groupe4pfe.stopcovid.repository.QRCodeMedecinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class QRCodeMedecinService {

    @Autowired
    private QRCodeMedecinRepository QRCodeMedecinRepository;

    @Autowired
    private AuthService authService;


    @Transactional
    public List<QRCodesMedecinResponse> addQRCodesMedecin(String nbrQRCode){
        List<QRCodesMedecinResponse> listQRCodes = new ArrayList<QRCodesMedecinResponse>();
        Medecin medecin = authService.getCurrentMedecin();
        if(medecin != null) {
            for (int i = 0; i < Integer.parseInt(nbrQRCode); i++) {
                UUID contenu = UUID.randomUUID();
                QRCodeMedecin QRCodeMedecin = new QRCodeMedecin(medecin, contenu);
                QRCodeMedecinRepository.save(QRCodeMedecin);
                QRCodesMedecinResponse QRCodeResponse = new QRCodesMedecinResponse(contenu.toString());
                listQRCodes.add(QRCodeResponse);
            }
            return listQRCodes;
        }
        throw new QRCodeMedecinException("Vous n'avez pas le droit de réaliser ce type d'action");
    }
}
