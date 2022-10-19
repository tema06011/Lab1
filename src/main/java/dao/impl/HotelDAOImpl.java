package dao.impl;

import DTO.HotelDTO;
import dao.HotelDAO;
import entity.Category;
import entity.Hotel;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelDAOImpl implements HotelDAO {
    private final Connection connection = DatabaseConnection.getConnection();

    @Override
    public Hotel findHotelNameByID(final long id) throws SQLException {
        String sql = "SELECT name FROM hotel where id=?";
        PreparedStatement prstatment = connection.prepareStatement(sql);
        prstatment.setLong(1, id);
        ResultSet resultSet = prstatment.executeQuery();
        Hotel hotel = new Hotel();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            hotel.setName(name);
        }
        return hotel;
    }

    @Override
    public List<Hotel> getHotelListByCiteName(final String name) throws SQLException {
        String querySql = "SELECT * FROM hotel join city on city.id=hotel.city_id where city.name=?";
        PreparedStatement prstatment = connection.prepareStatement(querySql);
        prstatment.setString(1, name);
        ResultSet resultSet = prstatment.executeQuery();
        ArrayList<Hotel> hotelList = new ArrayList<>();
        while (resultSet.next()) {
            Hotel hotel = new Hotel();
            hotel.setId(resultSet.getLong("id"));
            hotel.setName(resultSet.getString("name"));
            hotel.setStarAmount(resultSet.getInt("star_amount"));
            hotel.setCityId(resultSet.getLong("city_id"));
            hotel.setStreet(resultSet.getString("street"));
            hotel.setNumberOfBuilding(resultSet.getInt("number_of_building"));
            hotel.setPhoneNumber(resultSet.getString("phone_number"));
            hotel.setPhoto(resultSet.getString("photo"));
            hotel.setAbout(resultSet.getString("about"));
            hotelList.add(hotel);
        }
        return hotelList;
    }

    @Override
    public HotelDTO findHotelbyId(final long id) throws SQLException {
        String querySql = "SELECT hotel.name as hotelName, city.name as cityName," +
                "star_amount,street,number_of_building,phone_number,photo,about " +
                "FROM hotel join city on city.id=hotel.city_id" +
                " where hotel.id=?";
        PreparedStatement prstatment = connection.prepareStatement(querySql);
        prstatment.setLong(1, id);
        ResultSet resultSet = prstatment.executeQuery();
        HotelDTO hotelDTO = new HotelDTO();
        while (resultSet.next()) {
            hotelDTO.setHotelName(resultSet.getString("hotelName"));
            hotelDTO.setStarAmount(resultSet.getInt("star_amount"));
            hotelDTO.setCityName(resultSet.getString("cityName"));
            hotelDTO.setStreet(resultSet.getString("street"));
            hotelDTO.setNumberOfBuilding(resultSet.getInt("number_of_building"));
            hotelDTO.setPhoneNumber(resultSet.getString("phone_number"));
            hotelDTO.setPhoto(resultSet.getString("photo"));
            hotelDTO.setAbout(resultSet.getString("about"));
        }
        return hotelDTO;
    }

    @Override
    public List<Hotel> getAllHotels() throws SQLException {
        String querySql = "SELECT * from hotel";
        PreparedStatement prstatment = connection.prepareStatement(querySql);
        ResultSet resultSet = prstatment.executeQuery();
        ArrayList<Hotel> allHotelsList = new ArrayList<>();
        while (resultSet.next()) {
            Hotel hotel = new Hotel();
            hotel.setId(resultSet.getLong("id"));
            hotel.setName(resultSet.getString("name"));
            hotel.setStarAmount(resultSet.getInt("star_amount"));
            hotel.setAbout(resultSet.getString("about"));
            hotel.setPhoto(resultSet.getString("photo"));
            allHotelsList.add(hotel);
        }
        return allHotelsList;
    }

    @Override
    public void addOwnObject(final Hotel hotel) throws SQLException {
        String querySql = "insert into hotel(name,star_amount,street,number_of_building,phone_number,city_id,photo,about) " +
                "values(?,?,?,?,?,?,?,?)";
        PreparedStatement prstatment = connection.prepareStatement(querySql);
        prstatment.setString(1, hotel.getName());
        prstatment.setInt(2, hotel.getStarAmount());
        prstatment.setString(3, hotel.getStreet());
        prstatment.setInt(4, hotel.getNumberOfBuilding());
        prstatment.setString(5, hotel.getPhoneNumber());
        prstatment.setLong(6, hotel.getCityId());
        prstatment.setString(7, hotel.getPhoto());
        prstatment.setString(8, hotel.getAbout());
        int affectedRows = prstatment.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("Creating booking failed, no rows affected.");
        }
    }

    @Override
    public List<Category> getCategoryList() throws SQLException {
        String querySql = "SELECT * from category";
        PreparedStatement prstatment = connection.prepareStatement(querySql);
        ResultSet resultSet = prstatment.executeQuery();
        ArrayList<Category> categoryArrayList = new ArrayList<>();
        while (resultSet.next()) {
            Category category = new Category();
            category.setName(resultSet.getString("name"));
            category.setId(resultSet.getLong("id"));
            categoryArrayList.add(category);
        }
        return categoryArrayList;
    }

    @Override
    public long getHotelIdbyHotelName(final String name) throws SQLException {
        String querySql = "SELECT id from hotel where name=?";
        PreparedStatement prstatment = connection.prepareStatement(querySql);
        prstatment.setString(1, name);
        ResultSet resultSet = prstatment.executeQuery();
        long id = 0;
        while (resultSet.next()) {
            id = resultSet.getLong("id");
        }
        return id;
    }
}



