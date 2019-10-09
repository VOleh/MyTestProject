package service;

import dao.ContactsDao;
import model.Contacts;

public class ContactsService implements CRUD <Contacts,Boolean> {
    private ContactsDao dao = new ContactsDao();
    private boolean check;


    @Override
    public Boolean create(Contacts contacts, int id) {

        return dao.add(contacts,id);
    }

    @Override
    public Contacts read(int i) {
        return null;
    }

    @Override
    public boolean update(Contacts contacts, int id) {
        return dao.update(contacts,id);
    }

    @Override
    public boolean delete(Contacts contacts, int id) {
        return false;
    }
}
