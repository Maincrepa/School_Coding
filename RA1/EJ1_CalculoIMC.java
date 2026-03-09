/*
Escriu un programa que sol·liciti a l’usuari el pes en quilograms i l’alçada en metres. Calcula
l’Índex de Massa Corporal (IMC) amb la fórmula:
        IMC = pes / (alçada²)
Mostra l’IMC calculat amb dos decimals. Després, sense utilitzar estructures condicionals,
mostra les diferències de l’IMC respecte als valors de referència (18,5 i 25) perquè l’usuari pugui
interpretar si es troba en baix pes, pes normal o sobrepès.
*/

import java.util.Scanner;

// <18.5 UNDER
// 18.5-24.9 NORMAL
// >25 OVER

public class EJ1_CalculoIMC {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("// Ejercicio 1 // Calculo del IMC!");

        System.out.print("Introdueix el teu pes en kg: "); // Get Mass
        float Mass = scanner.nextFloat();

        System.out.print("Introdueix la teva alçada en metres: "); // Get Height
        float Height = scanner.nextFloat();

        float IMC_Calc = Mass / (Height * Height); // Formula IMC

        IMC_Calc = (float) Math.floor((IMC_Calc * 100)) / 100; // Arrodonir a 2 decimals

        System.out.println("El teu IMC és: " + IMC_Calc + " | Els teus resultats son:" + "\nInfrapeso = " + (IMC_Calc < 18.5) + "\nPeso normal = " + (IMC_Calc <= 24.9 && IMC_Calc >= 18.5) + "\nSobrepeso = " + (IMC_Calc <= 29.9 && IMC_Calc > 24.9) + "\nObesidad = " + (IMC_Calc > 29.9));
    }
}
