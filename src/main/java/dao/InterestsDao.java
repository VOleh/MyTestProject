package dao;

import model.Interests;
import utils.DataBaseConnector;

import javax.servlet.http.Part;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InterestsDao {
    private PreparedStatement ps;
    private ResultSet rs;
    private Interests interests;

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
        String sql = "SELECT books, films, musics, sports FROM interests  WHERE id=?";

        try {
            ps = DataBaseConnector.createConnection().prepareStatement(sql);
            ps.setInt(1, id);
            interests = new Interests();
            if(ps.execute())
                rs = ps.getResultSet();
                if(rs.next()){
                    interests.setBooks(rs.getString("books"));
                    interests.setFilms(rs.getString("films"));
                    interests.setMusic(rs.getString("musics"));
                    interests.setSport(rs.getString("sports"));
                }
                return  interests;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        InterestsDao dao = new InterestsDao();
        System.out.println(dao.update(new Interests(),1));
    }

    public Interests update(Interests interests, int id) {
        String sql = "UPDATE  interests SET books=?, films=?, musics=?, sports=?  WHERE id=?";

        try {
            ps = DataBaseConnector.createConnection().prepareStatement(sql);
            ps.setString(1, interests.getBooks());
            ps.setString(2, interests.getFilms());
            ps.setString(3, interests.getMusic());
            ps.setString(4, interests.getSport());
            ps.setInt(5, id);

            if(ps.executeUpdate() !=0)
                return  read(id);



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean delete(Interests interests, int id) {
        return false;
    }

}
