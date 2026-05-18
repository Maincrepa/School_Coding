package com.example.adoption.services;

// Package
import com.example.adoption.model.Animal;
import com.example.adoption.repository.AnimalRepository;

// Framework
import org.springframework.stereotype.Service;

// Java
import java.util.List;
import java.util.Optional;

// Contains business logic, called by controller

@Service
public class AdoptionService {
    private final AnimalRepository animalRepository;

    AdoptionService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public Optional<Animal> findById(Long id) {
        return animalRepository.findById(id);
    }

    public Animal save(Animal animal) {
        return animalRepository.save(animal);
    }

    public void delete(Long id) {
        animalRepository.deleteById(id);
    }
}