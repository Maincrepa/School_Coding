/*
Mostra per pantalla una taula de 10 × 10 on cada fila comenci amb un número més alt
que l’anterior.
*/

public class RA3_PEC3_Ex2 {

    public static void main(String[] args) {
        System.out.println("/// Taula 10x10, cada fila +1 ///");

        for (int row = 1; row <= 10; row += 1) {
            for (int col = 0; col <= 9; col += 1) {
                System.out.printf("%4d", (col + row));
            }
            System.out.println("");
        }

    }
}
