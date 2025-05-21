package nivell3.appManager;

import nivell3.exceptions.ExceptionNamePersonInvalid;
import nivell3.exceptions.RowInvalidExeption;
import nivell3.exceptions.SeatInvalidException;
import nivell3.model.Cinema;
import nivell3.model.Seat;

import java.util.ArrayList;
import java.util.Scanner;

public class CinemaManager {

   private Cinema cinema;
   static Scanner sc = new Scanner(System.in);

    public CinemaManager(Cinema cinema) {
        this.cinema = cinema;
    }

    public static int menu() {
        int menuOption = 0;
        System.out.println("\nMenú:\n" +
                "1. Show all reserved seats.\n" +
                "2. Show the seats reserved by a person.\n" +
                "3. Reserve a seat.\n" +
                "4. Cancel a seat reservation.\n" +
                "5. Cancel all reservations for a person.\n" +
                "6. Exit.\n");
        menuOption =  sc.nextInt();
        sc.nextLine();
        return menuOption;
    }

    public void showSeats(){
        ArrayList<Seat> seats = cinema.getSeatManager().getSeats();

        if(seats.isEmpty()) {
            System.out.println("There are no seat already booked.");
        } else {
            for (Seat s : seats) {
                System.out.printf(s.toString());
            }
        }
    }

    public void showPersonBooking(){
        String name = introducePerson();
        ArrayList<Seat> seats = cinema.getSeatManager().getSeats();
        boolean bookings = false;

            for (Seat s : seats) {
                if (s.getNamePerson().equalsIgnoreCase(name)) {
                    System.out.println(s.toString());
                    bookings = true;
                }
            }

        if (!bookings){
            System.out.println("There ara no seat already booked for " + name);
        }
    }

    public void bookSeat(){
        int row  = introduceRow();
        int seat = introduceSeat();
        String name = introducePerson();

        cinema.getSeatManager().addSeat(new Seat(row, seat, name));
    }

    public void cancelSeat(){
        ArrayList<Seat> seats = cinema.getSeatManager().getSeats();
        int row  = introduceRow();
        int seat = introduceSeat();
        boolean removeSeat = false;

        for (int i = 0; i < seats.size(); i++) {
            Seat s = seats.get(i);
            if (s.getSeat() == seat && s.getRow() == row) {
                removeSeat = true;
                cinema.getSeatManager().removeSeat(row, seat);
                System.out.println("Seat booking cancel·led.");
                break;
            }
        }

        if (!removeSeat){
            System.out.println("This seat is not reserved.");
        }

    }

    public void cancelPersonBook(){
        ArrayList<Seat> seats = cinema.getSeatManager().getSeats();
        String name = introducePerson();
        boolean bookCancel = false;

        for (int i = 0; i < seats.size(); i++) {
            Seat s = seats.get(i);
            if (s.getPerson().equalsIgnoreCase(name)) {
                cinema.getSeatManager().getSeats().remove(s);
                bookCancel = true;
                System.out.println("Book cancel·led.");
            }
        }
        if (!bookCancel) {
            System.out.println("This sit is not reserved.");
        }
    }

    public String introducePerson() throws ExceptionNamePersonInvalid {
        while (true) {
            try {
                System.out.println("Introduce the person's name: ");
                String name = sc.nextLine().trim();

                if (name.matches(".*\\d.*") || name.isEmpty()) {
                    throw new ExceptionNamePersonInvalid();
                }
                return name;
            } catch (ExceptionNamePersonInvalid e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int introduceRow(){
        while(true){
            try{
                System.out.println("Introduce a row number: ");
                int row  = sc.nextInt();
                sc.nextLine();

                if(row >= 1 && row <= cinema.getRowsNum()) {
                    return row;
                } else {
                    throw new RowInvalidExeption();
                }
                } catch (RowInvalidExeption e){
                    System.out.println(e.getMessage());
                }
        }
    }

    public int introduceSeat(){
        while(true) {
            try{
                System.out.println("Introduce a seat number: ");
                int seat  = sc.nextInt();
                sc.nextLine();

                if(seat >= 1 && seat <= cinema.getSeatsNum()) {
                    return seat;
                } else {
                    throw new SeatInvalidException();
                }
            } catch (SeatInvalidException e){
                System.out.println(e.getMessage());

            }
        }
    }
}
