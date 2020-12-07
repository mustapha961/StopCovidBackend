package groupe4pfe.stopcovid.dto;

public class CitoyenRegisterRequest {
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
