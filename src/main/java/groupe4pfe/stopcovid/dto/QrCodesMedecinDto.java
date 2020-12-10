package groupe4pfe.stopcovid.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QrCodesMedecinDto {

    @JsonProperty(required = true,defaultValue = "1")
    private String nbrQRCode;

    public QrCodesMedecinDto(){
    }
    public QrCodesMedecinDto(String nbrQRCode){
        this.nbrQRCode = nbrQRCode;
    }

    public String getNbrQRCode() {
        return nbrQRCode;
    }

    public void setNbrQRCode(String nbrQRCode) {
        this.nbrQRCode = nbrQRCode;
    }
}
