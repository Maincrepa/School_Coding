package com.socialapp.model;

import com.socialapp.controller.RedSocial;

/*
Admin hereta de Usuario amb extends. No cal redeclarar cap atribut ni metode de Usuario, ja
els te per herencia. Afegeix un array de Strings anomenat baneats per guardar els usernames
dels usuaris baneats, i la constant MAX_BANEATS amb valor 50.
El constructor d'Admin ha de cridar super() com a primera instruccio passant-li els tres
parametres. Els metodes propis d'Admin son:
- banearUsuari(RedSocial red, String username): afegeix el username a baneats.
- eliminarUsuari(RedSocial red, String username): elimina l'usuari de la xarxa cridant
red.eliminar().
- llistarUsuaris(RedSocial red): imprimeix tots els usuaris registrats a la xarxa.
Sobreescriu toString() amb @Override per indicar que l'usuari es administrador
*/

public class Admin extends Usuario {
    private String[] baneats;
    private static final int MAX_BANEATS = 50;

    /*
    ==========================================
        CONSTRUCTOR
    ==========================================
    */
    public Admin(String username, String contrasenya, String email) {
        super(username, contrasenya, email);
        this.baneats = new String[MAX_BANEATS];
    }

    /*
    ==========================================
        MÉTODES ADMIN
    ==========================================
    */

    public void banearUsuari(RedSocial red, String username) {
        if (this.baneats.length >= MAX_BANEATS) {
            System.out.println("No es poden banear més usuaris.");
            return;
        }
        this.baneats[this.baneats.length] = username; // Afegim el username a l'array de baneats
    }

    public void eliminarUsuari(RedSocial red, String username) {
        red.eliminar(username); // Cridem al metode eliminar de RedSocial
    }

    public void llistarUsuaris(RedSocial red) {
        Usuario[] usuaris = red.getUsuaris(); // Agafem la llista d'usuaris de RedSocial

        for (int i = 0; i < red.getNumUsuaris(); i++) {
            System.out.println("Username: " + usuaris[i].getUsername() + ", Email: " + usuaris[i].getEmail());
        }
    }

    /*
    ==========================================
        MÉTODES TOSTRING
    ==========================================
    */

    @Override
    public String toString() {
        return "Admin{username = '" + this.getUsername() + "', email = " + this.getEmail() + "}";
    }
    
}
