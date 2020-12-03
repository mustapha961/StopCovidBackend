package groupe4pfe.stopcovid.service;

import groupe4pfe.stopcovid.model.Citoyen;
import groupe4pfe.stopcovid.repository.CitoyenRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitoyenService {

  @Autowired
  private CitoyenRepository citoyenRepository;

  @Transactional
  public Citoyen addCitoyen(Citoyen citoyen) {
    Citoyen newCitoyen = citoyenRepository.save(citoyen);
    return newCitoyen;
  }

  @Transactional
  public List<Citoyen> getAllCitoyens() {
    List<Citoyen> users = citoyenRepository.findAll();
    return users;
  }
}
