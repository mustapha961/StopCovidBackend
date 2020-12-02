package groupe4pfe.stopcovid.model;

import javax.persistence.*;

@Entity
@IdClass(LieuId.class)
@Table(name = "lieux")
public class Lieu {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String nom;

    private String descritpion;

    @Id
    @ManyToOne
    @JoinColumn(name="id", nullable=false)
    private Etablissement etablissement;

    public Lieu() {}

    public Lieu(Long id,String nom, String description){
        this.id = id;
        this.nom = nom;
        this.descritpion = description;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDescritpion() {
        return descritpion;
    }

    public Etablissement getEtablissement() {
        return etablissement;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescritpion(String descritpion) {
        this.descritpion = descritpion;
    }

    public void setEtablissement(Etablissement etablissement) {
        this.etablissement = etablissement;
    }
}
