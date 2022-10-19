package service.impl;

import DTO.HotelDTO;
import dao.FavoriteDAO;
import dao.impl.FavoriteDAOImpl;
import entity.Favorite;
import service.FavoriteService;

import java.sql.SQLException;
import java.util.List;

public class FavoriteServiceImpl implements FavoriteService {
    private final FavoriteDAO favoriteDAO = new FavoriteDAOImpl();

    @Override
    public List<HotelDTO> getFavoriteListByUserId(final long userID) {
        List<HotelDTO> result = null;
        try {
            result = favoriteDAO.getFavoriteListByUserId(userID);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public void saveFavorite(final Favorite favorite) {
        try {
            favoriteDAO.saveFavorite(favorite);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
