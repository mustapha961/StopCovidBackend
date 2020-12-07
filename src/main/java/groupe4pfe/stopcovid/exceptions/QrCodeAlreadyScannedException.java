package groupe4pfe.stopcovid.exceptions;

public class QrCodeAlreadyScannedException extends RuntimeException{

    public QrCodeAlreadyScannedException() {
    }

    public QrCodeAlreadyScannedException(String message) {
        super(message);
    }
}
