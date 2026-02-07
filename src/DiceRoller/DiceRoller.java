package DiceRoller;

import java.util.Random;
import java.util.Scanner;

public class DiceRoller {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int numOfDice;
        int total = 0;

        System.out.print("Inserisci il numero di dadi da lanciare: ");
        numOfDice = scanner.nextInt();

        if(numOfDice > 0) {
            for(int i = 1; i <= numOfDice; i++) {
                int roll = random.nextInt(1,7);
                System.out.printf("Lancio %d: %d\n",i,roll);
                printDie(roll);
                total += roll;
            }
        }
        else {
            System.out.println("Devi lanciare almeno 1 dado");
        }

        System.out.println("Il totale e': " + total);

        scanner.close();

    }

    static void printDie(int roll) {
        String die1 = """
                 -------
                |       |
                |   ●   |
                |       |
                 -------
                """;
        String die2 = """
                 -------
                | ●     |
                |       |
                |     ● |
                 -------
                """;
        String die3 = """
                 -------
                | ●     |
                |   ●   |
                |     ● |
                 -------
                """;
        String die4 = """
                 -------
                | ●   ● |
                |       |
                | ●   ● |
                 -------
                """;
        String die5 = """
                 -------
                | ●   ● |
                |   ●   |
                | ●   ● |
                 -------
                """;
        String die6 = """
                 -------
                | ●   ● |
                | ●   ● |
                | ●   ● |
                 -------
                """;

        switch(roll) {
            case 1 -> System.out.println(die1);
            case 2 -> System.out.println(die2);
            case 3 -> System.out.println(die3);
            case 4 -> System.out.println(die4);
            case 5 -> System.out.println(die5);
            case 6 -> System.out.println(die6);
            default -> System.out.println("Lancio non valido");
        }

    }

}
