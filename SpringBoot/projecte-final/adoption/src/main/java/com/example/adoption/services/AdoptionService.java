package com.example.adoption.services;

// Package
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.adoption.model.Animal;
import com.example.adoption.model.Species;
import com.example.adoption.repository.AnimalRepository;
import com.example.adoption.repository.SpeciesRepository;

// Contains business logic, called by controller

@Service
public class AdoptionService {
    private final AnimalRepository animalRepository;
    private final SpeciesRepository speciesRepository;

    AdoptionService(AnimalRepository animalRepository, SpeciesRepository speciesRepository) {
        this.animalRepository = animalRepository;
        this.speciesRepository = speciesRepository;
    }

    public List<Species> getAllSpecies() {
        try {
            return speciesRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving species list", e);
        }
    }

    public Optional<Species> findSpeciesById(Integer id) {
        try {
            return speciesRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error finding species with id: " + id, e);
        }
    }

    public List<Animal> getAllAnimals() {
        try {
            return animalRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving animal list", e);
        }
    }

    public Optional<Animal> findById(Long id) {
        try {
            return animalRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error finding animal with id: " + id, e);
        }
    }

    public Animal save(Animal animal) {
        try {
            return animalRepository.save(animal);
        } catch (Exception e) {
            throw new RuntimeException("Error saving animal", e);
        }
    }

    public void delete(Long id) {
        try {
            animalRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting animal with id: " + id, e);
        }
    }
}