package groupe4pfe.stopcovid.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "scansQRCodeEtablissements")
public class ScanQRCodeEtablissement {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable = false)
  private Date dateEntree;

  @ManyToOne
  @JoinColumn(name = "lieu_id", referencedColumnName = "id",nullable = false)
  private Lieu lieu;

  @JsonManagedReference
  @ManyToOne
  @JoinColumn(name = "citoyen_id", referencedColumnName = "id",nullable = false)
  private Citoyen citoyen;

  public ScanQRCodeEtablissement() {}

  public ScanQRCodeEtablissement(Date date_entree, Lieu lieu, Citoyen citoyen) {
    this.dateEntree = date_entree;
    this.lieu = lieu;
    this.citoyen = citoyen;
  }

  public Long getId() {
    return id;
  }

  public Citoyen getCitoyen() {
    return citoyen;
  }

  public Date getDate_entree() {
    return dateEntree;
  }

  public Lieu getLieu() {
    return lieu;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setCitoyen(Citoyen citoyen) {
    this.citoyen = citoyen;
  }

  public void setDate_entree(Date date_entree) {
    this.dateEntree = date_entree;
  }

  public void setLieu(Lieu lieu) {
    this.lieu = lieu;
  }
}
