package servlet;

import entity.User;
import service.CityService;
import service.UserService;
import service.impl.CityServiceImpl;
import service.impl.UserServiceImpl;
import util.HashPasswordUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;


@WebServlet("/registration")
public class RegistrationPageServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl();
    public CityService cityService = new CityServiceImpl();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setLastname(req.getParameter("lastname"));
        user.setName(req.getParameter("name"));
        user.setSurname(req.getParameter("surname"));
        user.setBirthday(Date.valueOf(req.getParameter("birthday")));
        user.setCityId(cityService.getCityIdbyName(req.getParameter("cityName")));
        user.setStreet(req.getParameter("street"));
        user.setNumberOfBuilding(Integer.parseInt(req.getParameter("number_of_building")));
        user.setPhoneNumber(req.getParameter("phone_number"));
        user.setLogin(req.getParameter("login"));
        user.setPassword(HashPasswordUtil.hashPassword(req.getParameter("password")));
        userService.regist(user);
        getServletContext().getRequestDispatcher("/pages/login.jsp").forward(req, resp);

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("cityList", cityService.getAllCities());
        getServletContext().getRequestDispatcher("/pages/register.jsp").forward(req, resp);

    }

}

