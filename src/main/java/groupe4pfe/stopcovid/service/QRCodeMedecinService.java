package groupe4pfe.stopcovid.service;

import groupe4pfe.stopcovid.dto.response.QRCodeMedecinResponse;
import groupe4pfe.stopcovid.model.Medecin;
import groupe4pfe.stopcovid.model.QRCodeMedecin;
import groupe4pfe.stopcovid.repository.QRCodeMedecinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
public class QRCodeMedecinService {

    @Autowired
    private QRCodeMedecinRepository QRCodeMedecinRepository;

    @Autowired
    private AuthService authService;


    @Transactional
    public QRCodeMedecinResponse addQRCodeMedecin(){
        UUID contenu = UUID.randomUUID();
        Medecin medecin = authService.getCurrentMedecin ();
        QRCodeMedecin QRCodeMedecin = new QRCodeMedecin(medecin, contenu);
        QRCodeMedecin = QRCodeMedecinRepository.save(QRCodeMedecin);
        return new QRCodeMedecinResponse(contenu.toString());
    }
}
