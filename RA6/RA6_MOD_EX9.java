import java.util.Scanner;

public class RA6_MOD_EX9 {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("/// Funcions | Exercici 9 | Implementa un mètode que calculi la mitjana dels valors d'un array de nombres reals. ///");
        
        double valors[] = {4.8,3.3,246.2,76.1,243,787.7,12};

        double resultat = mitjana(valors);
        System.out.println("La mitjana dels valors és: " + resultat);
    }
    public static double mitjana(double[] valors) {
        double mitjana = 0;
        for (int array_i = 0; array_i < valors.length; array_i++) {
            mitjana += valors[array_i]; // suma tots els valors
        }
        return (mitjana / valors.length); // retorna la mitjana
    }
}
