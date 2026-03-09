/*
Demana a l’usuari dos nombres enters. Realitza i mostra les operacions següents:
1. Suma, resta, multiplicació.
2. Divisió entera i divisió real.
3. Mòdul.
4. Comparacions: si el primer és més gran, més petit, igual o diferent del segon.

Requisits:
    Fes servir operadors aritmètics i relacionals.
    Mostra els resultats de les comparacions com a valors booleans.
*/

import java.util.Scanner;

public class EJ4_OperacionsNumEnters {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("// Exercici 4 // Operacions amb Números Enters");

        System.out.println("Introdueix el primer número (a):"); // num A
        int a = scanner.nextInt();
        System.out.println("Introdueix el segon número (b):"); // num B
        int b = scanner.nextInt();

        System.out.println("/// OPERACIONS DISPONIBLES ///"); // display the operations
        System.out.println("│ 0 │ Totes disponibles");
        System.out.println("│ 1 │ Suma (a + b)");
        System.out.println("│ 2 │ Resta (a - b)");
        System.out.println("│ 3 │ Multiplicació (a * b)");
        System.out.println("│ 4 │ Divisió (a / b)");
        System.out.println("│ 5 │ Mòdul (a % b)");
        System.out.println("│ 6 │ Comparació a > b");
        System.out.println("│ 7 │ Comparació a < b");
        System.out.println("│ 8 │ Comparació a == b");

        System.out.print("Selecciona una operació (0-8): ");
        int choice = scanner.nextInt();

        System.out.println("/// RESULTAT ///");

        switch (choice) { // see which op user chose

            case 0: // ALL OPERATIONS
                System.out.println("/// TOTES LES OPERACIONS ///");
                System.out.println("Suma: a + b = " + (a + b));
                System.out.println("Resta: a - b = " + (a - b));
                System.out.println("Multiplicació: a * b = " + (a * b));
                System.out.println("Divisió: a / b = " + (a / b));
                System.out.println("Mòdul: a % b = " + (a % b));
                System.out.println("a > b: " + (a > b));
                System.out.println("a < b: " + (a < b));
                System.out.println("a == b: " + (a == b));
                break;


                // Individual operations
            case 1:
                System.out.println("Suma: a + b = " + (a + b));
                break;
            case 2:
                System.out.println("Resta: a - b = " + (a - b));
                break;
            case 3:
                System.out.println("Multiplicació: a * b = " + (a * b));
                break;
            case 4:
                System.out.println("Divisió: a / b = " + (a / b));
                break;
            case 5:
                System.out.println("Mòdul: a % b = " + (a % b));
                break;
            case 6:
                System.out.println("a > b: " + (a > b));
                break;
            case 7:
                System.out.println("a < b: " + (a < b));
                break;
            case 8:
                System.out.println("a == b: " + (a == b));
                break;

            default: // invalid input
                System.out.println("INVALID");
        }
    }
}
