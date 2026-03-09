import java.util.Scanner;

public class Practice_NoRepetits {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String[] Paraules = new String[5];
        int[] toshow = new int[Paraules.length]; // array to store which to show

        System.out.println("Introdueix 5 paraules:");
        for (int i = 0; i < Paraules.length; i++) { // 5 iter. loop
            System.out.print("· Introdueix la paraula [" + (i + 1) + "]: ");

            String inputtedP = input.next();
            Paraules[i] = inputtedP; // assign i pos in array with word
        }

        for (int i = 0; i < Paraules.length; i++) { // 5 iteration loop for each word
            System.out.println("Comparing paraula: " + Paraules[i]);
            boolean original = true;
            for (int z = 0; z < Paraules.length; z++) { // 5 iteration loop for comparing WORD with each Paraules
                if (z != i) { // MUST CHECK WORD != WORD so it doens't compare with itself
                    if (Paraules[i].equals(Paraules[z])) {
                        System.out.println(" ! " + Paraules[i] + " equals " + Paraules[z]);
                        original = false;
                    }
                }
            }
            if (original) {
                toshow[i] = i;
            }
            System.out.println(" / / ");
        }

        for (int i = 0; i < toshow.length; i++) { // print loop
            if (toshow[i] != 0) {
                int z = toshow[i];
                System.out.println("Paraula original: " + Paraules[z]);
            }
        }
    }
}
