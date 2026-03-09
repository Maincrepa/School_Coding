/*
Crear un array d'enters i cercar si un número concret existeix dins de l'array
*/

public class RA6_EX2 {
    public static void main(String[] args) {
        System.out.println("/// Arrays | Exercici 2 | array d'enters i cercar si un número concret existeix dins de l'array ///");

        int[] Array = {6,2,8,6,3,7,1,9,6,4,2,8,9,4}; // el array de numeros enters
        int numeroconcret = 7; // el numero que volem buscar
        int i = 0; // iterations
        boolean encontrat = false; // boolean si es troba

        while ((i < Array.length) && !encontrat) { // mentre que no superem la lenght del array i mentre que encontrem el numero, do:
            if (Array[i] == numeroconcret) { // si el num en la posició del array és igual al num concret, s'ha encontrat.
                encontrat = true;
            }
            i++; // anar un per un
        }

        if (encontrat) {
         System.out.println("S'ha trobat el numero concret."); // true, s'ha encontrat
         } else {
         System.out.println("No s'ha trobat el numero conctret."); // false, no s'ha encontrat
         }
    }
}
