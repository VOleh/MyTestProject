package dao;

import model.Interests;
import utils.DataBaseConnector;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InterestsDao {
    private PreparedStatement ps;

    public  boolean add(Interests interests, int id) {
        String sql = "INSERT INTO interests (id,  books, films, musics, sports)  VALUES (?,?,?,?,?)";

        try {
            ps = DataBaseConnector.createConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, interests.getBooks());
            ps.setString(3, interests.getFilms());
            ps.setString(4, interests.getMusic());
            ps.setString(5, interests.getSport());

            if(ps.executeUpdate() !=0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }



    public Interests read(int id) {

        return null;
    }


    public Interests update(Interests interests, int id) {

        return null;
    }


    public boolean delete(Interests interests, int id) {

        return false;
    }

}
