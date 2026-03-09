package botiga;

public class Inventari {
    private Producte[] productes;
    private int numProductes;
    private static final int MAX_PRODUCTES = 100;
    
    // CONSTRUCTOR
    public Inventari() {
        this.productes = new Producte[MAX_PRODUCTES]; // inicialitzar this.productes
        this.numProductes = 0; // inicialitzar this.numProductes
    }
    
    public boolean afegirProducte(Producte producte) {
        if (!(numProductes < MAX_PRODUCTES)) {
            // no hi ha espai
            System.out.println("No hi ha espai");

            return false;
        }

        this.productes[numProductes] = producte;
        numProductes++; // incrementem el index/contador.

        return true;
    }
    
    public Producte buscarProducte(String codi) {
        for (int i = 0; i < this.numProductes; i++) {
            if (this.productes[i] != null && this.productes[i].getCodi().equals(codi)) {
                String output = this.productes[i].mostrarInfo();
                System.out.println(output); // mostrar el producte encontrat
                return this.productes[i]; // retornem producte retornat
            }
        }
        return null;
    }
    
    public void llistarProductesStockBaix() {
        for (int i = 0; i < this.numProductes; i++) {
            if (this.productes[i].teStockBaix()) {
                String output = this.productes[i].mostrarInfo();
                System.out.println(output);
            }
        }
    }
    
    public double calcularValorTotal() {
        double total = 0.0;

        for (int i = 0; i < this.numProductes; i++) {
            total += this.productes[i].calcularValor();
        }

        return total;
    }
    
    public void llistarTotsElsProductes() {
        for (int i = 0; i < this.numProductes; i++) {
            String output = this.productes[i].mostrarInfo();
            System.out.println(output);
        }
    }
}
