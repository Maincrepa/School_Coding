package com.example.adoption.controller;

// Package


// Framework
import com.example.adoption.repository.AnimalRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// Java



// Handles routes, processes requests, sends to view

@Controller
public class AdoptionController {
    private final AnimalRepository animalRepository;

    AdoptionController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @GetMapping("/")
    public String listAnimals(Model model) {
        model.addAttribute("animals", animalRepository.findAll());
        return "llista";  // src\main\resources\templates\llista.html
    }
}