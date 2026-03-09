import java.util.Scanner;

/**
 * Gestor de Notes d'Estudiants
 * 
 * Aquest projecte t'ensenya:
 * - Arrays per guardar múltiples dades
 * - Mètodes per organitzar el codi
 * - Càlculs amb arrays
 * 
 * Funcionalitats:
 * 1. Introduir notes d'un estudiant
 * 2. Mostrar totes les notes
 * 3. Calcular la nota mitjana
 * 4. Trobar la nota més alta i més baixa
 * 5. Comptar notes aprovades/suspeses
 */
public class GestorNotas {
    static Scanner sc = new Scanner(System.in);
    
    // Array per guardar les notes (màxim 10 assignatures)
    static double[] notes = new double[10];
    static int numAssignatures = 0; // Comptador de quantes assignatures tenim
    
    public static void main(String[] args) {
        System.out.println("=== GESTOR DE NOTES D'ESTUDIANT ===");
        System.out.println();
        
        boolean running = true;
        
        while (running) {
            mostrarMenu();
            int opcio = sc.nextInt();
            
            switch (opcio) {
                case 1:
                    introduirNotes();
                    break;
                case 2:
                    mostrarNotes();
                    break;
                case 3:
                    calcularMitjana();
                    break;
                case 4:
                    trobarNotesExtremes();
                    break;
                case 5:
                    comptarAprovats();
                    break;
                case 6:
                    System.out.println("Sortint del programa...");
                    running = false;
                    break;
                default:
                    System.out.println("Opció no vàlida. Tria un número del 1 al 6.");
            }
            
            System.out.println(); // Línia en blanc per visualització
        }
    }
    
    /**
     * Mètode per mostrar el menú principal
     */
    public static void mostrarMenu() {
        System.out.println("--- MENÚ PRINCIPAL ---");
        System.out.println("1. Introduir notes");
        System.out.println("2. Mostrar totes les notes");
        System.out.println("3. Calcular nota mitjana");
        System.out.println("4. Trobar nota més alta i més baixa");
        System.out.println("5. Comptar aprovats i suspesos");
        System.out.println("6. Sortir");
        System.out.print("Selecciona una opció: ");
    }
    
    /**
     * Mètode per introduir les notes de l'estudiant
     */
    public static void introduirNotes() {
        System.out.print("Quantes assignatures vols introduir? (màxim 10): ");
        numAssignatures = sc.nextInt();
        
        // Validació: màxim 10 assignatures
        if (numAssignatures > 10) {
            System.out.println("Màxim 10 assignatures. S'estableix a 10.");
            numAssignatures = 10;
        }
        
        // Demanar cada nota
        for (int i = 0; i < numAssignatures; i++) {
            System.out.print("Introdueix la nota de l'assignatura " + (i + 1) + " (0-10): ");
            double nota = sc.nextDouble();
            
            // Validació: nota entre 0 i 10
            if (nota >= 0 && nota <= 10) {
                notes[i] = nota;
            } else {
                System.out.println("Nota no vàlida. S'estableix a 0.");
                notes[i] = 0;
            }
        }
        
        System.out.println("Notes introduïdes correctament!");
    }
    
    /**
     * Mètode per mostrar totes les notes introduïdes
     */
    public static void mostrarNotes() {
        if (numAssignatures == 0) {
            System.out.println("No hi ha notes introduïdes encara.");
            return;
        }
        
        System.out.println("--- NOTES DE L'ESTUDIANT ---");
        for (int i = 0; i < numAssignatures; i++) {
            System.out.println("Assignatura " + (i + 1) + ": " + notes[i]);
        }
    }
    
    /**
     * Mètode per calcular i mostrar la nota mitjana
     */
    public static void calcularMitjana() {
        if (numAssignatures == 0) {
            System.out.println("No hi ha notes per calcular la mitjana.");
            return;
        }
        
        double suma = 0;
        for (int i = 0; i < numAssignatures; i++) {
            suma += notes[i];
        }
        
        double mitjana = suma / numAssignatures;
        System.out.println("Nota mitjana: " + String.format("%.2f", mitjana));
        
        // Determinar si l'estudiant ha aprovat
        if (mitjana >= 5.0) {
            System.out.println("¡L'estudiant ha aprovat amb nota mitjana!");
        } else {
            System.out.println("L'estudiant ha suspès. Nota mitjana insuficient.");
        }
    }
    
    /**
     * Mètode per trobar la nota més alta i més baixa
     */
    public static void trobarNotesExtremes() {
        if (numAssignatures == 0) {
            System.out.println("No hi ha notes per analitzar.");
            return;
        }
        
        double notaMaxima = notes[0];
        double notaMinima = notes[0];
        int posicioMaxima = 0;
        int posicioMinima = 0;
        
        for (int i = 1; i < numAssignatures; i++) {
            if (notes[i] > notaMaxima) {
                notaMaxima = notes[i];
                posicioMaxima = i;
            }
            if (notes[i] < notaMinima) {
                notaMinima = notes[i];
                posicioMinima = i;
            }
        }
        
        System.out.println("--- NOTES EXTREMES ---");
        System.out.println("Nota més alta: " + notaMaxima + " (Assignatura " + (posicioMaxima + 1) + ")");
        System.out.println("Nota més baixa: " + notaMinima + " (Assignatura " + (posicioMinima + 1) + ")");
    }
    
    /**
     * Mètode per comptar quantes assignatures estan aprovades i suspeses
     */
    public static void comptarAprovats() {
        if (numAssignatures == 0) {
            System.out.println("No hi ha notes per analitzar.");
            return;
        }
        
        int aprovats = 0;
        int suspesos = 0;
        
        for (int i = 0; i < numAssignatures; i++) {
            if (notes[i] >= 5.0) {
                aprovats++;
            } else {
                suspesos++;
            }
        }
        
        System.out.println("--- RESUM D'APROVATS ---");
        System.out.println("Assignatures aprovades: " + aprovats);
        System.out.println("Assignatures suspeses: " + suspesos);
        
        double percentatgeAprovats = (double) aprovats / numAssignatures * 100;
        System.out.println("Percentatge d'aprovats: " + String.format("%.1f", percentatgeAprovats) + "%");
    }
}