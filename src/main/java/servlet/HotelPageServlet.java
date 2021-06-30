package servlet;

import DTO.BookingDTO;
import dao.BookingDAO;
import dao.HotelDAO;
import dao.RoomDAO;
import dao.impl.BookingDAOImpl;
import dao.impl.HotelDAOImpl;
import dao.impl.RoomDAOImpl;
import entity.Booking;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet("/hotel")
public class HotelPageServlet extends HttpServlet {
    HotelDAO hotelDAO = new HotelDAOImpl();
    RoomDAO roomDAO = new RoomDAOImpl();
    BookingDAO bookingDAO = new BookingDAOImpl();
    private BookingDTO bookingDTO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strId = req.getParameter("id");
        long id = 0;
        id = Long.parseLong(strId);
        System.out.println(id);
        try {
            req.setAttribute("hotelDTO", hotelDAO.idHotels(id));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            req.setAttribute("roomList", roomDAO.roomList(id));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            req.setAttribute("paymentList", bookingDAO.paymentList());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/pages/hotel.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("submit".equals(action)) {
            bookingDTO.setLastname(req.getParameter("lastname"));
            bookingDTO.setUserName(req.getParameter("userName"));
            bookingDTO.setSurname(req.getParameter("surname"));
            bookingDTO.setStart(Date.valueOf(req.getParameter("start")));
            bookingDTO.setEnd(Date.valueOf(req.getParameter("end")));
            bookingDTO.setCategoryName(req.getParameter("categoryName"));
            bookingDTO.setPaymentType(req.getParameter("paymentType"));
            bookingDTO.setCost(Integer.parseInt(req.getParameter("cost")));
        }
        req.setAttribute("bookingDTO", bookingDTO);
        req.getRequestDispatcher("/pages/hotel.jsp").forward(req, resp);
    }
}

