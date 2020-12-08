package groupe4pfe.stopcovid.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CitoyenRegisterRequest {

    @JsonProperty(required = true)
    String deviceToken;

    public CitoyenRegisterRequest() {
    }

    public CitoyenRegisterRequest(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }
}
