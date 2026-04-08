import java.util.Scanner;

public class Supermercat {
    public static String[] nomsProductes = {"Llet (1L)", "Pa de motlle", "Pollastre (1kg)", "Arròs (1kg)", "Pomes (1kg)", "Aigua mineral (6L)", "Cereals", "Iogurt pack x4"};
    public static double[] preusProductes = {1.20, 1.50, 5.99, 1.80, 2.50, 3.20, 3.75, 2.10};
    public static int[] quantitatsCarret = new int[nomsProductes.length]; // "array 1D on l'índex i correspon al producte i del catàleg. Si quantitatsCarret[2] = 3, vol dir que hi ha 3 unitats del producte 2 al carret."

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        boolean active = true;

        while (active) {
            System.out.println(); // espai
            int option = menu();

            switch (option) {
                case 1: // Veure catàleg — Mostra tots els productes amb el seu preu
                    veureCataleg();
                break;
                case 2: // Afegir producte al carret — L'usuari tria un producte i la quantitat
                    afegirProducteAlCarret();
                break;
                case 3: // Veure carret — Mostra els productes afegits, quantitats i subtotals
                    veureCarret();
                break;
                case 4: // Eliminar producte del carret
                    eliminarProducteDelCarret();
                break;
                case 5: // Pagar i sortir — Mostra el tiquet final i acaba el programa
                    pagarISortir();
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
        === SUPERMERCAT JAVA ===

            1. Veure catàleg
            2. Afegir producte al carret
            3. Veure carret
            4. Eliminar producte del carret
            5. Pagar i sortir
                
        """);

        while (!(menu_option >= 0 && menu_option <= 5)) { // Opcions: 0-5
            System.out.print("Introdueix l'opció: ");
            menu_option = input.nextInt();
        }

        return menu_option;
    }

    public static void veureCataleg() {
        System.out.println("--- CATALEG DE PRODUCTES ---");
        for (int i = 0; i < nomsProductes.length; i++) { // Mostrem tots els productes amb un bucle
            System.out.printf("    %d. %s - %.2f EUR\n", i + 1, nomsProductes[i], preusProductes[i]);
            // Print de l'ID del producte (int), nom del producte (string) i preu (double amb 2 decimals)
        }
    }

    public static void afegirProducteAlCarret() {
        int producte_id = -1; // guardem l'ID del producte que vol afegir al carret
        int quantitat = -1; // guardem quants productes vol afegir al carret

        while (!(producte_id >= 1 && producte_id <= nomsProductes.length)) {
            System.out.print("Introdueix l'ID del producte: ");
            producte_id = input.nextInt();
        }

        while (quantitat <= 0) {
            System.out.print("Quantitat per afegir: ");
            quantitat = input.nextInt();
        }

        quantitatsCarret[producte_id - 1] += quantitat; // Suma la quantitat al carret (recordem que l'ID del producte PEL USUARI és 1-based i l'índex de l'array és 0-based, per aixo fem producte_id - 1)

        System.out.printf("S'han afegit %dx %s al carret!\n", quantitat, nomsProductes[producte_id - 1]);
        // Print de confirmació de la quantitat (int amb 'x' com suffix) i producte (string).
    }

    public static void veureCarret() {
        System.out.println("--- EL TEU CARRET ---");
        double subtotal = calcularTotalMethod();

        for (int i = 0; i < quantitatsCarret.length; i++) {
            // per cada producte, si la quantitat és > 0, calcula el total del producte i suma al subtotal
            if (quantitatsCarret[i] > 0) {

                System.out.printf(" · %s x%d | %.2f EUR\n", nomsProductes[i], quantitatsCarret[i], quantitatsCarret[i] * preusProductes[i]);
                // Print del producte (string), quantitat (int amb x com prefix) i total del producte amb 2 decimals
            }
        }
        if (subtotal == 0.0) {
            System.out.println("El teu carret està buit!");
        } else {
            System.out.println(); // espai
            System.out.println("------------------"); // Print del subtotal amb 2 decimals
            System.out.printf("Subtotal: %.2f EUR\n", subtotal);
        } 
    }

    public static void eliminarProducteDelCarret() {
        int producte_id = -1; // guardem l'ID del producte que vol eliminar del carret
        int quantitat = -1; // guardem quants productes vol eliminar del carret

        while (!(producte_id >= 1 && producte_id <= nomsProductes.length)) {
            System.out.print("Introdueix l'ID del producte: ");
            producte_id = input.nextInt();
        }

        while (quantitat <= 0) {
            System.out.print("Quantitat per eliminar: ");
            quantitat = input.nextInt();
        }

        if (quantitatsCarret[producte_id - 1] >= quantitat) {
            // ens assegurem que existeixen suficients unitats del producte al carret per eliminar la quantitat demanada

            quantitatsCarret[producte_id - 1] -= quantitat;
            System.out.printf("! S'han eliminat %dx %s del carret!\n", quantitat, nomsProductes[producte_id - 1]);
        } else {
            System.out.println("No hi ha suficients unitats d'aquest producte al carret!");
        }
    }

    //public static double calcularTotal() {}
    // He decidit que era millor treure aquest métode del menu públic i crear una funció helper que s'encarrega de calcular el total, ja que així evitem que l'usuari s'oblidi de calcular el total abans de pagar i sempre es calcularà automàticament al pagament final.

    //public static void aplicarDescompte() {}
    // He decidit que era millor calcular-ho automaticament al calcular el total, ja que així evitem que l'usuari s'oblidi d'aplicar el descompte i sempre se li aplicarà quan correspongui. Per això, he eliminat aquesta funció i he creat una funció helper que s'encarrega d'aplicar el descompte automàticament al calcular el total.

    public static void pagarISortir() {
        double total = calcularTotalMethod();
        double totalAmbIVA = retornaAmbIVA(total);
        System.out.println("! S'ha aplicat l'IVA del 21% al total");
        double totalFinal = aplicarDescompteMethod(totalAmbIVA);

        System.out.printf("Total a pagar: %.2f EUR\n", totalFinal);
        
        int option = -1;
        while (!(option == 0 || option == 1)) {
            System.out.print("Vols continuar i pagar? (1: Sí, 0: No): ");
            option = input.nextInt();
        }

        if (option == 1) {
            System.out.println("Gràcies per la teva compra! Fins aviat!");
        } else {
            System.out.println("Compra cancel·lada. Fins aviat!");
        }
    }


    // =================================
    // HELPERS

    public static double retornaAmbIVA(double subtotal) {
        return subtotal * 1.21; // "Per calcular l'IVA: totalAmbIVA = subtotal * 1.21"
    }

    public static double aplicarDescompteMethod(double total) {
        if (total > 50.0) {
            System.out.println("S'ha aplicat un descompte del 10%!");
            return total * 0.90; // "Per al descompte: si subtotal > 50, totalFinal = subtotal * 0.90"
        }
        return total;
    }

    public static double calcularTotalMethod() {
        double subtotal = 0.0;

        for (int i = 0; i < quantitatsCarret.length; i++) {
            if (quantitatsCarret[i] > 0) {
                subtotal += quantitatsCarret[i] * preusProductes[i];
            }
        }
        return subtotal;
    }
}