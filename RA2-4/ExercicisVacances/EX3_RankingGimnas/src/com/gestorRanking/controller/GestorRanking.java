package com.GestorRanking.controller;

import java.util.ArrayList;

import com.GestorRanking.model.Esportista;

public class GestorRanking {
    
    private ArrayList<Esportista> EsportistesArray;
    private int numEsportistes;

    /*
    ==========================================
        CONSTRUCTOR
    ==========================================
    */
    
    // CONSTRUCTOR que inicialitza l'array
    public GestorRanking() {
        EsportistesArray = new ArrayList<>(); // Inicialitzem l'ArrayList
        numEsportistes = 0;
    } 

    /*
    ==========================================
        MÉTODES
    ==========================================
    */

    public boolean registrar(Esportista u) { // registrar(Esportista u): afegeix l'esportista a la llista.
        this.EsportistesArray.add(u); // Afegim l'esportista a l'ArrayList
        this.numEsportistes++;

        return true; // Procés finalitzar correctament.
    }

    /*
    ==========================================
        RANKING
    ==========================================
    */

    // retorna una llista de esportistes ordenada per marca (de millor a pitjor)
    public void consultarRanking() {
        for (Esportista esportista : EsportistesArray) {
            //esportista.obtindrePuntuacio
        }
    }

    /*
    ==========================================
        GETTERS
    ==========================================
    */

    public ArrayList<Esportista> getEsportistes() {
        return this.EsportistesArray;
    }

    public int getNumEsportistes() {
        return numEsportistes;
    }
}
