package com.example.endevina_animal.model;

import java.util.List;

public class Pelicula extends ContingutAdivinar {

    private int any;
    private String imatge;   // Nom del fitxer (ex: "titanic.jpg")

    public Pelicula(String nom, int any, String imatge, List<String> pistes) {
        super(nom, pistes);
        this.any = any;
        this.imatge = imatge;
    }

    public int getAny() { return any; }
    public String getImatge() { return imatge; }

    @Override
    public String mostrarPista() {
        return "/pelis/" + imatge;
    }
}