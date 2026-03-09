// Joc Paraulògic

/*
7 lletres, ha de trobar max paraules valides possible

valid if:
- minim 3 lletres
- conté lletra central (marca entre claudators)
- totes les seves lletres pertanyen al conjunt de 7 lletres (poden repetir)


PUNTUACIÓ:
- 3 lletr: 1 pnt
- 4 lletr: 2 pnt
- 5+ lletr: 1 pnt per lletr
- Tuti (7 lletres del joc): 10 pnt extra

LLETRES: A, E, M, P, L, [R]
R: Lletra central

RAM → 1 pt (3 lletres, conté R ✓)
MARE → 2 pts (4 lletres, conté R ✓)
ARMAR → 5 pts (5 lletres, conté R ✓)
PALMAR → 6 pts (6 lletres, conté R ✓)
PALMERA → 7+10 = 17 pts (TUTI 🏆, usa A+E+M+P+L+R)
PALMA → ❌ no conté la lletra central [R]
ARBRE → ❌ conté 'B', que no és al conjunt

*/

import java.util.Scanner;

//System.out.println("DEBUG | DESC: ");

public class Examen_2Trimestre {
    static Scanner input = new Scanner(System.in);

    static final char[] LLETRES = {'a','e','m','p','l','r','c'};
    private static final char LLETRA_C = 'r'; // lletra central

    // Diccionari de paraules vàlides (NO cal modificar-lo)
    private static final String[] DICCIONARI = {
    "ram", "mar", "mare", "arma", "armar", "remar",
    "palmar", "palmera", "mara", "rama", "amar", "marca", "calmar"
    };

    static boolean gameactive;

    static int PuntsTotal;

    static String[] paraulesTrobades = new String[DICCIONARI.length];
    static int paraulesTrobadesIndex = 0;

    public static void main(String[] args) {
        inici();
    }

    /*
    ===================================
        INICI
    ===================================
    */

    public static void inici() {
        // Arranca
        gameactive = true;
        PuntsTotal = 0;

        // Mostra lletres
        mostrarLletres();

        // Bucle que demana paraules fins que usuari escriu "FI"
        while (gameactive) {
            llegirParaula();
        }
    }

    /*
    ===================================
    *    MÉTODE 1 - esParaulaValida
    ===================================
    */

    /**
     * Comprova si una paraula és vàlida segons les regles del Paraulògic.
     *
     * @param paraula La paraula introduïda (en minúscules).
     * @return true si és vàlida, false si no.
     */
    public static boolean esParaulaValida(String paraula) {
       
        if (!teMinimLletres(paraula)) {
            // No té el mínim de lletres
            System.out.println(paraula.toUpperCase() + " no té el mínim de 3 lletres!");
            return false;
        }

        if (esDuplicada(paraula)) {
            // La paraula és duplicada
            System.out.println(paraula.toUpperCase() + " ja l'has trobat!");
            return false;
        }

        if (!esAlDiccionari(paraula)) {
            System.out.println(paraula.toUpperCase() + " no está al diccionari!");
            return false;
        }

        boolean paraulacentral = false;
        boolean paraula_alien_no_trobada = false;

        for (int lletra = 0; lletra < paraula.length(); lletra++) {
            char lletra_paraula = paraula.charAt(lletra);

            if (lletra_paraula == LLETRA_C) { // Té la paraula central?
                paraulacentral = true;
            }
            

            for (int lletres_req = 0; lletres_req < LLETRES.length; lletres_req++) {
                // Comprovem que les paraules pertanyen al conjunt.

                if (lletra_paraula == LLETRES[lletres_req]) {
                    // la lletra encaixa; parem de fer check de paraula alien ja que segurament no hi ha
                    paraula_alien_no_trobada = true;
                }
            }
        }

        if (!paraulacentral) { 
            // Si la paraula no té la lletra central:
            System.out.println("La teva paraula no té la lletra central");
            return false;
        }

        if (!paraula_alien_no_trobada) { 
            // Si la paraula té lletres alien (que no pertanyen al conjunt) que no están en LLETRES:
            System.out.println("La teva paraula no no pertanyen al conjunt");
            return false;
        }
        
        return true;
    }


    /*
    ===================================
    *    MÉTODE 2 - calcularPuntuacio
    ===================================
    */

    /**
     * Calcula els punts d'una paraula vàlida.
     * 3 lletres→1pt | 4 lletres→2pts | 5+→1pt/lletra | tuti→+10pts
     *
     * @param paraula La paraula vàlida.
     */
    public static void calcularPuntuacio(String paraula) {
        int PuntsObtinguts = 0;
        //TODO: CALCULAR PUNTUACIÓ

        /*
        - 3 lletr: 1 pnt
        - 4 lletr: 2 pnt
        - 5+ lletr: 1 pnt per lletr
        - Tuti (7 lletres del joc): 10 pnt extra
        */

        int lletresEncertades = 0;

        for (int lletra = 0; lletra < paraula.length(); lletra++) {
            char lletra_paraula = paraula.charAt(lletra);
            
            for (int lletres_req = 0; lletres_req < LLETRES.length; lletres_req++) {
                if (lletra_paraula == LLETRES[lletres_req]) {
                    lletresEncertades++;
                }
            }
        }

        if (lletresEncertades == 3) {
            // Ha encertat 3; donem 1 punt
            PuntsObtinguts = 1;

        } else if (lletresEncertades == 4) {
            // Ha encertat 4; donem 2 punts
            PuntsObtinguts = 2;

        } else if (lletresEncertades > 4) {
            // Ha encertat 5 o més; donem 1 punt per cada lletra
            PuntsObtinguts = lletresEncertades;
        }

        if (lletresEncertades >= LLETRES.length) {
            // Paraual tuti, té totes les lletres
            PuntsObtinguts += 10; // otorguem punts extra!
        }

        // Sumem els punts obtinguts a la puntuació total.
        PuntsTotal += PuntsObtinguts;

        // Resultat final:
        System.out.print(paraula.toUpperCase() + " es valida! ");
        System.out.println("+" + PuntsObtinguts + " punts | Total: " + PuntsTotal + " punts.");
        System.out.println();
    }

