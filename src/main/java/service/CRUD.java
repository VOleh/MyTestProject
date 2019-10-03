package service;

interface CRUD {
     <T,U> boolean create(T t,U u);
     <T,U> T read(U u);
     <T,U> T update(T t, U u);
     <T,U> boolean delete(T t, U u);
}
