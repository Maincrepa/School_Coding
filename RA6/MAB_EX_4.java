/*
Una consultora d’enginyeria analitza la distribució de càrregues d’un pont. El model simplificat es representa amb una matriu quadrada on matriu[i][j] representa la influència entre dos punts estructurals.
En un sistema ideal, la matriu hauria de ser simètrica (matriu[i][j] == matriu[j][i]).

Tasques:
1. Demana a l’usuari la mida n de la matriu (entre 2 i 7).
2. Omple la matriu amb valors aleatoris entre 1 i 20.
3. Mostra la matriu.
4. Determina si la matriu és simètrica comprovant tots els parells [i][j] i [j][i].
5. En cas que no sigui simètrica:
    # mostra el primer parell d’elements que trenquen la simetria,
    # genera una versió simètrica corregida, on cada posició matriu[i][j] rep el valor mitjà de matriu[i][j] i matriu[j][i].
 */
import java.util.Scanner;

public class MAB_EX_4 { // finished

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("/ / Detecció de simetria en informes d'enginyeria estructural / /");

        int num = 0;

        while (!(num >= 2 && num <= 7)) { // sistema d'introducció
            System.out.print("Introdueix la mida n de la matriu (entre 2-7): ");
            num = input.nextInt();
        }

        int[][] matriu = new int[num][num];

        System.out.println();
        System.out.println("Matriu " + num + "x" + num + ": ");
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                int rand = (int) ((Math.random() * 20) + 1); // valor random 1-20
                matriu[i][j] = rand;
                System.out.printf("%-5s", rand); // print taula
            }
            System.out.println();
        }

        boolean Simetrica = true;
        int rompe_i = 0, rompe_j = 0;

        for (int i = 0; i < num; i++) {
            for (int j = i + 1; j < num; j++) {
                if ((matriu[i][j] != matriu[j][i]) && (Simetrica)) {
                    Simetrica = false; // tallem el bucle
                    rompe_i = i + 1; // primers valors que trenquen
                    rompe_j = j + 1;
                }
            }
        }

        System.out.println();
        if (Simetrica) {
            System.out.println("La matriu SÍ és simètrica");
        } else {
            System.out.println("La matriu NO és simètrica");
            System.out.println("El parell que trenca la simetria és: [" + rompe_i + "-" + rompe_j + "] i [" + rompe_j + "-" + rompe_i + "]");

            for (int i = 0; i < num; i++) {
                for (int j = i + 1; j < num; j++) {
                    if (matriu[i][j] != matriu[j][i]) {
                        int valor = ((matriu[i][j]+matriu[j][i]) / 2); // valor mitjà
                        matriu[i][j] = valor; // assignació dels valors correctes/simètrics
                        matriu[j][i] = valor;
                    }
                }
            }

            System.out.println();
            System.out.println("Print de la versió simètrica corregida:");
            for (int i = 0; i < num; i++) {
                for (int j = 0; j < num; j++) {
                    System.out.printf("%-5s", matriu[i][j]); // print taula
                }
                System.out.println();
            }
        }

    }
}
