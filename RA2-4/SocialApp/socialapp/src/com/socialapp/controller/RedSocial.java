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
    
    private String[][] UsuariosArray;
    private int numUsuaris;
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

    public boolean registrar(Usuario u) { // registrar(Usuario u): afegeix l'usuari a la llista.
        if (!(this.numUsuaris < MAX_USUARIS)) {
            // Num usuaris >= MAX_USUARIS, no hi ha espai per a més usuaris.
            System.out.println("No hi ha espai");
            return false;
        }
        this.UsuariosArray[this.numUsuaris][0] = u.getUsername();
        this.UsuariosArray[this.numUsuaris][1] = u.getContrasenya();
        this.numUsuaris++;

        return true; // Procés finalitzar correctament.
    }

    public boolean eliminar(String username) {
        

        return true; // Procés finalitzar correctament.
    }

    public Usuario buscar(String username) {
        

        return null; // Usuari no trobat.
    }

    public Usuario login() { //El metode login() de RedSocial retorna un objecte de tipus Usuario.
        //if (usuari instanceof Admin) {} //Aquesta comprovacio es fa a Menu despres del login.

        //busca l'usuari i comprova la contrasenya. Retorna l'objecte Usuario si es correcte, o null si no.

        return null; // Login incorrecte.
    }

    /*
    ==========================================
        GETTERS
    ==========================================
    */

    public void getUsuaris() {
        
    }

    public int getNumUsuaris() {
        return numUsuaris;
    }
}
