package MusicApp.Controller.TipusContingut;

import java.util.ArrayList;

import MusicApp.Controller.Contingut;

public class Podcast extends Contingut {
    protected String tema;
    protected String resum;
    protected String idioma;
    
    //-------------------------------------

    // Constructor
    public Podcast(String titol, String autor, double duration, String tema, String resum, String idioma) {
        super(titol, autor, duration);

        this.tema = tema;
        this.resum = resum;
        this.idioma = idioma;
    }

    // Getters

    public String getTema() {
        return this.tema;
    }

    public String getResum() {
        return this.resum;
    }

    public String getIdioma() {
        return this.idioma;
    }

    //-------------------------------------

    @Override
    public String getTipus() {
        return "PODCAST";
    } 

    //-------------------------------------

    @Override
    public void reproduir() {
        String output = """
        ================================

            · Ara reproduïnt:
            %s
            
            - Presentador: %s
            - Duració: %s
            - Album: %s
            - Tematica: %s
            - Idioma: %s
            - Resum: %s

        ================================
        """.formatted(
            this.titol, 
            this.autor, 
            getDuracioFormatejada(this.duration),
            this.tema,
            this.idioma,
            this.resum
        );

        System.out.println(output);
    }


    
}
