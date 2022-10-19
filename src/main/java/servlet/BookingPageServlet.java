package servlet;

import entity.Booking;
import service.BookingService;
import service.HotelService;
import service.impl.BookingServiceImpl;
import service.impl.HotelServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

import static java.lang.Long.parseLong;

@WebServlet("/booking")
public class BookingPageServlet extends HttpServlet {
    private final HotelService hotelService = new HotelServiceImpl();
    private final BookingService bookingService=new BookingServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final Booking booking = new Booking();
        booking.setHotelId(bookingService.getHotelIDbyName(req.getParameter("hotelName")));
        booking.setRoomId(bookingService.getRoomIDbyCategoryName(req.getParameter("category")));
        long userId = (long) req.getSession().getAttribute("id");
        booking.setUserId(userId);
        booking.setStart(Date.valueOf(req.getParameter("entry")));
        booking.setEnd(Date.valueOf(req.getParameter("departure")));
        booking.setPaymentTypeId(bookingService.getPaymentTypeIDbyName(req.getParameter("paymentType")));
        bookingService.saveBooking(booking);
        resp.sendRedirect("/YourBooking");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strId = req.getParameter("id");
        long id = parseLong(strId);
        req.setAttribute("hotelDTO", hotelService.findHotelbyId(id));
        req.setAttribute("paymentList", bookingService.paymentList());
        getServletContext().getRequestDispatcher("/pages/yourBookings.jsp").forward(req, resp);
    }
}
