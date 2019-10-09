package service;

import dao.PostDao;
import model.Post;
import org.apache.commons.fileupload.FileItem;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class PostService  {
    private PostDao dao = new PostDao();
    private int idMessage;

    public boolean addMessage(List<FileItem> multiFiles, int id) throws UnsupportedEncodingException {
        for (FileItem item : multiFiles) {

            if (item.isFormField()) {
                // Process regular form field (input type="text|radio|checkbox|etc", select, etc).
                String message = item.getString();
                idMessage = dao.addMessage(item.getString(),id);

            } else {
                try {
                    item.write(new File(System.getenv("MY_PROJECT_IMG") + item.getName()+idMessage));
                    return dao.addPhoto(item.getName(),idMessage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public List<Post> read(int id) {
        return dao.readMessage(id);
    }
}
