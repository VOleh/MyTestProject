package service;


import dao.UserDao;
import model.User;

public class  UserService   implements CR <User>  {
    private UserDao dao = new UserDao();
    private boolean check;

    @Override
    public int create(User user) {
        return dao.addUser(user);
    }

    @Override
    public User read(int i) {
        return null;
    }

    public User readByEmail() {
        return null;
    }
}
