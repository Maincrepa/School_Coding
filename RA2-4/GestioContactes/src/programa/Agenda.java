package programa;
import java.util.Scanner;

import utilitats.contactes.GestorContactes;

public class Agenda {
    /*
    Afegir contacte (nom, telèfon)
    Buscar contacte per nom
    Eliminar contacte
    Mostrar tots els contactes
    */

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        GestorContactes gestorContactes = new GestorContactes();
        gestorContactes.Initialize();

        boolean active = true;

        while (active) {
            //clearScreen();
            System.out.println();
            int option = menu();

            switch (option) {
                case 1: // Afegir contacte
                    afegirContacte();
                    break;
                case 2: // Buscar contacte per nom
                    buscarContactePerNom();
                    break;
                case 3: // Eliminar contacte
                    eliminarContacte();
                    break;
                case 4: // Mostrar tots els contactes
                    mostrarContactes();
                    break;
                case 0:
                    active = false;
                    break;
                default:
                    break;
            }
        }
    }

    public static int menu() {
        int menu_option = -1;

        System.out.println("""
        =================================

            GESTOR DE CONTACTES

        =================================

            1. Afegir contacte
            2. Buscar contacte per nom
            3. Eliminar contacte
            4. Mostrar tots els contactes

            0. Sortir
                
        """);

        while (!(menu_option >= 0 && menu_option <= 4)) { // Opcions: 0-4
            System.out.print("Introdueix l'opció: ");
            menu_option = input.nextInt();
        }

        return menu_option;
    }

    public static void afegirContacte() {
        //clearScreen();
        System.out.println("""
        =================================

            Creació de contacte

        =================================

        """);

        System.out.print("Nom: ");
        String nomContacte = input.next();

        System.out.print("Telefon: ");
        String telefonContacte = input.next();
        
        GestorContactes.AfegirContacte(nomContacte, telefonContacte);

        System.out.println("Contacte creat!");
        System.out.println("=================================");
    }


    public static void mostrarContactes() {
        //clearScreen();
        System.out.println("""
        =================================

            Taula d'usuaris

        =================================

        """);
        GestorContactes.mostrarTaula();
    }

    public static void buscarContactePerNom() {
        System.out.println("""
        =================================

            Buscar Contacte Per Nom

        =================================

        """);

        System.out.print("Nom: ");
        String nomContacte = input.next();

        GestorContactes.buscarContactePerNom(nomContacte);
    }

    public static void eliminarContacte() {
        System.out.println("""
        =================================

            Eliminar Contate Per Posició

        =================================

        """);

        System.out.print("Posició: ");
        int position = input.nextInt();

        GestorContactes.eliminarContacte(position);
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
}
