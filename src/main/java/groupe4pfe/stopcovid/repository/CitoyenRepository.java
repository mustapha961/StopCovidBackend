package groupe4pfe.stopcovid.repository;

import groupe4pfe.stopcovid.model.Citoyen;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitoyenRepository extends CrudRepository<Citoyen, UUID> {
  @Override
  Optional<Citoyen> findById(UUID id);

  @Override
  List<Citoyen> findAll();
}
