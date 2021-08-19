package dao;

import entity.User;

import java.sql.SQLException;

public interface UserDAO {
    public void regist(User user) throws SQLException;

    public User login(String login) throws SQLException;
}
