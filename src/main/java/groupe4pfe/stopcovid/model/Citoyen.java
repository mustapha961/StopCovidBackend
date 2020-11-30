package groupe4pfe.stopcovid.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "citoyens")
public class Citoyen {
    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    private EtatCitoyen etat;

    public Citoyen(){
    }

    public Citoyen(UUID id,EtatCitoyen etat){
        this.id = id;
        this.etat = etat;
    }

    public EtatCitoyen getEtat() {
        return etat;
    }

    public UUID getId() {
        return id;
    }

    public void setEtat(EtatCitoyen etat) {
        this.etat = etat;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
