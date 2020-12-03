package groupe4pfe.stopcovid.repository;

import groupe4pfe.stopcovid.model.QRCodeMedecin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QRCodeMedecinRepository
  extends CrudRepository<QRCodeMedecin, Long> {}
