package MusicApp.Main;
import MusicApp.Controller.Contingut;
import MusicApp.Controller.TipusContingut.Canco;

public class Main {
    
    public static void main(String[] args) {
        Contingut c = new Canco("TestingSong", "nullo", 120, "Tezting", "Pop");
        c.reproduir();
        System.out.println(c.getDescripcio());;
    }
}
