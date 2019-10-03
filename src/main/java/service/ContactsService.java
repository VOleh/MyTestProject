package service;

import model.Contacts;
import model.User;

public class ContactsService implements CRUD{
    @Override
    public <Contacts,User> boolean create(Contacts t,User u) {
        return false;
    }

    @Override
    public <Contacts, User> Contacts read(User u) {
        return null;
    }

    @Override
    public <Contacts,User> Contacts update(Contacts t, User u) {
        return null;
    }

    @Override
    public <Contacts,User> boolean delete(Contacts t, User u) {
        return false;
    }
}
