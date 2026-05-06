package com.example.agenda.model;

// src/main/java/com/exemple/agenda/model/Contacte.java

import jakarta.persistence.*;

// @Entity -> "Aquesta classe representa una FILA de la taula contactes".
//            Aqui es on l'ORM (Hibernate) entra en escena.
@Entity
@Table(name = "contactes")    // nom EXACTE de la taula a MySQL
public class Contacte {

    // @Id              -> aquest camp és la PRIMARY KEY
    // @GeneratedValue  -> AUTO_INCREMENT: el genera MySQL
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Column lliga el camp Java amb la columna SQL.
    // (Si el nom coincideix, no cal posar-lo.)
    @Column(name = "nom", nullable = false, length = 50)
    private String nom;

    @Column(name = "telefon", length = 15)
    private String telefon;

    @Column(name = "email", length = 100)
    private String email;

    // === Constructor BUIT obligatori per a JPA ===
    // Hibernate crea l'objecte amb reflexió i després omple els camps.
    public Contacte() {}

    public Contacte(String nom, String telefon, String email) {
        this.nom = nom;
        this.telefon = telefon;
        this.email = email;
    }

    // Getters i Setters
    public Long getId()             { return id; }
    public void setId(Long id)      { this.id = id; }
    public String getNom()          { return nom; }
    public void setNom(String n)    { this.nom = n; }
    public String getTelefon()      { return telefon; }
    public void setTelefon(String t){ this.telefon = t; }
    public String getEmail()        { return email; }
    public void setEmail(String e)  { this.email = e; }
}