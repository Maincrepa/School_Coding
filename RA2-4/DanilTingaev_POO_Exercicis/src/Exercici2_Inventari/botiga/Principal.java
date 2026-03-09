package botiga;
import java.util.Scanner;

public class Principal {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Inventari inventari = new Inventari();
        boolean active = true;

        while (active) {
            int opcio = menu();

            switch (opcio) {
                case 0:
                    active = false;
                    break;
                case 1:
                    nouProducte(inventari);
                    break;
                case 2:
                    buscarProducte(inventari);
                    break;
                case 3:
                    afegirStock(inventari);
                    break;
                case 4:
                    retirarStock(inventari);
                    break;
                case 5:
                    llistarStockBaix(inventari);
                    break;
                case 6:
                    llistarTots(inventari);
                    break;
                case 7:
                    valorTotal(inventari);
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

            INVENTARI

        ==================================

            1. Nou producte
            2. Buscar producte
            3. Afegir stock
            4. Retirar stock
            5. Productes amb stock baix
            6. Llistar tots els productes
            7. Valor total de l'inventari
            0. Sortir

        ==================================

        """;

        while (!(escull >= 0 && escull <= 7)) {
            System.out.println(menuString);
            System.out.print("Opció: ");
            escull = input.nextInt();
        }

        return escull;
    }

    public static void nouProducte(Inventari inventari) {
        System.out.println("""

        ==================================

            NOU PRODUCTE

        ==================================

        """);

        System.out.print("Codi: ");
        String codi = input.next();

        System.out.print("Nom: ");
        String nom = input.next();

        System.out.print("Preu: ");
        double preu = input.nextDouble();

        System.out.print("Stock inicial: ");
        int stock = input.nextInt();

        Producte nou = new Producte(codi, nom, preu, stock);
        boolean afegit = inventari.afegirProducte(nou);
        if (afegit) {
            System.out.println("Producte afegit correctament.");
        }

        System.out.println("==================================");
    }

    public static void buscarProducte(Inventari inventari) {
        System.out.println("""

        ==================================

            BUSCAR PRODUCTE

        ==================================

        """);

        System.out.print("Codi del producte: ");
        String codi = input.next();

        Producte trobat = inventari.buscarProducte(codi);
        if (trobat == null) {
            System.out.println("Producte no trobat.");
        }

        System.out.println("==================================");
    }

    public static void afegirStock(Inventari inventari) {
        System.out.println("""

        ==================================

            AFEGIR STOCK

        ==================================

        """);

        System.out.print("Codi del producte: ");
        String codi = input.next();

        Producte producte = inventari.buscarProducte(codi);
        if (producte == null) {
            System.out.println("Producte no trobat.");
        } else {
            System.out.print("Quantitat a afegir: ");
            int quantitat = input.nextInt();
            boolean ok = producte.afegirStock(quantitat);
            if (ok) {
                System.out.println("Stock afegit correctament.");
            } else {
                System.out.println("Quantitat no vàlida.");
            }
        }

        System.out.println("==================================");
    }

    public static void retirarStock(Inventari inventari) {
        System.out.println("""

        ==================================

            RETIRAR STOCK

        ==================================

        """);

        System.out.print("Codi del producte: ");
        String codi = input.next();

        Producte producte = inventari.buscarProducte(codi);
        if (producte == null) {
            System.out.println("Producte no trobat.");
        } else {
            System.out.print("Quantitat a retirar: ");
            int quantitat = input.nextInt();
            boolean ok = producte.retirarStock(quantitat);
            if (ok) {
                System.out.println("Stock retirat correctament.");
            } else {
                System.out.println("Stock insuficient.");
            }
        }

        System.out.println("==================================");
    }

    public static void llistarStockBaix(Inventari inventari) {
        System.out.println("""

        ==================================

            PRODUCTES AMB STOCK BAIX

        ==================================

        """);

        inventari.llistarProductesStockBaix();

        System.out.println("==================================");
    }

    public static void llistarTots(Inventari inventari) {
        System.out.println("""

        ==================================

            TOTS ELS PRODUCTES

        ==================================

        """);

        inventari.llistarTotsElsProductes();

        System.out.println("==================================");
    }

    public static void valorTotal(Inventari inventari) {
        System.out.println("""

        ==================================

            VALOR TOTAL DE L'INVENTARI

        ==================================

        """);

        double total = inventari.calcularValorTotal();
        System.out.printf("Valor total: %.2f€%n", total);

        System.out.println("==================================");
    }
}

