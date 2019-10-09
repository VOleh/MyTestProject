package controllers;

import dao.UserDao;
import model.Interests;
import model.User;
import service.InterestsService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "EditInterestsServlet",urlPatterns = {"/edit-interests"})

public class EditInterestsServlet extends HttpServlet {
    private InterestsService service = new InterestsService();
    private Interests interests;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        interests = new Interests();
        interests.setBooks(request.getParameter("books"));
        interests.setFilms(request.getParameter("films"));
        interests.setMusic(request.getParameter("musics"));
        interests.setSport(request.getParameter("sports"));

        System.out.println(((User)request.getSession(false).getAttribute("user")).getUserId());

        if(service.update(interests,((User)request.getSession(false).getAttribute("user")).getUserId())) {
            request.setAttribute("description","Your data successfully updated!");
            request.getRequestDispatcher("/interestsUpdate.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
