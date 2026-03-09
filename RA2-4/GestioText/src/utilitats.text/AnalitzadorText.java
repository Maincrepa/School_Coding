package utilitats.text;

public class AnalitzadorText {
    final static char[] vocals = {'a', 'e', 'i', 'o', 'u'};
    final static String consonants = "bcdfghjklmnpqrstvwxyz";

    public static int comptarVocals(String text) {
        int vocals_num = 0; // comptador buit

        for (int i = 0; i < text.length(); i++) { // iterem pel text
            char textchar = text.charAt(i); // agafem el char de cada caracter del text
            for (int voc = 0; voc < vocals.length; voc++) { // iterem pel array de vocals
                if (textchar == vocals[voc]) { // si el caracter del text i la vocal coincideixen;
                    vocals_num++; // agreguem 1 al comptador
                }
            }
        }

        return vocals_num; // retornem la quantitat de vocals final.
    }
    public static int comptarConsonants(String text) {
        int cons_num = 0; // Comptador buit

        for (int i = 0; i < text.length(); i++) { // Iterem pel text
            char textchar = text.charAt(i); // agafem el char de cada caracter del text

            for (int cons = 0; cons < consonants.length(); cons++) { // iterem pel string de consonants
                if (textchar == consonants.charAt(cons)) { // si el caracter del text i la vocal coincideixen;
                    cons_num++; // agreguem 1 al comptador
                } 
            }
        }

        return cons_num; // Retornem la quantitat de constants final.
    }

    public static String invertirText(String text) {
        String textInvertit = ""; // text buit

        for (int char_i = text.length(); char_i > 0; char_i--) { // iterem la lenght de la cadena en sentit contrari; ..,4,3,2,1
            textInvertit += text.charAt(char_i-1); // posem el char en el text invertit
        }

        return textInvertit; // retornem text invertir
    }
    public static boolean esPalindrom(String text) {
        boolean esPalindromValue = true; // valor inicial

        for (int char_i = 0; char_i < text.length()/2; char_i++) { // iterem per la mitad de la frase (partir frase en 2)
            char left_char = text.toLowerCase().charAt(char_i); // agafem el caracter de la esquerra
            char right_char = text.toLowerCase().charAt((text.length()-1) - char_i); // agafem el caracter de la dreta
            if (left_char != right_char) { // comparem els dos caracters, a la mínima que no coincideixen;
                esPalindromValue = false; // no és palindrom
            }
        }

        return esPalindromValue; // retornem el resultat final
    }
}
