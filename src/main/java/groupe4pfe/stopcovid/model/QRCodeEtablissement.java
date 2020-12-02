package groupe4pfe.stopcovid.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="QRCodeEtablissements")
public class QRCodeEtablissement {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lieu", referencedColumnName = "id", nullable=false)
    private Lieu lieu;

    private String contenu;

    @OneToMany(mappedBy="QRCode")
    private Set<ScanQRCodeEtablissement> scansQRCodeEtablissements;

    public QRCodeEtablissement(){}

    public QRCodeEtablissement(Lieu lieu, String contenu){
        this.lieu = lieu;
        this.contenu = contenu;
        this.scansQRCodeEtablissements = new HashSet<ScanQRCodeEtablissement>();
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

    public Set<ScanQRCodeEtablissement> getScansQRCodeEtablissements() {
        return scansQRCodeEtablissements;
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

    public void setScansQRCodeEtablissements(Set<ScanQRCodeEtablissement> scansQRCodeEtablissements) {
        this.scansQRCodeEtablissements = scansQRCodeEtablissements;
    }
}
