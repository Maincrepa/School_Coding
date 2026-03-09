import java.util.Scanner;

/**
 * GESTOR DE ESTUDIANTES - Programa principal que demuestra POO
 * 
 * Este programa muestra cómo:
 * 1. CREAR objetos usando constructores
 * 2. USAR métodos de los objetos
 * 3. INTERACTUAR con múltiples objetos
 * 4. GESTIONAR objetos en un programa real
 * 
 * CONCEPTOS DEMOSTRADOS:
 * - Instanciación de objetos
 * - Llamada a métodos
 * - Paso de parámetros a métodos
 * - Uso de diferentes constructores
 */
public class GestorEstudiantes {
    // Scanner estático - se comparte entre todos los métodos de esta clase
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE GESTIÓN DE ESTUDIANTES ===\n");
        
        // ========== CREACIÓN DE OBJETOS ==========
        // Aquí vemos cómo crear objetos usando la palabra clave 'new'
        // Cada 'new' llama a un constructor de la clase Estudiante
        
        // Usando el constructor básico (sin nota media)
        Estudiante estudiante1 = new Estudiante("Ana García", 20, "Informática");
        
        // Usando el constructor sobrecargado (con nota media)
        Estudiante estudiante2 = new Estudiante("Carlos López", 19, "Matemáticas", 8.5);
        
        // Otro objeto con el constructor básico
        Estudiante estudiante3 = new Estudiante("María Rodríguez", 17, "Física");
        
        // Mostrar estudiantes iniciales
        System.out.println("=== ESTUDIANTES REGISTRADOS ===\n");
        System.out.println(estudiante1);
        System.out.println("\n" + estudiante2);
        System.out.println("\n" + estudiante3);
        
        // ========== INTERACCIÓN CON OBJETOS ==========
        // Ahora vamos a ver cómo USAR los objetos que hemos creado
        // Llamaremos a sus métodos para hacer que "hagan cosas"
        
        System.out.println("\n=== SIMULACIÓN DE ACTIVIDADES ===\n");
        
        // Ana estudia y hace un examen
        // NOTA: estudiante1.estudiar() llama al método estudiar() del objeto estudiante1
        estudiante1.estudiar();        // Llama al método estudiar()
        estudiante1.hacerExamen(7.8);  // Llama al método hacerExamen() con parámetro 7.8
        
        // Carlos hace otro examen
        // Cada objeto mantiene su propio estado (sus propios datos)
        estudiante2.estudiar();        // El mismo método, pero en un objeto diferente
        estudiante2.hacerExamen(9.2);  // Esto cambia la nota de Carlos, no la de Ana
        
        // María celebra cumpleaños - usamos getter y setter
        System.out.println(estudiante3.getNombre() + " celebra su cumpleaños!");
        estudiante3.setEdad(18);       // Usar el setter para cambiar la edad
        // Combinamos getter con concatenación de strings
        System.out.println("Ahora " + estudiante3.getNombre() + " tiene " + estudiante3.getEdad() + " años");
        
        // Mostrar estado final
        System.out.println("\n=== ESTADO FINAL ===\n");
        System.out.println(estudiante1);
        System.out.println("\n" + estudiante2);
        System.out.println("\n" + estudiante3);
        
        // Parte interactiva - crear tu propio estudiante
        System.out.println("\n=== CREAR TU PROPIO ESTUDIANTE ===");
        crearEstudianteInteractivo();
        
        scanner.close();
    }
    
    /**
     * MÉTODO ESTÁTICO que crea un estudiante de forma interactiva
     * 
     * Este método demuestra:
     * - Cómo decidir qué constructor usar basado en input del usuario
     * - Cómo crear objetos dinámicamente
     * - Cómo usar los métodos del objeto recién creado
     */
    public static void crearEstudianteInteractivo() {
        // Recoger datos del usuario
        System.out.print("Introduce tu nombre: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Introduce tu edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer después de nextInt()
        
        System.out.print("Introduce tu carrera: ");
        String carrera = scanner.nextLine();
        
        System.out.print("¿Tienes ya una nota media? (s/n): ");
        String tieneNota = scanner.nextLine().toLowerCase();
        
        // Declaramos la variable pero aún no la inicializamos
        // El tipo es Estudiante - puede contener cualquier objeto de esa clase
        Estudiante tuEstudiante;
        
        // ========== SELECCIÓN DINÁMICA DE CONSTRUCTOR ==========
        // Basado en la respuesta del usuario, elegimos qué constructor usar
        
        if (tieneNota.equals("s") || tieneNota.equals("sí")) {
            // Si tiene nota, pedimos el valor y usamos el constructor con 4 parámetros
            System.out.print("Introduce tu nota media (0-10): ");
            double nota = scanner.nextDouble();
            // Constructor sobrecargado - incluye la nota media
            tuEstudiante = new Estudiante(nombre, edad, carrera, nota);
        } else {
            // Si no tiene nota, usamos el constructor básico con 3 parámetros
            // La nota se pondrá automáticamente a 0.0
            tuEstudiante = new Estudiante(nombre, edad, carrera);
        }
        
        System.out.println("\n¡Estudiante creado exitosamente!\n");
        System.out.println(tuEstudiante);
        
        // Simular algunas actividades
        System.out.println("\nSimulemos algunas actividades:");
        tuEstudiante.estudiar();
        
        if (tuEstudiante.getNotaMedia() == 0.0) {
            System.out.print("Haces tu primer examen. ¿Qué nota sacas? (0-10): ");
            double primeraNota = scanner.nextDouble();
            tuEstudiante.hacerExamen(primeraNota);
            
            System.out.println("\n=== TU PERFIL FINAL ===");
            System.out.println(tuEstudiante);
        }
    }
}