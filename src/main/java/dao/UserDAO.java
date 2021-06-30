package dao;

import entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    public User login(String username, String password) throws SQLException;
    public  void regist(User user) throws SQLException;
}