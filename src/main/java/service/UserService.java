package service;

import entity.User;

public interface UserService {
     void regist(User user);

     User login(String login);
}
