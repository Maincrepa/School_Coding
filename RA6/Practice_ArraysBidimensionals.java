/*
Practice
*/

public class Practice_ArraysBidimensionals {
    public static void main(String[] args) {
        int setmanes = 4;
        int dies = 7;

        int[] highest_info = new int[3];
        highest_info[0] = 0;

        int total = 0;

        int[][] array = new int[setmanes][dies];

        for (int it_setmanes = 0; it_setmanes < array.length; it_setmanes++) {
            System.out.println("Setmana: " + (it_setmanes + 1));
            int totalvisits = 0; // visites total aquesta setmana

            for (int it_dies = 0; it_dies < array[it_setmanes].length; it_dies++) {
                int random = (int) ((Math.random() * 40) + 10); // random between 10 and 40
                totalvisits += random;
                total += random;

                // highest check
                if (random > highest_info[0]) {
                    highest_info[0] = random; // assignar el numero más alto
                    highest_info[1] = it_setmanes; // assignar la semana del num
                    highest_info[2] = it_dies; // assignar el dia del num
                }

                // day print:
                System.out.println("El dia " + (it_dies + 1) + " hi ha hagut " + random + " visites.");
            }

            System.out.println(); // setmana print:
            System.out.println("Total de visites aquesta setmana: " + totalvisits + " visites.");
            System.out.println("---------------------");
            System.out.println();
        }

        System.out.println("Outputs finals: "); // breu anàlisi interna: 

        System.out.println("El número de visites més alt és: " + highest_info[0] + ", el día " + (highest_info[2]+1) + " de la setmana " + (highest_info[1]+1) + ".");

        System.out.println("Un total global de " + total + " visites s'han produït aquestes " + setmanes + " setmanes."); // total

        System.out.println("Mitjana global de visites: " + total + "/(" + setmanes + "*" + dies + ") = " 
                + (total / (setmanes * dies)) + " és la mitjana de visites aquestes " + setmanes + " setmanes."); // global avg

    }
}
