package groupe4pfe.stopcovid.repository;

import groupe4pfe.stopcovid.dto.LieuxQrCodeDto;
import groupe4pfe.stopcovid.model.Lieu;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface LieuRepository extends CrudRepository<Lieu, Long> {


    List<Lieu> findAllByEtablissementId(Long idEtablissement);

}
