package groupe4pfe.stopcovid.exceptions;

public class UnauthorizeException extends RuntimeException {

    public UnauthorizeException() {
    }

    public UnauthorizeException(String message) {
        super(message);
    }
}
