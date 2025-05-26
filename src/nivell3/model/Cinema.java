package nivell3.model;

import nivell3.appManager.CinemaManager;
import nivell3.appManager.SeatManager;
import nivell3.exceptions.BusySeatException;

import java.util.Scanner;

public class Cinema {
    private int rowsNum;
    private int seatsNum;
    private SeatManager seatManager;
    private CinemaManager cinemaManager;
    private Scanner sc = new Scanner(System.in);

    public Cinema() {
        this.seatManager = new SeatManager();
        this.cinemaManager = new CinemaManager(this);
        requestInitialData();
    }

    public int getRowsNum() {
        return rowsNum;
    }

    public int getSeatsNum() {
        return seatsNum;
    }

    public SeatManager getSeatManager() {
        return seatManager;
    }

    public void requestInitialData() {
        while (true) {
            System.out.print("Enter the number of cinema rows: ");
            if (sc.hasNextInt()) {
                rowsNum = sc.nextInt();
                if (rowsNum > 0) break;
                else System.out.println("The number of rows must be greater than zero.");
            } else {
                System.out.println("Invalid input. Please enter a whole number.");
                sc.next();
            }
        }
        while (true) {
            System.out.print("Enter the number of seats per row: ");
            if (sc.hasNextInt()) {
                seatsNum = sc.nextInt();
                if (seatsNum > 0) break;
                else System.out.println("The number of seats must be greater than zero.");
            } else {
                System.out.println("Invalid input. Please enter a whole number.");
                sc.next();
            }
        }

    }

    public void start() throws BusySeatException {
        int menuOption;
        do {
            menuOption = CinemaManager.menu();
            switch (menuOption) {
                case 1:
                    cinemaManager.showSeats();
                    break;
                case 2:
                    cinemaManager.showPersonBooking();
                    break;
                case 3:
                    cinemaManager.bookSeat();
                    break;
                case 4:
                    cinemaManager.cancelSeat();
                    break;
                case 5:
                    String personsName = cinemaManager.introducePerson();
                    cinemaManager.cancelPersonBook(personsName);
                    break;
                case 6:
                    System.out.println("Bye bye...");
                    break;
                default:
                    System.out.println("Invàlid option.");
            }
        } while (menuOption != 6);
    }
}
