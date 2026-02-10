package Basics.BankingProgram;

import java.util.Scanner;

public class BankingProgram {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        double balance = 0;
        boolean isRunning = true;
        int choice;

        while(isRunning) {

            System.out.println("-----------");
            System.out.println("SIMPLE BANK");
            System.out.println("-----------");
            System.out.println("1. SALDO");
            System.out.println("2. DEPOSITARE");
            System.out.println("3. PRELEVARE");
            System.out.println("4. EXIT");
            System.out.println("-----------");

            System.out.print("Seleiona un' operazione (1-4): ");
            choice = scanner.nextInt();

            switch(choice) {
                case 1 -> showBalance(balance);
                case 2 -> balance += deposit();
                case 3 -> balance -= withdraw(balance);
                case 4 -> {
                    System.out.println("-----------");
                    System.out.println("ARRIVEDERCI");
                    System.out.println("-----------");
                    isRunning = false;
                }
                default -> System.out.println("Operazione non valida");
            }
        }

    scanner.close();

    }

    static void showBalance(double balance) {
        System.out.println("-----");
        System.out.println("SALDO");
        System.out.println("-----");
        System.out.printf("€ %,.2f\n", balance);
    }

    static double deposit() {
        System.out.println("----------");
        System.out.println("DEPOSITARE");
        System.out.println("----------");
        double amount = scanner.nextDouble();
        if(amount < 0) {
            System.out.println("Non puoi depositare una somma negativa.");
            return 0;
        }
        return amount;
    }

    static double withdraw(double balance) {
        System.out.println("---------");
        System.out.println("PRELEVARE");
        System.out.println("---------");
        double amount = scanner.nextDouble();
        if(amount < 0) {
            System.out.println("Non puoi prelevare una somma negativa.");
            return 0;
        }
        if(amount > balance) {
            System.out.println("Fondi insufficienti.");
            return 0;
        }
        return amount;
    }

}
