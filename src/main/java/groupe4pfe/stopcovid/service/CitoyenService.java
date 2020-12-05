package groupe4pfe.stopcovid.service;

import groupe4pfe.stopcovid.dto.response.CitoyenResponse;
import groupe4pfe.stopcovid.exceptions.CitoyenNotFoundException;
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

  @Autowired
  private AuthService authService;

  @Transactional
  public CitoyenResponse getCitoyenViaToken(){
    Citoyen citoyen = authService.getCurrentCitoyen();
    if(citoyen != null)
      return new CitoyenResponse(citoyen.getId().toString(),citoyen.getEtat().getEtat());
    throw new CitoyenNotFoundException("Ce citoyen n'existe pas");
  }

  @Transactional
  public Citoyen addCitoyen(Citoyen citoyen) {
    Citoyen newCitoyen = citoyenRepository.save(citoyen);
    return newCitoyen;
  }


}
