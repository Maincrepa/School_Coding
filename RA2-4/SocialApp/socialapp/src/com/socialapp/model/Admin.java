package com.socialapp.model;

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

public class Admin {
    
}
