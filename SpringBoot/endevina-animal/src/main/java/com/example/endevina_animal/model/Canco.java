package com.example.endevina_animal.model;

import java.util.List;

public class Canco extends ContingutAdivinar {

    private String artista;
    private String arxiuAudio;   // Nom del fitxer MP3 (ex: "queen_bohemian.mp3")

    public Canco(String nom, String artista, String arxiuAudio, List<String> pistes) {
        super(nom, pistes);
        this.artista = artista;
        this.arxiuAudio = arxiuAudio;
    }

    public String getArtista() { return artista; }
    public String getArxiuAudio() { return arxiuAudio; }

    @Override
    public String mostrarPista() {
        return "/audios/" + arxiuAudio;
    }
}