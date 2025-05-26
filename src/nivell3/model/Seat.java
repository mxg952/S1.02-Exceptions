package nivell3.model;

import nivell3.appManager.SeatManager;

public class Seat {

    private int row;
    private int seat;
    private String namePerson;

    public Seat(int row, int seat, String namePerson) {
        this.row = row;
        this.seat = seat;
        this.namePerson = namePerson;
    }

    public int getRow() {
        return this.row;
    }

    public int getSeat() {
        return this.seat;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public String getPerson() {
        return this.namePerson;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Seat other = (Seat) obj;
        return this.row == other.row && this.seat == other.seat;
    }

    public String toString() {
        return "\nPersona: " + this.namePerson + ", Fila: " + this.row
                + ", Seient " + this.seat;
    }

}
