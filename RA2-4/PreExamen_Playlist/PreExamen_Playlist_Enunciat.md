# 🎵 PLAYLIST - Gestor de Cançons

**Temps:** 90 minuts  
**Dificultat:** ★★★☆☆

---

## Descripció del programa

Has de crear un gestor de llistes de reproducció musical que permeti gestionar fins a **100 cançons**.

Cada cançó té 3 dades:
- **Títol** (String)
- **Artista** (String)
- **Durada** en format "mm:ss" (String), exemple: "03:45"

Els usuaris poden:
- Afegir cançons a la playlist
- Buscar una cançó pel títol
- Veure totes les cançons
- Eliminar una cançó
- Veure la durada total de la playlist

---

## Representació de les dades

Utilitza un **array bidimensional de Strings** `String[100][3]` on:
- Columna 0 = títol
- Columna 1 = artista
- Columna 2 = durada

També necessites una variable **`int numCançons`** per saber quantes cançons hi ha.

---

## Funcionament del programa

### Menú principal
```
=============================
   PLAYLIST MANAGER
=============================
1. Afegir cançó
2. Buscar cançó
3. Llistar totes les cançons
4. Eliminar cançó
5. Mostrar durada total
0. Sortir
=============================
```

### Opció 1: Afegir cançó
Demana títol, artista i durada. Afegeix la cançó si no hi ha errors.

**Exemple d'ús correcte:**
```
Títol: Imagine
Artista: John Lennon
Durada (mm:ss): 03:03
Cançó afegida correctament!
```

**Casos d'error a detectar:**
- No hi ha espai (ja hi ha 100 cançons)
- Ja existeix una cançó amb aquest títol (no permetre duplicats)
- La durada no té el format correcte "mm:ss"
  - ✓ Correcte: "03:45", "12:30", "00:59"
  - ✗ Incorrecte: "3:45", "03-45", "3:4", "345"

### Opció 2: Buscar cançó
Demana un títol i mostra les dades de la cançó si existeix.

**Exemple trobada:**
```
Títol: Imagine
-----------------------------
Cançó trobada!
Títol: Imagine
Artista: John Lennon
Durada: 03:03
```

**Exemple no trobada:**
```
Títol: Yesterday
-----------------------------
Cançó no trobada
```

### Opció 3: Llistar totes les cançons
Mostra totes les cançons de la playlist numerades.

**Exemple amb 3 cançons:**
```
=============================
PLAYLIST COMPLETA
=============================
Total: 3 cançons

1. Imagine - John Lennon (03:03)
2. Bohemian Rhapsody - Queen (05:55)
3. Let It Be - The Beatles (04:03)
=============================
```

**Exemple sense cançons:**
```
La playlist està buida
```

### Opció 4: Eliminar cançó
Demana un títol i elimina la cançó si existeix.

**Mètode d'eliminació:**
Quan elimines la cançó de la posició `i`:
1. Copia l'última cançó (posició `numCançons - 1`) a la posició `i`
2. Resta 1 a `numCançons`

**Exemple correcte:**
```
Títol: Imagine
Cançó eliminada correctament!
```

**Exemple error:**
```
Títol: Yesterday
ERROR: No existeix cap cançó amb aquest títol
```

### Opció 5: Mostrar durada total
Suma les durades de totes les cançons i mostra el resultat.

**Exemple:**
```
Total de cançons: 3
Durada total: 13:01
```

**Càlcul:**
1. Convertir cada durada "mm:ss" a segons totals
   - Exemple: "03:45" = 3×60 + 45 = 225 segons
2. Sumar tots els segons
3. Convertir el resultat a format "mm:ss"
   - Exemple: 781 segons = 13 minuts i 1 segon = "13:01"

**Pista per formatar amb zeros:** `String.format("%02d:%02d", minuts, segons)`

---

## Requisits tècnics

1. **Validacions obligatòries:**
   - No permetre títols duplicats
   - Validar format de durada "mm:ss" (longitud 5, caràcter central ':')
   - Comprovar que tots els caràcters excepte ':' siguin dígits

2. **Gestió del comptador:**
   - Incrementar `numCançons` després d'afegir
   - Decrementar `numCançons` després d'eliminar

3. **Conversions de durada:**
   - String "mm:ss" → int segons
   - int segons → String "mm:ss"

4. **Bucle de menú:**
   - El menú es repeteix fins que l'usuari esculli l'opció 0

---

## Criteris d'avaluació

- **40%** - Afegir i llistar correctament
- **20%** - Buscar i eliminar correctament
- **20%** - Validacions (format durada, duplicats)
- **10%** - Càlcul de durada total
- **10%** - Organització i claredat del codi

---

**Bona sort! 🍀**
