package dao.impl;

import dao.FeedbackDAO;
import entity.Feedback;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class FeedbackDAOImpl implements FeedbackDAO {
    Connection connection = DatabaseConnection.getConnection();
    @Override
    public void saveFeedback(Feedback feedback) throws SQLException {
        Statement statement = connection.createStatement();
        String querySql ="INSERT INTO feedback VALUES";

    }
}
