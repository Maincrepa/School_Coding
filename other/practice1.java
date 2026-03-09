import java.util.Scanner;

public class practice1 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Introduce un dia de la semana (1-7): ");
        int dia = scanner.nextInt();

        String [] DiesSetmana = {" ","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};

        if (dia > 0 && dia < 8) {
            System.out.println("El dia " + dia + " corresponde a " + DiesSetmana[dia]);
        } else {
            System.err.println("Input Equivocat!");
        }
       
    }
}