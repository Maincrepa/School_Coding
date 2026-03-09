/*
Mostra un menú perquè l’usuari triï quina figura vol imprimir per pantalla.
Permet repetir fins que triï “Sortir”.
Opcions d’exemple:
1. Triangle
2. Quadrat
3. Rectangle
4. Sortir
*/

import java.util.Scanner;

public class RA3_PEC2_FiguresGeom {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("/// RA3:PEC2 | Menú de figures geomètriques ///");

        // menu perque usuari trii

        boolean selecting = true; // exit val

        while (selecting == true) {

            System.out.println("  | Selecciona una figura geometrica per imprimir");
            System.out.println("1 | Triangle");
            System.out.println("2 | Quadrat");
            System.out.println("3 | Rectangle");
            System.out.println("4 | Sortir");

            int option = sc.nextInt(); // selecting one of 4 options

            System.out.println("Has seleccionat " + option + "."); // print selected
            System.out.println(" "); //visual

            switch (option) {
                case 1:
                    System.out.println("Imprimint un triangle..");
                    break;

                case 2:
                    System.out.println("Imprimint un quadrat..");
                    break;

                case 3:
                    System.out.println("Imprimint un rectangle..");
                    break;
                    
                case 4:
                    System.out.println("Sortint del programa..");
                    selecting = false;
                    break;

                default:
                    System.out.println("Selecciona una opció vàlida");
                    break;
            }

            System.out.println(" "); //visual
            System.out.println("-------------------------------");

        }

    }
}
