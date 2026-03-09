/*
Dissenyeu un programa que mostri una matriu de 10 × 10 on només la diagonal
principal contingui nombres de l’1 al 10 i la resta siguin zeros
*/

public class RA3_PEC3_Ex5 {

    public static void main(String[] args) {
        System.out.println("/// Taula 10x10, diagonal + 1 ///");

        int DiagonalNum = 1;

        for (int row = 0; row <= 9; row++) {

            // print n* zeros before, print DiagonalNum, print n* after

            for (int side = 0; side <= 9; side++) {
                if (row == side) {
                    System.out.printf("%4d", DiagonalNum);
                } else {
                    System.out.printf("%4d", 0);
                }
            }
            DiagonalNum++;
            System.out.println();

            /*
             * for (int zeros = 1; zeros <= row && row > 0; zeros++) {
             * System.out.printf("%3c", '*');
             * }
             * 
             * System.out.printf("%3d", DiagonalNum);
             * 
             * for (int zeros = 8; zeros >= row; zeros--) {
             * System.out.printf("%3c", '*');
             * }
             * 
             * DiagonalNum++;
             * System.out.println("");
             */

        }

    }
}
