package MusicApp.Controller.TipusContingut;

import MusicApp.Controller.Contingut;

public class Canco extends Contingut {
    protected String album;
    protected String genere;
    
    //-------------------------------------

    // Constructor
    public Canco(String titol, String autor, double duration, String album, String genere) {
        super(titol, autor, duration);

        this.album = album;
        this.genere = genere;
    }

    // Getters

    public String getAlbum() {
        return this.album;
    }

    public String getGenere() {
        return this.genere;
    }

    //-------------------------------------

    @Override
    public String getTipus() {
        return "CANCO";
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
            - Album: %s
            - Genere Principal: %s

        ================================
        """.formatted(
            this.titol, 
            this.autor, 
            getDuracioFormatejada(this.duration),
            this.album,
            this.genere
        );

        System.out.println(output);
    }


    
}
