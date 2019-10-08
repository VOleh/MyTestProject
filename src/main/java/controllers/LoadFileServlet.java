package controllers;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.FileLoadService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@MultipartConfig
@WebServlet(urlPatterns = {"/load"})
public class LoadFileServlet extends HttpServlet {
    private FileLoadService service = new FileLoadService();
    private List<FileItem> multiFiles = null;
    private HttpSession httpSession = null;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());

        List<FileItem>  multiFiles = null;
        try {
            multiFiles = sf.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

        if(service.create(multiFiles,(Integer) request.getSession(false).getAttribute("currentId"))){
            request.getRequestDispatcher("/home").forward(request,response);
        }else{
            request.setAttribute("remark","You can't load your photo!Please try again");
            request.getRequestDispatcher("/file.jsp").forward(request,response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
