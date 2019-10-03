package dao;

import model.User;
import service.UserService;

public class UserDao {
    public boolean addUser(){
        String sql = "INSERT INTO User (name, surname, birthday, gender, password)  VALUES (?,?,?,?,?)";

        return false;
    }

    public User findUser(){
        String sql = "";

        return null;
    }
}
