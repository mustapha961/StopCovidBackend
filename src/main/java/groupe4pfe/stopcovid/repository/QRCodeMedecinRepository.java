package groupe4pfe.stopcovid.repository;

import groupe4pfe.stopcovid.model.QRCodeMedecin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface QRCodeMedecinRepository extends CrudRepository<QRCodeMedecin, Long> {

    Optional<QRCodeMedecin> findByContenu(String qrCode);

}
