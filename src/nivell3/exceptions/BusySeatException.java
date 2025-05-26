package nivell3.exceptions;

public class BusySeatException extends Exception {
    public BusySeatException() {
        super("The seat is already booked. ");
    }
}
