package com.example.model;


import javax.persistence.*;

@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String email;

    // Constructeurs
    public Utilisateur() {}

    public Utilisateur(String nom, String email) {
        this.nom = nom;
        this.email = email;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
