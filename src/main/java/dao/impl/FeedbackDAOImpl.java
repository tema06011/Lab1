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
    public Feedback getFeedbackByhotelId(final long id) throws SQLException {
        Statement statement = connection.createStatement();
        String querySql = "SELECT feedback.feedback,feedback.start_amount," +
                "FROM feedback where hotel.id=?";
        PreparedStatement prstatment = connection.prepareStatement(querySql);
        prstatment.setLong(1, id);
        ResultSet resultSet = prstatment.executeQuery();
        Feedback feedback = new Feedback();
        while (resultSet.next()) {
            feedback.setFeedback(resultSet.getString("feedback"));
            feedback.setStarAmount(resultSet.getInt("starAmount"));
        }
        return feedback;
    }

    @Override
    public void saveFeedback(Feedback feedback) throws SQLException {
        Statement statement = connection.createStatement();
        String querySql = "INSERT INTO feedback(feedback,star_amount,hotel_id) VALUES(?,?,?)";
        PreparedStatement prstatment = connection.prepareStatement(querySql);
        prstatment.setString(1, feedback.getFeedback());
        prstatment.setInt(2, feedback.getStarAmount());
        prstatment.setLong(3, feedback.getHotelID());
        int affectedRows = prstatment.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("Creating feedback failed, no rows affected.");
        }
    }

    @Override
    public List<Feedback> getAllFeedbacksByHotelId(final long id) throws SQLException {
        Statement statement = connection.createStatement();
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
