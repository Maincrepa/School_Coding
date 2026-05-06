package com.example.agenda.repository;

import com.example.agenda.model.Contacte;
import org.springframework.data.jpa.repository.JpaRepository;

// src/main/java/com/exemple/agenda/repository/ContacteRepository.java

import java.util.List;

// AIXÒ ÉS UN INTERFACE (no una classe!)
// JpaRepository<Contacte, Long> ens regala TOT això sense escriure res:
//
//   findAll()         ->  SELECT * FROM contactes
//   findById(id)      ->  SELECT * FROM contactes WHERE id = ?
//   save(c)           ->  INSERT (si id == null) o UPDATE (si id ja existeix)
//   deleteById(id)    ->  DELETE FROM contactes WHERE id = ?
//   count()           ->  SELECT COUNT(*) FROM contactes
//   existsById(id)    ->  SELECT 1 ... WHERE id = ?
//
// Spring crea automàticament una classe que implementa aquesta interface.
// El que en patrons clàssics s'anomenaria ContacteDAOImpl.
public interface ContacteRepository extends JpaRepository<Contacte, Long> {
    //                                          ^^^^^^^^   ^^^^
    //                                          Entity     tipus de l'@Id

    // === QUERIES PERSONALITZADES ===
    // Spring les implementa sola a partir del NOM del mètode:

    // SELECT * FROM contactes WHERE nom LIKE '%fragment%'  (case-insensitive)
    List<Contacte> findByNomContainingIgnoreCase(String fragment);

    // SELECT * FROM contactes WHERE email = ?
    Contacte findByEmail(String email);

    // SELECT * FROM contactes ORDER BY nom ASC
    List<Contacte> findAllByOrderByNomAsc();
}