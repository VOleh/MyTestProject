package service;

public interface CRUD <Type,B> {
     B create(Type t, int id);
     Type read(int i);
     Type update(Type t, int id);
     boolean delete(Type t, int id);
}
