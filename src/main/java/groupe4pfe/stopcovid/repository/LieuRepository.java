package groupe4pfe.stopcovid.repository;

import groupe4pfe.stopcovid.model.Lieu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface LieuRepository extends CrudRepository<Lieu, Long> {

    List<Lieu> findAllByEtablissementId(Long idEtablissement);

    Optional<Lieu> findByQrCode(String qrCode);

}
