package nivell3.exceptions;

public class NamePersonInvalidException extends RuntimeException {
    public NamePersonInvalidException() {
        super("Format Error. Introduce just letters.");
    }
}
