package groupe4pfe.stopcovid.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LieuDto {

    @JsonProperty(required = true)
    private String nom;
    @JsonProperty(required = true)
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
