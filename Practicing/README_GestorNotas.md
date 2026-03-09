# Gestor de Notes d'Estudiant

## 📚 Què és aquest projecte?

Aquest és un programa Java que t'ajuda a gestionar les notes d'un estudiant. És perfecte per aprendre conceptes nous de programació!

## 🎯 Què aprendràs?

### 1. **Arrays (Matrius)**
- Com guardar múltiples dades del mateix tipus
- Accedir a elements específics d'un array
- Recórrer arrays amb bucles

### 2. **Mètodes (Funcions)**
- Dividir el codi en parts més petites i organitzades
- Reutilitzar codi
- Pasar dades entre mètodes

### 3. **Validació de dades**
- Comprovar que les dades introduïdes són correctes
- Gestionar errors de forma bàsica

## 🚀 Com executar el programa?

1. Compila el programa:
```bash
javac GestorNotas.java
```

2. Executa el programa:
```bash
java GestorNotas
```

## 🎮 Com usar el programa?

El programa té un menú amb 6 opcions:

1. **Introduir notes**: Pots introduir fins a 10 notes d'assignatures
2. **Mostrar notes**: Veure totes les notes introduïdes
3. **Calcular mitjana**: Calcular la nota mitjana i veure si ha aprovat
4. **Notes extremes**: Trobar la nota més alta i més baixa
5. **Comptar aprovats**: Veure quantes assignatures estan aprovades
6. **Sortir**: Tancar el programa

## 🔧 Conceptes nous utilitzats:

### Arrays:
```java
double[] notes = new double[10];  // Array per 10 notes
notes[0] = 8.5;                   // Assignar valor
double nota = notes[0];           // Llegir valor
```

### Mètodes:
```java
public static void mostrarMenu() {
    // Codi del mètode
}
```

### Bucles amb arrays:
```java
for (int i = 0; i < notes.length; i++) {
    System.out.println(notes[i]);
}
```

## 💡 Exercicis per practicar:

1. **Fàcil**: Afegeix una opció per esborrar totes les notes
2. **Mitjà**: Permet modificar una nota específica
3. **Difícil**: Afegeix noms d'assignatures (necessitaràs un array de String)

## 🔍 Per què aquest projecte?

Aquest projecte està dissenyat específicament per al teu nivell perquè:

- ✅ Usa conceptes que ja coneixes (bucles, conditionals, Scanner)
- ✅ Introdueix conceptes nous de forma gradual (arrays, mètodes)
- ✅ És pràctic i útil
- ✅ Té una estructura clara i organitzada

## 📈 Següent pas:

Després de dominar aquest projecte, estaràs preparat per aprendre:
- Classes i objectes (POO)
- Collections (ArrayList, HashMap)
- Herència i polimorfisme

¡Bon aprenentatge! 🎓