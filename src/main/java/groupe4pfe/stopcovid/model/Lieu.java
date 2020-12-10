package groupe4pfe.stopcovid.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "lieux")
public class Lieu {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(nullable = false)
  private String nom;
  @Column(nullable = false)
  private String description;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "etablissements_id", nullable = false)
  private Etablissement etablissement;
  @Column(nullable = false)
  private String qrCode;

  public Lieu(Etablissement etablissement, String nom, String description, String qrCode) {
    this.etablissement= etablissement;
    this.nom = nom;
    this.description = description;
    this.qrCode = qrCode;
  }

  public Lieu(){ }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getQrCode() {
    return qrCode;
  }

  public void setQrCode(String qrCode) {
    this.qrCode = qrCode;
  }

  public Long getId() {
    return id;
  }

  public String getNom() {
    return nom;
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

  public void setEtablissement(Etablissement etablissement) {
    this.etablissement = etablissement;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Lieu lieu = (Lieu) o;
    return getId().equals(lieu.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }
}
