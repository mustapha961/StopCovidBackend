package groupe4pfe.stopcovid.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "etablissements")
public class Etablissement {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String nom;

  private String adresse;

  private String email;

  private String mot_de_passe;

  public Etablissement(
    String nom,
    String adresse,
    String email,
    String mot_de_passe
  ) {
    this.id = id;
    this.nom = nom;
    this.adresse = adresse;
    this.email = email;
    this.mot_de_passe = mot_de_passe;
  }

  public Etablissement() {}

  public String getEmail() {
    return email;
  }

  public String getMot_de_passe() {
    return mot_de_passe;
  }

  public String getNom() {
    return nom;
  }

  public Long getId() {
    return id;
  }

  public String getAdresse() {
    return adresse;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setMot_de_passe(String mot_de_passe) {
    this.mot_de_passe = mot_de_passe;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
