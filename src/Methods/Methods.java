package Methods;
import java.util.Scanner;

public class Methods {

    static void countDown(int duration) throws InterruptedException {
        for(duration = 5; duration > 0; duration--) {
            System.out.print("Il programma si arrestera' in: " + duration + "\r");
            Thread.sleep(1000);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);

        double num1, num2;
        char operator;
        double result = 0.0;
        boolean validOperator = true;

        System.out.print("Inserisci il primo numero: ");
        num1 = scanner.nextDouble();

        System.out.print("Inserisci un operatore (+, -, *, /, ^): ");
        operator = scanner.next().charAt(0);

        System.out.print("Inserisci il secondo numero: ");
        num2 = scanner.nextDouble();

        switch(operator) {
            case '+' -> result = num1 + num2;
            case '-' -> result = num1 - num2;
            case '*' -> result = num1 * num2;
            case '/' -> {
                if(num2 == 0) {
                    System.out.println("Non e' possibile dividere per 0!");
                }
                else {
                    result = num1 / num2;
                }
            }
            case '^' -> result = Math.pow(num1,num2);
            default -> {
                System.out.println(operator + " non e' un operatore valido.");
                validOperator = false;
            }
        }

        if(validOperator) {
            System.out.println("Il risultato e': " + result);
        }

        scanner.close();

        countDown(5);
    }

}
