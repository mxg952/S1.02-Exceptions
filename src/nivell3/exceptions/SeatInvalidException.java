package nivell3.exceptions;

public class SeatInvalidException extends RuntimeException {
    public SeatInvalidException() {
        super("The seat number is incorrect.");
    }
}
