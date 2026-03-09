/*
Crea un programa que representi l’inventari del teu heroi amb un array de 5 posicions.
Demana per teclat els objectes que troba durant l’aventura i desa’ls dins l’array.
Un cop completat, mostra per pantalla el contingut total de l’inventari.
*/

import java.util.Scanner;

public class RA6_A2_EX1 { // finished
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("/// Arrays 2 | Exercici 1 | Programa que representi l’inventari del teu heroi amb un array ///");

        String[] inventario = {"Nada", "Nada", "Nada", "Nada", "Nada"}; // el inventari variable

        while (true) {
            System.out.println("· Este es tu inventario:");
            for (int invL = 0; invL < inventario.length; invL++) { // print del inventari
                System.out.println((invL + 1) + ": " + inventario[invL]);
            }
            System.out.println("Inventa't un objecte que has encontrat: ");
            String Object = input.nextLine(); // introducció del objecte

            System.out.print("En quin inventari vols deixar " + Object + "? (1-5) ");
            int invspace = input.nextInt(); 
            input.nextLine(); // consumeix el newline que deixa nextInt() [AI]
            
            if (invspace >= 1 && invspace <= 5) {
                System.out.println("Has deixat " + Object + " en l'inventari " + invspace);
                inventario[invspace - 1] = Object; // assignar l'objecte a l'espai de l'inventari que vol
            }

        }

    }

}
