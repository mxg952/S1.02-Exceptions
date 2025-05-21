package nivell3.model;

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

    public boolean equals(int row, int seat){
        if (row == this.getRow() && seat == this.getSeat()) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "\nPersona: " + this.namePerson + ", Fila: " + this.row
                + ", Seient " + this.seat;
    }

}
