package service;

import entity.Feedback;

import java.util.List;

public interface FeedbackService {
    void saveFeedback(Feedback feedback) ;

    List<Feedback> getAllFeedbacksByHotelId(long id) ;
}
