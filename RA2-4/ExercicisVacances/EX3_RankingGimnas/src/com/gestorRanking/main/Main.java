package com.GestorRanking.main;

import com.GestorRanking.controller.GestorRanking;
import com.GestorRanking.model.Esportista;
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
            String nomIdentificador = "esportista_" + i;
            String nomMostra = "Esportista " + i;
            String disciplina = "Disciplina " + ((i % 3) + 1); // Assigna una disciplina cíclica entre 3 disciplines
            int edat = 20 + i; // Edat entre 21 i 25
            String dataIntroduccio = "2024-06-" + String.format("%02d", i); // Data entre 2024-06-01 i 2024-06-05

            gestorRanking.registrar(new Esportista(nomIdentificador, nomMostra, disciplina, edat, dataIntroduccio));
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