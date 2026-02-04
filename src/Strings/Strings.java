package Strings;
import java.util.Scanner;

public class Strings {
    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);

        /*
        String name = "Enrico Atzeni";

        int length = name.length();
        char letter = name.charAt(6);
        int index = name.indexOf(" ");
        int lastIndex = name.lastIndexOf("i");

        name = name.toUpperCase();

        System.out.println(length);
        System.out.println(letter);
        System.out.println(index);
        System.out.println(lastIndex);
        System.out.println(name);

        name = name.toLowerCase();
        System.out.println(name);

        name = "    Enrico Atzeni   ";
        name = name.trim();

        System.out.println(name);

        name = name.replace("E","3");
        name = name.replace("e","3");
        System.out.println(name);
         */

        System.out.print("Inserisci il tuo nome: ");
        String name = scanner.nextLine();

        if(name.equalsIgnoreCase("password")) {
            System.out.println("Il tuo nome non puo' essere 'password'");
        }
        else {

            System.out.println("Il tuo nome e' valido!");

            if(name.isEmpty()) {
                System.out.println("Il tuo nome e' vuoto");
            }
            else {
                System.out.println("Ciao, " + name + "!");
            }

            if(name.contains(" ")) {
                System.out.println("Il tuo nome contiene degli spazi");
            }
            else {
                System.out.println("Il tuo nome non contiene alcuno spazio");
            }
        }

        // Substrings

        System.out.print("Inserisci la tua mail: ");
        String email = scanner.nextLine();

        String username = email.substring(0, email.indexOf("@"));
        String domain = email.substring(email.indexOf("@")+1);

        System.out.println("Username: " + username);
        System.out.println("Dominio: " + domain);

        scanner.close();
    }
}
