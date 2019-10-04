package service;

import dao.InterestsDao;
import model.Interests;

public class InterestsService implements  CRUD <Interests>  {
    private InterestsDao dao = new InterestsDao();

    @Override
    public boolean create(Interests interests, int id) {
        return dao.add(interests,id);
    }

    @Override
    public Interests read(Integer i) {
        return null;
    }

    @Override
    public Interests update(Interests interests, Integer i) {
        return null;
    }

    @Override
    public boolean delete(Interests interests, Integer i) {
        return false;
    }
}
