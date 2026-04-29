package com.example.endevina_animal.model;

import java.util.List;

public class Animal extends ContingutAdivinar {

    private String imatge;   // Nom del fitxer (ex: "gos.jpg")

    public Animal(String nom, String imatge, List<String> pistes) {
        super(nom, pistes);   // PRIMER: passa nom i pistes al pare
        this.imatge = imatge;
    }

    public String getImatge() { return imatge; }

    @Override
    public String mostrarPista() {
        return "/images/" + imatge;
    }
}