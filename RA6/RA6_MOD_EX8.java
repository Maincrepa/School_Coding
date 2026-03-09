import java.util.Scanner;

public class RA6_MOD_EX8 {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("/// Funcions | Exercici 8 | Implementa un mètode que indiqui si una paraula o frase és un palíndrom (es llegeix igual d'esquerra a dreta que de dreta a esquerra). ///");
        System.out.print("Introdueix la cadena de text: ");
        String text = input.nextLine();

        boolean resultat = esPalindrom(text);
        System.out.println("El num és palíndrom: " + resultat);
    }
    public static boolean esPalindrom(String text) {
        boolean Palindrom = true;

        for (int char_i = 0; char_i < text.length()/2; char_i++) {
                char left_char = text.toLowerCase().charAt(char_i);
                char right_char = text.toLowerCase().charAt((text.length()-1) - char_i);
            if (left_char != right_char) {
                Palindrom = false;
            }
        }

        return Palindrom;
    }
}
