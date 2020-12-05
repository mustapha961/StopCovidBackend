package groupe4pfe.stopcovid.exceptions;

public class CitoyenNotFoundException extends RuntimeException{
    public CitoyenNotFoundException() {
    }

    public CitoyenNotFoundException(String message) {
        super(message);
    }
}
