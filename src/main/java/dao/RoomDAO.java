package dao;

import entity.Room;

import java.sql.SQLException;
import java.util.List;

public interface RoomDAO {
    List<Room> getRoomListByHotelId(long id) throws SQLException;

    void addRoom(Room room) throws SQLException;
}
