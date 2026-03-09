/*
El jugador tira un dau fins que surti un 6. El programa mostra totes les tirades i el nombre
d’intents totals.Després pregunta si vol tornar a jugar
*/

import java.util.Scanner;

public class RA3_PEC2_1_JocDeDau {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("/// RA3:PEC2 | Joc de Dau ///");

        // tirar dau
        // repetir fins que surti 6

        // mostrar: totes les tirades, intents totals
        // ask if want to play again

        boolean playing = true;

        while (playing) {
            boolean Won = false;

            
            int Plays = 0;

            while (Won == false) {
                int RandomPlay = (int) (Math.random() * 6) + 1;
                Plays ++;
                if (RandomPlay == 6) { // WIN CONDITION
                    System.out.println("Sacaste un 6, Has Ganado!");
                    System.out.println("En total, tiraste el dado " + Plays + " veces.");
                    Won = true;

                } else { // repeat
                    System.out.println("No te tocó el 6, repitiendo (Intento: " + RandomPlay + ")");
                }
            }

            System.out.println("Exit game? (y/n)");
            char exitchar = sc.next().charAt(0);

            if (exitchar == 'y') {
                System.out.println("USER DECIDED TO EXIT");
                playing = false;
            }
        }

    }
}
