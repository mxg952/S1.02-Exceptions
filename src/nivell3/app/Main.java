package nivell3.app;

import nivell3.exceptions.BusySeatException;
import nivell3.model.Cinema;

public class Main {

    public static void main(String[] args) throws BusySeatException {

        Cinema cinema = new Cinema();
        cinema.start();

    }
}
