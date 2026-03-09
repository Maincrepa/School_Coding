import java.util.Scanner;

public class RA6_MOD_EX3 {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("/// Funcions | Exercici 3 | Implementa un mètode que indiqui si un nombre és parell. ///");
        System.out.print("Introdueix un num: ");
        int num = input.nextInt();

        boolean resultat = esParell(num); // Funció per veure si num és parell

        System.out.println("El num és parell: " + resultat);
    }
    public static boolean esParell(int a) {
        boolean parell_check = (a % 2 == 0); // Operació
        return parell_check; // Retornar el resultat
    }
}
