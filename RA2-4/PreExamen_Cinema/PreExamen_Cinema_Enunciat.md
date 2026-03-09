# 🎬 CINEMA - Gestor de Reserves de Butaques

**Temps:** 90 minuts  
**Dificultat:** ★★☆☆☆

---

## Descripció del programa

Has de crear un sistema de gestió de reserves per a una sala de cinema amb **8 files** i **10 seients** per fila (total: 80 butaques).

Els usuaris poden:
- Veure l'estat de la sala
- Reservar una butaca (indicant fila 1-8 i seient A-J)
- Cancel·lar una reserva
- Veure quantes butaques queden lliures

---

## Representació de les dades

Utilitza un **array bidimensional de caràcters** `char[8][10]` on:
- `'L'` = butaca Lliure
- `'X'` = butaca ocupada (reservada)

Les files es numeren de **1 a 8** (de davant a darrere).  
Els seients es designen amb lletres de **A a J** (d'esquerra a dreta).

---

## Funcionament del programa

### Menú principal
```
=============================
   CINEMA LA SALLE
=============================
1. Mostrar sala
2. Reservar butaca
3. Cancel·lar reserva
4. Comptar butaques lliures
0. Sortir
=============================
```

### Opció 1: Mostrar sala
Mostra l'estat actual de totes les butaques en format visual:
```
=============================
   PANTALLA
=============================
     A B C D E F G H I J
  1  L L X L L L L X L L
  2  L X X L L L L L L L
  3  L L L L L L L L L L
  4  X X L L L L L X X L
  5  L L L L L L L L L L
  6  L L L X X X L L L L
  7  L L L L L L L L L L
  8  L L L L L L L L L L
=============================
```

### Opció 2: Reservar butaca
Demana fila i seient. Si la butaca està lliure i les dades són vàlides, la marca com a ocupada.

**Exemple d'ús correcte:**
```
Fila (1-8): 3
Seient (A-J): D
Butaca reservada: Fila 3, Seient D
```

**Casos d'error a detectar:**
- Fila fora del rang 1-8
- Seient fora del rang A-J
- Butaca ja ocupada

### Opció 3: Cancel·lar reserva
Demana fila i seient. Si la butaca està ocupada, la marca com a lliure.

**Casos d'error a detectar:**
- Fila o seient no vàlids
- Butaca que ja està lliure (no es pot cancel·lar)

### Opció 4: Comptar butaques lliures
Mostra les estadístiques de la sala:
```
Butaques lliures: 62 / 80
Butaques ocupades: 18 / 80
Percentatge d'ocupació: 22.5%
```

---

## Requisits tècnics

1. **Validacions obligatòries:**
   - La fila ha d'estar entre 1 i 8
   - El seient ha d'estar entre 'A' i 'J' (acceptar majúscules i minúscules)
   - Per reservar: comprovar que la butaca estigui lliure
   - Per cancel·lar: comprovar que la butaca estigui ocupada

2. **Conversió lletra ↔ índex:**
   - Seient 'A' = columna 0
   - Seient 'D' = columna 3
   - Seient 'J' = columna 9

3. **Inicialització:**
   - Al començar el programa, totes les butaques han d'estar lliures ('L')

4. **Bucle de menú:**
   - El menú es repeteix fins que l'usuari esculli l'opció 0 (sortir)

---

## Criteris d'avaluació

- **60%** - Totes les funcionalitats implementades correctament
- **20%** - Validacions i control d'errors
- **20%** - Organització del codi i claredat

---

**Bona sort! 🍀**
