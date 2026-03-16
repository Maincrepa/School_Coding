package com.socialapp.view;

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

    public void mostrarMenuPrincipal() {
        System.out.println("MENU!!!!");

        boolean active = true;

        while (active) {
            int option = menuOpcions();

            switch (option) {
                case 1: // LOGIN
                    
                break;
                case 0: // SORTIR
                    
                break;
            
                default:
                    break;
            }
        }
    }


    /*
    ==========================================
        MÉTODE MENU USUARI i ADMIN
    ==========================================
    */

    public static int menuOpcions() {
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

    public static void mostrarMenuUsuari(Usuario u) {

    }

    public static void mostrarMenuAdmin(Admin a) {
        
    }
}
