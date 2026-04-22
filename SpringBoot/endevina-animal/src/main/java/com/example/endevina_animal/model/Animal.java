package com.example.endevina_animal.model;

import java.util.List;

public class Animal {

    private String nom;
    private String imatge;     // Nom del fitxer (ex: "gos.jpg")
    private List<String> pistes;

    public Animal(String nom, String imatge, List<String> pistes) {
        this.nom = nom;
        this.imatge = imatge;
        this.pistes = pistes;
    }

    // Getters
    public String getNom() { return nom; }
    public String getImatge() { return imatge; }
    public List<String> getPistes() { return pistes; }

    // Metode que comprova si una resposta es correcta
    // (ignorant majuscules/minuscules i espais)
    public boolean encertada(String resposta) {
        return nom.equalsIgnoreCase(resposta.trim());
    }
}