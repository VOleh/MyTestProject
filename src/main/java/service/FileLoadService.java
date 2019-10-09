package service;

import dao.ProfileAvatarDao;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

public class FileLoadService {
    private ProfileAvatarDao dao = new ProfileAvatarDao();
    private HttpSession httpSession;


    public boolean create( List<FileItem> multiFiles, int id) {
        try {
            for(FileItem item : multiFiles) {
                item.write(new File(System.getenv("MY_PROJECT_IMG") + item.getName()));

                if(dao.add(item.getName(),id))
                    return  true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public String read(int id) {
        return dao.read(id);
    }
}
