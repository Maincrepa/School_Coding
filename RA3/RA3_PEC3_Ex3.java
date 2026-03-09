/*
Escriviu un programa que mostri per pantalla un triangle numèric creixent, començant
per 1 a la primera línia i afegint un nombre més a cada línia fins arribar a 10.
*/

public class RA3_PEC3_Ex3 {

    public static void main(String[] args) {
        System.out.println("/// Triangle numeric creixent ///");

        int CharsToShow = 1;

        for (int row = 1; row <= 10; row += 1) {
            for (int col = 1; col <= CharsToShow; col += 1) {
                System.out.printf("%4d", (col));
            }
            CharsToShow++;
            System.out.println("");
        }

    }
}
