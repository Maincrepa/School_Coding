package com.GestorRanking.controller;

import java.util.ArrayList;

import com.GestorRanking.model.Esportista;

public class GestorRanking {
    
    private ArrayList<Esportista> EsportistesArray;
    private int numEsportistes;
    private static final int MAX_ESPORTISTES = 50;
    //TODO: fer MAX_ESPORTISTES variable i no constant.

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
        if (!(this.numEsportistes < MAX_ESPORTISTES)) {
            System.out.println("No hi ha espai");
            return false;
        }
        this.EsportistesArray.add(u); // Afegim l'esportista a l'ArrayList
        this.numEsportistes++;

        return true; // Procés finalitzar correctament.
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
