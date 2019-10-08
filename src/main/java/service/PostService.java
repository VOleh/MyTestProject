package service;

import dao.PostDao;
import model.Post;

public class PostService  {
    private PostDao dao = new PostDao();

    public int addMessage(Post post, int id) {
        return dao.addMessage(post,id);
    }
    public boolean addPhoto (String url,int id){
        return dao.addPhoto(url,id);
    }


}
