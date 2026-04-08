# Client
Un gimnàs del teu barri vol deixar d'apuntar els rànkings d'esportistes en una pissarra. Cada
setmana s'esborren i es perden les dades. Et contracten per crear una aplicació de consola que
permeti gestionar els seus esportistes i les seves marques.

## El que ens diu el client
"Necessitem poder apuntar els esportistes amb les seves marques, veure qui va primer, treure gent
que ja no ve, i tenir alguna estadística per motivar-los. La resta la deixo a les teves mans, tu ets
l'informàtic."

# Requisits mínims
L'aplicació ha de permetre, com a mínim:
· Registrar esportistes amb les seves dades
· Consultar el rànking ordenat per marca
· Eliminar esportistes que ja no venen al gimnàs
· Veure alguna mena d'estadística de les dades registrades
· Un menú interactiu per consola
Més enllà d'això, tens llibertat total. Quantes més funcionalitats útils i ben implementades, millor.

# Decisions
## 3.1 Dades
### 1. Q: Quines dades guardaràs de cada esportista? Nom i marca són el mínim, però... disciplina? edat? data de registre? Gènere? Pensa què necessita un gimnàs real.

- Nom Identificador (curt) [nomIdentificador]
- Nom complet (de mostra) [NomMostra]
- Disciplina o tipus d'exercici (per poder filtrar per categoria) [Disciplina]
- Array de Resultats de les proves (per veure progrés) [ResultatsArray]
- Edat (important per estadístiques i comparacions entre grups) [Edat]
- Data de registre o data de la marca (per saber quan es va obtenir la millor marca) [dataIntroduccio]


### 2. Q: Hi haurà un límit màxim d'esportistes? Si sí, quin i per què? Si no, com ho gestionaràs?
Inicialment, volia posar un limit amb una constant `MAX_ESPORTISTES`, però ja que he decidit fer servir un ArrayList, no veig necessitat de posar un máxim.

## 3.2 Text
### 1. Q: Faràs servir arrays, ArrayList, o una combinació dels dos?
Faré servir `ArrayList` per gestionar els esportistes.

## 3.3 Funcionalitats
### 1. Q: Quines opcions tindrà el teu menú? Els 4 requisits mínims i què més?
1. Registrar esportista
2. Consultar rànquing
3. Eliminar esportista
4. Veure estadístiques
5. Buscar esportistes per nom o per disciplina,
6. Modificar la marca d'un esportista existent,
7. Mostrar el rànquing per disciplina específica.

0. Sortir de l'aplicació


### 2. Q: Com ordenaràs el rànquing? Quin algorisme? Si tens múltiples arrays/llistes, com els sincronitzaràs?
Ordenaré el rànquing segons la marca de cada esportista, de la millor a la pitjor. En un `ArrayList<Esportista>`..

### 3. Q: Quines estadístiques tenen sentit per a un gimnàs? Millor marca? Mitjana? Per disciplina?
Les estadístiques que tenen sentit són:
- Millor marca general
- Pitjor marca
- Marca mitjana del rànquing
- Nombre d'esportistes per disciplina
- Nombre d'esportistes actius
- Edat mitjana

### 4. Q: Com validaràs l'entrada de l'usuari? Què passa si escriu un nom buit o una marca negativa?
Validaré cada entrada amb condicions explícites:
- El nom no pot estar buit ni ser només espais,
- La disciplina no pot estar buida,
- La marca ha de ser un nombre positiu,
- L'edat ha de ser un nombre positiu i raonable.

Si l'usuari introdueix dades incorrectes, mostraré un missatge d'error i li demanaré que torni a entrar el valor correcte abans de continuar.

# Reflexió Obligatoria
## 1. Per què has triat arrays / ArrayList / combinació? Argumenta amb exemples concrets del teu codi.
He triat `ArrayList` perquè gestiona automàticament la mida i facilita les operacions d'afegir i eliminar esportistes.

Per exemple, en el mètode `registrar(Esportista u)` afegeixo directament l'objecte amb `EsportistesArray.add(u)` i no cal crear un array nou ni moure tots els elements.

Si hagués utilitzat un `Esportista[]`, hauria hagut de controlar un número màxim manual i desplaçar tots els elements cada vegada que eliminava algú.

## 2. En quin mètode o funcionalitat la teva elecció t'ha facilitat més la vida? Per què?
La funcionalitat de `eliminar esportista` em va facilitar molt amb `ArrayList`, perquè només cal cridar `remove(index)` o `remove(object)` i la llista reordena els elements sola.

Amb un array fix, hauria hagut de copiar manualment cada element següent per omplir el buit, cosa que és més lenta i més propensa a errors d'índex.

## 3. Hi ha alguna part del codi on t'hauria anat millor amb l'altra estructura? Quina i per què?
Si el projecte fos una aplicació molt petita amb un nombre d'esportistes totalment fix i sense eliminacions, un array podria haver estat suficient i una mica més eficient en memòria.

Però en aquesta aplicació, on els esportistes entren i surten cada setmana, `ArrayList` és la millor opció perquè aporta més flexibilitat.

## 4. Si haguessis de refactoritzar tot el programa amb l'estructura contrària, quin mètode seria el més difícil de canviar? Per què?
El mètode més difícil de refactoritzar seria l'eliminació d'un esportista, perquè amb un array caldria desplaçar tots els elements següents i mantenir un comptador de posicions.

També seria més complicat ordenar el rànquing, ja que hauria de programar un algorisme de classificació manual en lloc d'utilitzar `Collections.sort`.

## 5. Quina estructura recomanaries a un company que comença aquest exercici des de zero? Per què?
Li recomanaria `ArrayList` perquè simplifica molt la gestió dels esportistes.

Amb `ArrayList` és més fàcil afegir, eliminar, ordenar i recórrer els elements, i no cal preocupar-se de la capacitat de l'array ni de fer còpies manuals.