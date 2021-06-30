package dao.impl;

import dao.UserDAO;
import entity.User;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private final Connection connection = DatabaseConnection.getConnection();

    @Override
    public User login(String login, String password) throws SQLException {
        Statement statement = connection.createStatement();
        String querySql ="select lastname,name,surname,birthday,cityID,street,numberOfBuilding,phoneNumber,login, " +
                "password from user where login = ? and password = ? ";
        PreparedStatement prstatment = connection.prepareStatement(querySql);
        prstatment.setString(1,"login");
        prstatment.setString(2,"password");
       List<User>list=new ArrayList<>();
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
    public void regist(User user) throws SQLException {

        try{
            Statement statement = connection.createStatement();
       // String querySql ="insert into user values (?,?,?,?,?,?,?,?,?)";
            String querySql="insert into user(lastname,name,surname,birthday,street,number_of_building,phone_number,login,password) values (?,?,?,?,?,?,?,?,?)";
        PreparedStatement prstatment = connection.prepareStatement(querySql);
        prstatment.setString(1, user.getLastname());
        prstatment.setString(2, user.getName());
        prstatment.setString(3, user.getSurname());
        prstatment.setDate(4, user.getBirthday());
     //   prstatment.setLong(5, user.getCityID());
        prstatment.setString(5,user.getStreet());
        prstatment.setInt(6, user.getNumberOfBuilding());
        prstatment.setString(7,user.getPhoneNumber());
        prstatment.setString(8,user.getLogin());
        prstatment.setString(9,user.getPassword());
            int affectedRows = prstatment.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

        }catch(Exception e){
            e.printStackTrace();
        }


    }
}
