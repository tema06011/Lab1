package servlet;

import service.HotelService;
import service.impl.HotelServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/allHotels")
public class AllHotelsPageServlet extends HttpServlet {
    private final HotelService hotelService = new HotelServiceImpl();

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("allHotelsList", hotelService.getAllHotels());

        getServletContext().getRequestDispatcher("/pages/allhotels.jsp").forward(req, resp);
    }
}
