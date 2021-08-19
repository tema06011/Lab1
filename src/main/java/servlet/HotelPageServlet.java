package servlet;

import DTO.BookingDTO;
import dao.BookingDAO;
import dao.FeedbackDAO;
import dao.HotelDAO;
import dao.RoomDAO;
import dao.impl.BookingDAOImpl;
import dao.impl.FeedbackDAOImpl;
import dao.impl.HotelDAOImpl;
import dao.impl.RoomDAOImpl;
import entity.Feedback;
import entity.Hotel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/hotel")
public class HotelPageServlet extends HttpServlet {
    HotelDAO hotelDAO = new HotelDAOImpl();
    RoomDAO roomDAO = new RoomDAOImpl();
    BookingDAO bookingDAO = new BookingDAOImpl();
    private BookingDTO bookingDTO;
    Hotel hotel = new Hotel();
    private final Feedback feedback = new Feedback();
    private final FeedbackDAO feedbackDAO = new FeedbackDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strId = req.getParameter("id");
        long id = 0;
        id = Long.parseLong(strId);
        System.out.println(id);
        try {
            req.setAttribute("hotelDTO", hotelDAO.findHotelbyId(id));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            req.setAttribute("roomList", roomDAO.getRoomListByHotelId(id));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            req.setAttribute("paymentList", bookingDAO.paymentList());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            req.setAttribute("feedbackList", feedbackDAO.getAllFeedbacksByHotelId(id));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/pages/hotel.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        feedback.setFeedback(req.getParameter("feedback"));
        feedback.setStarAmount(Integer.parseInt(req.getParameter("rating")));
        try {
            feedback.setHotelID(hotelDAO.getHotelIdbyHotelName(req.getParameter("hotelName")));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            feedbackDAO.saveFeedback(feedback);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

