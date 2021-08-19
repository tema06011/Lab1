package dao;

import DTO.HotelDTO;
import entity.Favorite;

import java.sql.SQLException;
import java.util.List;

public interface FavoriteDAO {
    public List<HotelDTO> getFavoriteListByUserId(long userID) throws SQLException;

    public void saveFavorite(Favorite favorite) throws SQLException;
}
