package com.socialapp.view;

import com.socialapp.controller.RedSocial;
import com.socialapp.model.Admin;
import com.socialapp.model.Usuario;

import java.util.Scanner;

/*
Conte el Scanner i tota la interaccio per consola. Cap altra classe pot tenir System.out ni
Scanner. Rep un objecte RedSocial pel constructor i el guarda com a atribut. Te tres metodes:
- mostrarMenuPrincipal(): bucle principal amb les opcions login i sortir.
- mostrarMenuUsuari(Usuario u): menu per a usuaris normals amb les seves opcions.
- mostrarMenuAdmin(Admin a): menu per a administradors amb les seves opcions.
*/


public class Menu {
    static Scanner input = new Scanner(System.in);

    /*
    ==========================================
        MÉTODE PRINCIPAL
    ==========================================
    */

    public void mostrarMenuPrincipal(RedSocial redSocial) {
        boolean active = true;

        while (active) {
            int option = menuOpcions();

            switch (option) {
                case 1: // LOGIN
                    login(redSocial);
                    break;

                case 0: // SORTIR
                    active = false;
                    break;
            

                default: // fallback
                    active = false;
                    break;
            }
        }
    }


    /*
    ==========================================
        MÉTODE MENU OPCIONS
    ==========================================
    */

    private static int menuOpcions() {
        int escull = -1;

        String menuString = """
        
        ==================================

            MENU PRINCIPAL

        ==================================

            1. Login
            0. Salir    

        ==================================

        """;

        while (!(escull >= 0 && escull <= 1)) {
            System.out.println(menuString);
            System.out.print("Opció: ");
            escull = input.nextInt();
        }

        return escull;
    }

    /*
    ==========================================
        MÉTODE MENU USUARI i ADMIN
    ==========================================
    */

    public static void mostrarMenuUsuari(Usuario u) {

    }

    public static void mostrarMenuAdmin(Admin a) {
        
    }

    /*
    ==========================================
        MÉTODE LOGIN
    ==========================================
    */

    private void login(RedSocial redSocial) {
        // Demana username i contrasenya, comprova que existeix l'usuari i que la contrasenya és correcta. Retorna l'objecte Usuario si es correcte, o null si no.
        System.out.println("""

        ==================================
                LOGIN
        ==================================

        """);

        System.out.print("Username: ");
        String username = input.next();

        System.out.print("Contrasenya: ");
        String contrasenya = input.next();

        Usuario usuari = redSocial.login(username, contrasenya);
        if (usuari == null) {
            System.out.println("No s'ha pogut fer login.");
            return;
        }

        System.out.println("Login correcte. Benvingut " + usuari.getUsername() + "!");
        
        if (usuari instanceof Admin) {
            mostrarMenuAdmin((Admin) usuari);
        } else {
            mostrarMenuUsuari(usuari);
        }
    }
}
