package service;

import DTO.HotelDTO;
import entity.Category;
import entity.Hotel;

import java.util.List;

public interface HotelService {

    List<Hotel> getHotelListByCiteName(String name);

    HotelDTO findHotelbyId(long id);

    List<Hotel> getAllHotels();

    void addOwnObject(Hotel hotel);

    List<Category> getCategoryList();

    long getHotelIdbyHotelName(String name);
}
