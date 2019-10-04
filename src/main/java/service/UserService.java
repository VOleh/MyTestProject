package service;


import dao.UserDao;
import model.User;

public class  UserService<U,I> implements CR <U,I> {
    private UserDao dao = new UserDao();

    @Override
    public  boolean create(User u) {
        dao.addUser(u);
        return false;
    }

    @Override
    public <I> U read(I i) {
        return null;
    }
}
