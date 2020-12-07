package groupe4pfe.stopcovid.controller;

import groupe4pfe.stopcovid.dto.LieuDto;
import groupe4pfe.stopcovid.dto.LieuxQrCodeDto;
import groupe4pfe.stopcovid.dto.response.GetLieuxResponse;
import groupe4pfe.stopcovid.dto.response.ResponseError;
import groupe4pfe.stopcovid.exceptions.UnauthorizeException;
import groupe4pfe.stopcovid.service.LieuxServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etablissement/lieux")
public class EtablissementController {

    @Autowired
    private LieuxServices lieuxServices;

    @GetMapping("")
    @CrossOrigin
    public ResponseEntity<?> getAllLieux(){
        try {
            List<LieuxQrCodeDto> lieuxQrCodeDtoList = lieuxServices.getLieux();
            return ResponseEntity.status(HttpStatus.OK).body(lieuxQrCodeDtoList);
        }catch (UnauthorizeException e){

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseError(e.getMessage()));
        }
    }

    @PostMapping("")
    @CrossOrigin
    public ResponseEntity<?> insererLieux(@RequestBody LieuDto lieuDto){
        try {
            LieuxQrCodeDto lieuxQrCodeDto = lieuxServices.insererLieu(lieuDto);
            return ResponseEntity.status(HttpStatus.OK).body(lieuxQrCodeDto);
        }catch (UnauthorizeException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseError(e.getMessage()));
        }
    }
}
