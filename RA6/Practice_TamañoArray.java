import java.util.Scanner;

public class Practice_TamañoArray {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        boolean introduint = true;
        double[] tempArray = new double[5];
        double[] finishedarray = new double[0];
        int posició = 0;
        int arrays = 1;

        while (introduint) {
            double[] Notes = new double[(5 * arrays)];

            if (arrays > 1) { // not first iteration
                for (int i = 0; i < tempArray.length; i++) {
                    System.out.println("T" + i + ": " + tempArray[i]);
                    Notes[i] = tempArray[i];
                    //System.out.println("REPLACED NOTES [" + i + "] WITH " + tempArray[i]); // debug
                }

                System.out.println(" / / ");

                for (int i = 0; i < Notes.length; i++) {
                    System.out.println("R" + i + ": " + Notes[i]);
                }
            }

            System.out.println("Array num: " + arrays);
            for (int i = 0; i < 5; i++) { // for this new array of 5:
                System.out.print("Introdueix la nota (0-10) per la posició [" + ((posició + 1)) + "]: ");
                double notaintr = input.nextDouble();

                if (notaintr >= 0 && notaintr <= 10) { // correct num
                    Notes[posició] = notaintr;
                } else if (notaintr == -1) { // exit num
                    System.out.println("Has decidit terminar la llista");
                    finishedarray = new double[posició];
                    finishedarray = Notes;
                    introduint = false;
                    break;
                } else { // wrong num
                    System.out.println("/ Introdueix un numero correcte");
                }
                posició++;
            }

            arrays++;
            tempArray = new double[5 * arrays];
            tempArray = Notes;

            for (int i = 0; i < tempArray.length; i++) {
                System.out.println(tempArray[i]);
            }

            System.out.println("S'ha afegit 5 noves posicions, arrays: " + arrays);
        }

        for (
            int i = 0; i < finishedarray.length; i++) {
            System.out.println("R" + i + ": " + finishedarray[i]);
        }
    }

}
