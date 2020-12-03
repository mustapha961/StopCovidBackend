package groupe4pfe.stopcovid.model;

import java.io.Serializable;
import java.util.Objects;

public class ScanQRCodeMedecinId implements Serializable {

    private Citoyen citoyen;

    private ScanQRCodeMedecin scanQRCodeMedecin;

    public ScanQRCodeMedecinId(Citoyen citoyen,ScanQRCodeMedecin scanQRCodeMedecin){
        this.citoyen = citoyen;
        this.scanQRCodeMedecin = scanQRCodeMedecin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScanQRCodeMedecinId that = (ScanQRCodeMedecinId) o;
        return Objects.equals(citoyen, that.citoyen) &&
                Objects.equals(scanQRCodeMedecin, that.scanQRCodeMedecin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(citoyen, scanQRCodeMedecin);
    }
}
