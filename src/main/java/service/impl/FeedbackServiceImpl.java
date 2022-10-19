package service.impl;

import dao.FeedbackDAO;
import dao.impl.FeedbackDAOImpl;
import entity.Feedback;
import service.FeedbackService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FeedbackServiceImpl implements FeedbackService {
    private final FeedbackDAO feedbackDAO=new FeedbackDAOImpl();
    @Override
    public void saveFeedback(final Feedback feedback) {
        try {
            feedbackDAO.saveFeedback(feedback);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Override
    public List<Feedback> getAllFeedbacksByHotelId(final long id) {
       List<Feedback> result=new ArrayList<>();
        try {
           result=feedbackDAO.getAllFeedbacksByHotelId(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
}
