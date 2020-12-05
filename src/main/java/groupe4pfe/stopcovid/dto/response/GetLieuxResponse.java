package groupe4pfe.stopcovid.dto.response;

import groupe4pfe.stopcovid.dto.LieuxQrCodeDto;

import java.util.ArrayList;
import java.util.List;

public class GetLieuxResponse {

    private List<LieuxQrCodeDto> lieuxQrCodeDtoList;

    public GetLieuxResponse() { }

    public GetLieuxResponse(List<LieuxQrCodeDto> lieuxQrCodeDtoList) {
        this.lieuxQrCodeDtoList = lieuxQrCodeDtoList;
    }

    public List<LieuxQrCodeDto> getLieuxQrCodeDtoList() {
        return lieuxQrCodeDtoList;
    }

    public void setLieuxQrCodeDtoList(List<LieuxQrCodeDto> lieuxQrCodeDtoList) {
        this.lieuxQrCodeDtoList = lieuxQrCodeDtoList;
    }
}
