package groupe4pfe.stopcovid.controller;

import groupe4pfe.stopcovid.model.Citoyen;
import groupe4pfe.stopcovid.model.EtatCitoyen;
import groupe4pfe.stopcovid.service.CitoyenService;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class CitoyenController {

  @Autowired
  private CitoyenService citoyenServ;

  @GetMapping("/ok")
  @CrossOrigin
  public Citoyen test2() {
    Citoyen citoyen = citoyenServ.addCitoyen(
      new Citoyen(UUID.randomUUID(), EtatCitoyen.EN_BONNE_SANTE)
    );
    return citoyen;
  }

  @GetMapping("")
  @CrossOrigin
  public List<Citoyen> test() {
    return citoyenServ.getAllCitoyens();
  }
}
