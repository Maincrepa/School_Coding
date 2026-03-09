import java.util.Scanner;

public class RA6_MOD_EX10 {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("/// Funcions | Exercici 10 | Implementa un mètode que retorni el valor més gran dins d'una matriu bidimensional d'enters. ///");

        int matriu[][] = {
            {1,2,3},
            {4,8,6},
            {2,5,6},
        };

        int resultat = maxim(matriu);
        System.out.println("El valor més gran és: " + resultat);
    }
    public static int maxim(int[][] matriu) {
        int valor_maxim = 0;
        for (int row = 0; row < matriu.length; row++) {
            for (int col = 0; col < matriu[row].length; col++) {
                if (matriu[row][col] > valor_maxim) {
                    valor_maxim = matriu[row][col];
                }
            }
        }
        return valor_maxim;
    }
}
