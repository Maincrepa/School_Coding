package agenda;

public class Contacte {
    // Atributs PRIVATS
    private String nom;
    private String telefon;
    private String email;
    
    // CONSTRUCTOR amb validació OBLIGATÒRIA
    public Contacte(String nom, String telefon, String email) {
        if (!(validarNom(nom) && validarTelefon(telefon) && validarEmail(email))) {
            // Si NO és correcte l'informació (alguna return false); info incorrecte, no podem seguir
            System.out.println("L'informació no és correcte.");
            return;
        }
        // L'informació és correcte, seguim.

        this.nom = nom;
        this.telefon = telefon;
        this.email = email;
    }
    
    // GETTERS (obligatoris)
    public String getNom() {
        return this.nom;
    }
    
    public String getTelefon() {
        return this.telefon;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    // SETTERS amb validació (obligatoris)
    public void setTelefon(String telefon) {
        if (!validarTelefon(telefon)) {
            // No s'ha pogut validar, informació incorrecta.
            return;
        }

        this.telefon = telefon;
    }
    
    public void setEmail(String email) {
        if (!validarEmail(email)) {
            // No s'ha pogut validar, informació incorrecta.
            return;
        }

        this.email = email;
    }
    
    // Mètode per mostrar informació
    public String mostrarInfo() {
        String nom = this.nom;
        String email = this.email;
        String telefon = this.telefon;

        String output = """
        
            Nom: %s
            Email: %s
            Telefon: %s

        """.formatted(nom,email,telefon);

        return output; // retornem el string pel print en Principal
    }


    // Métodes extra:
    private boolean validarNom(String nom) {
        if (nom == null || nom.isEmpty()) { 
            // El nom és buit, retornar
            System.out.println("El nom és buit");
            return false;
        }
        return true;
    }

    private boolean validarEmail(String email) {
        boolean emailcorrect = false;
        for (int i = 0; i < email.length(); i++) {
            // Mirem cada char del email per buscar l'arroba
            if (email.charAt(i) == '@') {
                // S'ha encontrat l'arroba
                emailcorrect = true;
            }
        }
        if (!emailcorrect) {
            System.out.println("El email és incorrecte (no té l'arroba)");
            return false;
        }
        return emailcorrect;
    }

    private boolean validarTelefon(String telefon) {
        if (telefon.length() < 9) {
            System.out.println("El telefon és incorrecte");
            return false;
        }
        return true;
    }
}
