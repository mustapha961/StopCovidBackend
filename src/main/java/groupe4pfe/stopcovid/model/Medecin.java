package groupe4pfe.stopcovid.model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.*;

@Entity
@Table(name = "medecins")
public class Medecin {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(nullable = false)
  private String nom;
  @Column(nullable = false)
  private String prenom;
  @Column(nullable = false)
  private String email;
  @Column(nullable = false)
  private String mot_de_passe;

  public Medecin(String nom, String prenom, String email, String mot_de_passe) {
    this.nom = nom;
    this.prenom = prenom;
    this.email = email;
    this.mot_de_passe = mot_de_passe;
  }

  public Medecin() {}

  public Long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public String getMot_de_passe() {
    return mot_de_passe;
  }

  public String getNom() {
    return nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setId(Long id) {
    this.id = id;
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

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }
}
