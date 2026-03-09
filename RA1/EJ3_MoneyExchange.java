/*
Crea un programa que converteixi una quantitat d’euros a dòlars. El programa ha de demanar a
l’usuari la quantitat en euros i el tipus de canvi actual (quants dòlars per euro). Després, mostra
la quantitat convertida en dòlars. A més, converteix de nou la quantitat en dòlars a euros per
verificar la precisió.
Requisits:
    Realitza la conversió en ambdues direccions.
    Mostra els resultats amb fins a dos decimals.
*/

import java.util.Scanner;

public class EJ3_MoneyExchange {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("// Exercici 3 // Intercanvi entre monedes");

        System.out.println("Introdueix la quantitat d'euros a convertir:"); // Get amount in eur
        double euros = scanner.nextDouble();

        System.out.println("Introdueix el canvi actual:"); // Get exchange rate
        double exchangeRate = scanner.nextDouble();

        double dollars = Math.floor(euros * exchangeRate * 100) / 100; // Càlcul i arrodoniment a 2 decimals

        System.out.println(euros + " euros es converteix en: " + dollars + " dollars."); // Print

        System.out.println("Verificació, qty euros original: " + (dollars / exchangeRate) + " euros"); // verif
    }
}
