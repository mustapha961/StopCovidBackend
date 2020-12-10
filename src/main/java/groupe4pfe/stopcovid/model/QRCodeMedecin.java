package groupe4pfe.stopcovid.model;

import java.util.UUID;
import javax.persistence.*;

@Entity
@Table(name = "QRCodeMedecins")
public class QRCodeMedecin {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
    name = "medecin_id",
    referencedColumnName = "id",
    nullable = false
  )
  private Medecin medecin;
  @Column(nullable = false)
  private String contenu;

  public QRCodeMedecin() {}

  public QRCodeMedecin(Medecin medecin, String contenu) {
    this.medecin = medecin;
    this.contenu = contenu;
  }

  public Long getId() {
    return id;
  }

  public String getContenu() {
    return contenu;
  }

  public Medecin getMedecin() {
    return medecin;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setContenu(String contenu) {
    this.contenu = contenu;
  }

  public void setMedecin(Medecin medecin) {
    this.medecin = medecin;
  }
}
