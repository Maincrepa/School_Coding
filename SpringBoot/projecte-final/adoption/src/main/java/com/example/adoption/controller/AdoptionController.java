package com.example.adoption.controller;

// Package
import com.example.adoption.model.Animal;
import com.example.adoption.services.AdoptionService;

// Framework
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// Handles routes, processes requests, sends to view

@Controller
public class AdoptionController {
    private final AdoptionService adoptionService;

    AdoptionController(AdoptionService adoptionService) {
        this.adoptionService = adoptionService;
    }

    @GetMapping("/")
    public String listAnimals(@RequestParam(defaultValue = "false") Boolean admin, Model model) {
        model.addAttribute("animals", adoptionService.getAllAnimals());
        model.addAttribute("admin", admin);
        return "llista";
    }

    // Declared before /animals/{id} so Spring matches "new" literally, not as a path variable
    @GetMapping("/animals/new")
    public String newAnimal(@RequestParam(defaultValue = "false") Boolean admin, Model model) {
        model.addAttribute("animal", new Animal());
        model.addAttribute("admin", admin);
        model.addAttribute("edit", true);
        model.addAttribute("isNew", true);
        return "detall";
    }

    @GetMapping("/animals/{id}")
    public String detailAnimal(@PathVariable Long id,
                               @RequestParam(defaultValue = "false") Boolean admin,
                               @RequestParam(defaultValue = "false") Boolean edit,
                               Model model) {
        Animal animal = adoptionService.findById(id).orElseThrow();
        model.addAttribute("animal", animal);
        model.addAttribute("admin", admin);
        model.addAttribute("edit", edit);
        model.addAttribute("isNew", false);
        return "detall";
    }

    @PostMapping("/animals")
    public String createAnimal(@ModelAttribute Animal animal) {
        adoptionService.save(animal);
        return "redirect:/";
    }

    @PostMapping("/animals/{id}")
    public String updateAnimal(@PathVariable Long id, @ModelAttribute Animal animal) {
        animal.setId(id);
        adoptionService.save(animal);
        return "redirect:/animals/" + id;
    }

    @PostMapping("/animals/{id}/delete")
    public String deleteAnimal(@PathVariable Long id) {
        adoptionService.delete(id);
        return "redirect:/";
    }
}