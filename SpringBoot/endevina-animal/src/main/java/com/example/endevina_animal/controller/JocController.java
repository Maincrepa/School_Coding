package com.example.endevina_animal.controller;

import com.example.endevina_animal.model.Animal;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Random;

@Controller
public class JocController {

    // Llista d'animals disponibles (de moment hardcoded)
    private final List<Animal> animals = List.of(
        new Animal("Gos", "gos.png",
            List.of("Te 4 potes", "Fa bup bup", "Es el millor amic de l'home")),
        new Animal("Gat", "gat.png",
            List.of("Te 4 potes", "Fa miau", "Li agrada dormir al sofa")),
        new Animal("Elefant", "elefant.png",
            List.of("Es molt gran", "Te una trompa llarga", "Viu a Africa i Asia")),
        new Animal("Girafa", "girafa.png",
            List.of("Te el coll molt llarg", "Menja fulles dels arbres", "Viu a la sabana")),
        new Animal("Lleo", "lleo.png",
            List.of("Es el rei de la selva", "Rugeix molt fort", "Viu en manades"))
    );

    private final Random random = new Random();

    // ===== PAGINA PRINCIPAL =====
    @GetMapping("/")
    public String inici(HttpSession sessio, Model model) {
        // Busquem l'animal actual a la sessio.
        // Si no hi es, n'agafem un d'aleatori
        Animal actual = (Animal) sessio.getAttribute("animalActual");
        if (actual == null) {
            actual = animals.get(random.nextInt(animals.size()));
            sessio.setAttribute("animalActual", actual);
            sessio.setAttribute("intents", 0);
        }

        Integer intents = (Integer) sessio.getAttribute("intents");
        Integer puntuacio = (Integer) sessio.getAttribute("puntuacio");
        if (puntuacio == null) puntuacio = 0;

        // Les pistes es revelen progressivament:
        // Intent 0 -> 1 pista, Intent 1 -> 2 pistes, Intent 2 -> totes
        int numPistes = Math.min(intents + 1, actual.getPistes().size());
        List<String> pistesVisibles = actual.getPistes().subList(0, numPistes);

        model.addAttribute("animal", actual);
        model.addAttribute("intents", intents);
        model.addAttribute("pistesVisibles", pistesVisibles);
        model.addAttribute("puntuacio", puntuacio);
        return "joc";
    }

    // ===== REBRE LA RESPOSTA =====
    @PostMapping("/endevinar")
    public String endevinar(@RequestParam String resposta,
                            HttpSession sessio,
                            Model model) {
        Animal actual = (Animal) sessio.getAttribute("animalActual");

        if (actual.encertada(resposta)) {
            // Correcte! Calculem punts (menys intents = mes punts)
            Integer intents = (Integer) sessio.getAttribute("intents");
            int punts = Math.max(10 - intents * 3, 1);

            Integer puntuacio = (Integer) sessio.getAttribute("puntuacio");
            if (puntuacio == null) puntuacio = 0;
            sessio.setAttribute("puntuacio", puntuacio + punts);

            model.addAttribute("animal", actual);
            model.addAttribute("puntsGuanyats", punts);
            model.addAttribute("puntuacio", puntuacio + punts);
            return "encertat";
        } else {
            // Incorrecte: sumem un intent i tornem a la pagina principal
            Integer intents = (Integer) sessio.getAttribute("intents");
            sessio.setAttribute("intents", intents + 1);
            sessio.setAttribute("ultimError", resposta);
            return "redirect:/";
        }
    }

    // ===== SEGUENT ANIMAL =====
    @GetMapping("/seguent")
    public String seguent(HttpSession sessio) {
        sessio.removeAttribute("animalActual");
        sessio.removeAttribute("intents");
        sessio.removeAttribute("ultimError");
        return "redirect:/";
    }

    // ===== REINICIAR EL JOC =====
    @GetMapping("/reiniciar")
    public String reiniciar(HttpSession sessio) {
        sessio.invalidate();
        return "redirect:/";
    }
}