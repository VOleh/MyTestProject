package service;

 interface CR {
     <U> boolean create(U u);
     <T> T read(int id);
}
