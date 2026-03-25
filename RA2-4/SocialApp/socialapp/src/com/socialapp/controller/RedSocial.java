package com.socialapp.controller;

import java.util.ArrayList;

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
    
    private ArrayList<Usuario> UsuariosArray;
    private int numUsuaris;
    private static final int MAX_USUARIS = 50;

    /*
    ==========================================
        CONSTRUCTOR
    ==========================================
    */
    
    // CONSTRUCTOR que inicialitza l'array
    public RedSocial() {
        UsuariosArray = new ArrayList<>(); // Inicialitzem l'ArrayList
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
        this.UsuariosArray.add(u); // Afegim l'usuari a l'ArrayList
        this.numUsuaris++;

        return true; // Procés finalitzar correctament.
    }

    public boolean eliminar(String username) {
        for (int i = 0; i < this.numUsuaris; i++) {
            if (this.UsuariosArray.get(i) != null && this.UsuariosArray.get(i).getUsername().equals(username)) {
                this.UsuariosArray.remove(i);
                this.numUsuaris--;
                
                return true; // Procés finalitzar correctament.
            }
        }
        return false; // Usuari no trobat.
    }

    public Usuario buscar(String username) {
        for (int i = 0; i < this.numUsuaris; i++) {
            if (this.UsuariosArray.get(i) != null && this.UsuariosArray.get(i).getUsername().equals(username)) {
                // Aquí podríem crear un objecte Usuario amb la informació trobada si fos necessari
                
                // Retornem un objecte Usuario amb username, contrasenya i email trobats
                return this.UsuariosArray.get(i); 
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

    public ArrayList<Usuario> getUsuaris() {
        return this.UsuariosArray;
    }

    public int getNumUsuaris() {
        return numUsuaris;
    }
}
