package MusicApp.Main;

import MusicApp.Controller.Contingut;
import MusicApp.Controller.TipusContingut.*;
import MusicApp.View.Menu;

public class Main {
    
    public static void main(String[] args) {
        /*
        ==========================================
            INSTANCIES
        ==========================================
        */
        //Crea una instancia de Playlist
        //TODO

        /*
        ==========================================
            CONTINGUT DE PROVA
        ==========================================
        */

        Contingut c = new Canco("TestingSong", "nullo", 129, "Tezting", "Pop");
        c.reproduir();
        System.out.println(c.getDescripcio());

        Contingut p = new Podcast("Java Facts", "Jabbus", 832, "Technology", "Very interesting podcast about Java facts", "English");
        p.reproduir();
        System.out.println(p.getDescripcio());

        Contingut a = new Audiollibre("Audi llibrr", "Mariajose", 300, 4, "Ficció", "Español", "pepito");
        a.reproduir();
        System.out.println(a.getDescripcio());

        /*
        ==========================================
            INSTANCIA MENU
        ==========================================
        */

        Menu menu = new Menu();
        menu.mostrarMenuPrincipal(); // playlist aqui
    }
}