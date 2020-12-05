package groupe4pfe.stopcovid.dto;

import org.springframework.beans.factory.annotation.Value;


public class LieuxQrCodeDto {

    private String nom;
    private String description;
    private String qrCode;

    public LieuxQrCodeDto() {
    }

    public LieuxQrCodeDto(String nom, String description, String qrCode) {
        this.nom = nom;
        this.description = description;
        this.qrCode = qrCode;
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

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }
}
