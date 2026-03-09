# 🧩 LABERINT - Joc d'Exploració

**Temps:** 120 minuts  
**Dificultat:** ★★★★☆

---

## Descripció del programa

Has de crear un joc de laberint on un personatge es mou per un mapa de **10×10 caselles** intentant arribar a la sortida abans d'esgotar els 30 moviments permesos. Pel camí pot recollir monedes.

El mapa conté:
- **Personatge (P)**: controles amb W/A/S/D
- **Sortida (E)**: objectiu a assolir
- **Monedes (C)**: es recullen automàticament en trepitjar-les
- **Parets (#)**: no es poden travessar
- **Caselles buides (.)**: es poden travessar

---

## Representació de les dades

Utilitza un **array bidimensional de caràcters** `char[10][10]` on cada caràcter representa:
- `'.'` = casella buida
- `'#'` = paret
- `'C'` = moneda
- `'P'` = personatge
- `'E'` = sortida

**Variables addicionals necessàries:**
- Posició del personatge: `int px, py`
- Posició de la sortida: `int ex, ey`
- Monedes recollides: `int monedes`
- Moviments realitzats: `int moviments`

**Constants recomanades:**
- 20 parets
- 10 monedes
- 30 moviments màxim

---

## Funcionament del programa

### 1. Inicialització del mapa (aleatòria)

Al començar el programa:
1. Omple tot el mapa amb caselles buides ('.')
2. Col·loca 20 parets (#) en posicions aleatòries
3. Col·loca 10 monedes (C) en posicions aleatòries
4. Col·loca el personatge (P) en una posició aleatòria buida
5. Col·loca la sortida (E) en una posició aleatòria buida (diferent del personatge)

**Important:** Genera números aleatoris amb `(int)(Math.random() * 10)` per obtenir valors 0-9.

### 2. Visualització del mapa

Cada torn, mostra el mapa amb aquest format:
```
=============================
. . . # . . C . . .
. # . # . . . . # .
. # . . . # . . # C
. . . # . # . . . .
C . . . . . # . . E
. # # . . . # . . .
. . . . # . . . # .
# . P . # . C . . .
. . . . . . . . # .
. C . # . . . . . .
=============================
Monedes: 3
Moviments restants: 22
=============================
```

### 3. Controls del personatge

Cada torn demana una acció:
```
Acció (W/A/S/D, Q per sortir):
```

**Moviments:**
- **W** = amunt (fila - 1)
- **S** = avall (fila + 1)
- **A** = esquerra (columna - 1)
- **D** = dreta (columna + 1)
- **Q** = abandonar partida

### 4. Mecànica de moviment

Quan l'usuari intenta moure's:

1. **Calcular nova posició** segons la direcció escollida

2. **Validar moviment:**
   - Si la nova posició està fora del mapa (límits 0-9): ERROR, no et mous
   - Si hi ha una paret (#): ERROR, no et mous
   - Si tot és correcte: mou el personatge

3. **Si el moviment és vàlid:**
   - Si hi havia una moneda (C) a la nova posició: incrementa el comptador de monedes
   - Esborra el personatge de la posició antiga (posa '.')
   - Col·loca el personatge a la nova posició (posa 'P')
   - Incrementa el comptador de moviments
   - **IMPORTANT:** Assegura't que la sortida (E) segueixi visible si el personatge no hi és

4. **Comprovar victòria:**
   - Si el personatge està a la mateixa posició que la sortida → HAS GUANYAT

### 5. Condicions de final

El joc acaba quan:
- **VICTÒRIA**: El personatge arriba a la sortida
- **DERROTA**: S'esgoten els 30 moviments
- **ABANDONAMENT**: L'usuari prem Q

Mostra el mapa final i el resultat:
```
VICTÒRIA! Has arribat a la sortida.
Monedes aconseguides: 7
Moviments utilitzats: 18
```

o

```
DERROTA! Has esgotat els moviments.
Monedes aconseguides: 4
Moviments utilitzats: 30
```

---

## Requisits tècnics

1. **Col·locació aleatòria d'elements:**
   - Genera coordenades aleatòries
   - Comprova que la casella estigui buida abans de col·locar-hi res
   - Repeteix fins trobar una casella vàlida

2. **Gestió de posicions:**
   - El personatge i la sortida tenen les seves coordenades guardades en variables separades
   - Quan col·loques el personatge o la sortida, has d'actualitzar aquestes variables

3. **Moviments vàlids:**
   - Només compta com a moviment si és una tecla vàlida (W/A/S/D)
   - Els errors (fora límits, paret) NO compten com a moviment

4. **Preservar la sortida:**
   - Quan el personatge es mou, la sortida pot quedar tapada
   - Assegura't que si el personatge no està a la sortida, aquesta segueixi visible amb 'E'

---

## Criteris d'avaluació

- **30%** - Inicialització correcta del mapa amb elements aleatoris
- **30%** - Moviment del personatge amb validacions
- **20%** - Recollida de monedes i detecció de victòria/derrota
- **10%** - Visualització clara del mapa
- **10%** - Organització i claredat del codi

---

**Bona sort! 🍀**
