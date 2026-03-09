/*
Dissenyeu un programa que mostri per pantalla totes les taules de multiplicar del 1 al
10 en format de quadrat (10 × 10).
*/

public class RA3_PEC3_Ex1 {

    public static void main(String[] args) {
        System.out.println("/// Taula de multiplicar ///");

        for (int top = 1; top <= 10; top += 1) {
            for (int side = 1; side <= 10; side += 1) {
                //System.out.print("("+top+"*"+side+") és "+(side*top));
                System.out.printf("%4d",(top*side));
            }
            System.out.println("");
        }

    }
}
