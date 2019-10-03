package controllers;

import model.Interests;
import service.InterestsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Interests",urlPatterns = {"/interests"})
public class InterestsServlet extends HttpServlet {
    private Interests interests;
    private InterestsService service;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        interests = new Interests();
        service = new InterestsService();

        interests.setBooks(request.getParameter("books"));
        interests.setFilms(request.getParameter("films"));
        interests.setMusic(request.getParameter("musics"));
        interests.setSport(request.getParameter("sports"));

        service.add(interests);
    }
}
