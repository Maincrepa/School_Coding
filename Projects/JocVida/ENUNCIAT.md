# 🧬 JOC DE LA VIDA - Cèl·lules de Conway

## Descripció

Desenvoluparàs una simulació del famós "Joc de la Vida" de John Conway.

És un autòmat cel·lular on les cèl·lules viuen o moren segons regles simples:

**Regles:**
1. Una cèl·lula **viva** amb 2 o 3 veïns **sobreviu**
2. Una cèl·lula **viva** amb menys de 2 veïns **mor** (soledat)
3. Una cèl·lula **viva** amb més de 3 veïns **mor** (superpoblació)
4. Una cèl·lula **morta** amb exactament 3 veïns **neix**

---


# Nivell 3: Mostrar tauler

## Objectiu

Crea la funció `mostrarTauler()` que mostra el tauler per pantalla.

## Exemple

```
=============================
GENERACIÓ: 5
=============================
. . . . . . . . . .
. . ■ . . . . . . .
. . . ■ . . . . . .
. ■ ■ ■ . . . . . .
. . . . . . . . . .
. . . . . . . . . .
. . . . . . . . . .
. . . . . . . . . .
. . . . . . . . . .
. . . . . . . . . .
=============================
Cèl·lules vives: 5
=============================
```

## Tasca 3.1: Capçalera

```java
public static _______ mostrarTauler(_______, _______) {
```

💡 Pensa: Necessita el tauler i el número de generació.

## Tasca 3.2: Funció auxiliar cellulaACaracter

```java
public static char cellulaACaracter(int valor) {
    // 0 -> '.'
    // 1 -> '■' (o '*' si no funciona)
}
```

---

# Nivell 4: Crear tauler aleatori

## Objectiu

Crea la funció `crearTaulerAleatori()` que omple el tauler amb cèl·lules aleatòries.

## Tasca

```java
public static void crearTaulerAleatori(int[][] tauler) {
    // Per cada posició:
    // 30% de probabilitat de cèl·lula viva
    
}
```

---

# Nivell 5: Posar i treure cèl·lules

## Objectiu

Crea funcions per modificar el tauler manualment.

## Exemple

```
=============================
POSAR CÈL·LULA
=============================
Fila (0-9): 3
Columna (0-9): 5
Cèl·lula posada a [3, 5]
=============================
```

## Tasques

```java
public static _______ posarCellula(_______, _______, _______) {
    // Posa un 1 a la posició indicada
}

public static _______ treureCellula(_______, _______, _______) {
    // Posa un 0 a la posició indicada
}

public static _______ posicioValida(_______, _______, _______) {
    // Comprova si la fila i columna estan dins dels límits
}
```

---

# Nivell 6: Comptar veïns

## Objectiu

Crea la funció `comptarVeins()` que compta les cèl·lules vives al voltant d'una posició.

## Exemple

```
Veïns de la posició [1,1]:
  [0,0] [0,1] [0,2]
  [1,0] [X X] [1,2]
  [2,0] [2,1] [2,2]
```

Una cèl·lula té 8 veïns (excepte a les vores).

## Tasca

```java
public static _______ comptarVeins(_______, _______, _______) {
    // Comprova les 8 posicions del voltant
    // Suma 1 per cada veí viu
    // COMPTE: no surtis dels límits de l'array!
}
```

💡 Pista: Usa bucles de -1 a +1 per recórrer les posicions veïnes.

---

# Nivell 7: Avançar generació

## Objectiu

Crea la funció `avancarGeneracio()` que aplica les regles i crea la següent generació.

## Regles recordatori

| Estat actual  | Veïns | Nou estat |
|-------------- |-------|-----------|
| Viva          | < 2   | Mor       |
| Viva          | 2-3   | Sobreviu  |
| Viva          | > 3   | Mor       |
| Morta         | = 3   | Neix      |
| Morta         | ≠ 3   | Segueix morta |

## Tasca

```java
public static _______ avancarGeneracio(_______) {
    // 1. Crea un tauler temporal per guardar el nou estat
    
    // 2. Per cada cèl·lula:
    //    - Compta els veïns
    //    - Aplica les regles
    //    - Guarda el nou estat al tauler temporal
    
    // 3. Copia el tauler temporal al tauler original
}
```

⚠️ IMPORTANT: No modifiquis el tauler mentre el recorres! Usa un tauler temporal.

---



---

Bona sort! 🍀
