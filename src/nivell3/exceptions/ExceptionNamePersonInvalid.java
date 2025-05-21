package nivell3.exceptions;

public class ExceptionNamePersonInvalid extends RuntimeException {
    public ExceptionNamePersonInvalid() {
        super("Format Error. Introduce just letters.");
    }
}
