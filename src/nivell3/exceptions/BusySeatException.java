package nivell3.exceptions;

public class BusySeatException extends RuntimeException {
    public BusySeatException() {
        super("The seat is already booked. ");
    }
}
