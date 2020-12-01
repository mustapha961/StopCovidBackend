package groupe4pfe.stopcovid.controller;

import groupe4pfe.stopcovid.model.Citoyen;
import groupe4pfe.stopcovid.model.EtatCitoyen;
import groupe4pfe.stopcovid.service.CitoyenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("")
public class HelloController {



    @GetMapping("")
    @CrossOrigin
    public String test2(){
        return "Hello jeune citoyen";
    }

}
