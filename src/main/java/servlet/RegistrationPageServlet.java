package servlet;

import dao.CityDAO;
import dao.UserDAO;
import dao.impl.CityDAOImpl;
import dao.impl.UserDAOImpl;
import entity.City;
import entity.User;
import util.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.Long.parseLong;

@WebServlet("/registration")
public class RegistrationPageServlet extends HttpServlet {
    final Connection connection = DatabaseConnection.getConnection();
    UserDAO userDAO= new UserDAOImpl();


   @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       User user=new User();
       CityDAOImpl cityDAO=new CityDAOImpl();
       user.setLastname(req.getParameter("lastname"));
       user.setName(req.getParameter("name"));
       user.setSurname(req.getParameter("surname"));
       user.setBirthday(Date.valueOf(req.getParameter("birthday")));
       try {
           user.setCityID(cityDAO.city_id(req.getParameter("name")));
       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }
       user.setStreet(req.getParameter("street"));
       user.setNumberOfBuilding(Integer.parseInt(req.getParameter("number_of_building")));
       user.setPhoneNumber(req.getParameter("phone_number"));
       user.setLogin(req.getParameter("login"));
       user.setPassword(req.getParameter("password"));
       try {
           userDAO.regist(user);
       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }
       getServletContext().getRequestDispatcher("/pages/login.jsp").forward(req, resp);

    }

    CityDAO cityDAO=new CityDAOImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            req.setAttribute("cityList", cityDAO.getAllCities());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/pages/register.jsp").forward(req, resp);
        try{
            req.setAttribute("cityId",cityDAO.city_id("name"));
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/pages/register.jsp").forward(req, resp);
    }

}

