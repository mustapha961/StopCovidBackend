package groupe4pfe.stopcovid.controller;

import com.google.firebase.messaging.FirebaseMessagingException;
import groupe4pfe.stopcovid.Utils.FCMService;
import groupe4pfe.stopcovid.dto.LoginDto;
import groupe4pfe.stopcovid.dto.RegisterEtablissementDto;
import groupe4pfe.stopcovid.dto.RegisteMedecinDto;
import groupe4pfe.stopcovid.dto.response.AuthentificationResponse;
import groupe4pfe.stopcovid.dto.response.LoginResponse;
import groupe4pfe.stopcovid.dto.response.ResponseError;
import groupe4pfe.stopcovid.exceptions.LoginException;
import groupe4pfe.stopcovid.exceptions.RegisterException;
import groupe4pfe.stopcovid.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@RestController
@RequestMapping("/api/auth")
public class AuthentificationController {

  @Autowired
  private AuthService authService;
  @Autowired
  private FCMService fcmService;

  @PostMapping("/register/medecin")
  @CrossOrigin
  public ResponseEntity<?> signupMedecin(@RequestBody RegisteMedecinDto registermedecin) {
    try{
      AuthentificationResponse authentificationResponse = authService.signUpMedecin(registermedecin);
      return ResponseEntity.status(OK).body(authentificationResponse);
    }catch (RegisterException e){
      return ResponseEntity.status(UNAUTHORIZED).body(new ResponseError(e.getMessage()));
    }


  }

  @PostMapping("/register/etablissement")
  @CrossOrigin
  public ResponseEntity<?> signupEtablissement(
          @RequestBody RegisterEtablissementDto registermedecin
  )
  {
    try{
      AuthentificationResponse authentificationResponse = authService.signUpEtablissement(registermedecin);
      return ResponseEntity.status(OK).body(authentificationResponse);
    }catch (RegisterException e){
      return ResponseEntity.status(UNAUTHORIZED).body(new ResponseError(e.getMessage()));
    }
  }

  @PostMapping("/register/citoyen")
  @CrossOrigin
  public ResponseEntity<AuthentificationResponse> signupCitoyen(@RequestBody String deviceToken) {
    return ResponseEntity.status(OK).body(authService.signUpCitoyen(deviceToken));
  }

  @PostMapping("/login/medecin")
  @CrossOrigin
  public ResponseEntity<?> loginMedecin(@RequestBody LoginDto loginRequest){
    try{
      LoginResponse loginResponse =authService.loginMedecin(loginRequest);
      return ResponseEntity.status(OK).body(loginResponse);
    }catch (LoginException e){
      return ResponseEntity.status(UNAUTHORIZED).body(new ResponseError(e.getMessage()));
    }

  }

  @PostMapping("/login/etablissement")
  @CrossOrigin
  public ResponseEntity<?> loginEtablissement(@RequestBody LoginDto loginRequest){
    try{
      LoginResponse loginResponse = authService.loginEtablissement(loginRequest);
      return ResponseEntity.status(OK).body(authService.loginEtablissement(loginRequest));
    }catch (LoginException e){
      return ResponseEntity.status(UNAUTHORIZED).body(new ResponseError(e.getMessage()));
    }
  }



}
