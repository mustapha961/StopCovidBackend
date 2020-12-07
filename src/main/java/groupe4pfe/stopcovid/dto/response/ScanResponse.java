package groupe4pfe.stopcovid.dto.response;

import groupe4pfe.stopcovid.model.Citoyen;

public class ScanResponse {
    String type;
    int nbLieuxVisitesDansLaJournee;
    Citoyen citoyen;

    public ScanResponse() {
    }

    public ScanResponse(String type, int nbLieuxVisitesDansLaJournee, Citoyen citoyen) {
        this.type = type;
        this.nbLieuxVisitesDansLaJournee = nbLieuxVisitesDansLaJournee;
        this.citoyen = citoyen;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNbLieuxVisitesDansLaJournee() {
        return nbLieuxVisitesDansLaJournee;
    }

    public void setNbLieuxVisitesDansLaJournee(int nbLieuxVisitesDansLaJournee) {
        this.nbLieuxVisitesDansLaJournee = nbLieuxVisitesDansLaJournee;
    }

    public Citoyen getCitoyen() {
        return citoyen;
    }

    public void setCitoyen(Citoyen citoyen) {
        this.citoyen = citoyen;
    }
}
