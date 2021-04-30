package dao;

import DTO.HotelDTO;
import entity.Hotel;

import java.sql.SQLException;
import java.util.List;

public interface HotelDAO {
    Hotel findByID(long id) throws SQLException;
    public List<Hotel> hotelList(String name) throws SQLException;
    public HotelDTO idHotels(long id) throws SQLException;
}
