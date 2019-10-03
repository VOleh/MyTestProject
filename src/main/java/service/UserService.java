package service;



public class UserService implements CR {
    @Override
    public <User> boolean create(User u) {
        return false;
    }

    @Override
    public <User> User read(int id) {
        return null;
    }
}
