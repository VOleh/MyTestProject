package dao;

import model.Contacts;
import utils.DataBaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactsDao {

    private PreparedStatement ps;

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
        return null;
    }


    public Contacts update(Contacts contacts, int id) {
        return null;
    }


    public boolean delete(Contacts contacts, int id) {
        return false;
    }

}
