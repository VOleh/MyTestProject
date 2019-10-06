package service;


import dao.UserDao;
import model.User;

public class  UserService   implements CR <User>  {
    private final UserDao dao = new UserDao();

    @Override
    public int create(User user) {
        return dao.addUser(user);
    }

    @Override
    public User readById(int id) {
        return dao.readById(id);
    }

    @Override
    public User readByLoginPassword(String login, String password) {
        return dao.readUserByLoginPassword(login,password);
    }

    @Override
    public boolean userIsExist(String login, String password) {
        return dao.existIsUser(login,password);
    }
}
