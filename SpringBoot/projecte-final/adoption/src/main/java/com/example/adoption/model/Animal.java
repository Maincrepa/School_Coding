package com.example.adoption.model;

// Package


// Framework
import jakarta.persistence.*;

// Java
import java.time.LocalDate;

@Entity
@Table(name = "Pets")
public class Animal {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Code")
    private Long id;
    
    @Column(name = "Name")
    private String name;
    
    @Column(name = "Gender")
    private String gender;
    
    @Column(name = "BirthDate")
    private LocalDate birthDate;
    
    @Column(name = "IdSpecie")
    private Integer speciesId;
    
    @Column(name = "Adoptat")
    private Boolean adopted;
    
    @Column(name = "DataAdoptat")
    private LocalDate adoptedDate;

    // Setters
    public void setId(Long newId) { id = newId; }
    public void setName(String newName) { name = newName; }
    public void setGender(String newGender) { gender = newGender; }
    public void setBirthDate(LocalDate newBirthDate) { birthDate = newBirthDate; }
    public void setSpeciesId(Integer newSpeciesId) { speciesId = newSpeciesId; }
    public void setAdopted(Boolean newAdopted) { adopted = newAdopted; }
    public void setAdoptedDate(LocalDate newAdoptedDate) { adoptedDate = newAdoptedDate; }

    // Getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getGender() { return gender; }
    public LocalDate getBirthDate() { return birthDate; }
    public Integer getSpeciesId() { return speciesId; }
    public Boolean getAdopted() { return adopted; }
    public LocalDate getAdoptedDate() { return adoptedDate; }
}