package dao;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import model.Contacts;
import model.Interests;
import model.Role;
import model.User;
import service.UserService;
import utils.DataBaseConnector;
import utils.MD5;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;

public class UserDao {
    private PreparedStatement ps;
    private ResultSet rs;
    private String generateId [] = {"id"};
    private int id;

    public Integer addUser(User user){
        String sql = "INSERT INTO user (name, surname, email, gender, password,role)  VALUES (?,?,?,?,?,?)";
        try {
            ps = DataBaseConnector.createConnection().prepareStatement(sql,generateId);
            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getGender());
            ps.setString(5, user.getPassword());
            ps.setString(6, user.getRole().toString());


            if(ps.executeUpdate() !=0){
                rs = ps.getGeneratedKeys();
                if (rs.next()) {
                     id = rs.getInt(1);
                }
                return id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User readUserByLoginPassword(String login,  String password){
        String sql = "SELECT  id FROM project.user WHERE email=? AND password=?";
        try {
            ps = DataBaseConnector.createConnection().prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, password);
            ResultSet rs=null;
            if(ps.execute())
                rs = ps.getResultSet();

            User user = new User();
            if(rs.next()) {
                user.setUserId(rs.getInt("id"));
            }
            return user;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean existIsUser (String login,  String password){
        String sql = "SELECT id FROM user WHERE email=? AND password=?";
        try {
            ps = DataBaseConnector.createConnection().prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, password);
            if(ps.execute())
             rs = ps.getResultSet();

            if(!rs.next())
                return false;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
/*
    public static void main(String[] args) {
        UserDao dao =  new UserDao();
        User user = dao.readUserByLoginPassword("oleh@gmail.com","332704e79a7997e4b28ae6b18fa7f220");
        System.out.println(user);
    }*/
    public static void main(String[] args) {
        UserDao dao =  new UserDao();
        System.out.println(dao.readById(15));

    }

    public User readById(int id){
        User user = new User();
        ContactsDao contactsDao = new ContactsDao();
        InterestsDao interestsDao = new InterestsDao();
        ProfileAvatarDao profileAvatarDao = new ProfileAvatarDao();

        String sql = "SELECT name, surname, email, gender FROM user  WHERE id=? ";
        try {
            ps = DataBaseConnector.createConnection().prepareStatement(sql,generateId);
            ps.setInt(1, id);
            if(ps.execute())
                    rs = ps.getResultSet();
            if (rs.next()) {
                user.setName(rs.getString("name"));
                user.setSurname(rs.getString("surname"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));

                user.setContacts(contactsDao.read(id));
                user.setInterests(interestsDao.read(id));

                user.setPhoto(profileAvatarDao.read(id));
            }
              return user;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
