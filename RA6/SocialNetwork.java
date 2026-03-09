import java.util.Scanner;

/**
 * SOCIAL NETWORK - Administrador de Xarxa Social
 *
 * Estructura de dades:
 * - usuaris[i][0] = dni
 * - usuaris[i][1] = nom
 * - usuaris[i][2] = email
 * - usuaris[i][3] = password
 */
public class SocialNetwork {

    static Scanner sc = new Scanner(System.in);
    public static String[] DADES = {"DNI","Nom","Email","Password"};
    public static String[][] usuaris;
    public static int nextFreeUserPos;

    public static void main(String[] args) {
        usuaris = new String[100][4];
        nextFreeUserPos = 0;

        boolean active = true;

        DEBUG_fillList();

        while (active) {
            int opcio;

            // Bucle principal
            clearScreen();
            opcio = menu(); // - Crida menu() per obtenir opcio

            switch (opcio) { // - Segons l'opcio, crida la funció corresponent
                case 0: // Sortir
                    active = false;
                    break;
                case 1: // Crear usuari
                    crearUsuari();
                    break;
                case 2: // Buscar usuaris
                    buscarUsuari("null",true);
                    break;
                case 3: // Llistar usuaris
                    llistarUsuaris();
                    break;
                case 4: // Eliminar usuari
                    eliminarUsuari("null");
                    break;
                default:
                    break;
            }
        }
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

            SOCIAL NETWORK 

        ============================= 

            1. Crear usuari 

            2. Buscar usuari 

            3. Llistar usuaris 

            4. Eliminar usuari 

            0. Sortir 

        =============================         
        """); // Print del menu

        while (!(num >= 0 && num <= 4)) { // Opció de 0-4
            System.out.print("Introdueix una opció: ");
            num = sc.nextInt();
        }

        // Opció correcte, tanca el loop i seguim al return.
        return num;
    }


    // ===========================================
    // NIVELL 2: CREAR USUARI
    // ===========================================

    /**
    ############
    
    ** crearUsuari(): Crea un usuari basat en inputs de les dades
    
    ############
    
    @dadesIntroduides: DNI, Nom, Email, Password
    *! Nom: Per no fer servir nextLine, suposo que el client només posará el seu primer nom i no una cadena de text del seu nom complet.
    
    ############
    **/

    public static void crearUsuari() {
        clearScreen();
        System.out.println("""

        ============================= 

            CREACIÓ DE L'USUARI 

        =============================  

        """);
        String[] dadesIntroduides = new String[DADES.length];
        boolean DNI_Correct = false;

        for (int dada_i = 0; dada_i < DADES.length; dada_i++) { // dada_i = iterador
            String ComprovantDada = DADES[dada_i];
            boolean no_verificat = true;

            while (no_verificat) {
                System.out.print("Introdueix el " + ComprovantDada + ": ");
                String input = sc.next();

                if (ComprovantDada != "DNI") { // Verificar altres dades
                    no_verificat = false;
                    dadesIntroduides[dada_i] = input;

                } else { // Verificar DNI
                    if (!DNI_Correct) {
                        boolean comprovarDNI = buscarUsuari(input, false);
                        if (!comprovarDNI) { // DNI no existeix, continuem
                            dadesIntroduides[dada_i] = input;
                            DNI_Correct = true;
                            no_verificat = false;
                            //dadesFinalitzades++;
                        } else {
                            System.out.println("ERROR: Ja existeix un usuari amb aquest DNI.");
                        }
                    }
                }
            }
        }

        String sortida = """
        
        ============================= 

            USUARI CREAT 

        ============================= 

            DNI: %s

            Nom: %s 

            Email: %s 

            Password: %s 



            ! Usuari creat ! 

        =============================
        """.formatted(dadesIntroduides[0],
            dadesIntroduides[1],
            dadesIntroduides[2],
            dadesIntroduides[3]);
        
        System.out.println(sortida);

        usuaris[nextFreeUserPos] = dadesIntroduides;
        nextFreeUserPos++;

        teclaContinuar();
}

    // ===========================================
    // NIVELL 3: BUSCAR USUARI
    // ===========================================

    /**
    ############
    
    ** buscarUsuari(): Dona un DNI per buscar en "usuaris".
    
    ############
    
    @param DNI String - Input per buscar per DNI
    @param Print boolean - Boolean de si l'usuari vol que també que surti un print o no

    @return boolean - Retorna si existeix aquell usuari
        
    ############
    **/

    public static boolean buscarUsuari(String DNI, boolean PrintV) {
        if (PrintV) { // Si Visual; Limpiem output
            clearScreen(); 
            System.out.println("""
                            
            =============================

                BUSCAR USUARI

            =============================
            
            """);
        } 

        if ((nextFreeUserPos > 0)) {   // ? Hi ha usuaris registrats
            if (DNI.equals("null")) { // Si el DNI no és introduït prèviament,, s'ha de demanar
                System.out.print("Introdueix un DNI: ");
                DNI = sc.next();
            }
            boolean trobat = false;
            int Position = 0;

            for (int search_i = 0; search_i < nextFreeUserPos; search_i++) { // search_i = iterador
                if (usuaris[search_i][0].equals(DNI) && (!trobat)) {
                    Position = search_i;
                    trobat = true;
                }
            }
            

            if (PrintV) {
                clearScreen();
                if (trobat) {
                    String output = """
                            
                    =============================

                        BUSCAR USUARI

                    =============================
                    
                        DNI: %s
                    
                        Usuari trobat!
                    """.formatted(DNI);


                    System.out.println(output);

                    System.out.println(printUsuari(Position));
                } else {
                    String output = """
                            
                    =============================
                        BUSCAR USUARI
                    =============================
                    
                        DNI: %s
                    
                        Usuari no trobat

                    =============================
                    """.formatted(DNI);

                    System.out.println(output);
                }
                teclaContinuar();
            }
            
            return trobat;
        } else {
            if (PrintV) {
                System.out.println(NoUsuarisPrint());
                teclaContinuar();
            }
            return false;
        }
    }


    /** 
    ############ 

    ** printUsuari(): Petit métode per fer print a un usuari a partir de la posició en la llista d'usuaris

    ############

    @param Position int - La posició dins la llista d'usuari
    
    @return String - Retorna un string amb l'informació de l'usuari

    ############
    **/

    public static String printUsuari(int Position) {

        String output = ("""

        ============================= 

            DNI: %s

            Nom: %s 

            Email: %s 

            Password: %s 

        ============================= 
        """).formatted(usuaris[Position][0],
            usuaris[Position][1],
            usuaris[Position][2],
            "··········");

        return output;
    }

    // ===========================================
    // NIVELL 4: LLISTAR USUARIS
    // ===========================================


    /**
    ############
    
    ** llistarUsuaris(): Llistar tots els usuaris amb un print
    
    ############
    **/

    public static void llistarUsuaris() { 
        clearScreen();
        
        if (!(nextFreeUserPos > 0)) { // No hay nada
            System.out.println(NoUsuarisPrint());
        } else {
            System.out.println("""
            ============================= 

                LLISTAR USUARIS 

            =============================

            """);
            System.out.println("Usuaris totals: " + nextFreeUserPos);
            System.out.println("");
            for (int index = 0; index < nextFreeUserPos; index++) {
                if (usuaris[index][0] != null) {
                    System.out.println((index + 1) + ". " + usuaris[index][0] + " - " + usuaris[index][1]);
                }
            }

            System.out.println();
            System.out.println("=============================");
        }
        teclaContinuar();
    }

    // ===========================================
    // NIVELL 5: ELIMINAR USUARI
    // ===========================================

    /**
    ############
    
    ** eliminarUsuari(): Eliminem l'usuari a partir del DNI
    
    ############
    
    @param DNI String - Input del DNI de l'usuari que volem eliminar
        
    ############
    **/

    public static void eliminarUsuari(String DNI) {
        clearScreen(); 
        System.out.println("""
                        
        =============================

            ELIMINAR USUARI

        =============================
        
        """);

        if ((nextFreeUserPos > 0)) {   // ? Hi ha usuaris registrats
            int elim_pos = 0;
            boolean trobat = false;
            if (DNI.equals("null")) { // Existeix DNI; skip | No existeix; demanar
                while (!trobat) {
                    System.out.print("Introdueix un DNI: ");
                    DNI = sc.next();

                    for (int search_i = 0; search_i < nextFreeUserPos; search_i++) { // search_i = iterador
                        if (usuaris[search_i][0].equals(DNI)) {
                            trobat = true;
                            elim_pos = search_i; 
                        }
                    }
                    if (!trobat) {
                        System.out.println("Aquest DNI no pertany a ningún usuari");
                        System.out.println();
                    }
                }
            } else {
                trobat = true;
            }
            
            
            for(int pos = elim_pos + 1; pos < nextFreeUserPos; pos++) {
                usuaris[pos - 1] = usuaris[pos];
            }
            nextFreeUserPos--;

            String output = ("""
                            
            =============================

                USUARI ELIMINAT

                DNI = %s

            =============================
            
            """).formatted(DNI);
            System.out.println(output);

        } else {
            System.out.println(NoUsuarisPrint());
        }

    teclaContinuar();
    }

    // ===========================================
    // MÒDULS D'AJUDA
    // ===========================================

    /**
    ############
    
    ** NoUsuarisPrint(): Creem un string pels prints quan no hi ha usuaris
    
    ############
        
    @return String - El string fabricat pels prints
    
    ############
    **/
    public static String NoUsuarisPrint() {
        String output = ("""
        ============================= 

            LLISTAR USUARIS 

        ============================= 

            No hi ha usuaris registrats 

        ============================= 
        """);
        return output;
    }

    /**
    ############
    
    ** DEBUG_fillList(): Auto-Generar una llista de 20 posicions amb valors random
    
    ############
    **/

    public static void DEBUG_fillList() {
        for (int positon_i = 0; positon_i < 20; positon_i++) { // 20 slots
            boolean dni_fet = false;
            while (!dni_fet) {
                String DNI = ("X" + MathRand() + MathRand() + MathRand() + MathRand());
                boolean comprovarDNI = buscarUsuari(DNI, false);
                if (!comprovarDNI) { // DNI no existeix, continuem
                    dni_fet = true;
                    usuaris[positon_i][0] = DNI;
                }
            }
            usuaris[positon_i][1] = ("namerandom" + (MathRand() * 10));
            usuaris[positon_i][2] = (MathRand() + MathRand() + MathRand() + MathRand() + "@mail.com");
            usuaris[positon_i][3] = ("Password" + MathRand() + MathRand());
            nextFreeUserPos++;
        }
    }

    public static int MathRand() {
        return (int)((Math.random()*9)+1);
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
