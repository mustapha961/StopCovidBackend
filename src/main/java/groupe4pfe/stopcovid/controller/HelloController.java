package groupe4pfe.stopcovid.controller;

import groupe4pfe.stopcovid.model.Medecin;
import groupe4pfe.stopcovid.service.AuthService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class HelloController {

  @Autowired
  private AuthService authService;



  @GetMapping("/env")
  @CrossOrigin
  public String test3() {
    Map<String, String> env = System.getenv();
    return env.get("env") + " ENVIRONMENT ";
  }
}
