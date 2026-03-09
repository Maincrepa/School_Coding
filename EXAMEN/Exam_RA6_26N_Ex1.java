/*
text
*/

import java.util.Scanner;

public class Exam_RA6_26N_Ex1 {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.print("Introdueix un valor base: ");
            double valorbase = input.nextDouble(); // diferent de paper, he posat nextInt, olvidant que he cambiat de int a double

            boolean correctval = false;
            int num_env = 0; // diferent de paper, s'ha de declarar fora del bucle per fer servir en els calculs

            while (!correctval) {
                System.out.println("Selecciona un tipus d'enviament: " +
                        " 1: Enviament estàndar" +
                        " 2: Enviament urgent" +
                        " 3: Enviament internacional");

                System.err.print("Selecciona: (1/2/3): ");
                num_env = input.nextInt();

                switch (num_env) {
                    case 1:
                        System.out.println("Has seleccionat Enviament estàndar");
                        correctval = true;
                        break;
                    case 2:
                        System.out.println("Has seleccionat Enviament urgent");
                        correctval = true;
                        break;
                    case 3:
                        System.out.println("Has seleccionat Enviament internacional");
                        correctval = true;
                        break;
                    default:
                        System.out.println("Introdueix un enviament correcte (1/2/3).");
                        break;
                }
            }
            System.out.println();

            double base_IVA = (valorbase * (21.0/100.0));
            double[] suplementArray = {2, 5, 10};
            double calc_supl = (suplementArray[num_env-1]);
            double calc_final = ((valorbase + base_IVA) + calc_supl);

            System.out.println();
            System.out.println("Import base: " + valorbase + "€. " +
                "S'ha aplicat un IVA de 21%, resutant en l'increment de " + base_IVA + "€. " +
                "S'ha seleccionat l'enviament de tipus " + num_env + " resultant en un increment de " + calc_supl + "€. " +
                "El valor final és de: " + calc_final + "€."
            );

            if (calc_final > 100) {
                System.out.println("Valor alt");
            } else if (calc_final < 20) {
                System.out.println("Valor baix");
            } else {
                System.out.println("Valor correcte");
            }

            System.out.println(" / / / ");
            System.out.print("Has completat l'operació, vols continuar? [S/N]: ");
            char opcio_exit = input.next().toLowerCase().charAt(0); // diferent de paper, he posat lowercase en el if, i no en el input

            if (opcio_exit == 's') {
                System.out.println("Has decidit continuar");
            } else {
                System.out.println("Has decidit tancar el programa");
                running = false;
            }
        }
    }
}
