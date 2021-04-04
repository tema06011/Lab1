package dao.impl;

import dao.HotelDAO;
import entity.Hotel;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelDAOImpl implements HotelDAO {

    @Override
    public Hotel findByID(long id) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
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

    public List<Hotel> insertAllHotel() throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM hotel");
        ArrayList<Hotel> hotelList = new ArrayList<>();
        while (resultSet.next()) {
            Hotel hotel = new Hotel();
            hotel.setId(resultSet.getLong("id"));
            hotel.setName(resultSet.getString("name"));
            hotel.setStarAmount(resultSet.getInt("star_amount"));
            hotel.setCity(resultSet.getString("city"));
            hotel.setStreet(resultSet.getString("street"));
            hotel.setNumberOfBuilding(resultSet.getInt("number_of_building"));
            hotel.setPhoneNumber(resultSet.getString("phone_number"));

            hotelList.add(hotel);

        }
        return hotelList;
    }


}


