package groupe4pfe.stopcovid.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    @JoinColumn(name="id")
    private Etablissement etablissement;

    @OneToOne(mappedBy="lieu")
    private QRCodeEtablissement QRCodeEtablissement;

    public Lieu() {}

    public Lieu(String nom, String description){
        this.nom = nom;
        this.descritpion = description;
        this.QRCodeEtablissement = new QRCodeEtablissement();
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

    public QRCodeEtablissement getQRCodeEtablissements() {
        return QRCodeEtablissement;
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

    public void setQRCodeEtablissement(QRCodeEtablissement QRCodeEtablissements) {
        this.QRCodeEtablissement = QRCodeEtablissement;
    }
}
