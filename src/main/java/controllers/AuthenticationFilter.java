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

@WebFilter("/home")
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

         final HttpServletRequest request = (HttpServletRequest) servletRequest;
         final HttpServletResponse response = (HttpServletResponse) servletResponse;

        final HttpSession session = request.getSession(false);

        if (nonNull(session) && nonNull(session.getAttribute("user"))){
            Role role = ((User)(session.getAttribute("user"))).getRole();
                moveToMenu(request,response,role);
            filterChain.doFilter(request,response);
        }else if (nonNull(session.getAttribute("currentId"))) {
            moveToMenu(request, response, Role.valueOf((String) session.getAttribute("role")));
            filterChain.doFilter(request,response);
        }else
            moveToMenu(request,response,Role.UNKNOWN);
    }
    private static void moveToMenu (HttpServletRequest request,HttpServletResponse response, Role role) throws ServletException, IOException {
        if(role.equals(Role.USER)){
            request.getRequestDispatcher("/home").forward(request,response);

        } else  request.getRequestDispatcher("/").forward(request,response);
    }

    @Override
    public void destroy() {
    }
}
