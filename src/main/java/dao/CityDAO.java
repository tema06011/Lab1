package dao;

import entity.City;

import java.sql.SQLException;
import java.util.List;

public interface CityDAO {
    List<City> getAllCities() throws SQLException;

    Long getCityIdbyName(String name) throws SQLException;

}
