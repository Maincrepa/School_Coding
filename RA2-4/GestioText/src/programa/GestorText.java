import java.util.Scanner;

import utilitats.text.AnalitzadorText;

public class GestorText {
    public static void main(String[] args) throws Exception {
        System.out.println("Introdueix un text");
        Scanner input = new Scanner(System.in);
        String text = input.nextLine().toLowerCase();

        AnalitzadorText at = new AnalitzadorText();

        System.out.println("Vocals: " + at.comptarVocals(text));
        System.out.println("Consonants: " + at.comptarConsonants(text));
        System.out.println("Text invertit: " + at.invertirText(text));
        System.out.println("Text palindrom: " + at.esPalindrom(text));
    }
}
