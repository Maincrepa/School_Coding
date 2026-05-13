package com.example.adoption.model;

// Package


// Framework
import jakarta.persistence.*;

// Java


// Entity classes mapped to database tables

@Entity
@Table(name = "animals")
public class Animal {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String species;
    

    // Setters
    public void setId(Long newId) { id = newId; }
    public void setName(String newName) { name = newName; }
    public void setSpecies(String newSpecies) { species = newSpecies; }

    // Getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getSpecies() { return species; }
}