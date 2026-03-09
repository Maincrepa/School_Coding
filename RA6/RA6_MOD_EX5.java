import java.util.Scanner;

public class RA6_MOD_EX5 {
    static Scanner input = new Scanner(System.in);
    static char VOCALS[] = { 'a', 'e', 'i', 'o', 'u' };

    public static void main(String[] args) {
        

        System.out.println("/// Funcions | Exercici 5 | Implementa un mètode que compti quantes vocals té una cadena de text. ///");
        System.out.print("Introdueix la cadena de text: ");
        String text = input.nextLine();

        int resultat = comptarVocals(text);

        System.out.println("En la cadena de tetx hi ha " + resultat + " vocals.");
    }

    public static int comptarVocals(String text) {
        int vocals = 0; // comptador de vocals

        for (int char_i = 0; char_i < text.length(); char_i++) { // Iterar pel string
            for (int vocal_i = 0; vocal_i < VOCALS.length; vocal_i++) { // Iterar per les vocals
                if (text.toLowerCase().charAt(char_i) == VOCALS[vocal_i]) { // si la lletra == vocal;
                    System.out.println("La lleta ["+VOCALS[vocal_i]+"] de la posició [" + (char_i+1) + "] és una vocal");
                    vocals++; // incrementar el contador de vocals
                }
            }
        }
        return vocals;
    }
}
