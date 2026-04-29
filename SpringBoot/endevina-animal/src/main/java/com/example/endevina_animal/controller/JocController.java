package com.example.endevina_animal.controller;

import com.example.endevina_animal.model.Animal;
import com.example.endevina_animal.model.Canco;
import com.example.endevina_animal.model.ContingutAdivinar;
import com.example.endevina_animal.model.Pelicula;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class JocController {

    // Llistes (ArrayList és més flexible que arrays)
    private final List<ContingutAdivinar> animals = new ArrayList<>();
    private final List<ContingutAdivinar> cancons = new ArrayList<>();
    private final List<ContingutAdivinar> pelis   = new ArrayList<>();
    private final Random random = new Random();

    public JocController() {

        // ── ANIMALS ──────────────────────────────────────────────
        ArrayList<String> pistesGos = new ArrayList<>();
        pistesGos.add("Te 4 potes");
        pistesGos.add("Fa bup bup");
        pistesGos.add("Es el millor amic de l'home");
        animals.add(new Animal("Gos", "gos.png", pistesGos));

        ArrayList<String> pistesGat = new ArrayList<>();
        pistesGat.add("Te 4 potes");
        pistesGat.add("Fa miolaments");
        pistesGat.add("Es molt independent");
        animals.add(new Animal("Gat", "gat.png", pistesGat));

        ArrayList<String> pistesElefant = new ArrayList<>();
        pistesElefant.add("Es el mes gran dels animals terrestres");
        pistesElefant.add("Te una trompa molt llarga");
        pistesElefant.add("Viu a Africa i Asia");
        animals.add(new Animal("Elefant", "elefant.png", pistesElefant));

        ArrayList<String> pistesLleo = new ArrayList<>();
        pistesLleo.add("Es el rei de la selva");
        pistesLleo.add("Te una gran crinera");
        pistesLleo.add("Rugeix molt fort");
        animals.add(new Animal("Lleo", "lleo.png", pistesLleo));

        ArrayList<String> pistesOca = new ArrayList<>();
        pistesOca.add("Es un ocell de granja");
        pistesOca.add("Grunty i es pot menjar per Nadal");
        pistesOca.add("Dona ous grossos");
        animals.add(new Animal("Oca", "oca.png", pistesOca));

        // ── CANÇONS ───────────────────────────────────────────────
        ArrayList<String> pistesBoh = new ArrayList<>();
        pistesBoh.add("Es de Queen");
        pistesBoh.add("Dura mes de 5 minuts");
        pistesBoh.add("Te parts operistiques");
        cancons.add(new Canco("Bohemian Rhapsody", "Queen", "queen_bohemian.mp3", pistesBoh));

        ArrayList<String> pistesThriller = new ArrayList<>();
        pistesThriller.add("Es de Michael Jackson");
        pistesThriller.add("Te un videoclip de zombis");
        pistesThriller.add("Va sortir el 1982");
        cancons.add(new Canco("Thriller", "Michael Jackson", "mj_thriller.mp3", pistesThriller));

        ArrayList<String> pistesImagine = new ArrayList<>();
        pistesImagine.add("Es de John Lennon");
        pistesImagine.add("Es un hime a la pau mundial");
        pistesImagine.add("Comenca amb piano");
        cancons.add(new Canco("Imagine", "John Lennon", "lennon_imagine.mp3", pistesImagine));

        ArrayList<String> pistesSmoke = new ArrayList<>();
        pistesSmoke.add("Es de Deep Purple");
        pistesSmoke.add("Te un dels riffs de guitarra mes famosos de la historia");
        pistesSmoke.add("Parla d'un incendi a Montreux");
        cancons.add(new Canco("Smoke on the Water", "Deep Purple", "deeppurple_smoke.mp3", pistesSmoke));

        ArrayList<String> pistesHotel = new ArrayList<>();
        pistesHotel.add("Es de Eagles");
        pistesHotel.add("Parla d'un hotel misteriós");
        pistesHotel.add("Es un classic del rock dels anys 70");
        cancons.add(new Canco("Hotel California", "Eagles", "eagles_hotel.mp3", pistesHotel));

        // ── PEL·LÍCULES ───────────────────────────────────────────
        ArrayList<String> pistesTitanic = new ArrayList<>();
        pistesTitanic.add("Surten DiCaprio i Winslet");
        pistesTitanic.add("Hi ha un iceberg");
        pistesTitanic.add("Es va estrenar el 1997");
        pelis.add(new Pelicula("Titanic", 1997, "titanic.png", pistesTitanic));

        ArrayList<String> pistesMatrix = new ArrayList<>();
        pistesMatrix.add("Hi ha pilules vermelles i blaves");
        pistesMatrix.add("El protagonista pot aturar bales");
        pistesMatrix.add("Es va estrenar el 1999");
        pelis.add(new Pelicula("Matrix", 1999, "matrix.png", pistesMatrix));

        ArrayList<String> pistesAvatar = new ArrayList<>();
        pistesAvatar.add("Transcorre en un planeta que es diu Pandora");
        pistesAvatar.add("Els natius son blaus i alts");
        pistesAvatar.add("Es va estrenar el 2009");
        pelis.add(new Pelicula("Avatar", 2009, "avatar.png", pistesAvatar));

        ArrayList<String> pistesStar = new ArrayList<>();
        pistesStar.add("Hi ha jedis i siths");
        pistesStar.add("Hi ha un personatge amb mascara negra que respira fort");
        pistesStar.add("La primera pelicula va sortir el 1977");
        pelis.add(new Pelicula("Star Wars", 1977, "starwars.png", pistesStar));

        ArrayList<String> pistesFrozen = new ArrayList<>();
        pistesFrozen.add("La protagonista te poders de gel");
        pistesFrozen.add("Hi ha la canco 'Let It Go'");
        pistesFrozen.add("Es va estrenar el 2013");
        pelis.add(new Pelicula("Frozen", 2013, "frozen.png", pistesFrozen));
    }

    // ── PÀGINA PRINCIPAL ──────────────────────────────────────────
    @GetMapping("/")
    public String triar() {
        return "triar";
    }

    // ── INICIAR / CONTINUAR JOC ───────────────────────────────────
    @GetMapping("/joc/{mode}")
    public String iniciarJoc(@PathVariable String mode,
                             HttpSession sessio, Model model) {

        List<ContingutAdivinar> coleccio;
        if (mode.equals("animal"))       coleccio = animals;
        else if (mode.equals("canco"))   coleccio = cancons;
        else                             coleccio = pelis;

        // Si l'usuari ha canviat de mode, reseteja la partida
        String modeActual = (String) sessio.getAttribute("mode");
        if (!mode.equals(modeActual)) {
            sessio.removeAttribute("actual");
            sessio.removeAttribute("intents");
            sessio.removeAttribute("ultimError");
        }

        ContingutAdivinar actual = (ContingutAdivinar) sessio.getAttribute("actual");
        if (actual == null) {
            actual = coleccio.get(random.nextInt(coleccio.size()));
            sessio.setAttribute("actual", actual);
            sessio.setAttribute("mode", mode);
            sessio.setAttribute("intents", 0);
        }

        int intents = (Integer) sessio.getAttribute("intents");
        List<String> pistesVisibles = actual.getPistes()
                .subList(0, Math.min(intents + 1, actual.getPistes().size()));

        Integer puntuacio = (Integer) sessio.getAttribute("puntuacio");
        if (puntuacio == null) puntuacio = 0;

        // POLIMORFISME: Java crida la versió correcta de mostrarPista()
        // segons si actual és Animal, Canco o Pelicula
        model.addAttribute("contingut", actual);
        model.addAttribute("urlPista", actual.mostrarPista());
        model.addAttribute("mode", mode);
        model.addAttribute("intents", intents);
        model.addAttribute("pistesVisibles", pistesVisibles);
        model.addAttribute("puntuacio", puntuacio);
        model.addAttribute("ultimError", sessio.getAttribute("ultimError"));
        return "joc";
    }

    // ── REBRE LA RESPOSTA ─────────────────────────────────────────
    @PostMapping("/endevinar")
    public String endevinar(@RequestParam String resposta,
                            HttpSession sessio, Model model) {

        ContingutAdivinar actual = (ContingutAdivinar) sessio.getAttribute("actual");
        String mode = (String) sessio.getAttribute("mode");

        if (actual.encertada(resposta)) {
            Integer intents  = (Integer) sessio.getAttribute("intents");
            int punts = Math.max(10 - intents * 3, 1);

            Integer puntuacio = (Integer) sessio.getAttribute("puntuacio");
            if (puntuacio == null) puntuacio = 0;
            sessio.setAttribute("puntuacio", puntuacio + punts);

            model.addAttribute("contingut", actual);
            model.addAttribute("mode", mode);
            model.addAttribute("puntsGuanyats", punts);
            model.addAttribute("puntuacio", puntuacio + punts);
            return "encertat";
        } else {
            Integer intents = (Integer) sessio.getAttribute("intents");
            sessio.setAttribute("intents", intents + 1);
            sessio.setAttribute("ultimError", resposta);
            return "redirect:/joc/" + mode;
        }
    }

    // ── SEGÜENT ELEMENT ───────────────────────────────────────────
    @GetMapping("/seguent")
    public String seguent(HttpSession sessio) {
        String mode = (String) sessio.getAttribute("mode");
        sessio.removeAttribute("actual");
        sessio.removeAttribute("intents");
        sessio.removeAttribute("ultimError");
        if (mode == null) mode = "animal";
        return "redirect:/joc/" + mode;
    }

    // ── REINICIAR ─────────────────────────────────────────────────
    @GetMapping("/reiniciar")
    public String reiniciar(HttpSession sessio) {
        sessio.invalidate();
        return "redirect:/";
    }
}