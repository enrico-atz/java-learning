import javax.swing.*;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci il tuo nome: ");
        String nome = scanner.nextLine();

        System.out.print("Inserisci la tua eta': ");
        int eta = scanner.nextInt();

        System.out.print("Sei uno studente ? (s/n): ");
        char check = scanner.next().charAt(0);

        scanner.close();

        boolean isStudent = check == 's';

        String student = "ignoto";

        if(isStudent) {
            student = "Si";
        }
        else student = "No";

        System.out.println("Nome: " + nome);
        System.out.println("Eta: " + eta);
        System.out.println("Studente: " + student);

        Random random = new Random();

        int dado;

        dado = random.nextInt(1,7);

        System.out.println("Dado: " + dado);

    }
}
