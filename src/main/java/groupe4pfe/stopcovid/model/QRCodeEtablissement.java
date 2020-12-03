package groupe4pfe.stopcovid.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "QRCodeEtablissements")
public class QRCodeEtablissement {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String contenu;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "lieux_id", referencedColumnName = "id", nullable = false)
  private Lieu lieu;

  public QRCodeEtablissement() {}

  public QRCodeEtablissement(String contenu) {
    //this.lieu = lieu;
    this.contenu = contenu;
  }

  public Long getId() {
    return id;
  }

  public Lieu getLieu() {
    return lieu;
  }

  public String getContenu() {
    return contenu;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setContenu(String contenu) {
    this.contenu = contenu;
  }

  public void setLieu(Lieu lieu) {
    this.lieu = lieu;
  }
}
