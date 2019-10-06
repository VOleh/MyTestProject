package service;

public interface CRUD <T> {
     boolean create(T t, int i);
     T read(int i);
     T update(T t, int i);
     boolean delete(T t, int i);
}
