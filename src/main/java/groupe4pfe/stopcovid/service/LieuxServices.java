package groupe4pfe.stopcovid.service;

import groupe4pfe.stopcovid.dto.LieuDto;
import groupe4pfe.stopcovid.dto.LieuxQrCodeDto;
import groupe4pfe.stopcovid.exceptions.UnauthorizeException;
import groupe4pfe.stopcovid.model.*;
import groupe4pfe.stopcovid.repository.LieuRepository;
import groupe4pfe.stopcovid.repository.ScanQRCodeEtablissementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class LieuxServices {

    @Autowired
    private AuthService authService;
    @Autowired
    private LieuRepository lieuRepository;
    @Autowired
    private ScanQRCodeEtablissementRepository scanQRCodeEtablissementRepository;

    @Transactional
    public List<LieuxQrCodeDto> getLieux(){
        Etablissement etablissement = authService.getCurrentEtablissement();
        if(etablissement != null){
            List<Lieu> lieuList = lieuRepository.findAllByEtablissementId(etablissement.getId());
            List<LieuxQrCodeDto> lieuxQrCodeDtos = lieuList.stream()
                    .map(lieu -> new LieuxQrCodeDto(lieu.getId(),lieu.getNom(), lieu.getDescription(),lieu.getQrCode().toString()))
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
            return new LieuxQrCodeDto(lieu.getId(),lieu.getNom(),lieu.getDescription(),lieu.getQrCode().toString());

        }
        throw new UnauthorizeException("Vous n'avez pas le droit de réaliser ce type d'action");
    }

    @Transactional
    public Lieu getLieuFromQrCode(String qrCode){
        return lieuRepository.findByQrCode(qrCode).orElse(null);
    }

    @Transactional
    public int enregistrerCitoyen(Lieu lieu) {
        Citoyen citoyen = authService.getCurrentCitoyen();
        if(citoyen != null){
            Date currentDate = new Date();

            ScanQRCodeEtablissement scanQRCodeEtablissement = scanQRCodeEtablissementRepository
                    .save(new ScanQRCodeEtablissement(currentDate,lieu,citoyen));

            Date startOfTheDay = getStartOfDay(currentDate);
            Date endOfTheDay = getEndOfDay(currentDate);
            return scanQRCodeEtablissementRepository.countByCitoyenAndDateEntreeBetween(citoyen,startOfTheDay,endOfTheDay);


        }
        throw new UnauthorizeException("Vous n'avez pas le droit de réaliser ce type d'action");

    }

    private Date getStartOfDay(Date date) {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate dateTime = date.toInstant().atZone(defaultZoneId).toLocalDate();
        return Date.from(dateTime.atStartOfDay(defaultZoneId).toInstant());
    }

    private Date getEndOfDay(Date date) {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate dateTime = date.toInstant().atZone(defaultZoneId).toLocalDate();
        return Date.from(dateTime.plusDays(1).atStartOfDay(defaultZoneId).minusSeconds(1).toInstant());
    }

}
