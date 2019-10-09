package dao;

import model.Contacts;
import model.Post;
import utils.DataBaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PostDao {


    private PreparedStatement ps;
    private String generateId [] = {"id"};
    private ResultSet rs;
    private List<Post>list;

    public  Integer addMessage(String s, int id) {
        String sql = "INSERT INTO post (comments, userId)  VALUES (?,?)";
        try {
            ps = DataBaseConnector.createConnection().prepareStatement(sql,generateId);
            ps.setString(1, s);
            ps.setInt(2,id);

            if(ps.executeUpdate() !=0){
                rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    return  rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean addPhoto(String url, int id) {
        String sql = "INSERT INTO photo (url, postId)  VALUES (?,?)";
        try {
            ps = DataBaseConnector.createConnection().prepareStatement(sql);
            ps.setString(1, url);
            ps.setInt(2, id);

            if(ps.executeUpdate() !=0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Post> readMessage(int id) {
      String sql=" SELECT user.name, user.surname, post.comments,post.created, photo.url FROM user  " +
              "Inner JOIN post ON user.id = post.userId   INNER JOIN photo ON  photo.postId =post.id where user.id=?";

        try {
            ps = DataBaseConnector.createConnection().prepareStatement(sql);
            ps.setInt(1, id);
            if(ps.execute()){
                rs = ps.getResultSet();
            }
            list = new ArrayList<>();
            while(rs.next()){
                list.add(new Post(rs.getString("name"),rs.getString("comments"),
                        rs.getString("url"),rs.getString("created")));
            }
            return  list;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}









