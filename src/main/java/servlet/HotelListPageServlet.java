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

@WebServlet("/hotelList")
public class HotelListPageServlet extends HttpServlet {
    HotelDAO hotelDAO = new HotelDAOImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String city = req.getParameter("city");
        System.out.println(city);
        String entry = req.getParameter("entry");
        String departure = req.getParameter("departure");

        try {
            req.setAttribute("hotelList", hotelDAO.getHotelListByCiteName(city));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/pages/hotelList.jsp").forward(req, resp);

    }
}



