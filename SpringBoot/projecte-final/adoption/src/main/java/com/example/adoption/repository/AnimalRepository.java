package com.example.adoption.repository;

// Package
import com.example.adoption.model.Animal;

// Framework
import org.springframework.data.jpa.repository.JpaRepository;

// Java
import java.util.List;


// Interface for database queries

public interface AnimalRepository extends JpaRepository<Animal, Long> {
    List<Animal> findBySpeciesId(Integer speciesId);
}