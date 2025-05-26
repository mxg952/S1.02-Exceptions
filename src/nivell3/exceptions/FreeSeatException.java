package nivell3.exceptions;

public class FreeSeatException extends RuntimeException {
    public FreeSeatException() {
        super("This seat in not booked.");
    }
}
