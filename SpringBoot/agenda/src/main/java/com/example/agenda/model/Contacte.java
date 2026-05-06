package com.example.agenda.model;

// src/main/java/com/exemple/agenda/model/Contacte.java

import jakarta.persistence.*;

// @Entity -> "Aquesta classe representa una FILA de la taula contactes".
//            Aqui es on l'ORM (Hibernate) entra en escena.
@Entity                           // <-- ORM: Hibernate gestiona aquesta classe
@Table(name = "contactes")        // <-- nom exacte de la taula a Workbench
public class Contacte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nom;

    @Column(length = 15)
    private String telefon;

    @Column(length = 100)
    private String email;

    public Contacte() {}    // OBLIGATORI per a JPA

    public Contacte(String nom, String telefon, String email) {
        this.nom = nom;
        this.telefon = telefon;
        this.email = email;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getTelefon() { return telefon; }
    public void setTelefon(String telefon) { this.telefon = telefon; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}