package controllers;

import model.Contacts;
import service.ContactsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Contacts", urlPatterns = {"/contacts"})
public class ContactsServlet extends HttpServlet {
    private Contacts contacts;
    private ContactsService service;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        contacts =  new Contacts();
        service = new ContactsService();

        contacts.setCountry(request.getParameter("country"));
        contacts.setHomeTown(request.getParameter("town"));
        contacts.setMobilePhone(request.getParameter("phone"));

        //service.create();
    }
}
