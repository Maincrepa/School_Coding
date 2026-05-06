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

    private final ContacteRepository repo;

    // Spring injecta el repo automaticament
    public ContacteController(ContacteRepository repo) {
        this.repo = repo;
    }

    // ===== R: LLISTAR (amb cercador opcional) =====
    @GetMapping("/")
    public String llistar(@RequestParam(required = false) String q, Model model) {
        List<Contacte> contactes;
        if (q == null || q.isBlank()) {
            contactes = repo.findAll();                              // SELECT *
        } else {
            contactes = repo.findByNomContainingIgnoreCase(q);       // SELECT WHERE nom LIKE
        }
        model.addAttribute("contactes", contactes);
        model.addAttribute("q", q);
        return "llista";
    }

    // ===== Formulari per crear o editar =====
    @GetMapping("/nou")
    public String formNou(Model model) {
        model.addAttribute("contacte", new Contacte());
        return "formulari";
    }

    @GetMapping("/editar/{id}")
    public String formEditar(@PathVariable Long id, Model model) {
        // findById retorna Optional; aqui suposem que existeix
        Contacte c = repo.findById(id).orElseThrow();
        model.addAttribute("contacte", c);
        return "formulari";
    }

    // ===== C i U: GUARDAR (save fa INSERT o UPDATE segons hi hagi id) =====
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Contacte contacte) {
        repo.save(contacte);
        return "redirect:/";
    }

    // ===== D: ESBORRAR =====
    @GetMapping("/esborrar/{id}")
    public String esborrar(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/";
    }
}