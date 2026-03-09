

import java.util.Scanner;

public class Practice_Repetició {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Acumulador, sumar multiples de 3");

        System.out.println("Selecciona metodo de resolución: (1-3)");
        int Method = scanner.nextInt();

        switch (Method) {
            case 1: // Method 1: Using while

                int TillN = 30; // do until N
                int num = 3; // iterator

                while (num <= TillN) {
                    System.out.println(num + " és multiple de 3");
                    num += 3; // ir sumando de 3
                }

                break;

            case 2: // Method 2: Using for

                for (int LO_QUE_QUIERAS = 3; LO_QUE_QUIERAS <= 30; LO_QUE_QUIERAS += 3) {
                    System.out.println(LO_QUE_QUIERAS + " és multiple de 3");
                }

                break;

            case 3: // Method 3:i %% 3 == 0
                int TillN_3 = 300;
                int num3 = 0;

                while (num3 <= TillN_3) {
                    if (num3 % 3 == 0) {
                        System.out.println(num3 + " - Sí és multiple de 3!");
                    } else {
                        System.out.println(num3 + " - no es multiple de 3");
                    }
                    num3 += 1;
                }

                break;

            default:
                break;
        }

    }
}