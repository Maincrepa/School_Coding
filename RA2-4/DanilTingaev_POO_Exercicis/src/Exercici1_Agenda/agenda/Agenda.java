package agenda;

public class Agenda {
    private Contacte[] contactes;
    private int numContactes;
    private static final int MAX_CONTACTES = 50;
    
    // CONSTRUCTOR que inicialitza l'array
    public Agenda() {
        this.contactes = new Contacte[MAX_CONTACTES];
        this.numContactes = 0;
    }
    
    // Afegir contacte (retorna true si s'ha afegit)
    public boolean afegirContacte(Contacte contacte) {
        if (!(numContactes < MAX_CONTACTES)) {
            // no hi ha espai
            System.out.println("No hi ha espai");
            return false;
        }
        this.contactes[numContactes] = contacte;
        numContactes++;

        return true;
    }
    
    // Buscar contacte per nom (retorna el contacte o null)
    public Contacte buscarContacte(String nom) {
        for (int i = 0; i < this.numContactes; i++) {
            if (this.contactes[i] != null && this.contactes[i].getNom().equals(nom)) {
                mostrarContacte(this.contactes[i]); // mostrar el contacte encontrat
                return this.contactes[i]; // retornem contacte retornat
            }
        }
        return null;
    }
    
    // Eliminar contacte per nom (retorna true si s'ha eliminat)
    public boolean eliminarContacte(String nom) {
        for (int i = 0; i < this.numContactes; i++) {
            if (this.contactes[i] != null && this.contactes[i].getNom().equals(nom)) {
                // Mourre tots els elements una posició cap a l'esquerra
                for (int j = i; j < this.numContactes - 1; j++) {
                    this.contactes[j] = this.contactes[j + 1];
                }

                this.contactes[numContactes - 1] = null;

                numContactes--; // eliminem 1 del index de numero de contactes
                return true; // true; s'ha eliminat
            }
        }
        return false;
    }
    
    // Llistar tots els contactes
    public void llistarContactes() {
        for (int i = 0; i < this.numContactes; i++) {
            mostrarContacte(this.contactes[i]);
        }
    }
    
    // Obtenir número total de contactes
    public int getNumContactes() {

        return this.numContactes;
    }

    // Extra métode meu, mostrar contacte individual
    public void mostrarContacte(Contacte contacte) {
        String nom = contacte.getNom();
        String email = contacte.getEmail();
        String telefon = contacte.getTelefon();

        String output = """
        
            Nom: %s
            Email: %s
            Telefon: %s

        """.formatted(nom,email,telefon);

        System.out.println(output);
    }
}
