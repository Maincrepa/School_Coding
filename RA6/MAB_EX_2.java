/*
Un laboratori farmacèutic està monitorant un conjunt de valors que representen l’activitat d’una molècula en un entorn de prova. Les dades formen una matriu quadrada de 6×6.

Tasques:
1. Omple la matriu amb valors aleatoris entre 1 i 9.
2. Mostra la matriu en format visual.
3. Llegeix i mostra:
    # la diagonal principal (posicions [i][i]),
    # la diagonal secundària (posicions [i][n−1−i]).

4. Calcula:
    # La suma de la diagonal principal,
    # La suma de la diagonal secundària,
    # indica quina diagonal presenta més activitat total.
5. Determina si les diagonals contenen algun valor repetit.
*/

public class MAB_EX_2 { // finished
    public static void main(String[] args) {
        System.out.println("/ / Seguiment de patrons en dades biomèdiques / /");

        int[][] matriu = new int[6][6];
        int sum_p = 0; // diagonal principal
        int sum_s = 0; // diagonal secundaria

        int[] diagonal_p = new int[6];
        int[] diagonal_s = new int[6];

        boolean repetit = false; // verure si algun element es repeteixen

        System.out.println("Matriu 6x6:");
        for (int i = 0; i < matriu.length; i++) {
            for (int j = 0; j < matriu[i].length; j++) {
                int rand = (int) ((Math.random() * 9) + 1); // valor rand 1-9
                System.out.print(rand + " | ");
                matriu[i][j] = rand; // guardar en matriu
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Diagonal Principal 6x:");
        for (int i = 0; i < matriu.length; i++) {
            for (int j = 0; j < matriu[i].length; j++) {
                if (i == j) {
                    System.out.print(matriu[i][j] + " | ");
                    sum_p += matriu[i][j]; // sumar a la suma del matriu pricipal
                    diagonal_p[j] = matriu[i][j]; // assignar al array matriu principal
                } else {
                    System.out.print("* | ");
                }
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Diagonal Secundaria 6x:");
        for (int i = 0; i < matriu.length; i++) {
            for (int j = 0; j < matriu[i].length; j++) {
                if (i == (6 - 1 - j)) {
                    System.out.print(matriu[i][j] + " | ");
                    sum_s += matriu[i][j]; // sumar a la suma de la matriu secundaria
                    diagonal_s[j] = matriu[i][j]; // assignar al array matriu secundari
                } else {
                    System.out.print("* | ");
                }
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Càlculs:");
        System.out.println();
        System.out.println("La suma de la diagonal principal resulta a: " + sum_p);
        System.out.println("La suma de la diagonal secundaria resulta a: " + sum_s);

        if (sum_p == sum_s) { // equals
            System.out.println("Les dues diagonals tenen la mateixa activitat");
        } else if (sum_p > sum_s) { // major
            System.out.println("La diagonal principal té més activitat");
        } else { // minor
            System.out.println("La diagonal secundaria té més activitat");
        }

        for (int i = 0; i < diagonal_p.length; i++) {
            int compare_1 = diagonal_p[i];

            if (!repetit) {
                for (int z = 0; z < diagonal_s.length; z++) {
                    int compare_2 = diagonal_s[z];

                    if (compare_1 == compare_2) {
                        repetit = true; // atleast one repeats
                    }
                }
            }
        }

        if (repetit) {
            System.out.println("Les diagonales contenen algun valor repetit");
        }

    }
}
