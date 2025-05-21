package nivell1.model;

import nivell1.exceptions.VendaBuidaException;

import java.util.ArrayList;

public class Venda {

    public ArrayList<Producte> productes;
    public double preuFinal = 0.0;

    public Venda() {
        this.productes = new ArrayList<Producte>();
    }

    public void afegirProductes(Producte p) {
        this.productes.add(p);
    }

    public void calcularTotal() throws VendaBuidaException {

        if (this.productes.isEmpty()) {

            throw new VendaBuidaException("To make a sale, you must first add products");
        }

        for (Producte p : productes) {
                this.preuFinal += p.getPreu();
            }
        }
    
    @Override
    public String toString() {
        return "\nVenda:" +
                "\nProductes: " + this.productes +
                "\nPreuFinal: " + this.preuFinal + " €.";
    }
}
