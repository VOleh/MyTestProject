package dao;

import model.Contacts;
import model.Interests;
import utils.DataBaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactsDao {

    private PreparedStatement ps;
    private  Contacts contacts;
    private ResultSet rs;

    public  boolean add(Contacts contacts, int id) {
        String sql = "INSERT INTO contacts (id,  country, town, phone)  VALUES (?,?,?,?)";

        try {
            ps = DataBaseConnector.createConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, contacts.getCountry());
            ps.setString(3, contacts.getHomeTown());
            ps.setString(4, contacts.getMobilePhone());

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
            contacts = new Contacts();
            if(ps.execute())
                rs = ps.getResultSet();
            if(rs.next()){
                contacts.setCountry(rs.getString("country"));
                contacts.setHomeTown(rs.getString("town"));
                contacts.setMobilePhone(rs.getString("phone"));
            }
            return  contacts;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean update(Contacts contacts, int id) {
        String sql = "UPDATE  contacts SET country=?, town=?, phone=?  WHERE id=?";

        try {
            ps = DataBaseConnector.createConnection().prepareStatement(sql);
            ps.setString(1, contacts.getCountry());
            ps.setString(2, contacts.getHomeTown());
            ps.setString(3, contacts.getMobilePhone());
            ps.setInt(4, id);

            if(ps.executeUpdate() !=0)
                return  true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean delete(Contacts contacts, int id) {
        return false;
    }

}
