package controllers;

import model.Contacts;
import model.Interests;
import model.User;
import sun.java2d.pipe.SpanShapeRenderer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet(name = "Registration", urlPatterns = {"/registration"})
public class RegistrationServlet extends HttpServlet {
    private User user;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        user = new User();

        //DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        user.setName(request.getParameter("name"));
        user.setSurname(request.getParameter("surname"));
        user.setEmail(request.getParameter("email"));

       // user.setBirthday(dateFormat.format(date));

        user.setGender(request.getParameter("gender"));
        user.setPassword(request.getParameter("password"));



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
