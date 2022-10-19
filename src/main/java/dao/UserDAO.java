package dao;

import entity.User;

import java.sql.SQLException;

public interface UserDAO {
    void regist(User user) throws SQLException;

    User login(String login) throws SQLException;
}
