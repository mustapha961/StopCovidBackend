package groupe4pfe.stopcovid.controller;

import groupe4pfe.stopcovid.dto.response.ResponseError;
import groupe4pfe.stopcovid.exceptions.QRCodeMedecinException;
import groupe4pfe.stopcovid.service.QRCodeMedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/qrcode")
public class QRCodeMedecinController {

    @Autowired
    private QRCodeMedecinService QRCodeMedecinService;

    @PostMapping("/medecin")
    public ResponseEntity<?> addQRCodeMedecin(){
        try{
            return ResponseEntity.status(OK).body(QRCodeMedecinService.addQRCodeMedecin());
        }catch (QRCodeMedecinException e){
            return ResponseEntity.status(400).body(new ResponseError(e.getMessage()));
        }

    }

}
