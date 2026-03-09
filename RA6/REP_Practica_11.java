/*
text
*/

import java.util.Scanner;

public class REP_Practica_11 {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String[] Paraules = new String[5];
        int paraulesMésQ5 = 0;

        System.out.println("Introdueix 5 paraules:");
        for (int i = 0; i < 5; i++) { // 5 iteration loop
            System.out.print("· Introdueix la paraula [" + (i + 1) + "]: ");

            String inputtedP = input.next();
            Paraules[i] = inputtedP; // assign i pos in array with word

            if (inputtedP.length() > 5) { // see if word is > 5 lletres
                paraulesMésQ5++; // if true, add to counter
            }
        }

        int largestParaulaPos = 0; // guardar la pos en array de la palabra más grande
        for (int i = 1; i < Paraules.length; i++) { // 5 iteration loop
            if (Paraules[i].length() > Paraules[largestParaulaPos].length()) { // si paraula del iterador > palabra más grande;
                largestParaulaPos = i; // assignar nueva palabra más grande
            }
        }

        // final result prints
        System.out.println("La paraula més llarga és: " + Paraules[largestParaulaPos] + ", en la posició ["
                + (largestParaulaPos + 1) + "] amb [" + Paraules[largestParaulaPos].length() + "] lletres.");
        System.out.println("Hi ha " + paraulesMésQ5 + " paraula amb més de 5 lletres");

    }
}
