package groupe4pfe.stopcovid.controller;

import groupe4pfe.stopcovid.dto.response.ResponseError;
import groupe4pfe.stopcovid.exceptions.CitoyenNotFoundException;
import groupe4pfe.stopcovid.model.Citoyen;
import groupe4pfe.stopcovid.model.EtatCitoyen;
import groupe4pfe.stopcovid.service.CitoyenService;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/citoyen")
public class CitoyenController {

  @Autowired
  private CitoyenService citoyenServ;

  @GetMapping("")
  @CrossOrigin
  private ResponseEntity<?> verifyTokenCitoyen(){
    try{
      return ResponseEntity.status(HttpStatus.OK).body(citoyenServ.getCitoyenViaToken());
    }catch (CitoyenNotFoundException e){
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseError(e.getMessage()));
    }

  }

}
