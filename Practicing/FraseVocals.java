import java.util.Scanner;

public class FraseVocals {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        String[] vocals = {"a","e","i","o","u"};

        System.out.print("Introdueix una frase: ");
        
        String frase = input.nextLine();

        /*
         * totes vocals de frase minuscula;
         *   loop; 
         *      compare each nextchar(i)
         *      loop for each vocal comparator
         *      if vocalfound;
         *          nextchar(i) = nextchar(i).lowercase()
         * 
         * tots espais multiples, reduits en un (idk)
         * 
         * String lowercaseFrase = frase.toLowerCase();

         for (int i = 0; i < lowercaseFrase.length(); i++) { // loop to compare each char
            for (int z = 0; z < vocals.length; z++) { // compare each char with each vocal
                if (lowercaseFrase.charAt(i) == vocals[z]) {
                    System.out.println(lowercaseFrase.charAt(i) + " és una vocal");
                    char lowercasevocal = frase.charAt(i).lowercase;
                    frase.charAt(i) = lowercasevocal;
                }
            }
         }
         */

        String newfrase = frase;
        for (int i = 0; i < vocals.length; i++) { // replace all vocals with lowercase
            newfrase = newfrase.replace(vocals[i].toUpperCase(), vocals[i]);
        }

        System.out.println("Final Result:");
        System.out.println(newfrase);

    }
}
