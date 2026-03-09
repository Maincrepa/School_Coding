/*
L’empresa LightMatrix Corp., dedicada a la fabricació de panells LED, vol simular la rotació de patrons de llum en una matriu de 4×4. Quan el panell falla, la informació apareix desplaçada 90 graus.

Tasques:
1. Genera una matriu de 4×4 amb valors entre 0 i 9.
2. Mostra la matriu original.
3. Calcula la matriu rotada 90 graus a la dreta.
4. Calcula la matriu rotada 90 graus a l’esquerra.
5. Mostra totes les versions (original, rotada dreta, rotada esquerra).
6. Comprova si rotar dues vegades a la dreta dona el mateix resultat que rotar dues vegades a l’esquerra.
 */

public class MAB_EX_3 {

    public static void main(String[] args) {
        System.out.println("/ / Rotació de dades en panells LED / /");

        final int SIZE = 4;

        int[][] matriu_org = new int[SIZE][SIZE]; // matriu original
        int[][] matriu_rot = new int[SIZE][SIZE]; // matriu rotada

        System.out.println("Matriu 4x4:");

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int rand = (int) ((Math.random() * 9) + 1); // valor rand 1-9
                matriu_org[i][j] = rand; // guardar en matriu
                System.out.printf("%-5s", matriu_org[i][j]); // print
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Matriu rotada 90 graus a la dreta:");

        for (int row = 0; row < SIZE; row++) {
            for (int column = 0; column < SIZE; column++) {
                matriu_rot[row][column] = matriu_org[SIZE - 1 - column][row];
            }
        }

        for (int i = 0; i < matriu_rot.length; i++) {
            for (int j = 0; j < matriu_rot[i].length; j++) {
                System.out.printf("%-5s", matriu_rot[i][j]); // print
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Matriu rotada 90 graus a la l'esquerra:");

        int it2 = 4; // second iterator
        for (int row = 0; row < SIZE; row++) { // bottom up
            it2--;
            for (int column = 0; column < SIZE; column++) {
                matriu_rot[row][column] = matriu_org[column][it2];
            }
        }

        for (int i = 0; i < matriu_rot.length; i++) {
            for (int j = 0; j < matriu_rot[i].length; j++) {
                System.out.printf("%-5s", matriu_rot[i][j]); // print
            }
            System.out.println();
        }

        // rotar dues vegades a cada costat SEMPRE donará el mateix.
    }
}
