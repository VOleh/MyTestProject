package service;

import dao.ContactsDao;
import model.Contacts;

public class ContactsService implements CRUD <Contacts> {
    private ContactsDao dao = new ContactsDao();
    private boolean check;


    @Override
    public boolean create(Contacts contacts, int id) {
        return dao.add(contacts,id);
    }

    @Override
    public Contacts read(Integer i) {
        return null;
    }

    @Override
    public Contacts update(Contacts contacts, Integer i) {
        return null;
    }

    @Override
    public boolean delete(Contacts contacts, Integer i) {
        return false;
    }
}
