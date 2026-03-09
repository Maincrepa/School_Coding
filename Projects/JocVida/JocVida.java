import java.util.Scanner;

/**
 * JOC DE LA VIDA - Cèl·lules de Conway
 * 
 * Simulació d'autòmat cel·lular amb regles simples.
 * 0 = cèl·lula morta
 * 1 = cèl·lula viva
 */
public class JocVida {

static Scanner sc = new Scanner(System.in);

public static String[] DISPLAY;
public static int[][] tauler;
public static int generacio;

public static void main(String[] args) {
    DISPLAY = new String[] {
        "·", // 0: Mort
        "■", // 1: Viu
        "o", // 2: Neix
        "x", // 3: Mort
    };
    
    tauler = new int[10][10];
    generacio = 0;

    boolean active = true;

    while (active) {
        int opcio;

        // Bucle principal
        clearScreen();
        opcio = menu(); // - Crida menu() per obtenir opcio

        switch (opcio) {
            case 1: // Crear tauler buit
                crearTaulerBuit();
                
            break;
            case 2: // Crear tauler aleatori
                crearTaulerAleatori();    

            break;
            case 3: // Posar cèl·lula viva
                posarCellula();

            break;
            case 4: // Treure cèl·lula
                treureCellula();
                
            break;
            case 5: // Avançar generació
                avancarGeneracio(true);
                
            break;
            case 6: // Avançar N generacions
                avancarNGeneracions();

            break;
            case 7: // Mostrar tauler
                mostrarTauler(true);

            break;
            case 8: // Veure detalls sobre una cèl·lula
                cellulaAPosicio();

            break;
            case 0: // sortir
                active = false;
                
            break;
        
            default:
                break;
        }
        
    } // End Active Loop
}

// ===========================================
// NIVELL 1: MENÚ
// ===========================================

/**
    ############
    
    ** menu(): Ensenyar les opciones del menú i preguntar a l'usuari
    
    ############
        
    @return int - Retorna l'opció escullida
    
    ############
    **/

public static int menu() {
int num = -1; // Valor impossible -1 per començar el loop d'introducció de l'opció

System.out.println("""
============================= 

    JOC DE LA VIDA 

============================= 

    1. Crear tauler buit
    2. Crear tauler aleatori
    3. Posar cèl·lula viva
    4. Treure cèl·lula
    5. Avançar generació
    6. Avançar N generacions
    7. Mostrar tauler
    8. Veure detalls sobre una cèl·lula

    0. Sortir

=============================         
"""); // Print del menu

while (!(num >= 0 && num <= 8)) { // Opció de 0-8
    System.out.print("Introdueix una opció: ");
    num = sc.nextInt();
}

// Opció correcte, tanca el loop i seguim al return.
return num;
}


// ===========================================
// NIVELL 2: CREAR TAULER BUIT
// ===========================================

public static void crearTaulerBuit() {
    clearScreen();
    generacio = 0; // reset de les generacions
    for (int row = 0; row < tauler.length; row++) {
        for (int col = 0; col < tauler[row].length; col++) {
            tauler[row][col] = 0;
        }
    }
    System.out.println("S'ha creat una taula buida.");
    teclaContinuar();
}


// ===========================================
// NIVELL 3: MOSTRAR TAULER
// ===========================================


public static void mostrarTauler(boolean print) {
    clearScreen();

    String print_1 = ("""
    =============================

        GENERACIO: %s

    =============================

    """).formatted(generacio);
    if (print) { System.out.println(print_1); } // En cas se print visual:
    

    // NUMs HORIZONTAL
    System.out.print("   ");
    for (int col = 0; col < tauler[0].length; col++) {
        System.out.printf("%2d ", (col + 1));
    }
    System.out.println();
    System.out.println();
    
    // TAULA
    for (int row = 0; row < tauler.length; row++) {
        // NUMs VERTICAL
        System.out.printf("%2d ", row + 1);
        System.out.print(" ");
        
        // CÈL·LULES
        for (int col = 0; col < tauler[row].length; col++) {
            int cell_n = tauler[row][col];
            System.out.printf("%-2s ", DISPLAY[cell_n]);
        }
        System.out.println();
    }

    String print_2 = ("""
    
    =============================

        Cèl·lules vives: %s

    =============================
    """).formatted(comptarVives());

    

    if (print) { // En cas se print visual:
        System.out.println(print_2);
        teclaContinuar();
    }
    
}



// ===========================================
// NIVELL 4: CREAR TAULER ALEATORI
// ===========================================

public static void crearTaulerAleatori() {
    clearScreen();
    generacio = 0; // reset de les generacions

    for (int row = 0; row < tauler.length; row++) {
        for (int col = 0; col < tauler[row].length; col++) {
                                            //30%  1   0
            int rand = (int)(Math.random() < 0.3 ? 1 : 0);
            tauler[row][col] = rand;
        }
    }
    System.out.println("S'ha creat una taula aleatoria.");
    System.out.println();
    teclaContinuar();
}


// ===========================================
// NIVELL 5: POSAR I TREURE CÈL·LULES
// ===========================================

public static void posarCellula() {
    int[] grid_pos = {-1,-1};

    while (!posicioValida(grid_pos)) {
        clearScreen();
        mostrarTauler(false);
        System.out.println("""

        =============================

            POSAR CEL·LULA EN POSICIO

        =============================

        """);
        grid_pos = preguntarPosicio();
    }

    tauler[grid_pos[0]][grid_pos[1]] = 1; // posar cel·lula viva

    teclaContinuar();
}


public static void treureCellula() {
    int[] grid_pos = {-1,-1};

    while (!posicioValida(grid_pos)) {
        clearScreen();
        mostrarTauler(false);
        System.out.println("""

        =============================

            TREURE CEL·LULA EN POSICIO

        =============================

        """);
        grid_pos = preguntarPosicio();
    }

    tauler[grid_pos[0]][grid_pos[1]] = 0; // posar cel·lula morta (treure)

    teclaContinuar();
}

public static void cellulaAPosicio() {
    clearScreen();
    mostrarTauler(false);
    System.out.println("""

    =============================

    """);
    
    int[] grid_pos = {-1,-1};

    while (!posicioValida(grid_pos)) {
        grid_pos = preguntarPosicio();
    }

    int veins = comptarVeins((grid_pos[0]),(grid_pos[1]));

    String output = """

    =============================

        POSICIO: %s, %s

    =============================

        Num. Veïns Vius: %s

    =============================

    """.formatted((grid_pos[0] + 1),(grid_pos[1] + 1), veins);

    System.out.println(output);

    teclaContinuar();
}


public static boolean posicioValida(int[] grid_pos) {

    int row = grid_pos[0];
    int col = grid_pos[1];

    if (row >= 0 && col >= 0 &&
        row <= (tauler.length - 1) &&
        col <= (tauler[row].length - 1)
    ) {
       return true; // sí está dins
    } else {
        System.out.println("""
            ! Introdueix una Posicio Valida:
        """);

        return false; // NO está dins
    }
}


// ===========================================
// NIVELL 6: COMPTAR VEÏNS
// ===========================================

public static int calcVeins(int row, int col) {
    //System.out.println("POS-DBG | row: " + row + " | col: " + col + " || " + tauler[row][col]);

    return tauler[row][col];
}

public static int comptarVeins(int row, int col) {
    int num_veins = 0; // comptador de veins

    int veins[] = {
        // condition ? valueIfTrue : valueIfFalse

        // Cardinals 
        (row > 0)                       ? calcVeins(row - 1, col) : 0,     // NORD
        (row < tauler.length - 1)       ? calcVeins(row + 1, col) : 0,     // SUD
        (col < tauler[row].length - 1)  ? calcVeins(row, col + 1) : 0,    // EST
        (col > 0)                       ? calcVeins(row, col - 1) : 0,    // OEST
        
        // Diagonals
        (row > 0 && col < tauler[row].length - 1)                   ? calcVeins(row - 1, col + 1) : 0, // NE
        (row > 0 && col > 0)                                        ? calcVeins(row - 1, col - 1) : 0, // NW
        (row < tauler.length - 1 && col < tauler[row].length - 1)   ? calcVeins(row + 1, col + 1) : 0, // SE
        (row < tauler.length - 1 && col > 0)                        ? calcVeins(row + 1, col - 1) : 0, // SW
    };
    
    
    for (int iterador : veins) {
        if (iterador == 1) {
            num_veins++;
        }
    }

    return num_veins;
}


// ===========================================
// NIVELL 7: AVANÇAR GENERACIÓ
// ===========================================

public static void avancarGeneracio(boolean print) {
    int[][] temp_tauler = new int[tauler.length][tauler[0].length];
    int cel_mortes = 0; // Num cel·lules que han mort
    int cel_neix = 0;  // Num cel·lules que han nascut

    // llenar el tauler temporal amb cèl·lules del tauler original
    for (int row = 0; row < tauler.length; row++) {
        for (int col = 0; col < tauler[row].length; col++) {
            temp_tauler[row][col] = tauler[row][col];
        }
    }

    clearScreen();
    
    // Calcular els veïns
    for (int row = 0; row < tauler.length; row++) {
        for (int col = 0; col < tauler[row].length; col++) {
            int num_veins = comptarVeins(row, col);

            if (tauler[row][col] == 0) { // Cel·lula morta:

                if (num_veins == 3) {   // Neix 
                    temp_tauler[row][col] = 2; cel_neix++;
                } 
            } else { // Cel·lula viva:

                if (num_veins < 2 || num_veins > 3) { // Mor
                    temp_tauler[row][col] = 3; cel_mortes++;
                } 
            }

        }
    }

    generacio++;
    if (print) {
        
    
    // Mostrar les cel·lules que han mort i que han nascut de la taula temporal: 

    String print_1 = ("""
    =============================

        GENERACIO AVANÇADA
        GENERACIO NUM: %s
        CEL·LULES MORTES: %s
        CEL·LULES NASCUDES: %s

    =============================

    """).formatted(generacio,cel_mortes,cel_neix);
    System.out.println(print_1);
    

    // NUMs HORIZONTAL
    System.out.print("   ");
    for (int col = 0; col < temp_tauler[0].length; col++) {
        System.out.printf("%2d ", (col + 1));
    }
    System.out.println();
    System.out.println();
    
    // TAULA
    for (int row = 0; row < temp_tauler.length; row++) {
        // NUMs VERTICAL
        System.out.printf("%2d ", (row + 1));
        System.out.print(" ");
        
        // CÈL·LULES
        for (int col = 0; col < temp_tauler[row].length; col++) {
            int cell_n = temp_tauler[row][col];
            System.out.printf("%-2s ", DISPLAY[cell_n]);
        }
        System.out.println();
    }
    }


    // Assignar els nascuts i morts a les cel·lules vives i mortes:
    for (int row = 0; row < tauler.length; row++) {
        for (int col = 0; col < tauler[row].length; col++) {
            if (temp_tauler[row][col] == 2) { // Cel·lula nascuda:
                tauler[row][col] = 1;

            } else if(temp_tauler[row][col] == 3){ // Cel·lula morta:
                tauler[row][col] = 0;
            }

        }
    }

    
    if (print) {
        System.out.println();
        System.out.println("S'ha vançat una generació.");
        System.out.println();
        teclaContinuar();
    }
}

public static void avancarNGeneracions() {
    System.out.print("Avançar num de vegades: ");
    int avancarNum = sc.nextInt();

    String[] gennums = {" generacio"," generacions"};
    int gennum = 0;

    System.out.println();

    for (int i = 0; i < avancarNum; i++) { // avançar avancarNum vegades
        gennum++;
        avancarGeneracio(false);
    }

    if (gennum == 1) { // S'ha avançat 1 generació
        System.out.println("S'ha vançat " + gennum + gennums[0]);
    } else { // S'ha avançat N generacions ( > 1 )
        System.out.println("S'ha vançat " + gennum + gennums[1]);
    }

    
    mostrarTauler(true);
}


// ===========================================
// NIVELL 8: COMPTAR CÈL·LULES VIVES
// ===========================================

public static int comptarVives() {
    int num_vives = 0;

    for (int row = 0; row < tauler.length; row++) {
        for (int col = 0; col < tauler[row].length; col++) {
            int cell_n = tauler[row][col]; // mirem el status de la cel·lula en aquesta posició (0 o 1)
            if (cell_n == 1) {
                num_vives++;
            }
        }
    }
    return num_vives;
}


// ===========================================
// MÒDULS D'AJUDA [Personals]
// ===========================================



public static int[] preguntarPosicio() {
    int[] grid_pos = {0, 0};

    System.out.println();

    System.out.print("Introdueix columna: ");
    grid_pos[1] = (sc.nextInt() - 1); // traduir automaticament a posició de taula

    System.out.println();

    System.out.print("Introdueix row: ");
    grid_pos[0] = (sc.nextInt() - 1); // traduir automaticament a posició de taula

    System.out.println();

    return grid_pos;
}

// ===========================================
// MÒDULS D'AJUDA [Importades de l'internet]
// ===========================================

/**
############

** clearScreen(): Limpiem la terminal per llegir millor l'output

############
**/
public static void clearScreen() {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
}

/**
############

** teclaContinuar(): Posem una pausa a l'execució, continuem apretant la tecla 'c'

############
**/
public static void teclaContinuar() {
    System.out.println("Introdueix 'c' per continuar...");
    char charr = '0';
    while (charr != 'c') {
        charr = sc.next().charAt(0);
    }
}
}
