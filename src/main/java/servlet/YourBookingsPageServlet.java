package servlet;

import dao.BookingDAO;
import dao.impl.BookingDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/YourBooking")
public class YourBookingsPageServlet extends HttpServlet {
    private final BookingDAO bookingDAO = new BookingDAOImpl();

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("id") != null) {
            try {
                Long userID = (long) req.getSession().getAttribute("id");
                req.setAttribute("bookingList", bookingDAO.getBookingListByUserId(userID));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            getServletContext().getRequestDispatcher("/pages/yourBookings.jsp").forward(req, resp);
        } else {
            getServletContext().getRequestDispatcher("/pages/notLogged.jsp").forward(req, resp);
        }


    }
}

