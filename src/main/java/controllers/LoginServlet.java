package controllers;

import model.User;
import service.UserService;
import utils.MD5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Login",urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    private  UserService service = new UserService();
    private HttpSession session ;
    private String email;
    private String password;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        email = request.getParameter("email");
        password = MD5.runMD5( request.getParameter("password"));

            if (service.userIsExist(email,password)) {
                User user = service.readByLoginPassword(email, MD5.runMD5( request.getParameter("password")));
                System.out.println(user);
                session = request.getSession(true);
                session.setAttribute("currentId",user.getUserId());
                session.setAttribute("role",user.getRole());
                request.getRequestDispatcher("/home").forward(request,response);
            }else{
                request.setAttribute("remark","You input invalid data.Please check your login and password!");
                request.getRequestDispatcher("/").forward(request,response);
            }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
