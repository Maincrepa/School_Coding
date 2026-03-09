/*
text
*/

public class Exam_RA6_26N_Ex2 {

    public static void main(String[] args) {
        int numpositius = 0;
        double mitjana = 0;

        int[] valoracions = new int[7];

        for (int i = 0; i < valoracions.length; i++) {
            double numrand = ((Math.random()*4)+1);
            System.out.println("["+i+"]"+" té la valoració de: " + (int) numrand); // diferent de paper, transformat de double a int per millor llegibilitat
            mitjana += numrand;
            
            if ((int) numrand == 4 || (int) numrand == 5) { // diferent de paper, m'he olvidat transformar double a int
                numpositius++;
            }
        }

        System.out.println("El client ha puntuat de manera positiva " + numpositius + " vegades.");
        System.out.println("La mitjana de notes és: " + (mitjana/valoracions.length));
    }
}
