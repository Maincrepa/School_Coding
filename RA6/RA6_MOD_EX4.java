import java.util.Scanner;

public class RA6_MOD_EX4 {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("/// Funcions | Exercici 4 | Implementa un mètode que calculi la potència d'un nombre utilitzant un bucle (no es pot usar Math.pow).. ///");
        System.out.print("Introdueix la base: ");
        int base = input.nextInt();
        System.out.print("Introdueix el exponent: ");
        int exponent = input.nextInt();

        int resultat = potencia(base, exponent); // Funció

        System.out.println("La potència és: " + resultat);
    }
    public static int potencia(int base, int exponent) {
        int potencia = base;

        for (int i = 0; i < exponent - 1; i++) { // Iterar pel num de exponents -1
            potencia *= base; // multiplicar el resultat de l'anterior per la base (basicament multiplicar una altra vegada base x base)
        }
        return potencia; // Retornar el resultat
    }
}
