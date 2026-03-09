# 📚 Sistema de Biblioteca - Ejemplo de Programación Orientada a Objetos

## 🎯 Objetivo
Este proyecto es un ejemplo simple y completo de **Programación Orientada a Objetos (POO)** en Java, diseñado para entender los conceptos fundamentales de manera práctica.

## 🏗️ Estructura del Proyecto
```
Practicing/
├── Libro.java                 # Clase que representa un libro
├── Biblioteca.java            # Clase que gestiona una colección de libros  
├── SistemaBibliotecaMain.java # Programa principal con demostraciones
└── README.md                  # Este archivo
```

## 🔑 Conceptos de POO Demostrados

### 1. **CLASE** 📋
Una clase es una "plantilla" o "molde" para crear objetos.
```java
public class Libro {  // Esta es una CLASE
    // Definición de atributos y métodos
}
```

### 2. **OBJETO** 🎯
Un objeto es una "instancia" de una clase, es decir, una entidad específica creada a partir de la plantilla.
```java
Libro miLibro = new Libro("1984", "George Orwell", 1949);  // Esto es un OBJETO
```

### 3. **ATRIBUTOS** 📝
Son las características o propiedades que tiene un objeto.
```java
private String titulo;        // ATRIBUTO
private String autor;         // ATRIBUTO  
private int añoPublicacion;   // ATRIBUTO
private boolean disponible;   // ATRIBUTO
```

### 4. **MÉTODOS** ⚙️
Son las acciones o comportamientos que puede realizar un objeto.
```java
public void prestar() {       // MÉTODO
    // Lógica para prestar el libro
}

public String getTitulo() {   // MÉTODO
    return titulo;
}
```

### 5. **CONSTRUCTOR** 🏗️
Es un método especial que se ejecuta cuando se crea un objeto nuevo.
```java
public Libro(String titulo, String autor, int año) {  // CONSTRUCTOR
    this.titulo = titulo;
    this.autor = autor;
    this.añoPublicacion = año;
    this.disponible = true;
}
```

### 6. **ENCAPSULACIÓN** 🔒
Consiste en ocultar los detalles internos del objeto y controlar el acceso a través de métodos.
```java
private String titulo;        // PRIVADO - no se puede acceder directamente

public String getTitulo() {   // PÚBLICO - forma controlada de acceder
    return titulo;
}

public void setTitulo(String titulo) {  // PÚBLICO - forma controlada de modificar
    this.titulo = titulo;
}
```

### 7. **COMPOSICIÓN** 🧩
Una clase que contiene objetos de otra clase.
```java
public class Biblioteca {
    private List<Libro> libros;  // Biblioteca "tiene" libros (composición)
}
```

## 🚀 Cómo Ejecutar el Proyecto

### Opción 1: Desde VS Code
1. Abre el archivo `SistemaBibliotecaMain.java`
2. Haz clic en "Run" (▶️) o presiona `F5`

### Opción 2: Desde Terminal
```bash
# Navegar a la carpeta del proyecto
cd "c:\Users\Daniel\Documents\SALLE_CODE\Practicing"

# Compilar las clases
javac *.java

# Ejecutar el programa principal
java SistemaBibliotecaMain
```

## 📖 Flujo del Programa

El programa principal (`SistemaBibliotecaMain.java`) demuestra paso a paso:

1. **Creación de objetos** - Instanciación de biblioteca y libros
2. **Agregación de libros** - Uso de métodos para añadir libros
3. **Visualización** - Mostrar información usando métodos
4. **Operaciones** - Prestar y devolver libros
5. **Búsquedas** - Encontrar libros por título o autor
6. **Encapsulación** - Acceso controlado a los datos

## 💡 Conceptos Clave para Recordar

### ¿Por qué usar POO?
- **Organización**: El código está mejor estructurado
- **Reutilización**: Las clases se pueden usar en múltiples proyectos
- **Mantenimiento**: Es más fácil modificar y corregir errores
- **Escalabilidad**: Se pueden agregar nuevas funcionalidades fácilmente

### Diferencia entre Clase y Objeto
- **Clase**: Es como un "molde para galletas" 🍪
- **Objeto**: Es como cada "galleta individual" que sale del molde 🍪

### ¿Qué significa "this"?
- `this` se refiere al objeto actual
- Se usa para distinguir entre parámetros y atributos del objeto

## 🎓 Ejercicios para Practicar

1. **Fácil**: Agrega un atributo `isbn` a la clase Libro
2. **Intermedio**: Crea una clase `Usuario` que pueda tomar libros prestados
3. **Avanzado**: Implementa un sistema de fechas para controlar cuándo vence un préstamo

## 📚 Próximos Conceptos a Aprender

Una vez que domines estos conceptos básicos, puedes avanzar a:
- **Herencia** - Una clase que hereda de otra
- **Polimorfismo** - Un mismo método que se comporta diferente
- **Interfaces** - Contratos que deben cumplir las clases
- **Clases abstractas** - Clases que no se pueden instanciar

## 🤝 ¿Necesitas Ayuda?

Si tienes dudas sobre algún concepto:
1. Revisa los comentarios en el código
2. Ejecuta el programa paso a paso
3. Experimenta modificando los valores
4. ¡Pregunta lo que necesites!

---
*Este proyecto está diseñado como material educativo para aprender POO de forma práctica y divertida* 🎉