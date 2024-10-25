package com.example;


import com.example.model.Media;
import com.example.services.MediaService;
import com.example.services.EmpruntService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/media")
public class MediaServlet extends HttpServlet {

    @EJB
    private MediaService mediaService;

    @EJB
    private EmpruntService empruntService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer la liste des médias
        List<Media> medias = mediaService.getAllMedia();
        request.setAttribute("medias", medias);
        request.getRequestDispatcher("/WEB-INF/views/mediaList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Gérer l'emprunt d'un média
        Long mediaId = Long.parseLong(request.getParameter("mediaId"));
        Long userId = Long.parseLong(request.getParameter("userId")); // exemple d'identifiant utilisateur
        empruntService.emprunterMedia(mediaId, userId);
        response.sendRedirect("media"); // Redirection vers la liste mise à jour
    }
}

