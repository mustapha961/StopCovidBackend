package groupe4pfe.stopcovid.service;

import groupe4pfe.stopcovid.dto.LoginDto;
import groupe4pfe.stopcovid.dto.RegisterEtablissementDto;
import groupe4pfe.stopcovid.dto.response.LoginResponse;
import groupe4pfe.stopcovid.exceptions.LoginException;
import groupe4pfe.stopcovid.exceptions.RegisterException;
import groupe4pfe.stopcovid.model.EtatCitoyen;
import groupe4pfe.stopcovid.Utils.JwtUtil;
import groupe4pfe.stopcovid.dto.RegisteMedecinDto;
import groupe4pfe.stopcovid.dto.response.AuthentificationResponse;
import groupe4pfe.stopcovid.model.Citoyen;
import groupe4pfe.stopcovid.model.Etablissement;
import groupe4pfe.stopcovid.model.Medecin;
import groupe4pfe.stopcovid.repository.CitoyenRepository;
import groupe4pfe.stopcovid.repository.EtablissementRepository;
import groupe4pfe.stopcovid.repository.MedecinRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class AuthService {

  @Autowired
  private CitoyenRepository citoyenRepository;
  @Autowired
  private MedecinRepository medecinRepository;
  @Autowired
  private EtablissementRepository etablissementRepository;
  @Autowired
  private JwtUtil jwtUtil;
  @Autowired
  private PasswordEncoder passwordEncoder;

  @Transactional
  public AuthentificationResponse signUpMedecin(
    RegisteMedecinDto registerRequestMedecinDto
  ) {

    if(emailAlreadyExists(registerRequestMedecinDto.getEmail()))
      throw new RegisterException("Email already exists");

    String password = passwordEncoder.encode(
      registerRequestMedecinDto.getPassword()
    );
    Medecin medecin = new Medecin(
      registerRequestMedecinDto.getNom(),
      registerRequestMedecinDto.getPrenom(),
      registerRequestMedecinDto.getEmail(),
      password
    );

    medecin = medecinRepository.save(medecin);
    String token = jwtUtil.createToken(registerRequestMedecinDto.getEmail(), medecin.getId().toString(),"medecin");
    return new AuthentificationResponse(token,medecin.getEmail(),null);

  }

  @Transactional
  public AuthentificationResponse signUpEtablissement(RegisterEtablissementDto registerRequestEtablissementDto){
    String password = passwordEncoder.encode(
            registerRequestEtablissementDto.getPassword()
    );

    if(emailAlreadyExists(registerRequestEtablissementDto.getEmail()))
      throw new RegisterException("Email already exists");

    Etablissement etablissement = new Etablissement(
            registerRequestEtablissementDto.getNom(),
            registerRequestEtablissementDto.getAdresse(),
            registerRequestEtablissementDto.getEmail(),
            password);

    etablissement = etablissementRepository.save(etablissement);
    String token = jwtUtil.createToken(etablissement.getEmail(), etablissement.getId().toString(),"etablissement");
    return new AuthentificationResponse(token,etablissement.getEmail(),null);
  }

  public AuthentificationResponse signUpCitoyen(String deviceToken){
    UUID id = UUID.randomUUID();
    Citoyen citoyen = new Citoyen(id,deviceToken ,EtatCitoyen.EN_BONNE_SANTE);
    citoyen = citoyenRepository.save(citoyen);
    String token = jwtUtil.createToken("",citoyen.getId().toString(),"citoyen");
    return new AuthentificationResponse(token,null,citoyen.getId().toString());
  }

  public LoginResponse loginMedecin(LoginDto loginRequest){

    Medecin medecin = medecinRepository.findByEmail(loginRequest.getEmail()).orElseThrow(()-> new LoginException("Email or password does not match"));

    if(passwordEncoder.matches(loginRequest.getPassword(),medecin.getMot_de_passe())){
      String token = jwtUtil.createToken(medecin.getEmail(), medecin.getId().toString(),"medecin");
      return new LoginResponse(token);
    }else{
      throw new LoginException("Email or password does not match");
    }
  }

  public LoginResponse loginEtablissement(LoginDto loginRequest){

    Etablissement etablissement = etablissementRepository.findByEmail(loginRequest.getEmail()).orElseThrow(()-> new LoginException("Email or password does not match"));

    if(passwordEncoder.matches(loginRequest.getPassword(),etablissement.getMot_de_passe())){
      String token = jwtUtil.createToken(etablissement.getEmail(), etablissement.getId().toString(),"etablissement");
      return new LoginResponse(token);
    }else{
      throw new LoginException("Email or password does not match");
    }
  }


  public Medecin getCurrentMedecin (){
    User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    if (principal == null)
      return null;
    return medecinRepository.findByEmail(principal.getUsername()).orElse(null);
  }

  public Citoyen getCurrentCitoyen(){
    User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    if (principal == null)
      return null;
    return citoyenRepository.findById(UUID.fromString(principal.getUsername())).orElse(null);
  }

  public Etablissement getCurrentEtablissement(){
    User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    if (principal == null)
      return null;
    return etablissementRepository.findByEmail(principal.getUsername()).orElse(null);
  }

  private boolean emailAlreadyExists(String email){
    return !(medecinRepository.findByEmail(email).orElse(null) == null &&
              etablissementRepository.findByEmail(email).orElse(null) == null);
  }

}
