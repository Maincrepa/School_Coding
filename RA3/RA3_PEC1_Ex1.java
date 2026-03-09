/*
Crea una calculadora que demani dos números i una operació (+, -, *, /). Realitza l'operació
corresponent i mostra el resultat. Si és una divisió per zero, mostra error.
*/

import java.util.Scanner;

public class RA3_PEC1_Ex1 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("/// Calculadora Simple ///");

        System.out.print("Input el primer numero: "); // First num scan
        double firstnum = scanner.nextDouble();

        System.out.print("Input el segon numero: "); // Second num scan
        double secondnum = scanner.nextDouble();

        System.out.print("Input a operació (+, -, *, /): "); // Operation scan
        char operation = scanner.next().charAt(0);

        System.out.println("DEBUG: " + firstnum + " | " + secondnum + " | " + operation); // debug para devs
        double result = 0; // valor inicial

        switch (operation) {
            case '+': // Sumar
                result = firstnum + secondnum;
                break;

            case '-': // Restar
                result = firstnum - secondnum;
                break;

            case '*': // Multiplicar
                result = firstnum * secondnum;
                break;

            case '/': // Dividir
                if (secondnum == 0) {
                    System.out.println("! No es possibe dividir entre zero."); // dividir entre 0 check
                    result = 0;
                } else {
                    result = firstnum / secondnum;
                }
                break;

            default:
                System.out.println("Introduce una operacion válida.");
                break;
        }

        System.out.println("El resultado de la operación (" + firstnum + " " + operation + " " + secondnum + ") és: " + result); // RESULTADO FINAL
    }
}
