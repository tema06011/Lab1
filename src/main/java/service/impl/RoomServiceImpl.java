package service.impl;

import dao.RoomDAO;
import dao.impl.RoomDAOImpl;
import entity.Room;
import service.RoomService;

import java.sql.SQLException;
import java.util.List;

public class RoomServiceImpl implements RoomService {
    private final RoomDAO roomDAO=new RoomDAOImpl();
    @Override
    public List<Room> getRoomListByHotelId(final long id) {
        List<Room> result=null;
        try {
            result= roomDAO.getRoomListByHotelId(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public void addRoom(final Room room) {
        try {
            roomDAO.addRoom(room);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
