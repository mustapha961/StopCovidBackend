package groupe4pfe.stopcovid.model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.*;

@Entity
@Table(name = "citoyens")
public class Citoyen {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  private EtatCitoyen etat;

  public Citoyen() {}

  public Citoyen(UUID id, EtatCitoyen etat) {
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
