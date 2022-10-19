package service.impl;

import dao.CityDAO;
import dao.impl.CityDAOImpl;
import entity.City;
import service.CityService;

import java.sql.SQLException;
import java.util.List;

public class CityServiceImpl implements CityService {
    private CityDAO cityDAO=new CityDAOImpl();
    @Override
    public List<City> getAllCities() {
        List<City> result=null;
        try {
            result= cityDAO.getAllCities();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public Long getCityIdbyName(final String name) {
        Long result=null;
        try {
            result = cityDAO.getCityIdbyName(name);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
}
