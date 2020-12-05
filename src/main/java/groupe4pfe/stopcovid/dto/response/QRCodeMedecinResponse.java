package groupe4pfe.stopcovid.dto.response;

import groupe4pfe.stopcovid.model.QRCodeMedecin;

import java.util.UUID;

public class QRCodeMedecinResponse {

    private String contenu;

    public QRCodeMedecinResponse(){}

    public QRCodeMedecinResponse(String contenu){
        this.contenu = contenu;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
}
