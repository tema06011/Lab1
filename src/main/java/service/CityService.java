package service;

import entity.City;

import java.util.List;

public interface CityService {
     List<City> getAllCities();

     Long getCityIdbyName(String name);
}
