/**
 * PROGRAMA PRINCIPAL - Demostración de Programación Orientada a Objetos
 * 
 * Este programa muestra los conceptos básicos de OOP:
 * 1. CREACIÓN DE OBJETOS (instanciación)
 * 2. USO DE MÉTODOS (comportamiento de los objetos)
 * 3. INTERACCIÓN ENTRE OBJETOS
 * 4. ENCAPSULACIÓN (acceso a datos mediante métodos)
 */
public class SistemaBibliotecaMain {
    
    public static void main(String[] args) {
        
        // ==================== DEMOSTRACIÓN PASO A PASO ====================
        
        System.out.println("🚀 BIENVENIDO AL SISTEMA DE BIBLIOTECA");
        System.out.println("=" + "=".repeat(50));
        System.out.println("Este programa demuestra conceptos básicos de POO\n");
        
        // PASO 1: CREAR OBJETOS (Instanciación)
        System.out.println("📝 PASO 1: Creando objetos...");
        
        // Crear una biblioteca
        Biblioteca miBiblioteca = new Biblioteca("Biblioteca Central La Salle");
        
        // Crear libros individuales
        Libro libro1 = new Libro("El Quijote", "Miguel de Cervantes", 1605);
        Libro libro2 = new Libro("1984", "George Orwell", 1949);
        Libro libro3 = new Libro("El Hobbit", "J.R.R. Tolkien", 1937);
        
        esperarTecla();
        
        // PASO 2: USAR MÉTODOS DE LOS OBJETOS
        System.out.println("\n📝 PASO 2: Agregando libros a la biblioteca...");
        
        // Agregar libros usando el objeto libro
        miBiblioteca.agregarLibro(libro1);
        miBiblioteca.agregarLibro(libro2);
        miBiblioteca.agregarLibro(libro3);
        
        // Agregar libros directamente con datos
        miBiblioteca.agregarLibro("Cien años de soledad", "Gabriel García Márquez", 1967);
        miBiblioteca.agregarLibro("El Principito", "Antoine de Saint-Exupéry", 1943);
        
        esperarTecla();
        
        // PASO 3: MOSTRAR INFORMACIÓN (usando métodos)
        System.out.println("\n📝 PASO 3: Mostrando información...");
        miBiblioteca.mostrarTodosLosLibros();
        miBiblioteca.mostrarEstadisticas();
        
        esperarTecla();
        
        // PASO 4: DEMOSTRAR COMPORTAMIENTO DE OBJETOS
        System.out.println("📝 PASO 4: Prestando libros...");
        
        miBiblioteca.prestarLibro("1984");
        miBiblioteca.prestarLibro("El Hobbit");
        miBiblioteca.prestarLibro("Libro Inexistente");  // Caso de error
        
        System.out.println("\n🔍 Estado después de los préstamos:");
        miBiblioteca.mostrarLibrosDisponibles();
        miBiblioteca.mostrarEstadisticas();
        
        esperarTecla();
        
        // PASO 5: MÁS INTERACCIONES
        System.out.println("📝 PASO 5: Devolviendo un libro...");
        
        miBiblioteca.devolverLibro("1984");
        
        System.out.println("\n🔍 Estado después de la devolución:");
        miBiblioteca.mostrarLibrosDisponibles();
        
        esperarTecla();
        
        // PASO 6: DEMOSTRAR BÚSQUEDAS
        System.out.println("📝 PASO 6: Demostrando búsquedas...");
        
        // Buscar por título
        System.out.println("\n🔍 Buscando 'El Quijote':");
        Libro libroEncontrado = miBiblioteca.buscarPorTitulo("El Quijote");
        if (libroEncontrado != null) {
            libroEncontrado.mostrarInfo();
        }
        
        // Buscar por autor
        System.out.println("\n🔍 Buscando libros de 'J.R.R. Tolkien':");
        var librosDeAutor = miBiblioteca.buscarPorAutor("J.R.R. Tolkien");
        for (Libro libro : librosDeAutor) {
            System.out.println("  - " + libro);
        }
        
        esperarTecla();
        
        // PASO 7: DEMOSTRAR ENCAPSULACIÓN
        System.out.println("📝 PASO 7: Demostrando encapsulación...");
        
        System.out.println("\n🔒 Accediendo a datos mediante métodos (encapsulación):");
        System.out.println("Título del libro1: " + libro1.getTitulo());
        System.out.println("Autor del libro1: " + libro1.getAutor());
        System.out.println("Año del libro1: " + libro1.getAñoPublicacion());
        System.out.println("¿Está disponible? " + libro1.isDisponible());
        
        // Modificar datos usando setters
        System.out.println("\n✏️ Modificando el título usando setter:");
        System.out.println("Título anterior: " + libro1.getTitulo());
        libro1.setTitulo("Don Quijote de la Mancha");
        System.out.println("Título nuevo: " + libro1.getTitulo());
        
        esperarTecla();
        
        // RESUMEN FINAL
        System.out.println("\n🎯 RESUMEN DE CONCEPTOS DEMOSTRADOS:");
        System.out.println("=" + "=".repeat(50));
        System.out.println("✅ CLASES: Libro, Biblioteca (plantillas para objetos)");
        System.out.println("✅ OBJETOS: libro1, libro2, miBiblioteca (instancias de clases)");
        System.out.println("✅ ATRIBUTOS: titulo, autor, añoPublicacion, disponible");
        System.out.println("✅ MÉTODOS: prestar(), devolver(), agregarLibro(), buscarPorTitulo()");
        System.out.println("✅ CONSTRUCTOR: Libro(titulo, autor, año)");
        System.out.println("✅ ENCAPSULACIÓN: atributos privados + getters/setters");
        System.out.println("✅ COMPOSICIÓN: Biblioteca contiene múltiples Libros");
        System.out.println("=" + "=".repeat(50));
        
        System.out.println("\n🎉 ¡Felicidades! Has visto un ejemplo completo de POO");
        
        // Estado final
        miBiblioteca.mostrarEstadisticas();
    }
    
    /**
     * Método auxiliar para pausar la ejecución
     */
    private static void esperarTecla() {
        System.out.println("\n⏸️  Presiona Enter para continuar...");
        try {
            System.in.read();
        } catch (Exception e) {
            // Ignorar errores de entrada
        }
    }
}