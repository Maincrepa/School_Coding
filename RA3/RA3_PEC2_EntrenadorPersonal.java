/*
El programa demana el nombre de repeticions i imprimeix una línia per cada repetició.
Cada 5 repeticions anima amb un missatge. Si supera 20, felicita amb un missatge final.
*/

import java.util.Scanner;

public class RA3_PEC2_EntrenadorPersonal {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("/// RA3:PEC2 | Entrenador Personal ///");

        System.out.print("Introdueix quantes repeticions vols: ");
        int REP_max = sc.nextInt();
        boolean finished_workout = false;

        for (int REP = 0; REP <= REP_max ; REP++ ) {
            System.out.println("Repetició num: " + REP);

            if (REP % 5 == 0) {
                System.out.println("Has fet 5 repeticions, bon traball!");
            }

            if (REP > 20 && finished_workout == false) {
                System.out.println("Has fet 20 repeticions! Bon traball, has finalitzat l'entrenament.");
                finished_workout = true;
            }

        }


        // demana n. de pereticions
        // print linea per cada repetició

        // cada 5 repeticions, display suport message
        // if >20, felicita amb missatge final
    
    }
}
