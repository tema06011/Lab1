package dao.impl;

import dao.CityDAO;
import entity.City;


import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CityDAOImpl implements CityDAO {
    @Override
    public List<City> getAllCities() throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM city");
        ArrayList<City> cityList = new ArrayList<>();
        while (resultSet.next()){
            City city=new City();
            city.setId(resultSet.getLong("id"));
            city.setName(resultSet.getNString("name"));
            cityList.add(city);
        }
        return cityList;
    }
}
