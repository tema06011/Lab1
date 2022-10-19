package service;

import DTO.HotelDTO;
import entity.Favorite;

import java.util.List;

public interface FavoriteService {
    List<HotelDTO> getFavoriteListByUserId(long userID) ;

    void saveFavorite(Favorite favorite) ;
}
