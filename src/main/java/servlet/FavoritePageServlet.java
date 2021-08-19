package servlet;

import dao.FavoriteDAO;
import dao.HotelDAO;
import dao.impl.FavoriteDAOImpl;
import dao.impl.HotelDAOImpl;
import entity.Favorite;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/favorite")
public class FavoritePageServlet extends HttpServlet {

    private final HotelDAO hotelDAO = new HotelDAOImpl();
    private FavoriteDAO favoriteDAO = new FavoriteDAOImpl();

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        Favorite favorite = new Favorite();
        long userId = (long) req.getSession().getAttribute("id");
        favorite.setUserID(userId);
        try {
            favorite.setHotelID(hotelDAO.getHotelIdbyHotelName(req.getParameter("hotelName")));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            favoriteDAO.saveFavorite(favorite);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("id") != null) {
            User user = new User();
            try {
                long userID = (long) req.getSession().getAttribute("id");
                req.setAttribute("favoriteList", favoriteDAO.getFavoriteListByUserId(userID));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            getServletContext().getRequestDispatcher("/pages/favorite.jsp").forward(req, resp);
        } else {
            getServletContext().getRequestDispatcher("/pages/notLogged.jsp").forward(req, resp);
        }

    }
}
