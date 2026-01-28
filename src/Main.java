import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci il tuo nome: ");
        String name = scanner.nextLine();

        System.out.print("Inserisci la tua eta': ");
        int age = scanner.nextInt();

        System.out.print("Sei uno studente ? (s/n): ");
        char check = scanner.next().charAt(0);

        scanner.close();

        boolean isStudent = check == 's';

        String student = "ignoto";

        if(isStudent) {
            student = "Si";
        }
        else student = "No";

        System.out.println("Nome: " + name);
        System.out.println("Eta: " + age);
        System.out.println("Studente: " + student);

        Random random = new Random();

        int dice;

        dice = random.nextInt(1,7);

        System.out.println("Dado: " + dice);

        System.out.println("Pi greco: " + Math.PI);
        System.out.println("Eulero: " + Math.E);

        double result;

        result = Math.pow(2,3);
        result = Math.abs(-5);
        result = Math.sqrt(9);
        result = Math.round(3.14);
        result = Math.ceil(3.14);
        result = Math.floor(3.14);
        result = Math.max(10, 20);
        result = Math.min(10, 20);

        System.out.println(result);

    }
}
