package service;

import dao.InterestsDao;
import model.Interests;

public class InterestsService implements  CRUD <Interests,Boolean>  {
    private InterestsDao dao = new InterestsDao();

    @Override
    public Boolean create(Interests interests, int id) {
        return dao.add(interests,id);
    }

    @Override
    public Interests read(int i) {
        return null;
    }

    @Override
    public Interests update(Interests interests, int i) {
        return null;
    }

    @Override
    public boolean delete(Interests interests, int i) {
        return false;
    }
}
