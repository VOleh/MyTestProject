package service;

import model.Interests;
import model.User;

public class InterestsService implements CRUD {


    @Override
    public <Interests, User> boolean create(Interests t, User u) {
        return false;
    }

    @Override
    public <Interests, User> Interests read(User u) {
        return null;
    }

    @Override
    public <Interests,User> Interests update(Interests t, User u) {
        return null;
    }

    @Override
    public <Interests,User> boolean delete(Interests t, User u) {
        return false;
    }
}
