package Basics.JavaSlot;

import java.util.Random;
import java.util.Scanner;

public class JavaSlot {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int balance = 100;
        int bet;
        int payout;
        String[] symbols = {"🍒", "🍉", "🍋", "⭐"};
        String playAgain = "";

        System.out.println("*******************");
        System.out.println("🍒🍉 JAVASLOT 🍋⭐");
        System.out.println("*******************");



        while (balance > 0) {

            System.out.println("\nSaldo attuale: € " + balance);
            System.out.print("Piazza la tua scommessa: ");
            bet = scanner.nextInt();
            scanner.nextLine();

            if (bet > balance) {
                System.out.println("Fondi insufficienti");
                continue;
            } else if (bet <= 0) {
                System.out.println("Scommessa non valida ! (almeno 1 €)");
            } else {
                balance -= bet;
            }

            System.out.println("SPINNING...\n");
            String [] row = spinRow(symbols);
            printRow(row);
            System.out.println("\n");

            payout = getPayout(row,bet);

            if(payout > 0) {
                System.out.println("Hai vinto " + payout + " € !");
            }
            else {
                System.out.println("Hai perso " + bet +" € !");
            }

            balance += payout;

            boolean validAnswer = false;

            if(balance <= 0) {
                System.out.println("\n");
                System.out.println("*****************************");
                System.out.println(" SALDO TERMINATO | GAME OVER ");
                System.out.println("*****************************");
                break;
            }

            while(!validAnswer) {

                System.out.println("Vuoi giocare ancora? (s/n): ");
                playAgain = scanner.nextLine();

                if(playAgain.equalsIgnoreCase("s") || playAgain.equalsIgnoreCase("n")) {
                    validAnswer = true;
                }
                else {
                    System.out.println("Risposta non valida !");
                    continue;
                }
            }

            if(!playAgain.equalsIgnoreCase("s")) {
                System.out.println("\n");
                System.out.println("******************************");
                System.out.println(" GIOCO TERMINATO, ARRIVEDERCI ");
                System.out.println("******************************");
                break;
            }

        }

        scanner.close();

    }

    static String[] spinRow(String[] symbols) {

        Random random = new Random();
        String[] row = new String[3];

        for(int i = 0; i < 3; i++) {
            row[i] = symbols[random.nextInt(0,symbols.length)];
        }

        return row;
    }

    static void printRow(String[] row) {
        System.out.println(" " + String.join(" | ", row));
    }

    static int getPayout(String[] row, int bet) {

        if(row[0].equals(row[1]) && row[1].equals(row[2])) {
            return switch(row[0]) {
                case "🍒" -> bet * 2;
                case "🍉" -> bet * 3;
                case "🍋" -> bet * 5;
                case "⭐" -> bet * 10;
                default -> 0;
            };
        }

        if(row[0].equals(row[1]) || row[1].equals(row[2])) {
            return switch(row[1]) {
                case "🍒" -> bet * 1;
                case "🍉" -> bet * 2;
                case "🍋" -> bet * 3;
                case "⭐" -> bet * 4;
                default -> 0;
            };
        }

        return 0;
    }
}
