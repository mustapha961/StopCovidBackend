package groupe4pfe.stopcovid.exceptions;

public class RegisterException extends RuntimeException{
    public RegisterException() {
    }

    public RegisterException(String message) {
        super(message);
    }
}
