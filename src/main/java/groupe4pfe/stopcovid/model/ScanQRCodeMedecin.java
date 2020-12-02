package groupe4pfe.stopcovid.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "scansQRCodeMedecins")
public class ScanQRCodeMedecin {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Date date;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id",referencedColumnName = "id")
    private QRCodeMedecin QRCode;

    @ManyToOne
    @JoinColumn(name="id")
    private Citoyen citoyen;

    public ScanQRCodeMedecin(){}

    public ScanQRCodeMedecin(Date date,QRCodeMedecin QRCode, Citoyen citoyen){
        this.date = date;
        this.QRCode = QRCode;
        this.citoyen = citoyen;
    }

    public Long getId() {
        return id;
    }

    public Citoyen getCitoyen() {
        return citoyen;
    }

    public Date getDate() {
        return date;
    }

    public QRCodeMedecin getQRCode() {
        return QRCode;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQRCode(QRCodeMedecin QRCode) {
        this.QRCode = QRCode;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCitoyen(Citoyen citoyen) {
        this.citoyen = citoyen;
    }
}
