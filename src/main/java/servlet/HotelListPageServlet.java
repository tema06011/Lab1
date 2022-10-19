package servlet;

import service.HotelService;
import service.impl.HotelServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hotelList")
public class HotelListPageServlet extends HttpServlet {
    private final HotelService hotelService = new HotelServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String city = req.getParameter("city");
        System.out.println(city);
        req.setAttribute("hotelList", hotelService.getHotelListByCiteName(city));
        getServletContext().getRequestDispatcher("/pages/hotelList.jsp").forward(req, resp);

    }
}



