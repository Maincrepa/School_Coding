import java.util.Scanner;

public class RA6_MOD_EX7 {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("/// Funcions | Exercici 7 | Implementa un mètode que retorni la cadena de text invertida. ///");
        System.out.print("Introdueix la cadena de text: ");
        String text = input.nextLine();

        String resultat = invertir(text);
        System.out.println("Text Invertit: [" + resultat + "]");
    }
    public static String invertir(String text) {
        String TextInvertit = "";
        for (int char_i = text.length(); char_i > 0; char_i--) { // iterem la lenght de la cadena en sentit contrari; ..,4,3,2,1
            TextInvertit += text.charAt(char_i-1); // posem el char en el text invertit
        }

        return TextInvertit;
    }
}
