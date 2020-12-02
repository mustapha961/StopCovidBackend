package groupe4pfe.stopcovid.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="scansQRCodeEtablissements")
public class ScanQRCodeEtablissement {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Date date_entree;

    @ManyToOne
    @JoinColumn(name="id")
    private QRCodeEtablissement QRCode;

    @ManyToOne
    @JoinColumn(name="id")
    private Citoyen citoyen;

    public ScanQRCodeEtablissement(){}

    public ScanQRCodeEtablissement(Long id,Date date_entree,QRCodeEtablissement QRCode, Citoyen citoyen){
        this.id = id;
        this.date_entree = date_entree;
        this.QRCode = QRCode;
        this.citoyen = citoyen;
    }

    public Long getId() {
        return id;
    }

    public Citoyen getCitoyen() {
        return citoyen;
    }

    public Date getDate_entree() {
        return date_entree;
    }

    public QRCodeEtablissement getQRCode() {
        return QRCode;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCitoyen(Citoyen citoyen) {
        this.citoyen = citoyen;
    }

    public void setDate_entree(Date date_entree) {
        this.date_entree = date_entree;
    }

    public void setQRCode(QRCodeEtablissement QRCode) {
        this.QRCode = QRCode;
    }
}
