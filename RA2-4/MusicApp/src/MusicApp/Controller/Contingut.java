package MusicApp.Controller;

public abstract class Contingut {
    protected String titol;
    protected String autor;
    protected double duration;


    //-------------------------------------

    public Contingut(String titol, String autor, double duration) {
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

    public String getDuration() {
        return duration;
    }

    //-------------------------------------


    // Métode abstracte reproduir()
    public abstract void reproduir();
    
    // Métode abstracte getTipus()
    public abstract String getTipus();

}
