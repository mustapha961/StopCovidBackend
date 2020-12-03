package groupe4pfe.stopcovid.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "lieux")
public class Lieu {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String nom;

  private String descritpion;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "etablissements_id", nullable = false)
  private Etablissement etablissement;

  public Lieu() {}

  public Lieu(String nom, String description) {
    this.nom = nom;
    this.descritpion = description;
  }

  public Long getId() {
    return id;
  }

  public String getNom() {
    return nom;
  }

  public String getDescritpion() {
    return descritpion;
  }

  public Etablissement getEtablissement() {
    return etablissement;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public void setDescritpion(String descritpion) {
    this.descritpion = descritpion;
  }

  public void setEtablissement(Etablissement etablissement) {
    this.etablissement = etablissement;
  }
}
