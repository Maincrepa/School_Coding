/*
Crear un array amb notes e indicar si cada nota és aprovada o suspesa (aprovat > 5)
*/

public class RA6_EX5 {
    public static void main(String[] args) {
        System.out.println("/// Arrays | Exercici 5 | Array amb notes e indicar si cada nota és aprovada o suspesa (aprovat > 5) ///");

        int[] ArrayNotes = {8,7,4,6,3,2,8,6,10,6,8,4,3,2}; // les notes introduides pel profe
        int NotaPerAprovar = 5; // per si el profe és bó i vol aprovar si surt 4 per exemple.

        int i = 0; // iterador

        while (i < ArrayNotes.length) {
            if (ArrayNotes[i] > NotaPerAprovar) { // més de 5.
                System.out.println("La nota de posició [" + i + "] ha aprovat amb un " + ArrayNotes[i]);
            } else { // menys de 5
                System.out.println("La nota de posició [" + i + "] ha suspés amb un " + ArrayNotes[i]);
            }
            i++;
        }

    }
}
