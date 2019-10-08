package controllers;

import model.Post;
import model.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.FileLoadService;
import service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Post",urlPatterns = {"/post"})
public class PostServlet extends HttpServlet {
    private FileLoadService fileService = new FileLoadService();
    private PostService service = new PostService();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("message"));
        ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
        List<FileItem> multiFiles = null;
        Post post =null;
        int id =1;//((User) request.getSession(false).getAttribute("user")).getUserId();
        System.out.println("user id: "+id);
        try {
            multiFiles = sf.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        post = new Post();
        post.setComments(request.getParameter("message"));
        System.out.println(post);
        int messageId = service.addMessage(post,id);
        System.out.println("message id : "+messageId);
        if (messageId != 0) {
            if(fileService.create(multiFiles,messageId))
                for(FileItem fileItem:multiFiles){
                    service.addPhoto(fileItem.getName(),messageId);
                }
            request.getRequestDispatcher("/home").forward(request,response);
        }else{
            response.sendRedirect("/home");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
