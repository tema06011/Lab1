package servlet;

import dao.HotelDAO;
import dao.impl.HotelDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/allHotels")
public class AllHotelsPageServlet extends HttpServlet {
    HotelDAO hotelDAO = new HotelDAOImpl();

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("allHotelsList", hotelDAO.getAllHotels());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/pages/allhotels.jsp").forward(req, resp);
    }
}
