package Basics.Varargs;

import java.util.Scanner;

public class Varargs {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Quanti numeri vuoi sommare? ");
        int size = scanner.nextInt();

        int[] toSum = new int[size];

        for(int i = 0; i < size; i++) {
            System.out.printf("Inserisci numero %d: ", i+1);
            toSum[i] = scanner.nextInt();
        }

        int sum = add(toSum);

        System.out.println("La somma dei numeri e': " + sum);


    }

    static int add(int... numbers) {
        int sum = 0;
        for(int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
