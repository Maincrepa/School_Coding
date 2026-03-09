/*
Crear un array de 10 posicions i omplir-lo amb números aleatoris entre 1 i 100
*/

public class RA6_EX3 {
    public static void main(String[] args) {
        System.out.println("/// Arrays | Exercici 3 | Array de 10 posicions i omplir-lo amb números aleatoris entre 1 i 100 ///");

        int[] Array = new int[10]; // Creem array de 10 posicions sense valors.

        for (int i = 0; i < 10; i++) {
            int randomnum = (int) (Math.random() * 100) + 1; // crear numero random entre 1 i 100
            Array[i] = randomnum; // assignar el numero random a la posició del iterador de l'array
            System.out.println(Array[i]);
        }


    }
}
