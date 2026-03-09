/*
Crea un programa amb un array de 6 posicions que representi els cofres trobats en un mas antic.
Cada cofre pot contenir un objecte o estar buit.
Demana a l’usuari quin objecte busca i indica si l’ha trobat o no dins de l’array
*/

import java.util.Scanner;

public class RA6_A2_EX2 { // finished
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("/// Arrays 2 | Exercici 2 | Els cofres del tresor ///");

        String[] cofres_trobats = { "Test", "Raton", "Gallina", "-", "Luna" };

        boolean found = false;
        int foundin = 0;

        while (true) {
            System.out.println("Input un objecte que vols buscar: ");
            String Object = input.next();

            for (int i = 0; i < cofres_trobats.length; i++) {
                //System.out.println("En la posició [" + invL + "] s'ha trobat: " + cofres_trobats[invL]);
                System.out.println("DEBUG / COMPARING: [" + cofres_trobats[i] + "] with [" + Object + "]");
                if (cofres_trobats[i].equals(Object)) {
                    found = true;
                    foundin = i;
                } 
            }
            if (found) {
                    System.out.println("FOUND OBJECT: " + Object + " en el cofre [" + (foundin+1) + "]");
                } else {
                    System.out.println("No s'ha encontrat cap objecte amb el nom " + Object);
                }
            //input.nextLine();
        }

    }
}
