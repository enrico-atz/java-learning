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

        double a;
        double b;
        double c;

        System.out.print("Inserisci il lato a: ");
        a = scanner.nextDouble();

        System.out.print("Inserisci il lato b: ");
        b = scanner.nextDouble();

        c = Math.sqrt(Math.pow(a,2) + Math.pow(b,2));

        System.out.println("L'ipotenusa vale: " + c);

        double radius;
        double circumference;
        double area;
        double volume;

        System.out.print("Inserisci il raggio: ");
        radius = scanner.nextDouble();

        circumference = 2 * Math.PI * radius;
        area = Math.PI * Math.pow(radius,2);
        volume = (4.0/3.0) * Math.PI * Math.pow(radius,3);

        System.out.printf("Circonferenza: %.1f\n", circumference);
        System.out.printf("Area: %.1f\n", area);
        System.out.printf("Volume: %.1f\n", volume);

        double price1 = 9.99;
        double price2 = 1000.15;
        double price3 = -54.01;

        System.out.printf("% ,.2f\n", price1);
        System.out.printf("% ,.2f\n", price2);
        System.out.printf("% ,.2f\n", price3);

        int id1 = 1;
        int id2 = 12;
        int id3 = 123;
        int id4 = 1234;

        System.out.printf("%04d\n", id1);
        System.out.printf("%04d\n", id2);
        System.out.printf("%04d\n", id3);
        System.out.printf("%04d\n", id4);

        scanner.close();

    }
}
