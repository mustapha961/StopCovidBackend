package groupe4pfe.stopcovid.repository;

import groupe4pfe.stopcovid.model.Citoyen;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CitoyenRepository extends CrudRepository<Citoyen, UUID> {
    @Override
    Optional<Citoyen> findById(UUID id);

    @Override
    List<Citoyen> findAll();
}
