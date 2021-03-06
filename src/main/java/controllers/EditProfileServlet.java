package controllers;

import model.Contacts;
import model.User;
import service.ContactsService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProfileEditServlet" ,urlPatterns = {"/edit-profile"})
public class EditProfileServlet extends HttpServlet {
    private ContactsService service = new ContactsService();
    private Contacts contacts;
    private UserService userService;
    private User user;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        contacts = new Contacts();
        contacts.setCountry(request.getParameter("country"));
        contacts.setHomeTown(request.getParameter("homeTown"));
        contacts.setMobilePhone(request.getParameter("mobilePhone"));

        if(service.update(contacts,((User)request.getSession().getAttribute("user")).getUserId()))
            request.setAttribute("description","Your data successfully updated!");
            request.getRequestDispatcher("/home").forward(request,response);
    }
}
