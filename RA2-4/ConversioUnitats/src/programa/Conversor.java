import java.util.Scanner;

import utilitats.conversions.Distancia;
import utilitats.conversions.Pes;
import utilitats.conversions.Temperatura;

public class Conversor {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        Temperatura conv_temp = new Temperatura();
        Distancia conv_dist = new Distancia();
        Pes conv_pes = new Pes();

        boolean active = true;

        while (active) {
            System.out.println();
            int option = menu();

            switch (option) {
                case 1: // Temperatura; celsiusAFahrenheit
                    celsiusAFahrenheit();
                    break;
                case 2: // Distancia; kilometresAMilles
                    kilometresAMilles();
                    break;
                case 3: // Pes; kilosALliures
                    kilosALliures();
                    break;
                
                case 0:
                    active = false;
                    break;
                default:
                    break;
            }
        }
    }

    public static int menu() {
        int menu_option = -1;

        System.out.println("""
        ==========================
            CONVERTOR
        ==========================

            1. Celsius a Fahrenheit
            2. Kilometres a Milles
            3. Kilos a Lliures

            0. Sortir
                
        """);

        while (!(menu_option >= 0 && menu_option <= 3)) { // Opcions: 0-3
            System.out.print("Introdueix l'opció: ");
            menu_option = input.nextInt();
        }

        return menu_option;
    }

    public static void celsiusAFahrenheit() {
        double input = introduccioDades("Celsius");
        double resultat = Temperatura.celsiusAFahrenheit(input);
        System.out.println("Resultat (C -> F): " + resultat);
    }

    public static void kilometresAMilles() {
        double input = introduccioDades("Kilometres");
        double resultat = Distancia.kilometresAMilles(input);
        System.out.println("Resultat (Km -> Milles): " + resultat);
    }

    public static void kilosALliures() {
        double input = introduccioDades("Kilos");
        double resultat = Pes.kilosALliures(input);
        System.out.println("Resultat (Kg -> Lliures): " + resultat);
    }

    public static double introduccioDades(String tipus_dada) {
        System.out.print("Introdueix " + tipus_dada + ": ");
        double output = input.nextDouble();
        return output;
    }
}
