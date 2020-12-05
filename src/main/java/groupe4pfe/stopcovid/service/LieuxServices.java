package groupe4pfe.stopcovid.service;

import groupe4pfe.stopcovid.dto.LieuDto;
import groupe4pfe.stopcovid.dto.LieuxQrCodeDto;
import groupe4pfe.stopcovid.exceptions.UnauthorizeException;
import groupe4pfe.stopcovid.model.Etablissement;
import groupe4pfe.stopcovid.model.Lieu;
import groupe4pfe.stopcovid.model.QRCodeMedecin;
import groupe4pfe.stopcovid.repository.LieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class LieuxServices {

    @Autowired
    private AuthService authService;
    @Autowired
    private LieuRepository lieuRepository;

    @Transactional
    public List<LieuxQrCodeDto> getLieux(){
        Etablissement etablissement = authService.getCurrentEtablissement();
        if(etablissement != null){
            List<Lieu> lieuList = lieuRepository.findAllByEtablissementId(etablissement.getId());
            List<LieuxQrCodeDto> lieuxQrCodeDtos = lieuList.stream()
                    .map(lieu -> new LieuxQrCodeDto(lieu.getNom(), lieu.getDescription(),lieu.getQrCode()))
                    .collect(Collectors.toList());
            return lieuxQrCodeDtos;
        }
        throw new UnauthorizeException("Vous n'avez pas le droit de réaliser ce type d'action");
    }

    @Transactional
    public LieuxQrCodeDto insererLieu(LieuDto lieuDto){
        Etablissement etablissement = authService.getCurrentEtablissement();

        if(etablissement != null){
            System.out.println(etablissement.getEmail()+" "+etablissement.getId());
            Lieu lieu = new Lieu(etablissement,lieuDto.getNom(),lieuDto.getDescription(),UUID.randomUUID().toString());
            lieu = lieuRepository.save(lieu);
            return new LieuxQrCodeDto(lieu.getNom(),lieu.getDescription(),lieu.getQrCode());

        }
        throw new UnauthorizeException("Vous n'avez pas le droit de réaliser ce type d'action");
    }


}
