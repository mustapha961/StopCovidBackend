package groupe4pfe.stopcovid.repository;

import groupe4pfe.stopcovid.model.Etablissement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EtablissementRepository
  extends CrudRepository<Etablissement, Long> {

    Optional<Etablissement> findByEmail(String email);
}
