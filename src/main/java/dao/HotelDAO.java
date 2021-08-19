package dao;

import DTO.HotelDTO;
import entity.Category;
import entity.Hotel;

import java.sql.SQLException;
import java.util.List;

public interface HotelDAO {
    public Hotel findHotelNameByID(long id) throws SQLException;

    public List<Hotel> getHotelListByCiteName(String name) throws SQLException;

    public HotelDTO findHotelbyId(long id) throws SQLException;

    public List<Hotel> getAllHotels() throws SQLException;

    public void addOwnObject(Hotel hotel) throws SQLException;

    public List<Category> getCategoryList() throws SQLException;

    public long getHotelIdbyHotelName(String name) throws SQLException;

}
