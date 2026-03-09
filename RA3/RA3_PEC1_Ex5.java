/*
Aplica descomptes segons:
Menors de 18: 25%
Majors de 65: 30%
Socis: 15% extra sobre el descompte per edat
*/

import java.util.Scanner;

public class RA3_PEC1_Ex5 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("/// Sistema de Descomptes per Edat i Membresia ///");

        System.out.println("- | Se te aplica algunos de estos descuentos?");
        System.out.println("0 | No me aplica nada");
        System.out.println("1 | Menor de 18");
        System.out.println("2 | Mayor de 65");
        
        int Input_Descuento = scanner.nextInt();

        System.out.println("- | Eres socio de la empresa?");
        System.out.println("0 | No lo soy");
        System.out.println("1 | Sí lo soy");

        int Input_Soci = scanner.nextInt();

        int DescompteTotal = 0;

        switch (Input_Descuento) {
            case 1:
                DescompteTotal += 25;
                break;
            case 2:
                DescompteTotal += 30;
                break;
            default:
                break;
        }

        switch (Input_Soci) {
            case 1:
                DescompteTotal += 15;
                break;
            default:
                break;
        }

        System.out.println("El teu descompte total és de " + DescompteTotal + "%");
    }
}