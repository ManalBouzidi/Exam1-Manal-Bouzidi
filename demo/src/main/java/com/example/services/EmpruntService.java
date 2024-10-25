package com.example.services;


import com.example.model.Emprunt;
import com.example.model.Media;
import com.example.model.Utilisateur;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

@Stateless
public class EmpruntService {

    @PersistenceContext
    private EntityManager em;

    // Emprunter un média
    public Emprunt emprunterMedia(Long mediaId, Long utilisateurId) {
        Media media = em.find(Media.class, mediaId);
        Utilisateur utilisateur = em.find(Utilisateur.class, utilisateurId);

        if (media != null && utilisateur != null && media.isDisponible()) {
            Emprunt emprunt = new Emprunt(media, utilisateur);
            media.setDisponible(false); // Rendre indisponible

            em.merge(media);  // Mise à jour de la disponibilité du média
            em.persist(emprunt);

            return emprunt;
        }
        return null;
    }

    // Retourner un média
    public void retournerMedia(Long empruntId) {
        Emprunt emprunt = em.find(Emprunt.class, empruntId);
        if (emprunt != null && emprunt.getDateRetour() == null) {
            Media media = emprunt.getMedia();
            media.setDisponible(true); // Rendre disponible

            emprunt.setDateRetour(LocalDate.now());
            em.merge(media);  // Mise à jour de la disponibilité du média
            em.merge(emprunt);
        }
    }

    // Liste des emprunts
    public List<Emprunt> getAllEmprunts() {
        return em.createQuery("SELECT e FROM Emprunt e", Emprunt.class).getResultList();
    }
}

