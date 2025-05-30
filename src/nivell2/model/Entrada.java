package nivell2.model;

import nivell2.exception.InvalidDataException;

import javax.xml.transform.stream.StreamSource;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Entrada {

    static Scanner scanner =  new Scanner(System.in);

    public Entrada() {

    }

    public static char llegirChar(String message){
        while(true){
            System.out.println(message);
            String input = scanner.next();
            char inputChar = input.charAt(0);
            try {
                if (input.length() != 1) {
                    throw new InvalidDataException();
                }
                return inputChar;
            } catch (InvalidDataException e){
                    System.out.println("Format error. You must introduce a single character.");
            }
        }
    }

    public static String llegirString(String message) {
        while (true) {
            System.out.println(message);
            String input = scanner.next();
            try {
                if (input.isEmpty() || !input.matches("[a-zA-Z]+")) {
                    throw new InvalidDataException();
                }
                return input;
            } catch (InvalidDataException e) {
                System.out.println("Error. Input cannot be empty and also cannot be numbers.");
            }
        }
    }

    public static boolean llegirSiNo(String message)  {
        while (true) {
            try {
                System.out.println(message);
                String input = scanner.next();

                if (input.equalsIgnoreCase("y")) {
                    return true;
                } else if (input.equalsIgnoreCase("n")) {
                    return false;
                } else  {
                    throw new InvalidDataException();
                }
            } catch (InvalidDataException e) {
                System.out.println("Wrong answer. Introduce 'y' or 'n'.");
            }
        }
    }


    public static byte llegirByte(String message){
        while(true){
            try{
                System.out.println(message);
                byte input = scanner.nextByte();
                return input;

            } catch (InputMismatchException e){
                System.out.println("Format error. You must introduce a integer numer between -128 and 127.");
                scanner.nextLine();
            }
        }
    }

    public static int llegirInt(String message){
        while(true){
            try{
                System.out.println(message);
                int input = scanner.nextInt();

                if (input < 0 || input > 125) {
                    throw new InputMismatchException();
                }
                return  input;
            } catch (InputMismatchException e){
                System.out.println("Format error. You must introduce a vàlid integer number.");
                scanner.nextLine();
            }
        }

    }
    public  static float llegirFloat(String message){
        while(true){
            try{
                System.out.println(message);
                float input = scanner.nextFloat();
                return input;

            } catch (InputMismatchException e){
                System.out.println("Format error. You must introduce a decimal number using dot as separator.");
                scanner.nextLine();
            }
        }
    }

    public static double llegirDouble(String message){
        while(true){
            try{
                System.out.println(message);
                double input = scanner.nextDouble();
                if (input < 0) {
                    throw new InputMismatchException();
                }
                return input;

            } catch (InputMismatchException e){
                System.out.println("Format error. You must introduce a decimal number using dot as separator.");
                scanner.nextLine();
            }
        }
    }

}
