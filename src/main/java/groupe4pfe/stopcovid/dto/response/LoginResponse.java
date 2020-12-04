package groupe4pfe.stopcovid.dto.response;

public class LoginResponse {

    public String token;

    public LoginResponse() {

    }

    public LoginResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
