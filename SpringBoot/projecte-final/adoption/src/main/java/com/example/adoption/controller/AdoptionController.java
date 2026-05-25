package com.example.adoption.controller;

// Package
import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.Period;
import java.util.NoSuchElementException;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.adoption.model.Animal;
import com.example.adoption.services.AdoptionService;

// Handles routes, processes requests, sends to view

@Controller
public class AdoptionController {
    private final AdoptionService adoptionService;

    AdoptionController(AdoptionService adoptionService) {
        this.adoptionService = adoptionService;
    }

    @GetMapping("/")
    public String listAnimals(@RequestParam(defaultValue = "false") Boolean admin, Model model) {
        try {
            model.addAttribute("animals", adoptionService.getAllAnimals());
            model.addAttribute("admin", admin);
            return "llista";
        } catch (Exception e) {
            model.addAttribute("error", "Could not load animals: " + e.getMessage());
            return "llista";
        }
    }

    // Declared before /animals/{id} so Spring matches "new" literally, not as a path variable
    @GetMapping("/animals/new")
    public String newAnimal(@RequestParam(defaultValue = "false") Boolean admin, Model model) {
        model.addAttribute("species", adoptionService.getAllSpecies());
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
        try {
            Animal animal = adoptionService.findById(id).orElseThrow();
            if (animal.getBirthDate() != null) {
                model.addAttribute("ageYears", Period.between(animal.getBirthDate(), LocalDate.now()).getYears());
            }
            model.addAttribute("species", adoptionService.getAllSpecies());
            model.addAttribute("animal", animal);
            model.addAttribute("admin", admin);
            model.addAttribute("edit", edit);
            model.addAttribute("isNew", false);
            return "detall";
        } catch (NoSuchElementException e) {
            return "redirect:/";
        } catch (Exception e) {
            model.addAttribute("error", "Could not load animal: " + e.getMessage());
            return "redirect:/";
        }
    }

    @PostMapping("/animals/{id}/adopt")
    public String adoptAnimal(@PathVariable Long id) {
        try {
            Animal animal = adoptionService.findById(id).orElseThrow();
            animal.setAdopted(true);
            animal.setAdoptedDate(LocalDate.now());
            adoptionService.save(animal);
            return "redirect:/animals/" + id;
        } catch (NoSuchElementException e) {
            return "redirect:/";
        } catch (Exception e) {
            return "redirect:/";
        }
    }

    @PostMapping("/animals")
    public String createAnimal(@ModelAttribute Animal animal, 
                            BindingResult result, Model model) {
        // Resolve the Species entity first so @NotNull on species is satisfied before save
        if (animal.getSpeciesId() != null) {
            adoptionService.findSpeciesById(animal.getSpeciesId()).ifPresent(animal::setSpecies);
        }
        if (animal.getSpecies() == null) {
            result.rejectValue("speciesId", "required", "Species is required");
        }
        if (result.hasErrors()) {
            model.addAttribute("species", adoptionService.getAllSpecies());
            model.addAttribute("admin", true);
            model.addAttribute("isNew", true);
            return "detall";
        }
        try {
            adoptionService.save(animal);
        } catch (Exception e) {
            model.addAttribute("species", adoptionService.getAllSpecies());
            model.addAttribute("admin", true);
            model.addAttribute("isNew", true);
            return "detall";
        }
        return "redirect:/";
    }

    @PostMapping("/animals/{id}")
    public String updateAnimal(@PathVariable Long id, @ModelAttribute Animal animal) {
        try {
            animal.setId(id);
            if (animal.getSpeciesId() != null) {
                adoptionService.findSpeciesById(animal.getSpeciesId()).ifPresent(animal::setSpecies);
            }
            adoptionService.save(animal);
            return "redirect:/animals/" + id;
        } catch (Exception e) {
            return "redirect:/";
        }
    }

    @PostMapping("/animals/{id}/delete")
    public String deleteAnimal(@PathVariable Long id) {
        try {
            adoptionService.delete(id);
        } catch (Exception e) {
            return "redirect:/";
        }
        return "redirect:/";
    }


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Convert empty strings to null so optional ENUM columns (HealthStatus, Size, etc.)
        // receive null instead of "", which MySQL rejects as an invalid ENUM value
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
        binder.registerCustomEditor(Integer.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                if (text == null || text.trim().isEmpty()) {
                    // Leave as null for @NotNull to catch
                    setValue(null);
                } else {
                    try {
                        setValue(Integer.parseInt(text.trim()));
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Invalid species ID: " + text);
                    }
                }
            }
        });
    }
}