package dao.impl;

import dao.UserDAO;
import entity.User;
import util.DatabaseConnection;

import java.sql.*;

public class UserDAOImpl implements UserDAO {
    private final Connection connection = DatabaseConnection.getConnection();

    public void regist(final User user){
        try {
            String querySql = "insert into user(lastname,name,surname,birthday,street,number_of_building," +
                    "phone_number,login,password,city_id)" +
                    " values (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement prstatment = connection.prepareStatement(querySql);
            prstatment.setString(1, user.getLastname());
            prstatment.setString(2, user.getName());
            prstatment.setString(3, user.getSurname());
            prstatment.setDate(4, user.getBirthday());
            prstatment.setString(5, user.getStreet());
            prstatment.setInt(6, user.getNumberOfBuilding());
            prstatment.setString(7, user.getPhoneNumber());
            prstatment.setString(8, user.getLogin());
            prstatment.setString(9, user.getPassword());
            prstatment.setLong(10, user.getCityId());
            int affectedRows = prstatment.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User login(final String login) throws SQLException {
        User user = new User();
        String querySql = "select * from user where login=? ";
        PreparedStatement prstatment = connection.prepareStatement(querySql);
        prstatment.setString(1, login);
        ResultSet rs = prstatment.executeQuery();
        while (rs.next()) {
            user.setId(rs.getLong("id"));
            user.setLastname(rs.getString("lastname"));
            user.setName(rs.getString("name"));
            user.setSurname(rs.getString("surname"));
            user.setBirthday(rs.getDate("birthday"));
            user.setCityId(rs.getLong("city_id"));
            user.setStreet(rs.getString("street"));
            user.setNumberOfBuilding(rs.getInt("number_of_building"));
            user.setPhoneNumber(rs.getString("phone_number"));
            user.setLogin(rs.getString("login"));
            user.setPassword(rs.getString("password"));
        }
        return user;
    }
}
