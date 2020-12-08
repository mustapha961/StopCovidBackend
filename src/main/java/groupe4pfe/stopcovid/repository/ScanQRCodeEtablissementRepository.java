package groupe4pfe.stopcovid.repository;

import groupe4pfe.stopcovid.model.Citoyen;
import groupe4pfe.stopcovid.model.Lieu;
import groupe4pfe.stopcovid.model.ScanQRCodeEtablissement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ScanQRCodeEtablissementRepository extends CrudRepository<ScanQRCodeEtablissement, Long> {

    int countByCitoyenAndDateEntreeBetween(Citoyen citoyen, Date date1,Date date2);

    List<ScanQRCodeEtablissement> findAllByCitoyenAndDateEntreeAfter(Citoyen citoyen,Date date);

    List<ScanQRCodeEtablissement> findAllByLieuIn (List<Lieu> lieux);

}
