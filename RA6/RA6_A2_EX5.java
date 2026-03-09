/*
Crea un programa que mostri un menú amb les opcions següents:

Mostrar els objectes disponibles a la venda.

Comprar un objecte (es descompta el seu preu de l’or disponible).

Sortir del programa.

Fes servir dos arrays paral·lels: un amb els noms dels objectes i un altre amb els preus.
L’heroi comença amb 100 unitats d’or.
El programa ha de mantenir-se actiu fins que l’usuari triï l’opció de sortir
*/

import java.util.Scanner;

public class RA6_A2_EX5 {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) { // 2check
        System.out.println("/// Arrays 2 | Exercici 5 | La botiga de la vila ///");

        boolean buying = true;
        int herogold = 100; // variable d'or que té el personatge

        String[] Items = {"Espada","Diamant","Ferro","GeForce RTX 5090","Mana"}; // objectes per comprar
        int[] ItemPrice = {15, 60, 6, 1999, 20}; // Preus de cada objecte

        while (buying) { // bucle per tornar a comprar

            System.out.println("Ara mateix tens " + herogold + "g$.");
            System.out.println("Observes els objectes que ofereix la botiga i veus:");
            for (int i = 0; i < Items.length; i++) {
                // better to format string here
                System.out.println((i+1) + " | [" + ItemPrice[i] + "g$] | " + Items[i]);
            }

            System.out.print("Vols comprar algun objecte? (s/n): ");
            char exitchar = input.next().charAt(0);

            if (exitchar == 's') { // sí vol continuar comprant
                
                System.out.print("Quin objecte vols comprar? (1-" + Items.length + "): ");
                int tobuy = input.nextInt(); // selecció d'objecte
                
                System.out.println();
                if (herogold >= ItemPrice[tobuy-1]) { // got money to buy
                    herogold -= ItemPrice[tobuy-1]; // treure el diner del personatge perquè ha comprat
                    System.out.println("S | Has comprat " + Items[tobuy-1] + " per " + ItemPrice[tobuy-1] + "g$.");
                } else { // no money
                    System.out.println("! | No tents suficient or per comprar " + Items[tobuy-1]);
                    System.out.println("! | Es necessita " + ItemPrice[tobuy-1] + " or, i tu tens " + herogold + "g$.");
                }

            } else {
                System.out.println("Has decidit sortir de la botiga");
                buying = false;
            }
            System.out.println();
            System.out.println(" - - - ");
            System.out.println();
        }
    }
}
