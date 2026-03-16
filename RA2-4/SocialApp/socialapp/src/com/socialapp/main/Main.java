package com.socialapp.main;

import com.socialapp.controller.RedSocial;
import com.socialapp.view.Menu;

/*
Conte nomes el metode main(). Crea una instancia de RedSocial, afegeix alguns usuaris de
prova, crea una instancia de Menu i crida mostrarMenuPrincipal(). No ha de tenir cap altra
logica.
*/

public class Main {
    /*
    ==========================================
        INSTANCIES
    ==========================================
    */
    //Crea una instancia de RedSocial
    RedSocial redSocial = new RedSocial();

    /*
    ==========================================
        USUARIS PROVA
    ==========================================
    */
    //afegeix alguns usuaris de prova

    /*
    ==========================================
        INSTANCIA MENU
    ==========================================
    */
   Menu menu = new Menu();
   
    //crea una instancia de Menu i crida mostrarMenuPrincipal()
}


/*
Quan s'executa el programa, es mostra un menu inicial amb dues opcions: fer login o sortir.
L'usuari introdueix el seu username i contrasenya. Si les dades son correctes, s'accedeix al
menu corresponent. Si son incorrectes, es mostra un missatge d'error i es torna al menu
inicial.
Un cop identificat, si l'usuari es de tipus Usuario veu el seu menu d'opcions. Si es de tipus
Admin veu un menu diferent amb les opcions d'administracio. En qualsevol moment es pot
tancar la sessio i tornar al menu inicial.
*/