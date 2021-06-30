package dao;

import entity.Feedback;

import java.sql.SQLException;

public interface FeedbackDAO {
    public void saveFeedback(Feedback feedback) throws SQLException;
}
