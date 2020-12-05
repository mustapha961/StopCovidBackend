package groupe4pfe.stopcovid.dto;

public class QrCodesMedecinDto {
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
