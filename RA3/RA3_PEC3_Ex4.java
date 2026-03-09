/*
Feu un programa que imprimeixi un triangle invertit format per asteriscs (*) començant
amb 10 asteriscs i reduint-ne un a cada línia.
*/

public class RA3_PEC3_Ex4 {

    public static void main(String[] args) {
        System.out.println("/// Taula 10x10, cada fila +1 ///");

        int CharsToShow = 10;

        for (int row = 1; row <= 10; row += 1) {
            for (int col = 1; col <= CharsToShow; col += 1) {
                System.out.printf("%2c", '*');
            }
            CharsToShow--;
            System.out.println("");
        }

    }
}
