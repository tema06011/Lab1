package dao;

import DTO.HotelDTO;
import entity.Category;
import entity.Hotel;

import java.sql.SQLException;
import java.util.List;

public interface HotelDAO {
    Hotel findHotelNameByID(long id) throws SQLException;

    List<Hotel> getHotelListByCiteName(String name) throws SQLException;

    HotelDTO findHotelbyId(long id) throws SQLException;

    List<Hotel> getAllHotels() throws SQLException;

    void addOwnObject(Hotel hotel) throws SQLException;

    List<Category> getCategoryList() throws SQLException;

    long getHotelIdbyHotelName(String name) throws SQLException;

}
