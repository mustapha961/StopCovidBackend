package groupe4pfe.stopcovid.dto.response;

public class CitoyenResponse {

    private String UUID;
    private String etat;

    public CitoyenResponse(String UUID, String etat) {
        this.UUID = UUID;
        this.etat = etat;
    }

    public CitoyenResponse() {
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }


}
