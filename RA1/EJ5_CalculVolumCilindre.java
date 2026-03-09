/*
Calcula el volum d’un cilindre a partir del seu radi i alçada. El programa ha de demanar a l’usuari
el radi i l’alçada (en metres). La fórmula del volum és:
        V = π × radi² × alçada
Utilitza un valor constant per a π (3,1416). Mostra el volum calculat en metres cúbics amb tres
decimals.
*/

import java.util.Scanner;

public class EJ5_CalculVolumCilindre {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("// Exercici 5 // Càlcul del Volum d'un Cilindre");

        System.out.print("Introdueix el radi de la base del cilindre en metres (r): ");
        double radi = scanner.nextDouble();

        System.out.print("Introdueix l'alçada del cilindre en metres (h): ");
        double altura = scanner.nextDouble();

        double volum = Math.PI * Math.pow(radi, 2) * altura; // Formula V = pi * r^2 * h
        volum = Math.floor(volum * 1000) / 1000; // Arrodonir a 3 decimals

        System.out.println("El volum del cilindre és: " + volum + " metres cúbics.");
    }   

}
