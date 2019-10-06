package service;

public interface CR <User> {

     int create(User u);

      User readById(int id);

      User readByLoginPassword(String login, String password);

      boolean userIsExist(String login, String password);
}
