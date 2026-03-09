import java.util.ArrayList;
import java.util.List;

/**
 * CLASE BIBLIOTECA - Ejemplo de gestión de objetos
 * 
 * CONCEPTOS IMPORTANTES:
 * - COMPOSICIÓN: La biblioteca "tiene" libros (relación has-a)
 * - COLECCIONES: Uso de ArrayList para almacenar múltiples objetos
 * - MÉTODOS DE NEGOCIO: Funcionalidades específicas del dominio
 */
public class Biblioteca {
    
    // ATRIBUTOS
    private String nombre;
    private List<Libro> libros;    // Lista que contiene objetos de tipo Libro
    
    // CONSTRUCTOR
    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.libros = new ArrayList<>();  // Inicializamos la lista vacía
        System.out.println("🏛️ Biblioteca '" + nombre + "' creada exitosamente!");
    }
    
    // MÉTODOS PARA GESTIONAR LIBROS
    
    /**
     * Agregar un nuevo libro a la biblioteca
     */
    public void agregarLibro(Libro libro) {
        libros.add(libro);
        System.out.println("✅ Libro agregado: " + libro.getTitulo());
    }
    
    /**
     * Crear y agregar un libro directamente con los datos
     */
    public void agregarLibro(String titulo, String autor, int año) {
        Libro nuevoLibro = new Libro(titulo, autor, año);
        agregarLibro(nuevoLibro);
    }
    
    /**
     * Buscar un libro por título
     */
    public Libro buscarPorTitulo(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;  // No encontrado
    }
    
    /**
     * Buscar libros por autor
     */
    public List<Libro> buscarPorAutor(String autor) {
        List<Libro> librosDelAutor = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getAutor().equalsIgnoreCase(autor)) {
                librosDelAutor.add(libro);
            }
        }
        return librosDelAutor;
    }
    
    /**
     * Mostrar todos los libros disponibles
     */
    public void mostrarLibrosDisponibles() {
        System.out.println("\n📖 LIBROS DISPONIBLES EN " + nombre.toUpperCase());
        System.out.println("=" + "=".repeat(50));
        
        boolean hayDisponibles = false;
        for (Libro libro : libros) {
            if (libro.isDisponible()) {
                System.out.println(libro);
                hayDisponibles = true;
            }
        }
        
        if (!hayDisponibles) {
            System.out.println("❌ No hay libros disponibles en este momento.");
        }
        System.out.println();
    }
    
    /**
     * Mostrar todos los libros (disponibles y prestados)
     */
    public void mostrarTodosLosLibros() {
        System.out.println("\n📚 TODOS LOS LIBROS DE " + nombre.toUpperCase());
        System.out.println("=" + "=".repeat(50));
        
        if (libros.isEmpty()) {
            System.out.println("❌ La biblioteca está vacía.");
        } else {
            for (int i = 0; i < libros.size(); i++) {
                System.out.println((i + 1) + ". " + libros.get(i));
            }
        }
        System.out.println();
    }
    
    /**
     * Prestar un libro por título
     */
    public boolean prestarLibro(String titulo) {
        Libro libro = buscarPorTitulo(titulo);
        if (libro != null) {
            libro.prestar();
            return true;
        } else {
            System.out.println("❌ No se encontró el libro: " + titulo);
            return false;
        }
    }
    
    /**
     * Devolver un libro por título
     */
    public boolean devolverLibro(String titulo) {
        Libro libro = buscarPorTitulo(titulo);
        if (libro != null) {
            libro.devolver();
            return true;
        } else {
            System.out.println("❌ No se encontró el libro: " + titulo);
            return false;
        }
    }
    
    /**
     * Obtener estadísticas de la biblioteca
     */
    public void mostrarEstadisticas() {
        int total = libros.size();
        int disponibles = 0;
        int prestados = 0;
        
        for (Libro libro : libros) {
            if (libro.isDisponible()) {
                disponibles++;
            } else {
                prestados++;
            }
        }
        
        System.out.println("\n📊 ESTADÍSTICAS DE " + nombre.toUpperCase());
        System.out.println("=" + "=".repeat(40));
        System.out.println("Total de libros: " + total);
        System.out.println("Libros disponibles: " + disponibles);
        System.out.println("Libros prestados: " + prestados);
        System.out.println("=" + "=".repeat(40) + "\n");
    }
    
    // GETTERS
    public String getNombre() {
        return nombre;
    }
    
    public int getTotalLibros() {
        return libros.size();
    }
    
    public List<Libro> getLibros() {
        return new ArrayList<>(libros);  // Devolvemos una copia para mantener encapsulación
    }
}