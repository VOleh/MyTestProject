package dao;

import model.User;
import service.UserService;
import utils.DataBaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;

public class UserDao {
    private PreparedStatement ps;
    private String generateId [] = {"id"};
    private int id;
    public Integer addUser(User user){
        String sql = "INSERT INTO user (name, surname, email, gender, password)  VALUES (?,?,?,?,?)";
        try {
            ps = DataBaseConnector.createConnection().prepareStatement(sql,generateId);
            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getGender());
            ps.setString(5, user.getPassword());


            if(ps.executeUpdate() !=0){
                ResultSet resultSet = ps.getGeneratedKeys();
                if (resultSet.next()) {
                     id = resultSet.getInt(1);
                }
                return id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }




    public User findUserByEmail(User user){
        String sql = "Select ";

        return null;
    }
}
