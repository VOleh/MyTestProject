package controllers;

import model.User;
import service.PostService;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Servlet",urlPatterns = {"/home"})
public class ProfilePageServlet extends HttpServlet {

    private UserService service = new UserService();
    private PostService postService = new PostService();
    private HttpSession oldHttpSession;
    private User user;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         oldHttpSession = request.getSession(false);

        if((Integer) oldHttpSession.getAttribute("currentId") != null) {
            user = service.readById((Integer) oldHttpSession.getAttribute("currentId"));

            HttpSession newHttpSession = request.getSession(true);
            newHttpSession.setAttribute("user", user);
            newHttpSession.setAttribute("posts", postService.read(user.getUserId()));
        }
        request.getRequestDispatcher("/main.jsp").forward(request, response);
    }
}
