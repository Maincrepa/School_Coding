/*
Crear un array de caràcters i comptar les vegades que apareix un determinat caràcter
*/

public class RA6_EX4 {
    public static void main(String[] args) {
        System.out.println("/// Arrays | Exercici 4 | Array de caràcters i comptar les vegades que apareix un determinat caràcter ///");

        char[] CharArray = {'a','b','b','b','p','d','c','b','z'};
        char SelectedChar = 'b'; // caracter determinat

        int Comptador = 0; // comptem quantes vegades surt el caracter
        int i = 0; // iterador

        while (i < CharArray.length) {
            if (CharArray[i] == SelectedChar) { // mirem si el caracter de la posició i és igual que el caracter determinat.
                Comptador++; // sumem al comptador
            }
            i++;
        }

        System.out.println("S'ha comptat el caràcter [" + SelectedChar + "] " + Comptador + " vegades.");
    }
}
