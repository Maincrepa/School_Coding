package agenda;
import java.util.Scanner;

public class Principal {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        boolean active = true;

        while (active) {
            int opcio = menu();

            switch (opcio) {
                case 0:
                    active = false;
                    break;
                case 1:
                    nouContacte(agenda);
                    break;
                case 2:
                    buscarContacte(agenda);
                    break;
                case 3:
                    eliminarContacte(agenda);
                    break;
                case 4:
                    llistarContactes(agenda);
                    break;
                default:
                    break;
            }
        }
    }

    public static int menu() {
        int escull = -1;

        String menuString = """
        
        ==================================

            AGENDA

        ==================================

            1. Nou contacte
            2. Buscar contacte
            3. Eliminar contacte
            4. Listar contactes
            0. Salir    

        ==================================

        """;

        while (!(escull >= 0 && escull <= 4)) {
            System.out.println(menuString);
            System.out.print("Opció: ");
            escull = input.nextInt();
        }

        return escull;
    }

    public static void nouContacte(Agenda agenda) {
        String firstString = """
        
        ==================================

            CREACIÓ DE CONTACTE

        ==================================

        """;
        System.out.println(firstString);
        
        System.out.print("Nom: ");
        String nom = input.next();

        System.out.print("Telefon: ");
        String tel = input.next();

        System.out.print("Email: ");
        String email = input.next();
        
        Contacte nou_contacte = new Contacte(nom, tel, email);
        if (nou_contacte.getNom() != null) {
            boolean afegit = agenda.afegirContacte(nou_contacte);
            if (afegit) {
                System.out.println("Contacte afegit correctament.");
            }
        }

        System.out.println("==================================");
    }

    public static void buscarContacte(Agenda agenda) {
        String firstString = """
        
        ==================================

            BUSCAR CONTACTE

        ==================================

        """;
        System.out.println(firstString);

        System.out.print("Nom a buscar: ");
        String nom = input.next();

        Contacte trobat = agenda.buscarContacte(nom);
        if (trobat == null) {
            System.out.println("Contacte no trobat.");
        }

        System.out.println("==================================");
    }

    public static void eliminarContacte(Agenda agenda) {
        String firstString = """
        
        ==================================

            ELIMINAR CONTACTE

        ==================================

        """;
        System.out.println(firstString);

        System.out.print("Nom a eliminar: ");
        String nom = input.next();

        boolean eliminat = agenda.eliminarContacte(nom);
        if (eliminat) {
            System.out.println("Contacte eliminat correctament.");
        } else {
            System.out.println("Contacte no trobat.");
        }

        System.out.println("==================================");
    }

    public static void llistarContactes(Agenda agenda) {
        String firstString = """
        
        ==================================

            LLISTAR CONTACTES

        ==================================

        """;
        System.out.println(firstString);

        if (agenda.getNumContactes() == 0) {
            System.out.println("No hi ha contactes.");
        } else {
            agenda.llistarContactes();
        }

        System.out.println("==================================");
    }

}
