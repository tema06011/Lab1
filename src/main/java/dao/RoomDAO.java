package dao;

import entity.Room;

import java.sql.SQLException;
import java.util.List;

public interface RoomDAO {
    List<Room> roomList(long id) throws SQLException;
}
