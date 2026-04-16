# Objectiu

L'objectiu d'aquest projecte es implementar un reproductor de musica per consola en Java.
L'aplicacio gestiona una playlist que pot contenir tres tipus de contingut: Cançons, Podcasts i Audiollibres. L'usuari pot afegir contingut, llistar la playlist, reproduir-la sencera i veure estadistiques.
El projecte demostra l'us de classes abstractes (no pots crear un "contingut generic"), polimorfisme (tots els continguts es tracten igual a la playlist) i l'estructura MVC amb packages separats.

# Preguntes Clau

1. Pregunta 1: Quins atributs comparteixen una Canço, un Podcast i un Audiollibre? Quins son exclusius de cadascun?
- Els tres comparteixen: titol [String], autor [String], duration (segons)[double].

- Canço:
    - Album [String], 
    - Gènere [String]

- Podcast:
    - Tema [String]
    - Resum [String] (Descripció)
    - Idioma [String]

- Audiollibre:
    - Rating [int]
    - Gènere Principal [String]
    - Idioma [String]
    - Narrador [String]

2. Pregunta 2: Te sentit crear un objecte "Contingut" generic? Es a dir, fer new Contingut(...)? O nomes existeixen cançons, podcasts i audiollibres concrets?
- Per [Contingut], ho faré abstracte i no generic.

3. Pregunta 3: El metode reproduir(): pots escriure un cos al pare que serveixi per a tots? O cada tipus es reprodueix de forma diferent?
- El metode [reproduir()] será abstracte ja que faré que cada tipus de contingut tingui també la seva "interficie" amb els valors mostrats, això és més fàcil fer-ho si el métode es abstracte (cada fill ho ha de implementar-ho)

4. Pregunta 4: El metode getDuracioFormatejada(): funciona IGUAL per a tots (convertir segons a mm:ss) o cada tipus ho fa diferent?
- Ja que tots tres comparten "Duració", i tots són el mateix tipus d'arxiu, el convertidor funcionará igual per a tots.

5. Pregunta 5: Vols poder posar Cançons, Podcasts i Audiollibres a la mateixa llista (ArrayList). De quin tipus ha de ser l'ArrayList?
- De tipus <Contingut> ja que els tres tipus són continguts.