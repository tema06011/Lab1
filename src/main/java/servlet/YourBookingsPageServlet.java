package servlet;

import service.BookingService;
import service.impl.BookingServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/YourBooking")
public class YourBookingsPageServlet extends HttpServlet {
    private final BookingService bookingService = new BookingServiceImpl();
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
            Long userID = (long) req.getSession().getAttribute("id");
            req.setAttribute("bookingList", bookingService.getBookingListByUserId(userID));
            getServletContext().getRequestDispatcher("/pages/yourBookings.jsp").forward(req, resp);

        }



}

