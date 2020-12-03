package groupe4pfe.stopcovid.repository;

import groupe4pfe.stopcovid.model.ScanQRCodeEtablissement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScanQRCodeEtablissementRepository
  extends CrudRepository<ScanQRCodeEtablissement, Long> {}
