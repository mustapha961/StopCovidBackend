package groupe4pfe.stopcovid.repository;

import groupe4pfe.stopcovid.model.Medecin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedecinRepository extends CrudRepository<Medecin, Long> {

    Optional<Medecin> findByEmail(String email);

}
