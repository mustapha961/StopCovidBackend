package groupe4pfe.stopcovid.model;

import groupe4pfe.stopcovid.model.indentities.ScanQrCodeMedecinIndentity;
import java.sql.Date;
import javax.persistence.*;

@Entity
@Table(name = "scansQRCodeMedecins")
public class ScanQRCodeMedecin {

  @EmbeddedId
  private ScanQrCodeMedecinIndentity scanQrCodeMedecinIndentity;

  private Date date;

  public ScanQRCodeMedecin() {}

  public ScanQRCodeMedecin(
    ScanQrCodeMedecinIndentity scanQrCodeMedecinIndentity,
    Date date
  ) {
    this.scanQrCodeMedecinIndentity = scanQrCodeMedecinIndentity;
    this.date = date;
  }

  public ScanQrCodeMedecinIndentity getScanQrCodeMedecinIndentity() {
    return scanQrCodeMedecinIndentity;
  }

  public void setScanQrCodeMedecinIndentity(
    ScanQrCodeMedecinIndentity scanQrCodeMedecinIndentity
  ) {
    this.scanQrCodeMedecinIndentity = scanQrCodeMedecinIndentity;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }
}
