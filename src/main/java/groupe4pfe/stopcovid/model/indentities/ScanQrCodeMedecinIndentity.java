package groupe4pfe.stopcovid.model.indentities;

import groupe4pfe.stopcovid.model.Citoyen;
import groupe4pfe.stopcovid.model.QRCodeMedecin;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Embeddable
public class ScanQrCodeMedecinIndentity implements Serializable {

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(
    name = "citoyens_id",
    referencedColumnName = "id",
    nullable = false
  )
  private Citoyen citoyenId;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(
    name = "qrcodemedecin_id",
    referencedColumnName = "id",
    nullable = false,
    unique = true
  )
  private QRCodeMedecin qrCodeMedecinId;

  public ScanQrCodeMedecinIndentity() {}

  public ScanQrCodeMedecinIndentity(
    Citoyen citoyenId,
    QRCodeMedecin qrCodeMedecinId
  ) {
    this.citoyenId = citoyenId;
    this.qrCodeMedecinId = qrCodeMedecinId;
  }

  public Citoyen getCitoyenId() {
    return citoyenId;
  }

  public void setCitoyenId(Citoyen citoyenId) {
    this.citoyenId = citoyenId;
  }

  public QRCodeMedecin getQrCodeMedecinId() {
    return qrCodeMedecinId;
  }

  public void setQrCodeMedecinId(QRCodeMedecin qrCodeMedecinId) {
    this.qrCodeMedecinId = qrCodeMedecinId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ScanQrCodeMedecinIndentity that = (ScanQrCodeMedecinIndentity) o;
    return (
      getCitoyenId().equals(that.getCitoyenId()) &&
      getQrCodeMedecinId().equals(that.getQrCodeMedecinId())
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCitoyenId(), getQrCodeMedecinId());
  }
}
