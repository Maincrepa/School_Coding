import java.util.Scanner;

public class RA6_MOD_EX1 {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("/// Funcions | Exercici 1 | Implementa un mètode que retorni la suma de dos enters. ///");
        System.out.print("Introdueix el primer num: ");
        int num_a = input.nextInt();
        
        System.out.print("Introdueix el primer num: ");
        int num_b = input.nextInt();

        int resultat = suma_dos_enters(num_a, num_b); // Funció per sumar els dos

        System.out.println("El resultat de la suma és: " + resultat);
    }
    public static int suma_dos_enters(int a, int b) {
        int suma = (a + b); // Operació
        return suma; // Retornar el resultat
    }
}
