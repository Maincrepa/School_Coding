/*
text
*/

import java.util.Scanner;

public class REP_Practica_7 {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Vols que sigui creixent o decreixent? (c/d) ");
        char selection = input.next().charAt(0);

        System.out.print("Introdueix un nombre inicial m: "); // -5
        int num_m = input.nextInt();

        System.out.print("Introdueix una quantitat n: "); // 5
        int num_n = input.nextInt();

        int suma = 0;

        if (num_n > 0) {
            if (selection == 'd') { // drecreixent
                int num = num_m;
                for (int i = num_m; i < (num_n + num_m); i++) {
                    num--;
                    System.out.println(num);
                    suma += num;
                }
            } else if (selection == 'c') { // creixent, unchanged
                for (int i = num_m; i < (num_n + num_m); i++) {
                    System.out.println(i);
                    suma += i;
                }
            } else {
                System.out.println("Error: Selecciona un valor correcte.");
            }
        }

        System.out.println("La Suma final és: " + suma);
    }
}
