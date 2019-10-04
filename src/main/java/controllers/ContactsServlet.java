package controllers;

import model.Contacts;
import model.User;
import service.ContactsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Contacts", urlPatterns = {"/contacts"})
public class ContactsServlet extends HttpServlet {
    private Contacts contacts;
    private ContactsService service;
    private HttpSession session;
    private boolean check;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        contacts =  new Contacts();
        service = new ContactsService();
        session = request.getSession(false);

        contacts.setCountry(request.getParameter("country"));
        contacts.setHomeTown(request.getParameter("town"));
        contacts.setMobilePhone(request.getParameter("phone"));

        check = service.create(contacts, (Integer) session.getAttribute("id"));

        if(check){
            response.sendRedirect("/interests.jsp");
        }else{
            request.setAttribute("remark","Some problem!!");
            request.getRequestDispatcher("/contacts");
        }
    }
}
