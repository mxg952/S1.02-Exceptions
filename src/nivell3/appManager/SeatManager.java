package nivell3.appManager;

import nivell3.exceptions.BusySeatException;
import nivell3.exceptions.FreeSeatException;
import nivell3.model.Seat;

import java.util.ArrayList;

public class SeatManager {

    ArrayList<Seat> seats;

    public SeatManager() {
        this.seats = new ArrayList<>();
    }

    public ArrayList<Seat> getSeats() {
        return this.seats;
    }

    public void addSeat(Seat seat) throws BusySeatException {
        int seatPosition = findSeat(seat.getRow(), seat.getSeat());
        if (seatPosition != -1) {
            throw new BusySeatException();
        } else {
            seats.add(seat);
            System.out.println("The seat has been reserved.");
        }
    }

    public void removeSeat(int row, int seat) {
        try {
            int index = findSeat(row, seat);
            if (index == -1) {
                throw new FreeSeatException();
            } else {
                seats.remove(index);
            }
        } catch (FreeSeatException e) {
            System.out.println(e.getMessage());
        }
    }

    public int findSeat(int row, int seat) {
        int seatIndex = -1;
        for (int i = 0; i < seats.size(); i++) {
            if ((seats.get(i).getRow() == row && seats.get(i).getSeat() == seat)) {
                seatIndex = i;
            }
        }
        return seatIndex;
    }

}
