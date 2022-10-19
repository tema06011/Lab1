package service.impl;

import DTO.HotelDTO;
import dao.HotelDAO;
import dao.impl.HotelDAOImpl;
import entity.Category;
import entity.Hotel;
import service.HotelService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HotelServiceImpl implements HotelService {
    private final HotelDAO hotelDAO = new HotelDAOImpl();

    @Override
    public List<Hotel> getHotelListByCiteName(final String name) {
        List<Hotel> result = null;
        try {
            result = hotelDAO.getHotelListByCiteName(name);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public HotelDTO findHotelbyId(long id) {
        HotelDTO result = null;
        try {
            result = hotelDAO.findHotelbyId(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Hotel> getAllHotels() {
        List<Hotel> result = new ArrayList<>();
        try {
            result = hotelDAO.getAllHotels();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public void addOwnObject(final Hotel hotel) {
        try {
            hotelDAO.addOwnObject(hotel);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Category> getCategoryList() {
        List<Category> result = new ArrayList<>();
        try {
            result = hotelDAO.getCategoryList();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public long getHotelIdbyHotelName(final String name) {
        Long result = null;
        try {
            result = hotelDAO.getHotelIdbyHotelName(name);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
}
