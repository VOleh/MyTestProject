package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "LoadFile",urlPatterns = "/addPhoto")
public class LoadFileServlet extends HttpServlet {
    private InputStream is;

    private Part photo;
    private InputStream inputStream;
    private String resultSet_add_userPhoto;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        photo = request.getPart("photo");
        inputStream = photo.getInputStream();

    }

}
