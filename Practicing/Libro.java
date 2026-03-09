/**
 * CLASE LIBRO - Ejemplo básico de Programación Orientada a Objetos
 * 
 * CONCEPTOS IMPORTANTES:
 * - ENCAPSULACIÓN: Los atributos son privados y se acceden mediante métodos
 * - CONSTRUCTOR: Método especial para crear objetos e inicializar atributos
 * - GETTERS/SETTERS: Métodos para acceder y modificar los atributos privados
 */
public class Libro {
    
    // ATRIBUTOS (características del objeto) - PRIVADOS para ENCAPSULACIÓN
    private String titulo;
    private String autor;
    private int añoPublicacion;
    private boolean disponible;
    
    // CONSTRUCTOR - Se ejecuta cuando creamos un nuevo libro
    public Libro(String titulo, String autor, int añoPublicacion) {
        this.titulo = titulo;           // 'this' se refiere al objeto actual
        this.autor = autor;
        this.añoPublicacion = añoPublicacion;
        this.disponible = true;         // Por defecto, un libro nuevo está disponible
    }
    
    // MÉTODOS GETTER - Para LEER los valores de los atributos privados
    public String getTitulo() {
        return titulo;
    }
    
    public String getAutor() {
        return autor;
    }
    
    public int getAñoPublicacion() {
        return añoPublicacion;
    }
    
    public boolean isDisponible() {
        return disponible;
    }
    
    // MÉTODOS SETTER - Para MODIFICAR los valores de los atributos privados
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public void setAñoPublicacion(int añoPublicacion) {
        this.añoPublicacion = añoPublicacion;
    }
    
    // MÉTODOS DE COMPORTAMIENTO - Lo que puede hacer el objeto
    public void prestar() {
        if (disponible) {
            disponible = false;
            System.out.println("El libro '" + titulo + "' ha sido prestado.");
        } else {
            System.out.println("El libro '" + titulo + "' no está disponible.");
        }
    }
    
    public void devolver() {
        if (!disponible) {
            disponible = true;
            System.out.println("El libro '" + titulo + "' ha sido devuelto.");
        } else {
            System.out.println("El libro '" + titulo + "' ya estaba disponible.");
        }
    }
    
    // MÉTODO toString() - Para mostrar la información del objeto de forma legible
    @Override
    public String toString() {
        String estado = disponible ? "Disponible" : "Prestado";
        return "📚 " + titulo + " - " + autor + " (" + añoPublicacion + ") [" + estado + "]";
    }
    
    // MÉTODO para obtener información completa
    public void mostrarInfo() {
        System.out.println("=== INFORMACIÓN DEL LIBRO ===");
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Año: " + añoPublicacion);
        System.out.println("Estado: " + (disponible ? "Disponible" : "Prestado"));
        System.out.println("===============================");
    }
}