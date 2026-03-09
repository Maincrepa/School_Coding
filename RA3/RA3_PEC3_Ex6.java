/*
Feu un programa que mostri una matriu de 10 × 10 amb una creu d’asteriscs formada
per la diagonal principal i la diagonal secundària. La resta de posicions s’omplen amb punts.
*/

public class RA3_PEC3_Ex6 {

    public static void main(String[] args) {
        System.out.println("/// Taula 10x10, diagonal + 1 ///");

        for (int fila = 0; fila <= 9; fila++) {
            /*
             * 10 total slots
             * 
             * space before
             * asterisk primary [ \ ] -1 fila, +1 columna
             * spaces middle (--2)
             * asterisk secondary [ / ] -1 fila, -1 columna
             * space after
             */

            for (int side = 0; side <= 9; side++) {
                if (fila == side) {
                    PrintAsterisk();
                } else if ((fila+side)==(10-1)) { //row + col == size - 1
                    PrintAsterisk();
                } else {
                    PrintSpace();
                }
            }
            System.out.println();

        }
    }

    public static void PrintSpace() {
        System.out.printf("%3c", '·');
    }

    public static void PrintAsterisk() {
        System.out.printf("%3c", '*');
    }
}
