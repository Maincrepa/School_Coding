import java.util.Scanner;

public class PreExamen_Cinema {
    static Scanner input = new Scanner(System.in);

    public static int[][] sala;
    public static String[] STATUS;
    public static char[] LLETRES;
    
    public static void main(String[] args) {
        sala = new int[8][10]; // 8 files 10 seients
        STATUS = new String[] {
            "L", // butaca Lliure
            "X" // butaca ocupada (reservada)
        };
        LLETRES = new char[] {
            'A','B','C','D','E','F','G','H','I','J'
        };

        boolean active = true;
        Start();

        while (active) {
            System.out.println();
            int opcio = menu();
            switch (opcio) {
                case 1: // Mostrar sala
                    MostrarSala();
                    
                    break;
                case 2: // Reservar butaca
                    ReservarButaca();

                    break;      
                case 3: // Cancel·lar reserva
                    ReservarButaca();

                    break;  
                case 4: // Comptar butaques lliures
                    ReservarButaca();

                    break;  
                case 0: // Sortir
                    active = false;

                    break;        
                default:
                    break;
            }

        }


    }

    public static int menu() {

        System.out.println("""
        =============================
            CINEMA LA SALLE
        =============================

            1. Mostrar sala
            2. Reservar butaca
            3. Cancel·lar reserva
            4. Comptar butaques lliures
            0. Sortir

        =============================
        """);

        System.out.print("Opció: ");
        int option = input.nextInt();

        return option;
    }

    public static void Start() {
        for (int row = 0; row < sala.length; row++) {
            for (int col = 0; col < sala[0].length; col++) {
                sala[row][col] = 0; // set to lliure
            }
        }
    }

    public static void MostrarSala() {
        System.out.println("""
        =============================
        PANTALLA
        =============================
        
        """);

        // Lletres horizontals
        System.out.print("  ");
        for (int i = 0; i < LLETRES.length; i++) {
            System.out.printf("%-2c ", LLETRES[i]);
        }
        System.out.println();

        // Butaques + Nums horizontals
        for (int row = 0; row < sala.length; row++) {
            System.out.print((row + 1) + " ");
            for (int col = 0; col < sala[0].length; col++) {
                int casilla = sala[row][col];
                System.out.printf("%-2s ", STATUS[casilla]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("=============================");
        System.out.println();
    }

    public static void ReservarButaca() {
        System.out.println("RESERVAR BUTACA");
        System.out.println();

        char posició[] = PedirPosicio();

        int butaca = sala[row][indexLletres]; // agafar el status de la butaca.
        int indexLletres = 0; // Posició en la taula "LLETRES"

        if (butaca == 0) { // 0 = lliure
            // S'han finalitzat els checks, reservar.
            System.out.print("Butaca reservada perfectament");
            sala[row][indexLletres] = 1; // reservar butaca.
        }
    }

    public static void CancellarReserva() {
        
    }

    public static char[] PedirPosicio() {
        char[] output = {'z','z'};
        // Introducció fila
        System.out.print("Introdueix una fila (1-8): ");
        int row = input.nextInt();
        row--; // treure un (visual = 1, index = 0)

        boolean checkFila = DinsRangFila(row);
        if (!checkFila) {
            return false; // Butaca fora de la fila.
        }
        output[0] = (char)row;

        // Introducció seient
        System.out.print("Introdueix un seient (A-J): ");
        char seat = input.next().charAt(0);

        char upperCaseSeat = Character.toUpperCase(seat); // Pel print i "LLETRES"

        boolean checkButaca = DinsRangButaca(upperCaseSeat);

        if (!checkButaca) {
            return false; // Butaca fora del rang.
        }
        output[1] = upperCaseSeat;

        // Tot está bé.
        return output;
    }

    public static boolean DinsRangFila(int fila) {
        // Check rang fila:
        if (!(fila >= 0 && fila < 8)) {  // No s'ha encontrat la fila;
            System.out.println("La fila no está dins del rang");
            return false;
        }
        return true;
    }

    public static boolean DinsRangButaca(char butaca) {
        // Check rang seient:
        boolean found = false; // S'ha encontrat en la taula "LLETRES"?

        for (int lettr = 0; lettr < LLETRES.length; lettr++) {
            if (butaca == LLETRES[lettr]) {
                found = true;
            }
        }
        if (!found) { // No s'ha encontrat el seient;
            System.out.println("El seient no está dins del rang");
            return false;
        }
        return true;
    }

    public static int IndexLLETRES(char butaca) {
        for (int lettr = 0; lettr < LLETRES.length; lettr++) {
            if (butaca == LLETRES[lettr]) {
                return lettr;
            }
        }
        return -1;
    }

    public static void ComptarButaquesLliures() {
        int lliures = 0;

        for (int row = 0; row < sala.length; row++) {
            for (int col = 0; col < sala[0].length; col++) {
                if (sala[row][col] == 0) {
                    lliures++;
                }
            }
        }

        System.out.println("Lliures: " + lliures);
    }
    
}