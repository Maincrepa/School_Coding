public class Practice_Notes {

    public static void main(String[] args) {
        double[] notes = { 5.5, 9, 4.2, 10, 0.2, 2.1, 6, 2, 6.5, 2.4, 7,5 };

        boolean ordering = true; // loop boolean

        while (ordering) {
            int corrects = 0; // var to see how many of the list are correct

            for (int i = 0; i < (notes.length-1); i++) {
                System.out.println(" / COMPARE: " + notes[i] + " with " + notes[i + 1]);
                if (notes[i] > notes[i + 1]) { // compraració incorrecta, (a > b), corregim
                    System.out.println(notes[i] + " IS BIGGER THAN " + notes[i + 1]);
                    double temp = notes[i]; // assignem var. temporal per guardar A

                    // cambiem d'ordre A i B
                    notes[i] = notes[i + 1]; // A = B
                    notes[i + 1] = temp; // B = "A"

                    System.out.println();

                    System.out.println("REPLACED [i]: " + notes[i]);
                    System.out.println("REPLACED [i+1]: " + notes[i + 1]);

                } else { // aquesta comparació és correcta (a < b)
                    corrects++;
                    System.out.println(notes[i] + " IS SMALLER THAN " + notes[i + 1]);
                }
                
                System.out.println(" - - ");
                System.out.println();
            }
            System.out.println("FINISHED GRAND LOOP");

            if (corrects == notes.length-1) { // quan el n. de correctes és igual al lenght de llista, sabem que totes són correctes i la llista está ordenada
                ordering = false; // finalitzem el grand loop
            }
        }

        for (int z = 0; z < notes.length; z++) { // final result print
            System.out.println((z+1) + " | " + notes[z]);
        }

    }
}
