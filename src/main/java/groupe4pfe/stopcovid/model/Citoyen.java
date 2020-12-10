package groupe4pfe.stopcovid.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "citoyens")
public class Citoyen {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column(nullable = false)
  private String deviceToken;

  @Column(nullable = false)
  private EtatCitoyen etat;

  @JsonBackReference
  @OneToMany()
  private List<ScanQRCodeEtablissement> etablissementsVisite;

  public Citoyen() {}

  public Citoyen(UUID id, String deviceToken,EtatCitoyen etat) {
    this.id = id;
    this.deviceToken = deviceToken;
    this.etat = etat;
  }

  public String getDeviceToken() {
    return deviceToken;
  }

  public void setDeviceToken(String deviceToken) {
    this.deviceToken = deviceToken;
  }

  public EtatCitoyen getEtat() {
    return etat;
  }

  public UUID getId() {
    return id;
  }

  public void setEtat(EtatCitoyen etat) {
    this.etat = etat;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public List<ScanQRCodeEtablissement> getEtablissementsVisite() {
    return etablissementsVisite;
  }

  public void setEtablissementsVisite(List<ScanQRCodeEtablissement> etablissementsVisite) {
    this.etablissementsVisite = etablissementsVisite;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Citoyen citoyen = (Citoyen) o;
    return getId().equals(citoyen.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }
}
