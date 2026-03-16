package com.socialapp.controller;

import com.socialapp.model.Admin;
import com.socialapp.model.Usuario;

/*
Gestiona la llista global d'usuaris de l'aplicacio. Te un array d'objectes Usuario de mida
maxima 50 i un enter numUsuaris per controlar quants hi ha. Els seus metodes son:
- registrar(Usuario u): afegeix l'usuari a la llista.
- eliminar(String username): elimina l'usuari amb aquell username.
- buscar(String username): retorna l'objecte Usuario amb aquell username, o null si no
existeix.
- login(String username, String contrasenya): busca l'usuari i comprova la contrasenya.
Retorna l'objecte Usuario si es correcte, o null si no.
- getUsuaris() i getNumUsuaris(): getters de la llista.
*/

public class RedSocial {
    
    static String[][] UsuariosArray;
    static int numUsuaris;
    private static final int MAX_USUARIS = 50;

    /*
    ==========================================
        CONSTRUCTOR
    ==========================================
    */
    
    // CONSTRUCTOR que inicialitza l'array
    public RedSocial() {
        UsuariosArray = new String[MAX_USUARIS][2]; // Inicialitzem 50 usuaris amb: username, contrasenya
        numUsuaris = 0;
    } 

    /*
    ==========================================
        MÉTODES
    ==========================================
    */

    public static void registrar(Usuario u) {
        // registrar(Usuario u): afegeix l'usuari a la llista.
    }

    public static void eliminar(String username) {
        
    }

    public static void buscar(String username) {
        
    }

    public static void login() { //El metode login() de RedSocial retorna un objecte de tipus Usuario.
        //if (usuari instanceof Admin) {} //Aquesta comprovacio es fa a Menu despres del login.

        //busca l'usuari i comprova la contrasenya. Retorna l'objecte Usuario si es correcte, o null si no.
    }

    /*
    ==========================================
        GETTERS
    ==========================================
    */

    public static void getUsuaris() {
        
    }

    public static void getNumUsuaris() {
        
    }
}
