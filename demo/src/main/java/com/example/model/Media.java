package com.example.model;

import javax.persistence.*;


@Entity
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private String type;  // "CD" ou "DVD"
    private boolean disponible = true;

    // Constructeurs
    public Media() {}

    public Media(String titre, String type) {
        this.titre = titre;
        this.type = type;
        this.disponible = true;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}

