package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Arr {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci la quantita' dei prodotti: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        System.out.println("\n");

        String[] foods = new String[quantity];

        int numOfFruit = foods.length;

        for(int i = 0; i < numOfFruit; i++) {
            System.out.printf("Inserisci prodotto %d: ", i+1);
            foods[i] = scanner.nextLine();
        }

        /*

        System.out.println("\nTraditional for loop: ");

        for(int i = 0; i < numOfFruit; i++) {
            System.out.println(foods[i]);
        }

        System.out.println("\nEnhanced for loop: ");

        for(String food : foods) {
            System.out.println(food);
        }

        */

        Arrays.sort(foods);

        System.out.println("\nArray ordinato alfabeticamente: ");

        for(String food : foods) {
            System.out.println(food);
        }

        System.out.print("\nInserisci prodotto da cercare nell' array: ");
        String target = scanner.next();

        findString(foods,target);

        scanner.close();
    }

    static void findString(String[] array, String target) {
        boolean isFound = false;
        for(int i = 0; i < array.length; i++) {
            if(array[i].equals(target)) {
                System.out.println("Corrispondenza trovata all'indice: " + i);
                isFound = true;
                break;
            }
        }
        if(!isFound) {
            System.out.println("Nessuna corrispondenza trovata");
        }
    }
}
