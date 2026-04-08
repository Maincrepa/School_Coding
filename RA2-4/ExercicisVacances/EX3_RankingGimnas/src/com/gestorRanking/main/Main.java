package com.GestorRanking.main;

import com.GestorRanking.controller.GestorRanking;
import com.GestorRanking.view.Menu;

public class Main {
    public static void main(String[] args) {
        /*
        ==========================================
            INSTANCIES
        ==========================================
        */
        GestorRanking gestorRanking = new GestorRanking();

        /*
        ==========================================
            ESPORTISTES PROVA
        ==========================================
        */

        //afegeix alguns esportistes de prova
        for (int i = 1; i <= 5; i++) {
            
        }

        /*
        ==========================================
            INSTANCIA MENU
        ==========================================
        */

        Menu menu = new Menu();
        menu.mostrarMenuPrincipal(gestorRanking);
    
        //crea una instancia de Menu i crida mostrarMenuPrincipal()
    }
}