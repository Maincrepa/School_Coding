/*
Practice
*/

public class Practice_ArrayBiFirst {
    public static void main(String[] args) {
        int columnas = 5; // assignar numero de columnas
        int filas = 8; // assignar numero de filas

        int totalnum = 0; // save current num

        int[][] taula = new int[columnas][filas]; // array bidimensional

        for (int i = 0; i < taula.length; i++) {
            //System.out.println("Columna: " + (i + 1));
            for (int j = 0; j < taula[i].length; j++) {
                int random = (int)(Math.random()*10)+1; //random
                taula[i][j] = random; // assignar

                System.out.print((taula[i][j] + 1) + " | "); // print

                totalnum += random; // sumar
            }
            System.out.println();
            System.out.println();
        }

        System.out.println("media = " + (totalnum/(columnas*filas)));
    }
}