        /*
    ===================================
    *    MÉTODE 3 - mostrarLletres
    ===================================
    */

    /**
     * Mostra per pantalla les 7 lletres disponibles destacant la central entre claudàtors. 
     * Exemple: A E M P L [R]
     **/

    public static void mostrarLletres() {
        System.out.println("=== PARAULOGIC ===");
        System.out.println();

        System.out.print("Lletres: ");

        // Print de les lletres no centrals
        for (int i = 0; i < LLETRES.length; i++) {
            System.out.print(LLETRES[i] + " ");
        }

        // Print de la lletra central
        System.out.print("[" + LLETRA_C + "]");
        
        System.out.println();
        System.out.println();
        System.out.println("-------------------");
    }

    /*
    ===================================
    *    MÉTODE 4 - llegirParaula
    ===================================
    */

    /**
     * Llegeix una paraula del teclat, la passa a minúscules i la retorna. 
     * Si l'usuari escriu "fi", el bucle ha d'acabar.
     */
    //TODO Main game loop
    public static void llegirParaula() {
        System.out.println();
        System.out.print("Introdueix paraula ('FI' per acabar): ");
        String paraula = input.nextLine().toLowerCase();
        
        if (paraula.equals("fi")) {
            // El jugador vol terminal el joc.
            gameactive = false;
            terminarJoc();

        } else { // El input no es "FI"; continuem
            // El jugador no vol terminar el joc, continuem.

            boolean paraulaValida = esParaulaValida(paraula);
            if (!paraulaValida) {
                // Paraula no valida
                System.out.println("La paraula no és valida!");
            } else {
                calcularPuntuacio(paraula);
                posarParaulaTrobadaEnTaula(paraula);
                
            }
        }
    }

    /*
    ===================================
    *    MÉTODE 5 - esAlDiccionari
    ===================================
    */

    /**
     * Comprova si una paraula existeix al diccionari.
     *
     * @param paraula Input de la paraula per comprovar-la.
     * @return boolean si és al diccionari o no.
     */
    public static boolean esAlDiccionari(String paraula) {
        for (int paraula_i = 0; paraula_i < DICCIONARI.length; paraula_i++) {
            if (DICCIONARI[paraula_i].equals(paraula)) {
                return true;
            }
        }

        return false;
    }
    
    /*
    ===================================
    *    MÉTODE 6 - esDuplicada
    ===================================
    */

    /**
     * Comprova si una paraula ja ha estat trobada en aquesta partida.
     * Usa un array de String per emmagatzemar les trobades.
     *
     * @param paraula Input de la paraula per comprovar-la.
     * @return boolean si es troba o no.
     */
    public static boolean esDuplicada(String paraula) {
        for (int i = 0; i < paraulesTrobades.length; i++) {
            if (paraula.equals(paraulesTrobades[i])) {
                // La paraula ja existeix en la taula de paraules trobades, no val, return false.
                return true;
            }
        }
        return false;
    }


    /*
    ===================================
    *    MÉTODE 7 - teMinimLletres
    ===================================
    */

    /**
     * Comprova si una paraula té el mínim de 3 lletres
     *
     * @param paraula Input de la paraula per comprovar-la.
     * @return Retorna boolean si té o no.
     */

    public static boolean teMinimLletres(String paraula) {
        //System.out.println("DEBUG | LLETRES EN LA PARAULA: " + paraula.length());
        if (paraula.length() >= 3) {
            return true;
        } else {
            return false;
        }
    }


    /*
    ===================================
    *    MÉTODE 8 - posarParaulaTrobadaEnTaula
    ===================================
    */

    /**
     * Posem la paraula trobada en la llista de paraules trobades.
     *
     * @param paraula Input de la paraula per guardar-la.
     */

    public static void posarParaulaTrobadaEnTaula(String paraula) {
        // Guardem la paraulla en un slot de la taula.
        paraulesTrobades[paraulesTrobadesIndex] = paraula;
        // Incrementem l'index per no posar dos paraules en una slot.
        paraulesTrobadesIndex++;
    }


    /*
    ===================================
    *    MÉTODE 9 - terminarJoc
    ===================================
    */

    /**
     * Termina el joc
     */

    public static void terminarJoc() {
        System.out.println("=== RESULTAT FINAL ===");
        String Punts = ("Puntuació: " + PuntsTotal + " punts | Paraules trobades: " + paraulesTrobadesIndex);
        String Paraules = "Paraules: ";

        System.out.println(Punts);

        System.out.println(); // Espai en blanc

        System.out.print(Paraules);

        for (int i = 0; i < paraulesTrobadesIndex; i++) {
            System.out.print(paraulesTrobades[i].toUpperCase());
            System.out.print(", "); // Espai entre paraules
        }

        // FIN!!!!!
    }




}
