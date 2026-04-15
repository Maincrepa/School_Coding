package MusicApp.Controller.TipusContingut;

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
            formatDuracio(this.duration),
            this.album,
            this.genere
        );

        System.out.println(output);
    }


    //-------------------------------------
    // Metode public per transformar la duració de double en un string ben formatejat

    public String getDuracioFormatejada(double duration) {
        int mins = (int)(duration / 60); // minuts
        int secs = (int)(duration % 60); // segons

        // formateem "mm:ss"
        return String.format("%02d:%02d", mins, secs);
    }
}
