package dao.impl;

import DTO.HotelDTO;
import dao.FavoriteDAO;
import entity.Favorite;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FavoriteDAOImpl implements FavoriteDAO {
    Connection connection = DatabaseConnection.getConnection();

    @Override
    public List<HotelDTO> getFavoriteListByUserId(final long userID) throws SQLException {
        String querySql = " select  h.name as hotelName, h.star_amount as starAmount, h.id" +
                " from favorite f" +
                " join hotel h on f.hotelID = h.id" +
                " where f.userID =?";
        PreparedStatement prstatment = connection.prepareStatement(querySql);
        prstatment.setLong(1, userID);
        ResultSet resultSet = prstatment.executeQuery();
        ArrayList<HotelDTO> favoriteList = new ArrayList<>();
        while (resultSet.next()) {
            HotelDTO hotelDTO = new HotelDTO();
            hotelDTO.setId(resultSet.getLong("id"));
            hotelDTO.setHotelName(resultSet.getString("hotelName"));
            hotelDTO.setStarAmount(resultSet.getInt("starAmount"));
            favoriteList.add(hotelDTO);
        }
        return favoriteList;
    }

    @Override
    public void saveFavorite(final Favorite favorite) throws SQLException {
        String querySql = "INSERT INTO favorite(hotelID,userID) values(?,?)";
        PreparedStatement prstatment = connection.prepareStatement(querySql);
        prstatment.setLong(1, favorite.getHotelId());
        prstatment.setLong(2, favorite.getUserId());
        int affectedRows = prstatment.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("Creating booking failed, no rows affected.");
        }
    }
}
