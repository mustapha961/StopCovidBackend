package groupe4pfe.stopcovid.repository;

import groupe4pfe.stopcovid.model.Citoyen;
import groupe4pfe.stopcovid.model.QRCodeMedecin;
import groupe4pfe.stopcovid.model.ScanQRCodeMedecin;
import groupe4pfe.stopcovid.model.indentities.ScanQrCodeMedecinIndentity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScanQRCodeMedecinRepository extends CrudRepository<ScanQRCodeMedecin, ScanQrCodeMedecinIndentity> {

    ScanQRCodeMedecin findByScanQrCodeMedecinIndentity(ScanQrCodeMedecinIndentity scanQrCodeMedecinIndentity);

}
