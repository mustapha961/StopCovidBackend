package groupe4pfe.stopcovid.dto.response;

import groupe4pfe.stopcovid.model.QRCodeMedecin;

import java.util.UUID;

public class QRCodesMedecinResponse {

    private String contenu;

    public QRCodesMedecinResponse(){}

    public QRCodesMedecinResponse(String contenu){
        this.contenu = contenu;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
}
