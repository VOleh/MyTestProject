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
    public Contacts read(int i) {
        return null;
    }

    @Override
    public Contacts update(Contacts contacts, int i) {
        return null;
    }

    @Override
    public boolean delete(Contacts contacts, int i) {
        return false;
    }
}
