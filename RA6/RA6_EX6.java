/*
Crear un array d’enters i invertir l’ordre dels seus elements
*/

public class RA6_EX6 {
    public static void main(String[] args) {
        System.out.println("/// Arrays | Exercici 6 | Array d'enters i invertir l'ordre dels seus elements ///");

        int[] Array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 }; // array de numeros
        int[] ArrayInvertit = new int[Array.length]; // crear un nou array amb el mateix lenght que Array

        int i = 0; // iterador
        int i_array = Array.length; // iterador de la posició del array pero anant de l'ultim al primer

        while (i < ArrayInvertit.length) { // iterem array.lenght vegades
            i_array--; // anem reduint el iterador array per anar de més a menys
            ArrayInvertit[i] = Array[i_array]; // assignem les posicions de l'array invertit amb els numeros invertits

            System.out.println("La posició [" + i + "] correspon a: " + ArrayInvertit[i]);
            i++;
        }

    }
}
