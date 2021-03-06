package groupe4pfe.stopcovid.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisteMedecinDto {

  @JsonProperty(required = true)
  private String nom;
  @JsonProperty(required = true)
  private String prenom;
  @JsonProperty(required = true)
  private String email;
  @JsonProperty(required = true)
  private String password;

  public RegisteMedecinDto() {}

  public RegisteMedecinDto(
    String nom,
    String prenom,
    String email,
    String password
  ) {
    this.nom = nom;
    this.prenom = prenom;
    this.email = email;
    this.password = password;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
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
