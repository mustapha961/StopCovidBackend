package groupe4pfe.stopcovid.dto.response;

import groupe4pfe.stopcovid.model.EtatCitoyen;

public class CitoyenResponse {

    private String UUID;
    private EtatCitoyen etat;

    public CitoyenResponse(String UUID, EtatCitoyen etat) {
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

    public EtatCitoyen getEtat() {
        return etat;
    }

    public void setEtat(EtatCitoyen etat) {
        this.etat = etat;
    }


}
