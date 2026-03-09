import java.util.Scanner;

public class RA6_MOD_EX2 {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("/// Funcions | Exercici 2 | Implementa un mètode que retorni el valor més gran entre dos enters. ///");
        System.out.print("Introdueix el primer num: ");
        int num_a = input.nextInt();
        System.out.print("Introdueix el primer num: ");
        int num_b = input.nextInt();

        int resultat = maxim(num_a, num_b);
        System.out.println("El num més gran és: " + resultat);
    }
    public static int maxim(int a, int b) {
        if (a > b) { // Si 'a' més gran;
            return a;
        } else { // Si 'b' més gran;
            return b;
        }
    }
}
