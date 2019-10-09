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
        String password = request.getParameter("password");


        final HttpSession session = request.getSession(true);

        if (nonNull(session) && nonNull(session.getAttribute("currentId"))
                && nonNull(session.getAttribute("user"))){
            Role role = ((User)(request.getSession(false).getAttribute("user"))).getRole();
                moveToMenu(request,response,role);

        }else
         if (service.userIsExist(email,password)) {
             User user = service.readByLoginPassword(email, password);
             session.setAttribute("currentId",user.getUserId());
             session.setAttribute("role",user.getRole());

             moveToMenu(request,response,user.getRole());

        }else
             moveToMenu(request,response,Role.UNKNOWN);

    }
    private static void moveToMenu (HttpServletRequest request,HttpServletResponse response, Role role) throws ServletException, IOException {
        if(role.equals(Role.USER)){
            request.getRequestDispatcher("/main").forward(request,response);

        }

        else
            if(role.equals(Role.UNKNOWN))
                request.getRequestDispatcher("/registration.jsp").forward(request,response);
            else
                request.getRequestDispatcher("/").forward(request,response);
    }

    @Override
    public void destroy() {
    }
}
