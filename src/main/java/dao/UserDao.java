package dao;

import model.User;
import service.UserService;
import utils.DataBaseConnector;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLOutput;

public class UserDao {
    private PreparedStatement ps;
    public boolean addUser(User u){
        String sql = "INSERT INTO user (name, surname, email, gender, password)  VALUES (?,?,?,?,?)";
        try {
            ps = DataBaseConnector.createConnection().prepareStatement(sql);
            ps.setString(1, u.getName());
            ps.setString(2, u.getSurname());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getGender());
            ps.setString(5, u.getPassword());
            System.out.println("User from dao "+u);
            if(ps.executeUpdate() !=0){return true;}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public User findUser(){
        String sql = "";

        return null;
    }
}
