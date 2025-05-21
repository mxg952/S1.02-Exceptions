package nivell2.app;

import nivell2.model.Entrada;
import nivell2.exception.InvalidDataException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws InvalidDataException {

        Entrada entrada = new Entrada();

        char inputChar = entrada.llegirChar("Introduce you birthday month inicial:");
        System.out.println("Resposta usuari: " +inputChar);

        String inputString = entrada.llegirString("Introduce your name:");
        System.out.println("Resposta usuari: " +inputString);

        boolean inputBoolean = entrada.llegirSiNo("Are you older than 18 years? Ansewer with 'y' for YES or 'n' for NO.");
        System.out.println("Resposta usuari: " + ((!inputBoolean)? "Si": "No"));

        byte inputByte = entrada.llegirByte("Enter a number between 1 and 30:");
        System.out.printf("Resposta usuari: " + inputByte);

        int inputInt = entrada.llegirInt("\nWhat is your age?");
        System.out.printf("Resposta usuari: " + inputInt + " years.");

        float inputFloat = entrada.llegirFloat("\nWhat is the average temperature where you live, in celsius degrees?");
        System.out.printf("Resposta usuari: " + inputFloat + " ºC");

        double inputDouble = entrada.llegirDouble("\nWhat is the average qualifications of your studies? ");
        System.out.printf("Resposta usuari: " + inputDouble);


    }
}