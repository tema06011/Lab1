package servlet;

import dao.CityDAO;
import dao.UserDAO;
import dao.impl.CityDAOImpl;
import dao.impl.UserDAOImpl;
import entity.User;

import util.HashPasswordUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

@WebServlet("/login")
public class LoginPageServlet extends HttpServlet {
    CityDAO cityDAO = new CityDAOImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println(request.getSession(false).getAttribute("login"));
        request.getRequestDispatcher("pages/login.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        try {
            UserDAO userDAO = new UserDAOImpl();
            User user = userDAO.login(login);
            if (user.getLogin() != null) {

                boolean validPassword = HashPasswordUtil.checkPassword(password, user.getPassword());

                if (validPassword) {
                    HttpSession session = req.getSession();
                    session.setAttribute("login", login);
                    session.setAttribute("id", user.getId());
                    System.out.println("successful login");
                    try {
                        req.setAttribute("cityList", cityDAO.getAllCities());
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    getServletContext().getRequestDispatcher("/pages/index.jsp").forward(req, resp);
                } else {
                    resp.sendError(401);
                }
            } else {
                resp.sendError(403);
            }
        } catch (SQLException | ServletException e) {
            e.printStackTrace();
        }
    }
}
