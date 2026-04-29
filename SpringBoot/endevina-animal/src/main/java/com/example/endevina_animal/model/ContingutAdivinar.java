package com.example.endevina_animal.model;

import java.util.List;

public abstract class ContingutAdivinar {

    protected String nom;
    protected List<String> pistes;

    public ContingutAdivinar(String nom, List<String> pistes) {
        this.nom = nom;
        this.pistes = pistes;
    }

    // Getters
    public String getNom() { return nom; }
    public List<String> getPistes() { return pistes; }

    // Comprova si la resposta és correcta (ignora majúscules i espais)
    public boolean encertada(String resposta) {
        return nom.equalsIgnoreCase(resposta.trim());
    }

    // Cada subclasse retorna la URL del recurs (imatge, àudio, fotograma)
    public abstract String mostrarPista();
}