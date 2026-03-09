/*
Simula un login que demani usuari i contrasenya. Si tots dos són correctes, mostra "Accés
concedit", sinó "Accés denegat"
*/

import java.util.Scanner;

public class RA3_PEC1_Ex3 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("/// Sistema d'Autenticació ///");

        // CREDENTIALS

        String SavedUser = "User1";
        String SavedPassword = "Pass123";

        //

        System.out.print("Introduce el usuario: "); // First scan
        String User = scanner.nextLine();

        System.out.print("Introduce la constraseña: "); // Second scan
        String Passw = scanner.nextLine();

        if (!User.equals(SavedUser)) { //.equal compare usr
            System.out.println("No se encontró el usuario, verifica tu input."); // user bad
        } else {
            if (!Passw.equals(SavedPassword)) { //.equal compare password
                System.out.println("Credenciales incorrectos, reintroduce los credenciales."); // password bad
            } else {
                System.out.println("Los credenciales són correctos, logging in.."); // both good

                // continue program
            }
        }
    }
}