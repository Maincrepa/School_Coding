package com.socialapp.controller;

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
    
    private String[][] UsuariosArray; // TODO: Canviar a array d'objectes Usuario i no string
    private int numUsuaris;
    private static final int MAX_USUARIS = 50;

    /*
    ==========================================
        CONSTRUCTOR
    ==========================================
    */
    
    // CONSTRUCTOR que inicialitza l'array
    public RedSocial() {
        UsuariosArray = new String[MAX_USUARIS][3]; // Inicialitzem 50 usuaris amb: username, contrasenya, email
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
        this.UsuariosArray[this.numUsuaris][2] = u.getEmail();
        this.numUsuaris++;

        return true; // Procés finalitzar correctament.
    }

    public boolean eliminar(String username) {
        for (int i = 0; i < this.numUsuaris; i++) {
            if (this.UsuariosArray[i][0] != null && this.UsuariosArray[i][0].equals(username)) {
                // Desplacem tots els usuaris següents una posició cap esquerra (-1)
                for (int j = i; j < this.numUsuaris - 1; j++) {
                    this.UsuariosArray[j] = this.UsuariosArray[j + 1];
                }

                this.UsuariosArray[this.numUsuaris - 1] = null; // Eliminem l'últim usuari duplicat
                this.numUsuaris--;
                
                return true; // Procés finalitzar correctament.
            }
        }
        return false; // Usuari no trobat.
    }

    public Usuario buscar(String username) {
        for (int i = 0; i < this.numUsuaris; i++) {
            if (this.UsuariosArray[i][0] != null && this.UsuariosArray[i][0].equals(username)) {
                // Aquí podríem crear un objecte Usuario amb la informació trobada si fos necessari
                
                // Retornem un objecte Usuario amb username, contrasenya i email trobats
                return new Usuario(this.UsuariosArray[i][0], this.UsuariosArray[i][1], this.UsuariosArray[i][2]); 
            }
        }

        return null; // Usuari no trobat.
    }

    public Usuario login(String username, String contrasenya) { 
        //El metode login() de RedSocial retorna un objecte de tipus Usuario.
        //busca l'usuari i comprova la contrasenya. Retorna l'objecte Usuario si es correcte, o null si no.

        Usuario usuari = buscar(username);
        if (usuari == null) {
            System.out.println("Error: No s'ha trobat l'usuari");
            return null;
        }
        if (!(usuari.getContrasenya().equals(contrasenya))) {
            // si les contrasenyes NO coincideixen, retorna incorrecte
            System.out.println("Error: Contrasenya incorrecta");
            return null;
        }
        
        return usuari; // Login correcte.
    }

    /*
    ==========================================
        GETTERS
    ==========================================
    */

    public String[][] getUsuaris() {
        return this.UsuariosArray;
    }

    public int getNumUsuaris() {
        return numUsuaris;
    }
}
