package groupe4pfe.stopcovid.controller;

import groupe4pfe.stopcovid.dto.response.CitoyenResponse;
import groupe4pfe.stopcovid.dto.response.ResponseError;
import groupe4pfe.stopcovid.dto.response.ScanResponse;
import groupe4pfe.stopcovid.exceptions.QrCodeAlreadyScannedException;
import groupe4pfe.stopcovid.model.Citoyen;
import groupe4pfe.stopcovid.model.Lieu;
import groupe4pfe.stopcovid.model.QRCodeMedecin;
import groupe4pfe.stopcovid.service.AuthService;
import groupe4pfe.stopcovid.service.LieuxServices;
import groupe4pfe.stopcovid.service.QRCodeMedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/scan")
public class ScanQrCodeController {

    @Autowired
    private LieuxServices lieuxServices;
    @Autowired
    private QRCodeMedecinService qrCodeMedecinService;
    @Autowired
    private AuthService authService;


    @PostMapping("/{qrCode}")
    @CrossOrigin
    public ResponseEntity<?> scanQrCode(@PathVariable String qrCode){
        Lieu lieu;
        QRCodeMedecin qrCodeMedecin;
        if((lieu = lieuxServices.getLieuFromQrCode(qrCode)) != null){
            int nbLieuxVisiteDansLaJournee = lieuxServices.enregistrerCitoyen(lieu);
            Citoyen citoyen = authService.getCurrentCitoyen();
            return ResponseEntity.status(HttpStatus.OK).body(new ScanResponse("lieu",nbLieuxVisiteDansLaJournee,citoyen));
        }else if((qrCodeMedecin = qrCodeMedecinService.getQrCodeMedecinFromQrCode(qrCode) )!= null){
            try{
                Citoyen citoyen = qrCodeMedecinService.scanQrCodeMedecin(qrCodeMedecin);
                return ResponseEntity.status(HttpStatus.OK)
                        .body(new ScanResponse("medecin",
                                lieuxServices.countNbLieuxvisiteDansLaJournee(citoyen,new Date()),
                                citoyen));
            }catch (QrCodeAlreadyScannedException e){
                return ResponseEntity.status(400).body(new ResponseError(e.getMessage()));
            }
        }else{
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new ResponseError("QR code inexistant"));
        }
    }
}
