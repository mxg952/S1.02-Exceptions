package nivell3.appManager;

import nivell3.exceptions.BusySeatException;
import nivell3.exceptions.NamePersonInvalidException;
import nivell3.exceptions.RowInvalidExeption;
import nivell3.exceptions.SeatInvalidException;
import nivell3.model.Cinema;
import nivell3.model.Seat;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class CinemaManager {
    private Cinema cinema;
    static Scanner sc = new Scanner(System.in);
    private SeatManager seatManager;

    public CinemaManager(Cinema cinema) {
        this.seatManager = cinema.getSeatManager();
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
        menuOption = sc.nextInt();
        sc.nextLine();
        return menuOption;
    }

    public void showSeats() {
        ArrayList<Seat> seats = cinema.getSeatManager().getSeats();

        if (seats.isEmpty()) {
            System.out.println("There are no seat already booked.");
        } else {
            for (Seat s : seats) {
                System.out.printf(s.toString());
            }
        }
    }

    public void showPersonBooking() {
        String name = introducePerson();
        ArrayList<Seat> seats = cinema.getSeatManager().getSeats();
        boolean bookings = false;

        for (Seat s : seats) {
            if (s.getNamePerson().equalsIgnoreCase(name)) {
                System.out.println(s.toString());
                bookings = true;
            }
        }

        if (!bookings) {
            System.out.println("There ara no seat already booked for " + name);
        }
    }

    public void bookSeat() throws BusySeatException {
        boolean reserved = false;
        String name = introducePerson();

        while (!reserved) {
            int row = introduceRow();
            int seat = introduceSeat();

            try {
                cinema.getSeatManager().addSeat(new Seat(row, seat, name));
                reserved = true;
            } catch (BusySeatException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void cancelSeat() {
        ArrayList<Seat> seats = cinema.getSeatManager().getSeats();
        int row = introduceRow();
        int seat = introduceSeat();
        boolean isBooked = false;

        for (int i = 0; i < seats.size(); i++) {
            Seat s = seats.get(i);
            if (s.getSeat() == seat && s.getRow() == row) {
                isBooked = true;
                cinema.getSeatManager().removeSeat(row, seat);
                System.out.println("Seat booking cancel·led.");
                break;
            }
        }

        if (!isBooked) {
            System.out.println("This seat is not reserved.");
        }

    }

    public void cancelPersonBook(String personName) {
        ArrayList<Seat> seats = cinema.getSeatManager().getSeats();
        boolean found = false;

        Iterator<Seat> iterator = seats.iterator();
        while (iterator.hasNext()) {
            Seat s = iterator.next();
            if (s.getNamePerson().equalsIgnoreCase(personName)) {
                iterator.remove();
                found = true;
            }
        }
        if (found) {
            System.out.println("All reservations for " + personName + " have been removed.");
        } else {
            System.out.println("No reservations found for " + personName + ".");
        }
    }

    public String introducePerson() throws NamePersonInvalidException {
        while (true) {
            try {
                System.out.println("Introduce the person's name: ");
                String name = sc.nextLine().trim();

                if (name.matches(".*\\d.*") || name.isEmpty()) {
                    throw new NamePersonInvalidException();
                }
                return name;
            } catch (NamePersonInvalidException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int introduceRow() {
        while (true) {
            try {
                System.out.println("Introduce a row number: ");
                int row = sc.nextInt();
                sc.nextLine();

                if (row >= 1 && row <= cinema.getRowsNum()) {
                    return row;
                } else {
                    throw new RowInvalidExeption();
                }
            } catch (RowInvalidExeption e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("You must enter a valid integer.");
                sc.nextLine();
            }
        }
    }

    public int introduceSeat() {
        while (true) {
            try {
                System.out.println("Introduce a seat number: ");
                int seat = sc.nextInt();
                sc.nextLine();

                if (seat >= 1 && seat <= cinema.getSeatsNum()) {
                    return seat;
                } else {
                    throw new SeatInvalidException();
                }
            } catch (SeatInvalidException e) {
                System.out.println(e.getMessage());

            } catch (InputMismatchException e) {
                System.out.println("You must enter a valid integer.");
                sc.nextLine(); // neteja el buffer per evitar bucle infinit
            }
        }
    }
}
