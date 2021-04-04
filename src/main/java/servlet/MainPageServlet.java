package servlet;

import dao.HotelDAO;
import dao.impl.HotelDAOImpl;
import entity.Hotel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("")
public class MainPageServlet extends HttpServlet {
    HotelDAO hotelDAO=new HotelDAOImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            req.setAttribute("hotelList", hotelDAO.insertAllHotel());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/pages/index.jsp").forward(req, resp);
    }
}
