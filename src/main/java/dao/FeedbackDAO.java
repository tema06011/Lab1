package dao;

import entity.Feedback;

import java.sql.SQLException;
import java.util.List;

public interface FeedbackDAO {
    void saveFeedback(Feedback feedback) throws SQLException;

    List<Feedback> getAllFeedbacksByHotelId(long id) throws SQLException;
}
