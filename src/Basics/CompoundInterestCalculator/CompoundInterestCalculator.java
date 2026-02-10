package Basics.CompoundInterestCalculator;
import java.util.Scanner;

public class CompoundInterestCalculator {
    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);

        double principal;
        double rate;
        int timesCompounded;
        int years;
        double amount;

        System.out.print("Inserisci il capitale: ");
        principal = scanner.nextDouble();

        System.out.print("Inserisci il tasso di interesse (in %): ");
        rate = scanner.nextDouble() / 100;

        System.out.print("Inserisci il numero di capitalizzazioni: ");
        timesCompounded = scanner.nextInt();

        System.out.print("Inserisci il numero di anni: ");
        years = scanner.nextInt();

        amount = principal * Math.pow(1 + rate / timesCompounded, timesCompounded * years);

        System.out.printf("La somma dopo %d anni sara': %.2f €", years, amount);

        scanner.close();
    }
}
