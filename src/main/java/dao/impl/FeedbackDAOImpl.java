package dao.impl;

import dao.FeedbackDAO;
import entity.Feedback;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDAOImpl implements FeedbackDAO {
    Connection connection = DatabaseConnection.getConnection();

    @Override
    public void saveFeedback(final Feedback feedback) throws SQLException {
        String querySql = "INSERT INTO feedback(feedback,star_amount,hotel_id) VALUES(?,?,?)";
        PreparedStatement prstatment = connection.prepareStatement(querySql);
        prstatment.setString(1, feedback.getFeedback());
        prstatment.setInt(2, feedback.getStarAmount());
        prstatment.setLong(3, feedback.getHotelId());
        int affectedRows = prstatment.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("Creating feedback failed, no rows affected.");
        }
    }

    @Override
    public List<Feedback> getAllFeedbacksByHotelId(final long id) throws SQLException {
        String querySql = "SELECT feedback,star_amount FROM feedback  where hotel_id=?";
        PreparedStatement prstatment = connection.prepareStatement(querySql);
        prstatment.setLong(1, id);
        ResultSet resultSet = prstatment.executeQuery();
        ArrayList<Feedback> feedbackList = new ArrayList<>();
        while (resultSet.next()) {
            Feedback feedback = new Feedback();
            feedback.setFeedback(resultSet.getString("feedback"));
            feedback.setStarAmount(resultSet.getInt("star_amount"));
            feedbackList.add(feedback);
        }
        return feedbackList;
    }
}
