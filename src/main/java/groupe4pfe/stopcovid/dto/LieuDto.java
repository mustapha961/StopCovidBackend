package groupe4pfe.stopcovid.dto;

public class LieuDto {

    private String nom;
    private String description;

    public LieuDto(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }

    public LieuDto() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
