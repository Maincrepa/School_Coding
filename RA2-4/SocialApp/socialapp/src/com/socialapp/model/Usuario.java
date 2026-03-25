package com.socialapp.model;

import java.util.ArrayList;

/*
Representa un usuari registrat a la xarxa. Te els seguents atributs privats: username,
contrasenya i email de tipus String. Tambe te un array de Strings anomenat posts per guardar
els textos publicats, i un array de Strings anomenat amics per guardar els usernames dels
seus amics. Declara les constants MAX_POSTS i MAX_AMICS amb valor 100 per limitar la
mida dels arrays.

Ha de tenir constructor, getters per a tots els atributs i toString(). Els metodes d'operacio son
els seguents:
- publicarPost(String text): afegeix el text a l'array posts.
- eliminarPost(int index): elimina el post de la posicio indicada.
- afegirAmic(String username): afegeix el username a l'array amics.
- eliminarAmic(String username): elimina el username de l'array amics.
*/

public class Usuario {
    // Atributs privats
    private String username;
    private String contrasenya;
    private String email;

    private ArrayList<String> amics;
    private ArrayList<String> posts;

    private int numAmics;
    private int numPosts;

    private static final int MAX_POSTS = 100;
    private static final int MAX_AMICS = 100;

    /*
    ==========================================
        CONSTRUCTOR
    ==========================================
    */

    public Usuario(String username, String contrasenya, String email) {
        if (!(validarUsername(username) && validarContrasenya(contrasenya) && validarEmail(email))) {
            // Si NO és correcte l'informació (alguna return false); info incorrecte, no podem seguir
            System.out.println("L'informació no és correcte.");
            return;
        }
        // L'informació és correcte, seguim.

        this.username = username;
        this.contrasenya = contrasenya;
        this.email = email;

        amics = new ArrayList<>();
        posts = new ArrayList<>();
    }

    /*
    ==========================================
        GETTERS
    ==========================================
    */

    public String getUsername() {
        return this.username;
    }

    public String getContrasenya() {
        return this.contrasenya;
    }

    public String getEmail() {
        return this.email;
    }

    public ArrayList<String> getAmics() {
        return this.amics;
    }

    public ArrayList<String> getPosts() {
        return this.posts;
    }

    public int getNumAmics() {
        return this.numAmics;
    }

    public int getNumPosts() {
        return this.numPosts;
    }

    /*
    ==========================================
        SETTERS
    ==========================================
    */

    public void setUsername(String username) {
        if (!validarUsername(username)) {
            // No s'ha pogut validar, informació incorrecta.
            return;
        }
        // Tota informació correcte, setting.
        this.username = username;
    }

    public void setContrasenya(String contrasenya) {
        if (!validarContrasenya(contrasenya)) {
            // No s'ha pogut validar, informació incorrecta.
            return;
        }
        // Tota informació correcte, setting.
        this.contrasenya = contrasenya;
    }

    public void setEmail(String email) {
        if (!validarEmail(email)) {
            // No s'ha pogut validar, informació incorrecta.
            return;
        }
        // Tota informació correcte, setting.
        this.email = email;
    }

    /*
    ==========================================
        POSTS
    ==========================================
    */

    public boolean publicarPost(String text) {
        if (numPosts >= MAX_POSTS) {
            // No es poden publicar més posts, s'ha arribat al màxim.
            System.out.println("No es poden publicar més posts.");
            return false;
        }

        this.posts.add(text); // Afegim el post a l'ArrayList de posts
        numPosts++;

        return true; // Publicat correctament.
    }

    public boolean eliminarPost(int index) {
        if (index < 0 || index >= numPosts) {
            // Index fora de rang
            System.out.println("Index fora de rang.");
            return false;
        }

        // Desplacem els posts cap -1 per omplir el buit
        posts.remove(index);
        numPosts--;

        return true; // Finalitzat; Post eliminat correctament.
    }



    /*
    ==========================================
        AMICS
    ==========================================
    */

    public boolean afegirAmic(String username) {
        if (numAmics >= MAX_AMICS) {
            System.out.println("No es poden afegir més amics. Has arribat al màxim.");
            return false;
        }
        if (username.equals(this.username)) {
            System.out.println("No et pots afegir com a amic.");
            return false;
        }
        for (int i = 0; i < numAmics; i++) {
            if (amics.get(i).equals(username)) {
                System.out.println("Aquest amic ja està afegit.");
                return false;
            }
        }
        // Afegim l'amic a l'array d'amics
        amics.add(username);
        numAmics++;
        return true; // Procés finalitzat correctament.
    }

    public boolean eliminarAmic(String username) {
        for (int i = 0; i < numAmics; i++) {
            if (amics.get(i).equals(username)) {
                // Desplacem cap -1 per omplir el buit
                for (int j = i; j < numAmics - 1; j++) {
                    amics.set(j, amics.get(j + 1));
                }
                amics.remove(numAmics - 1); // Eliminem l'últim duplicat
                numAmics--;
                return true; // Procés finalitzat correctament.
            }
        }

        System.out.println("No s'ha pogut eliminar l'amic. No existeix a l'array d'amics.");
        return false; // Procés finalitzat incorrectament.
    }

    /*
    ==========================================
        OTHER
    ==========================================
    */

    @Override
    public String toString() {
        // sense toString() s'obté l'adreça de memòria de l'objecte
        // sobreeescriu per utilitzar l'estructura meva en lloc del de Object

        return "Usuario{username = '" + this.username + "', email = " + this.email + "', posts: " + this.numPosts + ", amics: " + this.numAmics + "}";
    }

    /*
    ==========================================
        VALIDADORS
    ==========================================
    */

    private boolean validarUsername(String username) {
        if (username == null || username.isEmpty()) { 
            // El username és buit, retornar
            System.out.println("El username és buit");
            return false;
        }

        // Tot correcte, retornem true;
        return true;
    }

    private boolean validarEmail(String email) {
        if (email == null || email.isEmpty()) { // Es pot millorar comprovador, pero l'exercici no demana més
            // El email és buit, retornar
            System.out.println("El email está buit");
            return false;
        }

        // Tot correcte, retornem true;
        return true;
    }

    private boolean validarContrasenya(String contrasenya) {
        if (contrasenya == null || contrasenya.isEmpty()) { // Es pot millorar comprovador, pero l'exercici no demana més
            // La contrasenya és buida
            System.out.println("La contrasenya és buida");
            return false;
        }

        // Tot correcte, retornem true;
        return true;
    }
}
