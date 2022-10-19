package service;

import entity.Room;

import java.util.List;

public interface RoomService {
    List<Room> getRoomListByHotelId(long id) ;

    void addRoom(Room room);
}
