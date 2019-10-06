package controllers;

import model.Contacts;
import model.Interests;
import model.Role;
import model.User;
import service.UserService;
import sun.java2d.pipe.SpanShapeRenderer;
import utils.MD5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet(name = "Registration", urlPatterns = {"/registration"})
public class RegistrationServlet extends HttpServlet {
    private User user = new User();
    private UserService service = new UserService();
    private HttpSession session;
    private int userId;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        user.setName(request.getParameter("name"));
        user.setSurname(request.getParameter("surname"));
        user.setEmail(request.getParameter("email"));
        user.setBirthday(request.getParameter("date"));
        user.setGender(request.getParameter("gender"));
        user.setPassword(MD5.runMD5(request.getParameter("password")));
        user.setRole(Role.valueOf(request.getParameter("role")));

        userId = service.create(user);

        session = request.getSession(true);
        session.setAttribute("id",userId);

        response.sendRedirect("/contacts.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
