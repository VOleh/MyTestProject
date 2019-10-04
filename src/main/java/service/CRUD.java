package service;

public interface CRUD <T> {
     boolean create(T t, int i);
     T read(Integer i);
     T update(T t, Integer i);
     boolean delete(T t, Integer i);
}
