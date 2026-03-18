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
        System.out.println("DEBUG: Mostrant menu principal.");
        boolean active = true;
        Usuario usuari = null;

        while (active) {
            int option;
            if (usuari != null) { // mostrar versió del menu per continuar
                option = menuOpcions(0);
            } else {  // mostrar versió del menu per fer login
                option = menuOpcions(1);
            }
            

            switch (option) {
                case 1: // LOGIN
                    System.out.println("DEBUG: LOGIN. | " + usuari);
                    
                    if (usuari != null) {
                        mostrarMenuUsuari(usuari);
                    } else {
                        usuari = login(redSocial);
                    }
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

    private static int menuOpcions(int option) {
        int escull = -1;

        String menuString = """
        
        ==================================

            MENU PRINCIPAL

        ==================================

            1. %s
            0. Salir    

        ==================================

        """.formatted(option == 1 ? "Login" : "Continuar");

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
        int escull = printMenuUsuari();

        switch (escull) {
            case 1: // VEURE PERFIL
                veurePerfil(u);
                break;

            case 2: // AFEGIR AMIC
                afegirAmic(u);
                break;

            case 3: // ELIMINAR AMIC
                eliminarAmic(u);
                break;

            case 4: // CREAR POST
                crearPost(u);
                break;

            case 5: // ELIMINAR POST
                eliminarPost(u);
                break;

            default:
                break;
        }
    }

    public static void mostrarMenuAdmin(Admin a) {
        
    }

    /*
    ==========================================
        MÉTODE PRINT MENU USUARI i ADMIN
    ==========================================
    */

    private static int printMenuUsuari() {
        int escull = -1;

        System.out.println("""
                
        ==================================
            MENU USUARI
        ==================================
        """);

        String menuString = """

            1. Veure perfil
            2. Afegir amic
            3. Eliminar amic
            4. Crear post
            5. Eliminar post
            0. Sortir 

        ==================================

        """;

        while (!(escull >= 0 && escull <= 5)) {
            System.out.println(menuString);
            System.out.print("Opció: ");
            escull = input.nextInt();
        }

        return escull;
    }

    /*
    ==========================================
        MÉTODES USUARI
    ==========================================
    */

    private static void veurePerfil(Usuario u) {
        System.out.println(u.toString());
    }

    private static void afegirAmic(Usuario u) {
        System.out.print("Introdueix el username de l'amic que vols afegir: ");
        String username = input.next();

        boolean resultat = u.afegirAmic(username);
        if (resultat) {
            System.out.println("Amic afegit correctament.");
        } else {
            System.out.println("No s'ha pogut afegir l'amic.");
        }
    }

    private static void eliminarAmic(Usuario u) {
        System.out.print("Introdueix el username de l'amic que vols eliminar: ");
        String username = input.next();

        boolean resultat = u.eliminarAmic(username);
        if (resultat) {
            System.out.println("Amic eliminat correctament.");
        } else {
            System.out.println("No s'ha pogut eliminar l'amic.");
        }
    }

    private static void crearPost(Usuario u) {
        System.out.print("Introdueix el text del post: ");
        String text = input.next();

        boolean resultat = u.publicarPost(text);
        if (resultat) {
            System.out.println("Post creat correctament.");
        } else {
            System.out.println("No s'ha pogut crear el post.");
        }
    }

    private static void eliminarPost(Usuario u) {
        System.out.print("Introdueix l'index del post que vols eliminar: ");
        int index = input.nextInt();

        boolean resultat = u.eliminarPost(index);
        if (resultat) {
            System.out.println("Post eliminat correctament.");
        } else {
            System.out.println("No s'ha pogut eliminar el post.");
        }
    }

    /*
    ==========================================
        MÉTODES ADMIN
    ==========================================
    */




    /*
    ==========================================
        MÉTODE LOGIN
    ==========================================
    */

    private Usuario login(RedSocial redSocial) {
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
            return null;
        }

        System.out.println("Login correcte. Benvingut " + usuari.getUsername() + "!");
        
        if (usuari instanceof Admin) {
            mostrarMenuAdmin((Admin) usuari);
        } else {
            mostrarMenuUsuari(usuari);
        }
        return usuari;
    }
}
