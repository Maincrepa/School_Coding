package com.example.agenda.controller;

// src/main/java/com/exemple/agenda/controller/ContacteController.java

import com.example.agenda.model.Contacte;
import com.example.agenda.repository.ContacteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ContacteController {

    // === INJECCIÓ DEL DAO ===
    // Spring veu el constructor i passa una instància de ContacteRepository.
    // Tu no fas "new" mai. Aquest patró s'anomena "Inversion of Control".
    private final ContacteRepository repo;

    public ContacteController(ContacteRepository repo) {
        this.repo = repo;
    }

    // R: LLISTAR
    @GetMapping("/")
    public String llistar(Model model) {
        List<Contacte> tots = repo.findAll();           // SELECT * FROM contactes
        model.addAttribute("contactes", tots);
        return "llista";                                // -> templates/llista.html
    }

    // C: GUARDAR (alta o edició: save() decideix)
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Contacte contacte) {
        repo.save(contacte);                            // INSERT o UPDATE
        return "redirect:/";
    }

    // D: ESBORRAR
    @GetMapping("/esborrar/{id}")
    public String esborrar(@PathVariable Long id) {
        repo.deleteById(id);                            // DELETE FROM contactes WHERE id=?
        return "redirect:/";
    }

    // El Controller NO veu SQL, NO obre connexions, NO captura SQLException.
    // Tot això viu darrere del Repository (DAO) i de Hibernate (ORM).
}