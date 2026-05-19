package com.example.adoption.repository;

// Package
import com.example.adoption.model.Species;

// Framework
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeciesRepository extends JpaRepository<Species, Integer> {


}