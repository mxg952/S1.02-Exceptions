package nivell3.model;

import nivell3.appManager.CinemaManager;
import nivell3.appManager.SeatManager;

import javax.xml.transform.Source;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Cinema {

    private int rowsNum;
    private int seatsNum;
    private SeatManager seatManager;
    private CinemaManager cinemaManager;
    private Scanner sc  = new Scanner(System.in);

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

    public CinemaManager getCinemaManager() {
        return cinemaManager;
    }

    public void start() {
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
                    cinemaManager.cancelPersonBook();
                    break;
                case 6:
                    System.out.println("Bye bye...");
                    break;
                default:
                    System.out.println("Invàlid option.");
            }
        } while (menuOption != 6);

    }

    public void requestInitialData(){
        System.out.println("\nIntroduce the number of seats in the cinema: ");
        this.seatsNum = sc.nextInt();
        sc.nextLine();

        System.out.println("\nIntroduce the number of rows in the cinema: ");
        this.rowsNum = sc.nextInt();
        sc.nextLine();
    }
}
