package nivell3.exceptions;

public class RowInvalidExeption extends RuntimeException {
    public RowInvalidExeption() {
        super("The row number is incorrect.");
    }
}
