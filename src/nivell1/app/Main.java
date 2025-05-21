package nivell1.app;

import nivell1.exceptions.VendaBuidaException;
import nivell1.model.Producte;
import nivell1.model.Venda;

public class Main {
    public static void main(String[] args) {

        Venda v = new Venda();
        Producte patates = new Producte("Patates", 2.50);
        Producte pebrots = new Producte("Pebrots", 2.50);
        Producte pastanagues = new Producte("Pastanagues", 2.50);

        try {
            v.calcularTotal();
        } catch (VendaBuidaException e) {
            System.out.println(e.getMessage());
        }

        v.afegirProductes(patates);
        v.afegirProductes(pebrots);
        v.afegirProductes(pastanagues);

        try {
            v.calcularTotal();
        } catch (VendaBuidaException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(v);

    }
}