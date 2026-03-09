/*
Escriu un programa que demani a l’usuari una quantitat de temps en segons. El programa ha de
convertir aquesta quantitat a hores, minuts i segons. Per exemple, 3665 segons són 1 hora, 1
minut i 5 segons.Mostra el resultat en el format HH:MM:SS (assegura’t que hores, minuts i
segons es mostren amb dos dígits).
*/

import java.util.Scanner;

public class EJ2_ConveridorTemps {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("// Exercici 2 // Convertidor de Temps");


        System.out.print("Introdueix el temps en segons: ");
        int segons = scanner.nextInt();
        
        int originalSegons = segons; // Guardar valor original

        int hores = segons / 3600;    // 3600 s = 1 hr
        segons = segons % 3600; //mod
        
        int minuts = segons / 60;     // 60 s = 1 min
        segons = segons % 60; // mod

        System.out.println("El temps introduït (" + originalSegons + " segons) es converteix en: " + 
        hores + " HH : " + minuts + " MM : " + segons + " SS.");
    }
}
