package servlet;

import entity.Favorite;
import service.FavoriteService;
import service.HotelService;
import service.impl.FavoriteServiceImpl;
import service.impl.HotelServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/favorite")
public class FavoritePageServlet extends HttpServlet {

    private final HotelService hotelService = new HotelServiceImpl();
    private final FavoriteService favoriteService=new FavoriteServiceImpl();

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        Favorite favorite = new Favorite();
        long userId = (long) req.getSession().getAttribute("id");
        favorite.setUserId(userId);
        favorite.setHotelId(hotelService.getHotelIdbyHotelName(req.getParameter("hotelName")));
        favoriteService.saveFavorite(favorite);
        getServletContext().getRequestDispatcher("/pages/favorite.jsp").forward(req, resp);

    }

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
            long userID = (long) req.getSession().getAttribute("id");
            req.setAttribute("favoriteList", favoriteService.getFavoriteListByUserId(userID));
            getServletContext().getRequestDispatcher("/pages/favorite.jsp").forward(req, resp);

    }
}
