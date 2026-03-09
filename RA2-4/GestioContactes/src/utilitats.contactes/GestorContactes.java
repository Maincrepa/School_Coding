package utilitats.contactes;

public class GestorContactes {
    static String[][] contactes;
    static int last_free_index;

    public void Initialize() {
        contactes = new String[10][2]; // Crear una taula amb 10 usuaris (i 2 dades nom,tel) per començar.
        last_free_index = 0;
    } 

    public static void mostrarTaula() {
        if (contactes[0][0] == null) {
            System.out.println("La taula está buida");
            return;
        }
        for (int contacte = 0; contacte < contactes.length; contacte++) {
            if (!(contactes[contacte][0] == null)) {
                // No está null; no está buida, podem seguir
            
            String output = """
            ---------------------
                Posició: %02d
                Nom: %s
                Tel: %s
            ---------------------
            """.formatted(
                (contacte + 1),
                contactes[contacte][0],
                contactes[contacte][1]);

            System.out.println(output);
            }
        }
        System.out.println("=================================");
    }

    public static void AfegirContacte(String NomString, String TelefonString) {
        String[][] tempcontact;


        if (last_free_index == contactes.length) {
                // No hi ha lloc en la taula de contactes, la taula temporal ha de tindre +1 pel nou contacte.
                tempcontact = new String[contactes.length+1][2];

            } else { // Hi ha lloc, seguim fent servir la taula inicial.
                // Verifiquem que el últim index realment estigui sense usuari.

                if (!(contactes[last_free_index][0] == null)) {
                    System.out.println("Error: Aquest index ja esta ocupat, contacta un administrador");
                    return;

                } else {
                    // Seguim si no esta ocupat.
                    tempcontact = new String[contactes.length][2];
                }
            }

        // Omplim la taula temporal amb les dades de la taula real
        for (int omplir_usuari = 0; omplir_usuari < contactes.length; omplir_usuari++) {
            tempcontact[omplir_usuari][0] = contactes[omplir_usuari][0];
            tempcontact[omplir_usuari][1] = contactes[omplir_usuari][1];
        }

        // Crear informació del contacte

        String[] contacte = {
            NomString, // Nom
            TelefonString // Telefon
        };

        // Introduir el contacte en la taula temporal.

        tempcontact[last_free_index][0] = contacte[0];
        tempcontact[last_free_index][1] = contacte[1];

        // Canviar la taula real amb la taula temporal
        contactes = tempcontact;

        last_free_index++;
    }

    public static void buscarContactePerNom(String NomString) {
        if (contactes[0][0] == null) {
            System.out.println("La taula está buida, no hi ha contactes");
            return;
        }

        boolean encontrat = false;
        for (int contacte = 0; contacte < contactes.length; contacte++) {
            if (!(contactes[contacte][0] == null)) {
                // No está null; no está buida, podem seguir

            if (contactes[contacte][0].equals(NomString)) {
                System.out.println("S'ha encontrat l'usuari");
                encontrat = true;
            
                String output = """

                ---------------------
                    Posició: %02d
                    Nom: %s
                    Tel: %s
                ---------------------
                """.formatted(
                    (contacte + 1),
                    contactes[contacte][0],
                    contactes[contacte][1]);

                System.out.println(output);
                }
            }
        }
        if (!encontrat) {
            System.out.println("No s'ha encontrat cap usuari");
        }
    }

    public static void eliminarContacte(int Posicio) {
        if (contactes[0][0] == null) {
            System.out.println("La taula está buida, no hi ha contactes");
            return;
        }

        // Convertir la posició 1-based introduïda per l'usuari a index 0-based
        Posicio--; 

        String[][] tempcontact;

        tempcontact = new String[contactes.length-1][2];
        
        // Omplir la taula, abans del contacte eliminat normal
        // pero després del contacte elimat, s'ha de fer -1
        for (int index = 0; index < contactes.length; index++) {
            if (index < Posicio) { // abans de l'element a eliminar: copia normal
                tempcontact[index][0] = contactes[index][0];
                tempcontact[index][1] = contactes[index][1];
            } else if (index > Posicio) { // després: desplaçar -1
                tempcontact[index-1][0] = contactes[index][0];
                tempcontact[index-1][1] = contactes[index][1];
            } 
        }

        // Canviar la taula real amb la taula temporal
        contactes = tempcontact;

        last_free_index--;

    }

    
}

