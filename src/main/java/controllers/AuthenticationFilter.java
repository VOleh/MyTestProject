package controllers;

import model.Role;
import model.User;
import service.UserService;
import utils.MD5;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.util.Objects.nonNull;

@WebFilter(urlPatterns = {"/home"})
public class AuthenticationFilter implements Filter {
    final UserService service = new UserService();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

         final HttpServletRequest request = (HttpServletRequest) servletRequest;
         final HttpServletResponse response = (HttpServletResponse) servletResponse;

        String email = request.getParameter("email");
        String password = MD5.runMD5(request.getParameter("password"));

         if (service.userIsExist(email,password)) {
             User user = service.readByLoginPassword(email, password);

             HttpSession currentSession = request.getSession(true);

             currentSession.setAttribute("currentId",user.getUserId());

             request.getRequestDispatcher("/home").forward(request,response);

        }else
             request.getRequestDispatcher("/registration.jsp").forward(request,response);
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {
    }
}
