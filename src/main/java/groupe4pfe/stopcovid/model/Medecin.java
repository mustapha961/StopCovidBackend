package groupe4pfe.stopcovid.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "medecins")
public class Medecin {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String nom;

    private String prenom;

    private String email;

    private String mot_de_passe;

    @OneToMany(mappedBy="medecin")
    private Set<QRCodeMedecin> QRCodeMedecins;


    public Medecin(String nom,String prenom,String email,String mot_de_passe){
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mot_de_passe = mot_de_passe;
        this.QRCodeMedecins = new HashSet<QRCodeMedecin>();
    }

    public Medecin() {

    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Set<QRCodeMedecin> getQRCodeMedecins() {
        return QRCodeMedecins;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setQRCodeMedecins(Set<QRCodeMedecin> QRCodeMedecins) {
        this.QRCodeMedecins = QRCodeMedecins;
    }
}
