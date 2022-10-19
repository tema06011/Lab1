package dao.impl;

import dao.RoomDAO;
import entity.Category;
import entity.Room;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomDAOImpl implements RoomDAO {
    private final Connection connection = DatabaseConnection.getConnection();

    @Override
    public List<Room> getRoomListByHotelId(final long id) throws SQLException {
        String querySql = "SELECT category.name as categoryName, room.cost " +
                "FROM room join hotel on hotel.id=room.hotel_id " +
                "join category on category.id=room.category_id " +
                "where hotel.id=?";
        PreparedStatement prstatment = connection.prepareStatement(querySql);
        prstatment.setLong(1, id);
        ResultSet resultSet = prstatment.executeQuery();
        ArrayList<Room> roomList = new ArrayList<>();
        while (resultSet.next()) {
            Room room = new Room();
            Category category = new Category();
            category.setName(resultSet.getString("categoryName"));
            room.setCategory(category);
            room.setCost(resultSet.getInt("cost"));
            roomList.add(room);
        }
        return roomList;
    }

    @Override
    public void addRoom(final Room room) throws SQLException {
        String querySql = "insert into room(hotel_id,category_id,cost) values(?,?,?)";
        PreparedStatement prstatment = connection.prepareStatement(querySql);
        prstatment.setLong(1, room.getHotelId());
        prstatment.setLong(2, room.getCategoryId());
        prstatment.setInt(3, room.getCost());
        int affectedRows = prstatment.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("Creating booking failed, no rows affected.");
        }
    }

}
