package Basics.EnhancedSwitches;
import java.util.Scanner;

public class EnhancedSwitches {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci un giorno della settimana (omettere accento): ");

        String day = scanner.nextLine();

        switch(day) {
            case "Lunedi", "Martedi", "Mercoledi", "Giovedi" -> System.out.println("E' un giorno della settimana :(");
            case "Venerdi" -> System.out.println("Ci siamo quasi!");
            case "Sabato", "Domenica" -> System.out.println("Fine settimana! :)");
            default -> System.out.println(day + " non e' un giorno!");
        }

        scanner.close();
    }
}
