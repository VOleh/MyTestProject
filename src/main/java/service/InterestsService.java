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
    public boolean update(Interests interests, int id) {
        return dao.update(interests,id);
    }

    @Override
    public boolean delete(Interests interests, int id) {
        return false;
    }
}
