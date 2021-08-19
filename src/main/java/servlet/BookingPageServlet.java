package servlet;

import DTO.BookingDTO;
import dao.BookingDAO;
import dao.HotelDAO;
import dao.impl.BookingDAOImpl;
import dao.impl.HotelDAOImpl;
import entity.Booking;
import entity.User;
import util.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet("/booking")
public class BookingPageServlet extends HttpServlet {
    Connection connection = DatabaseConnection.getConnection();
    private final Booking booking = new Booking();
    private final BookingDAO bookingDAO = new BookingDAOImpl();
    private final BookingDTO bookingDTO = new BookingDTO();
    private final HotelDAO hotelDAO = new HotelDAOImpl();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            booking.setHotelID(bookingDAO.getHotelIDbyName(req.getParameter("hotelName")));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            booking.setRoomID(bookingDAO.getRoomIDbyCategoryName(req.getParameter("category")));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        long userId = (long) req.getSession().getAttribute("id");
        booking.setUserID(userId);
        booking.setStart(Date.valueOf(req.getParameter("entry")));
        booking.setEnd(Date.valueOf(req.getParameter("departure")));
        try {
            booking.setPaymentTypeID(bookingDAO.getPaymentTypeIDbyName(req.getParameter("paymentType")));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            bookingDAO.saveBooking(booking);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/pages/yourBookings.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strId = req.getParameter("id");
        long id = 0;
        id = Long.parseLong(strId);
        User user = new User();
        try {
            req.setAttribute("hotelDTO", hotelDAO.findHotelbyId(id));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            req.setAttribute("paymentList", bookingDAO.paymentList());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
