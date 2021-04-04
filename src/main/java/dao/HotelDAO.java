package dao;

import entity.Hotel;

import java.sql.SQLException;
import java.util.List;

public interface HotelDAO {
    Hotel findByID(long id) throws SQLException;
    public List<Hotel> insertAllHotel() throws SQLException;
}
