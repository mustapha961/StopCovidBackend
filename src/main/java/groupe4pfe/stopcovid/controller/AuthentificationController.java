package groupe4pfe.stopcovid.controller;

import groupe4pfe.stopcovid.dto.LoginRequest;
import groupe4pfe.stopcovid.dto.RegisterRequestEtablissementDto;
import groupe4pfe.stopcovid.dto.RegisterRequestMedecinDto;
import groupe4pfe.stopcovid.dto.response.AuthentificationResponse;
import groupe4pfe.stopcovid.dto.response.LoginResponse;
import groupe4pfe.stopcovid.dto.response.ResponseError;
import groupe4pfe.stopcovid.exceptions.LoginException;
import groupe4pfe.stopcovid.exceptions.RegisterException;
import groupe4pfe.stopcovid.model.Medecin;
import groupe4pfe.stopcovid.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@RestController
@RequestMapping("/api/auth")
public class AuthentificationController {

  @Autowired
  private AuthService authService;

  @PostMapping("/register/medecin")
  @CrossOrigin
  public ResponseEntity<?> signupMedecin(
    @RequestBody RegisterRequestMedecinDto registermedecin
  ) {
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
          @RequestBody RegisterRequestEtablissementDto registermedecin
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
  public ResponseEntity<AuthentificationResponse> signupCitoyen() {

    return ResponseEntity.status(OK).body(authService.signUpCitoyen());
  }

  @PostMapping("/login/medecin")
  @CrossOrigin
  public ResponseEntity<?> loginMedecin(@RequestBody LoginRequest loginRequest){
    try{
      LoginResponse loginResponse =authService.loginMedecin(loginRequest);
      return ResponseEntity.status(OK).body(loginResponse);
    }catch (LoginException e){
      return ResponseEntity.status(UNAUTHORIZED).body(new ResponseError(e.getMessage()));
    }

  }

  @PostMapping("/login/etablissement")
  @CrossOrigin
  public ResponseEntity<?> loginEtablissement(@RequestBody LoginRequest loginRequest){
    try{
      LoginResponse loginResponse = authService.loginEtablissement(loginRequest);
      return ResponseEntity.status(OK).body(authService.loginEtablissement(loginRequest));
    }catch (LoginException e){
      return ResponseEntity.status(UNAUTHORIZED).body(new ResponseError(e.getMessage()));
    }
  }



}
