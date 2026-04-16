package MusicApp.Controller.TipusContingut;

import MusicApp.Controller.Contingut;

public class Audiollibre extends Contingut {
    protected int rating; // 1-5
    protected String genere;
    protected String idioma;
    protected String narrador;
    
    //-------------------------------------

    // Constructor
    public Audiollibre(String titol, String autor, int duration, int rating, String genere, String idioma, String narrador) {
        super(titol, autor, duration);

        this.rating = rating;
        this.genere = genere;
        this.idioma = idioma;
        this.narrador = narrador;
    }

    // Getters

    public String getRating() {
        return this.rating;
    }

    public String getGenere() {
        return this.genere;
    }

    public String getIdioma() {
        return this.idioma;
    }

    public String getNarrador() {
        return this.narrador;
    }
    
    //-------------------------------------

    @Override
    public String getTipus() {
        return "AUDIOLLIBRE";
    } 

    //-------------------------------------

    @Override
    public void reproduir() {
        String output = """
        ================================

            · Ara reproduïnt:
            %s
            
            - Autor: %s
            - Duració: %s
            - rating: %s
            - Genere: %s
            - Idioma: %s
            - Narrador: %s

        ================================
        """.formatted(
            this.titol, 
            this.autor, 
            getDuracioFormatejada(this.duration),
            getRatingFormatejat(this.rating),
            this.genere,
            this.idioma,
            this.narrador
        );


        System.out.println(output);
    }

    private String getRatingFormatejat(int rating) {
        return String.format("%d/5", rating);
    }
    
}
