package groupe4pfe.stopcovid.repository;

import groupe4pfe.stopcovid.model.Lieu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LieuRepository extends CrudRepository<Lieu, Long> {}
