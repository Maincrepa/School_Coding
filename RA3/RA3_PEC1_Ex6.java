/*
Converteix entre diferents unitats usant switch:
1: cm a polzades
2: km a milles
3: °C a °F
4: kg a lliures
*/

import java.util.Scanner;

public class RA3_PEC1_Ex6 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("/// Conversor d'Unitats amb Switch ///");

        System.out.println("- | Quina unitat vols convertir?");
        System.out.println("1 | cm a polzades");
        System.out.println("2 | km a milles");
        System.out.println("3 | °C a °F");
        System.out.println("4 | kg a lliures");
        
        int UserConv = scanner.nextInt();
        String UnitFrom = "nil";
        String UnitTo = "nil";

        double UserNum = 0;

        double UserResult = 0;

        switch (UserConv) {
            case 1:
                UnitFrom = "cm"; // Unitat 1
                UnitTo = "polzades"; // Unitat 2

                System.out.print("Introdueix el numero de "+ UnitFrom +" que vols convertir a "+ UnitTo +": ");
                UserNum = scanner.nextDouble(); // Scan Input

                UserResult = (UserNum * 2.54); // Operació
                
                break;
            case 2:
                UnitFrom = "km"; // Unitat 1
                UnitTo = "milles"; // Unitat 2

                System.out.print("Introdueix el numero de "+ UnitFrom +" que vols convertir a "+ UnitTo +": ");
                UserNum = scanner.nextDouble(); // Scan Input

                UserResult = (UserNum * 1.609); // Operació
                
                break;

            case 3:
                UnitFrom = "°C"; // Unitat 1
                UnitTo = "°F"; // Unitat 2

                System.out.print("Introdueix el numero de "+ UnitFrom +" que vols convertir a "+ UnitTo +": ");
                UserNum = scanner.nextDouble(); // Scan Input

                UserResult = ((UserNum * 9/5) + 32); // Operació
                
                break;

            case 4:
                UnitFrom = "kg"; // Unitat 1
                UnitTo = "lliures"; // Unitat 2

                System.out.print("Introdueix el numero de "+ UnitFrom +" que vols convertir a "+ UnitTo +": ");
                UserNum = scanner.nextDouble(); // Scan Input

                UserResult = (UserNum * 2.2046); // Operació
                
                break;
            default:
                System.out.println("Selecciona una conversión viable"); // Wrong input
                break;
        }

        System.out.println(UserNum + " " + UnitFrom + " es converteix en " + UserResult + " " +  UnitTo);

    }
}