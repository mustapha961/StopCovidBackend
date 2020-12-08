package groupe4pfe.stopcovid.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisterEtablissementDto {

  @JsonProperty(required = true)
  private String nom;
  @JsonProperty(required = true)
  private String adresse;
  @JsonProperty(required = true)
  private String email;
  @JsonProperty(required = true)
  private String password;

  public RegisterEtablissementDto() {}

  public RegisterEtablissementDto(
    String nom,
    String adresse,
    String email,
    String password
  ) {
    this.nom = nom;
    this.adresse = adresse;
    this.email = email;
    this.password = password;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getAdresse() {
    return adresse;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
