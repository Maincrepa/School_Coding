package botiga;

public class Producte {
    // Atributs PRIVATS
    private String codi;
    private String nom;
    private double preu;
    private int stock;
    
    // CONSTRUCTOR amb validació OBLIGATÒRIA
    public Producte(String codi, String nom, double preu, int stock) {
        this.codi = codi;
        this.nom = nom;
        
        if (!validarPreu(preu)) {
            // preu incorrecte.
            this.preu = 0.01;
        } else {
            // preu correcte
            this.preu = preu;
        }
        
        if (!validarStock(stock)) {
            // stock incorrecte
            this.stock = 0;
        } else {
            // stock correcte
            this.stock = stock;
        }
    }
    
    // GETTERS (tots obligatoris)
    public String getCodi() {
        return this.codi;
    }
    
    public String getNom() {
        return this.nom;
    }
    
    public double getPreu() {
        return this.preu;
    }
    
    public int getStock() {
        return this.stock;
    }
    
    // SETTERS amb validació
    public void setPreu(double preu) {
        if (!validarPreu(preu)) {
            // No s'ha pogut validar, informació incorrecta; return.
            return;
        }

        this.preu = preu;
    }
    
    // Afegir stock (retorna true si s'ha afegit)
    public boolean afegirStock(int quantitat) {
        if (!validarStock(quantitat)) {
            return false;
        }
        this.stock += quantitat;
        return true;
    }
    
    // Retirar stock (retorna true si hi ha prou stock)
    public boolean retirarStock(int quantitat) {
        // comprovar si this.stock >= quantitat
        if (!(this.stock >= quantitat)) {
            //si no, retornar false
            return false;
        }

        // si sí, restar de this.stock i retornar true

        this.stock -= quantitat;
        return true;
    }
    
    // Calcular valor total (preu × stock)
    public double calcularValor() {
        return this.preu * this.stock;
        // retornar this.preu * this.stock
    }
    
    // Té stock baix? (menys de 5 unitats)
    public boolean teStockBaix() {
        return this.stock < 5; // retorna true si stock < 5
    }
    
    public String mostrarInfo() { // retornem String per fer el output en Principal
        String output = """
        
            Codi: %s
            Nom: %s
            Preu: %.2f€
            Stock: %d

        """.formatted(this.codi, this.nom, this.preu, this.stock);

        return output; // retornem el string pel print en Principal
    }


    // Checks apart

    private boolean validarPreu(double preu) {
        if (!(preu >= 0.0)) {
            return false;
        }
        return true;
    }

    private boolean validarStock(int quantitat) {
        if (!(quantitat >= 0)) {
            return false;
        }
        return true;
    }
}
