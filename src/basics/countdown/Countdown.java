package basics.countdown;
import java.util.Scanner;

public class Countdown {
    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci la durata (intera) del conto alla rovescia (in secondi): ");
        int count = scanner.nextInt();

        for(int i = count; i > 0; i--) {
            System.out.println(i);
            Thread.sleep(1000);
        }

        System.out.println("Conto alla rovescia terminato.");

    }
}
