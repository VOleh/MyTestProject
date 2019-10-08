package dao;

import model.Contacts;
import org.apache.commons.fileupload.FileItem;
import utils.DataBaseConnector;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ProfileAvatarDao {

    private PreparedStatement ps;
    private ResultSet rs;

    public boolean add(String url, int id) {
        String sql = "INSERT INTO useravatars (url, userId)  VALUES (?,?)";
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


    public String read(int id) {
        String sql = "SELECT url FROM useravatars  WHERE userId=?  order by useravatars.create desc  LIMIT 1";

        try {
            ps = DataBaseConnector.createConnection().prepareStatement(sql);
            ps.setInt(1, id);
            if(ps.execute())
                rs = ps.getResultSet();
            if(rs.next())
                return rs.getString("url");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        ProfileAvatarDao dao = new ProfileAvatarDao();
        System.out.println(dao.read(4));
    }

    public boolean delete(String url, int id) {
        String sql = "DELETE FROM useravatars  WHERE id=? AND url=? ";
        String result =null;
        try {
            ps = DataBaseConnector.createConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2,url);
            if(ps.execute())
                return  true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
