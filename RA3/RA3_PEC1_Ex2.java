/*
Demana tres costats d'un triangle i determina si és equilàter, isòsceles o escalè. Primer verifica si
poden formar un triangle
*/

import java.util.Scanner;

public class RA3_PEC1_Ex2 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("/// Classificador de Triangulos ///");


        System.out.print("Input el primer lado del triangulo: "); // First scan
        double Lado1 = scanner.nextDouble();

        System.out.print("Input el segon lado del triangulo: "); // Second scan
        double Lado2 = scanner.nextDouble();

        System.out.print("Input el segon lado del triangulo: "); // Third scan
        double Lado3 = scanner.nextDouble();

        boolean IsaTriangile = (Lado1+Lado2>Lado3) && (Lado1+Lado3>Lado2) && (Lado2+Lado3>Lado1); // TRIANGLE CHECKER

        if (IsaTriangile) {
            System.out.println("Triangulo correcto! Calculando.."); // Continue triangle alg.

            if (Lado1 == Lado2 && Lado2 == Lado3) { // tres lados iguales
                System.out.println("El triangulo és un Triangulo Equilátero");
            }
            else if (Lado1 == Lado2 || Lado1 == Lado3 || Lado2 == Lado3) { // exactamente dos lados iguales
                System.out.println("El triangulo és un Triangulo Isósceles");
            }
            else { // ningun angulo igual
                System.out.println("El triangulo és un Triangulo Escaleno");
            }
        }
        else {
            System.out.println("Tus inputs no crean un triangulo."); // Not a triangle output
        }
    }
}        