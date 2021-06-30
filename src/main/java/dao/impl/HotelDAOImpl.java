package dao.impl;

import DTO.HotelDTO;
import dao.HotelDAO;
import entity.Hotel;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelDAOImpl implements HotelDAO {
    private final Connection connection = DatabaseConnection.getConnection();

    @Override
    public Hotel findByID(long id) throws SQLException {

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
    public List<Hotel> hotelList(String name) throws SQLException {
        Statement statement = connection.createStatement();
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
            hotel.setCityID(resultSet.getLong("city_id"));
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
    public HotelDTO idHotels(long id) throws SQLException {
        Statement statement = connection.createStatement();
        String querySql = "SELECT hotel.name as hotelName, city.name as cityName," +
                "star_amount,street,number_of_building,phone_number,photo,about " +
                "FROM hotel join city on city.id=hotel.city_id where hotel.id=?";
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
    public Hotel getCoordination(long id) throws SQLException {
        Statement statement = connection.createStatement();
        String querySql = "SELECT lenght,width FROM hotel where hotel.id=? ";
        PreparedStatement prstatment = connection.prepareStatement(querySql);
        prstatment.setLong(1, id);
        ResultSet resultSet = prstatment.executeQuery();
        Hotel hotelCoordinats=new Hotel();
        while (resultSet.next()) {
            hotelCoordinats.setLength(resultSet.getFloat("lenght"));
            hotelCoordinats.setWidth(resultSet.getFloat("width"));
        }
        return hotelCoordinats;
    }

}



