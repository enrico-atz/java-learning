package RPS;

import java.util.Random;
import java.util.Scanner;

public class RPS {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Random random = new Random();

        String[] choices = {"sasso", "carta", "forbice"};

        String playerChoice;
        String computerChoice;

        System.out.println("********************************");
        System.out.println("SASSO ✊ / CARTA ✋ / FORBICI ️✌️");
        System.out.println("********************************");

        boolean playAgain = true;

        while(playAgain) {

            boolean isRunning = true;
            int count = 0;
            int score = 0;

            while(isRunning) {

                System.out.println("Digita la tua mossa (sasso / carta / forbice) | ROUND " + (count + 1));
                playerChoice = scanner.nextLine().toLowerCase();

                if(!playerChoice.equals("sasso") &&
                        !playerChoice.equals("carta") &&
                        !playerChoice.equals("forbice")) {
                    System.out.println("Mossa non valida!");
                    continue;
                }

                computerChoice = choices[random.nextInt(0,3)];
                System.out.println("Mossa della cpu: " + computerChoice);

                if(playerChoice.equals(computerChoice)) {
                    System.out.println("PAREGGIO");
                }
                else if(playerChoice.equals("sasso") && computerChoice.equals("forbice") ||
                        playerChoice.equals("carta") && computerChoice.equals("sasso") ||
                        playerChoice.equals("forbice") && computerChoice.equals("carta")) {
                    System.out.println("HAI VINTO");
                    score ++;
                }
                else {
                    System.out.println("HAI PERSO");
                }

                count ++;

                if(count == 5) {
                    System.out.println("*******************");
                    System.out.println(" PARTITA TERMINATA ");
                    System.out.println(" Punteggio: " + score);
                    System.out.println("*******************");
                    isRunning = false;
                }
            }

            String choice = "";
            boolean validChoice = false;

            while(!validChoice) {
                System.out.println("Vuoi giocare ancora? (si/no): ");
                choice = scanner.nextLine().toLowerCase();

                if(choice.equals("si") || choice.equals("sì") || choice.equals("no")) {
                    validChoice = true;
                }
                else {
                    System.out.println("Opzione non valida !");
                }
            }

            if(choice.equals("no")) {
                playAgain = false;
                System.out.println("*************");
                System.out.println(" ARRIVEDERCI ");
                System.out.println("*************");
            }

        }

        scanner.close();

    }

}

