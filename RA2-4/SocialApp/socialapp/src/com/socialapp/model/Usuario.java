package com.socialapp.model;

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

    private String[] amics;

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

        amics = new String[MAX_AMICS];
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
        OTHER
    ==========================================
    */








    @Override
    public String toString() {
        // sense toString() s'obté l'adreça de memòria de l'objecte
        // sobreeescriu per utilitzar l'estructura meva en lloc del de Object

        //return "Usuario{username = '" + this.username + "', email = " + this.email + "', posts: " + 
        return ""; //TODO: Finalitzar métode
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
        if (email == null || email.isEmpty()) { //TODO: Millorar comprovador
            // El email és buit, retornar
            System.out.println("El email está buit");
            return false;
        }

        // Tot correcte, retornem true;
        return true;
    }

    private boolean validarContrasenya(String contrasenya) {
        if (username == null || username.isEmpty()) {//TODO: Millorar comprovador
            // La contrasenya és buida
            System.out.println("La contrasenya és buida");
            return false;
        }

        // Tot correcte, retornem true;
        return true;
    }
}
