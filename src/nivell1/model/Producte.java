package nivell1.model;

public class Producte {

    public String nom;
    public double preu;

    public Producte(String nom, double preu) {
        this.nom = nom;
        this.preu = preu;
    }

    public double getPreu() {
        return preu;
    }

    @Override
    public String toString() {
        return "\nNom='" + this.nom +
                "\nPreu=" + this.preu;
    }
}


