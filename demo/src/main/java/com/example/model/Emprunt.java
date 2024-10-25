package com.example.model;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Media media;

    @ManyToOne
    private Utilisateur utilisateur;

    private LocalDate dateEmprunt;
    private LocalDate dateRetour;

    // Constructeurs
    public Emprunt() {}

    public Emprunt(Media media, Utilisateur utilisateur) {
        this.media = media;
        this.utilisateur = utilisateur;
        this.dateEmprunt = LocalDate.now();
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public LocalDate getDateEmprunt() {
        return dateEmprunt;
    }

    public LocalDate getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(LocalDate dateRetour) {
        this.dateRetour = dateRetour;
    }
}
