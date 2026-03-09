/*
Crear un array amb 10 posicions i omplir-lo amb els primers 10 múltiples de 5.
*/

public class RA6_EX1 {
    public static void main(String[] args) {
        System.out.println("/// Arrays | Exercici 1 | array amb 10 posicions i omplir-lo amb els primers 10 múltiples de 5 ///");
        int[] MultiplesArray = new int[10]; // crear array de 10 posicions sense valors.

        for (int i = 0; i < 10; i++) { // bucle per 10 iteracions.
            MultiplesArray[i] = (i*5); // assignar a la posició i, l'operació del multiple.
            System.out.println("En la posició: " + i + " hi correspon: " + MultiplesArray[i]);
        }
    }
}
