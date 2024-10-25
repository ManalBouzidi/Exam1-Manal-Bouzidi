package com.example.services;


import com.example.model.Media;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class MediaService {

    @PersistenceContext
    private EntityManager em;

    // Obtenir tous les médias
    public List<Media> getAllMedia() {
        return em.createQuery("SELECT m FROM Media m", Media.class).getResultList();
    }

    // Créer un nouveau média
    public Media createMedia(String titre, String type) {
        Media media = new Media(titre, type);
        em.persist(media);
        return media;
    }

    // Mettre à jour un média
    public Media updateMedia(Media media) {
        return em.merge(media);
    }

    // Supprimer un média
    public void deleteMedia(Long id) {
        Media media = em.find(Media.class, id);
        if (media != null) {
            em.remove(media);
        }
    }
}

