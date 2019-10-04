package service;

import model.User;

interface CR <U,I> {
     <U> boolean create(User u);
     <I> U read(I i);
}
