package com.example.agenda.repository;

import com.example.agenda.model.Contacte;
import org.springframework.data.jpa.repository.JpaRepository;

// src/main/java/com/exemple/agenda/repository/ContacteRepository.java

import java.util.List;

// Una sola interface i ja tenim CRUD complet:
//   findAll(), findById(id), save(c), deleteById(id), count()
public interface ContacteRepository extends JpaRepository<Contacte, Long> {

    // Query personalitzada: cercar per nom (LIKE, sense distingir majus/minus)
    // Spring genera el SQL només mirant el nom del mètode.
    List<Contacte> findByNomContainingIgnoreCase(String fragment);
}