package dao;

import entity.Feedback;

import java.sql.SQLException;
import java.util.List;

public interface FeedbackDAO {
    public void saveFeedback(Feedback feedback) throws SQLException;

    public Feedback getFeedbackByhotelId(long id) throws SQLException;

    public List<Feedback> getAllFeedbacksByHotelId(long id) throws SQLException;
}
