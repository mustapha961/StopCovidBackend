package groupe4pfe.stopcovid.dto.response;

public class AuthentificationResponse {
    String token;
    String uuid;
    String email;


    public AuthentificationResponse(String token, String email, String uuid) {
        this.token = token;
        this.email = email;
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
