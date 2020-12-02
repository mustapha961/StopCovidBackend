package groupe4pfe.stopcovid.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="QRCodeMedecins")
public class QRCodeMedecin {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="id")
    private Medecin medecin;

    private String contenu;

    @OneToOne(mappedBy="QRCode")
    private ScanQRCodeMedecin scansQRCodeMedecin;

    public QRCodeMedecin(){}

    public QRCodeMedecin(Medecin medecin,String contenu){
        this.medecin = medecin;
        this.contenu = contenu;
        this.scansQRCodeMedecin = new ScanQRCodeMedecin();
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

    public ScanQRCodeMedecin getScansQRCodeMedecin() {
        return scansQRCodeMedecin;
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

    public void setScansQRCodeMedecin(ScanQRCodeMedecin scansQRCodeMedecin) {
        this.scansQRCodeMedecin = scansQRCodeMedecin;
    }
}
