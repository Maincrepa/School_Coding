public class Estudiante {
    // Atributos (propiedades) de la clase
    private String nombre;
    private int edad;
    private double notaMedia;
    private String carrera;
    
    // Constructor - método especial para crear objetos
    public Estudiante(String nombre, int edad, String carrera) {
        this.nombre = nombre;
        this.edad = edad;
        this.carrera = carrera;
        this.notaMedia = 0.0; // Valor inicial
    }
    
    // Constructor sobrecargado (con nota media)
    public Estudiante(String nombre, int edad, String carrera, double notaMedia) {
        this.nombre = nombre;
        this.edad = edad;
        this.carrera = carrera;
        this.notaMedia = notaMedia;
    }
    
    // Métodos getter (para obtener valores)
    public String getNombre() {
        return nombre;
    }
    
    public int getEdad() {
        return edad;
    }
    
    public double getNotaMedia() {
        return notaMedia;
    }
    
    public String getCarrera() {
        return carrera;
    }
    
    // Métodos setter (para cambiar valores)
    public void setNotaMedia(double notaMedia) {
        if (notaMedia >= 0 && notaMedia <= 10) {
            this.notaMedia = notaMedia;
        } else {
            System.out.println("Error: La nota debe estar entre 0 y 10");
        }
    }
    
    public void setEdad(int edad) {
        if (edad > 0) {
            this.edad = edad;
        } else {
            System.out.println("Error: La edad debe ser positiva");
        }
    }
    
    // Métodos de comportamiento
    public void estudiar() {
        System.out.println(nombre + " está estudiando " + carrera);
    }
    
    public void hacerExamen(double nota) {
        setNotaMedia(nota);
        System.out.println(nombre + " ha hecho un examen. Nota: " + nota);
    }
    
    public String getEstadoAcademico() {
        if (notaMedia >= 9.0) {
            return "Excelente";
        } else if (notaMedia >= 7.0) {
            return "Notable";
        } else if (notaMedia >= 5.0) {
            return "Aprobado";
        } else {
            return "Suspenso";
        }
    }
    
    public boolean esMayorDeEdad() {
        return edad >= 18;
    }
    
    // Método toString para mostrar información del estudiante
    @Override
    public String toString() {
        return String.format(
            "┌─────────────────────────────────────┐\n" +
            "│           FICHA ESTUDIANTE          │\n" +
            "├─────────────────────────────────────┤\n" +
            "│ Nombre: %-27s │\n" +
            "│ Edad: %-29d │\n" +
            "│ Carrera: %-26s │\n" +
            "│ Nota Media: %-21.2f │\n" +
            "│ Estado: %-27s │\n" +
            "│ Mayor de Edad: %-18s │\n" +
            "└─────────────────────────────────────┘",
            nombre, edad, carrera, notaMedia, getEstadoAcademico(), 
            esMayorDeEdad() ? "Sí" : "No"
        );
    }
}