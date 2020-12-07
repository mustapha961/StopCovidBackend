package groupe4pfe.stopcovid.controller;

import groupe4pfe.stopcovid.dto.LieuxQrCodeDto;
import groupe4pfe.stopcovid.dto.QrCodesMedecinDto;
import groupe4pfe.stopcovid.dto.response.QRCodesMedecinResponse;
import groupe4pfe.stopcovid.dto.response.ResponseError;
import groupe4pfe.stopcovid.exceptions.QRCodeMedecinException;
import groupe4pfe.stopcovid.service.QRCodeMedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/medecin")
public class MedecinController {

    @Autowired
    private QRCodeMedecinService QRCodeMedecinService;

    @PostMapping("/qrcode")
    @CrossOrigin
    public ResponseEntity<?> addQRCodeMedecin(@RequestBody QrCodesMedecinDto QrCodesMedecinDto){
        try{
            List<QRCodesMedecinResponse> QRCodeMedecinList = QRCodeMedecinService.addQRCodesMedecin(QrCodesMedecinDto.getNbrQRCode());
            return ResponseEntity.status(OK).body(QRCodeMedecinList);
        }catch (QRCodeMedecinException e){
            return ResponseEntity.status(400).body(new ResponseError(e.getMessage()));
        }

    }

}
