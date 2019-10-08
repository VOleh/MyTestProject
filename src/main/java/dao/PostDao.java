package dao;

import model.Contacts;
import model.Post;
import utils.DataBaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostDao {
    private PreparedStatement ps;
    private String generateId [] = {"id"};
    private Post post;
    private ResultSet rs;

    public  Integer addMessage(Post post, int id) {
        String sql = "INSERT INTO post (comments, userId)  VALUES (?,?)";
        try {
            ps = DataBaseConnector.createConnection().prepareStatement(sql,generateId);
            ps.setString(1, post.getComments());
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













    public Contacts read(int id) {
        String sql = "SELECT country, town, phone FROM contacts  WHERE id=?";

        try {
            ps = DataBaseConnector.createConnection().prepareStatement(sql);
            ps.setInt(1, id);
           // contacts = new Contacts();
            if(ps.execute())
                rs = ps.getResultSet();
            if(rs.next()){

            }
            return  null;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public Contacts update(Contacts contacts, int id) {
        String sql = "UPDATE  contacts SET country=?, town=?, phone=?  WHERE id=?";

        try {
            ps = DataBaseConnector.createConnection().prepareStatement(sql);
            ps.setString(1, contacts.getCountry());
            ps.setString(2, contacts.getHomeTown());
            ps.setString(3, contacts.getMobilePhone());
            ps.setInt(4, id);

            if(ps.executeUpdate() !=0)
                return  read(id);



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean delete(Contacts contacts, int id) {
        return false;
    }

}
