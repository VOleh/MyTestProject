package service;

public interface CRUD <Type,B> {
     B create(Type t, int id);
     Type read(int i);
     boolean update(Type t, int id);
     boolean delete(Type t, int id);
}
