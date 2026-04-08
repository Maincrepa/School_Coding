import java.util.Scanner;

public class Supermercat {
    String[] nomsProductes = {"Llet (1L)", "Pa de motlle", "Pollastre (1kg)", "Arròs (1kg)", "Pomes (1kg)", "Aigua mineral (6L)", "Cereals", "Iogurt pack x4"};
    double[] preusProductes = {1.20, 1.50, 5.99, 1.80, 2.50, 3.20, 3.75, 2.10};
    int[] quantitatsCarret = new int[nomsProductes.length]; // "array 1D on l'índex i correspon al producte i del catàleg. Si quantitatsCarret[2] = 3, vol dir que hi ha 3 unitats del producte 2 al carret."

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        boolean active = true;

        while (active) {
            int option = menu();

            switch (option) {
                case 1: // Veure catàleg — Mostra tots els productes amb el seu preu
                    
                break;
                case 2: // Afegir producte al carret — L'usuari tria un producte i la quantitat
                    
                break;
                case 3: // Veure carret — Mostra els productes afegits, quantitats i subtotals
                    
                break;
                case 4: // Eliminar producte del carret
                    
                break;
                case 5: // Calcular total — Mostra el total amb un 21% d'IVA desglossat
                    
                break;
                case 6: // Aplicar descompte — Si el total supera 50€, aplica un 10% de descompte
                    
                break;
                case 7: // Pagar i sortir — Mostra el tiquet final i acaba el programa
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
            5. Calcular total
            6. Aplicar descompte
            7. Pagar i sortir
                
        """);

        while (!(menu_option >= 0 && menu_option <= 7)) { // Opcions: 0-7
            System.out.print("Introdueix l'opció: ");
            menu_option = input.nextInt();
        }

        return menu_option;
    }


}


/*
=== SUPERMERCAT JAVA ===
1. Veure catàleg
2. Afegir producte al carret
3. Veure carret
4. Eliminar producte del carret
5. Calcular total
6. Aplicar descompte
7. Pagar i sortir
Tria opció: 2
Introdueix l'ID del producte: 2
Quantitat: 2
S'han afegit 2x Pollastre (1kg) al carret!
Tria opció: 3
--- EL TEU CARRET ---
Pollastre (1kg) x2 11.98 EUR
------------------
Subtotal: 11.98 EUR

*/