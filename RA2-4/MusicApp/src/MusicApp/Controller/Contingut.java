package MusicApp.Controller;

public abstract class Contingut {
    protected String titol;
    protected String autor;
    protected int duration;


    //-------------------------------------

    public Contingut(String titol, String autor, int duration) {
        this.titol = titol;
        this.autor = autor;
        this.duration = duration;
    }

    public String getTitol() {
        return titol;
    }

    public String getAutor() {
        return autor;
    }

    public int getDuration() {
        return duration;
    }

    //-------------------------------------


    // Métode abstracte reproduir()
    public abstract void reproduir();
    
    // Métode abstracte getTipus()
    public abstract String getTipus();

    //-------------------------------------
    // Metode public per transformar la duració de double en un string ben formatejat

    public String getDuracioFormatejada(int duration) {
        int mins = (duration / 60); // minuts
        int secs = (duration % 60); // segons

        // formateem "mm:ss"
        return String.format("%02d:%02d", mins, secs);
    }

    //-------------------------------------
    // Metode public que retorna informació basica sobre el contingut

    public String getDescripcio() {
        return "[" + getTipus() + "] " + titol + " - " + autor;
    }
}
