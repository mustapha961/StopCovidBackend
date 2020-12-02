package groupe4pfe.stopcovid.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "citoyens")
public class Citoyen {
    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Enumerated(EnumType.ORDINAL)
    private EtatCitoyen etat;

    @OneToMany(mappedBy="citoyen")
    private Set<ScanQRCodeEtablissement> scansQRCodeEtablissements;

    @OneToMany(mappedBy="citoyen")
    private Set<ScanQRCodeMedecin> scansQRCodeMedecins;

    public Citoyen(){
    }

    public Citoyen(UUID id,EtatCitoyen etat){
        this.id = id;
        this.etat = etat;
        this.scansQRCodeEtablissements = new HashSet<ScanQRCodeEtablissement>();
        this.scansQRCodeMedecins = new HashSet<ScanQRCodeMedecin>();
    }

    public Set<ScanQRCodeEtablissement> getScansQRCodeEtablissements() {
        return scansQRCodeEtablissements;
    }

    public Set<ScanQRCodeMedecin> getScansQRCodeMedecins() {
        return scansQRCodeMedecins;
    }

    public EtatCitoyen getEtat() {
        return etat;
    }

    public UUID getId() {
        return id;
    }

    public void setScansQRCodeEtablissements(Set<ScanQRCodeEtablissement> scansQRCodeEtablissements) {
        this.scansQRCodeEtablissements = scansQRCodeEtablissements;
    }

    public void setScansQRCodeMedecins(Set<ScanQRCodeMedecin> scansQRCodeMedecins) {
        this.scansQRCodeMedecins = scansQRCodeMedecins;
    }

    public void setEtat(EtatCitoyen etat) {
        this.etat = etat;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
