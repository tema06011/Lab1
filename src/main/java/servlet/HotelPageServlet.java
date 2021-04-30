package servlet;

import dao.HotelDAO;
import dao.RoomDAO;
import dao.impl.HotelDAOImpl;
import dao.impl.RoomDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/hotel")
public class HotelPageServlet extends HttpServlet {
    HotelDAO hotelDAO= new HotelDAOImpl();
    RoomDAO roomDAO=new RoomDAOImpl();

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
            req.setAttribute("roomList",roomDAO.roomList(id));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/pages/hotel.jsp").forward(req, resp);
    }

}
