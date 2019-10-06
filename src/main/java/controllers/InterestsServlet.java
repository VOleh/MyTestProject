package controllers;

import model.Interests;
import service.InterestsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Interests",urlPatterns = {"/interests"})
public class InterestsServlet extends HttpServlet {
    private Interests interests;
    private InterestsService service;
    private HttpSession session;
    private boolean check;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        interests = new Interests();
        service = new InterestsService();
        session = request.getSession(false);

        interests.setBooks(request.getParameter("books"));
        interests.setFilms(request.getParameter("films"));
        interests.setMusic(request.getParameter("musics"));
        interests.setSport(request.getParameter("sports"));

        check = service.create(interests, (Integer) session.getAttribute("id"));
        if(check){
            response.sendRedirect("/");
        }else{
            request.setAttribute("remark","Some problem!!");
            request.getRequestDispatcher("/interests");
        }
    }
}
