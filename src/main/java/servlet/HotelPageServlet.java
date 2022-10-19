package servlet;

import entity.Feedback;
import service.BookingService;
import service.FeedbackService;
import service.HotelService;
import service.RoomService;
import service.impl.BookingServiceImpl;
import service.impl.FeedbackServiceImpl;
import service.impl.HotelServiceImpl;
import service.impl.RoomServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hotel")
public class HotelPageServlet extends HttpServlet {
    private final HotelService hotelService = new HotelServiceImpl();
    private final RoomService roomService = new RoomServiceImpl();
    private final BookingService bookingService = new BookingServiceImpl();
    private final Feedback feedback = new Feedback();
    private final FeedbackService feedbackService = new FeedbackServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));

        req.setAttribute("hotelDTO", hotelService.findHotelbyId(id));
        req.setAttribute("roomList", roomService.getRoomListByHotelId(id));
        req.setAttribute("paymentList", bookingService.paymentList());
        req.setAttribute("feedbackList", feedbackService.getAllFeedbacksByHotelId(id));

        getServletContext().getRequestDispatcher("/pages/hotel.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        feedback.setFeedback(req.getParameter("feedback"));
        feedback.setStarAmount(Integer.parseInt(req.getParameter("rating")));
        feedback.setHotelId(hotelService.getHotelIdbyHotelName(req.getParameter("hotelName")));
        feedbackService.saveFeedback(feedback);

    }
}

