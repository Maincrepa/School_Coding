import java.util.Scanner;

public class prueba_string {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Exercici Proba | Frase separat a lletres");

        System.out.println("Introdueix la frase (màxim 10 paraules, finalitzau amb un punt)");
        String frase = input.nextLine();
        String formedparaula = "";
        String[] paraules = new String[10];
        int numparaules = 0;

        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == ' ') {
                System.out.println(); // separador de palabras

                paraules[numparaules] = formedparaula;
                numparaules++;

                formedparaula = "";
            } else if (frase.charAt(i) == '.') {
                paraules[numparaules] = formedparaula;
                numparaules++;
                formedparaula = "";
            } else {
                formedparaula = (formedparaula + frase.charAt(i));
                System.out.print(frase.charAt(i));
            }
        }

        System.out.println();

        System.out.println(" / PARAULES " + numparaules);
        /*
         * for (int i = 0; i < paraules.length; i++) {
            if (paraules[i]) {
                System.out.println(paraules[i]);
            }
        }
         */

    }
}
