package service.impl;

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import entity.User;
import service.UserService;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
   private final UserDAO userDAO=new UserDAOImpl();
    @Override
    public void regist(final User user) {
        try {
            userDAO.regist(user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public User login(final String login) {
        User result=null;
        try {
            result=userDAO.login(login);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
}
