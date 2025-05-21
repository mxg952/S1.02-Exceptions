package nivell3.appManager;

import nivell3.exceptions.BusySeatException;
import nivell3.exceptions.FreeSeatException;
import nivell3.model.Seat;

import java.util.ArrayList;

public class SeatManager {

    ArrayList<Seat> seats;

    public SeatManager() {

        seats = new ArrayList<>();
    }

    public ArrayList<Seat> getSeats() {
        return this.seats;
    }

    public void addSeat(Seat seat) throws BusySeatException {
            try {
                if (foundSeat(seat.getRow(),seat.getSeat()) != -1) {
                    throw new BusySeatException();
                } else {
                    seats.add(seat);
                    System.out.println("The seat has been reserved.");

                }
            } catch (BusySeatException e){
                System.out.println(e.getMessage());
            }
    }



    public void removeSeat(int row, int seat) throws BusySeatException{
                try {
                    int index = foundSeat(row, seat);
                    if (index == -1) {
                        throw new FreeSeatException();
                    } else {
                        seats.remove(index);
                    }
                } catch (FreeSeatException e){
                    System.out.println(e.getMessage());
                }
            }

    public int foundSeat(int row, int seat){
        int seatIndex = -1;
        for (int i = 0; i <seats.size(); i ++){
            if ((seats.get(i).getRow() == row && seats.get(i).getSeat() == seat)){
                seatIndex = i;
            }
        }
        return seatIndex;
    }

}
