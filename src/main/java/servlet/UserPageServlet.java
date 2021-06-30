package servlet;

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/user")
public class UserPageServlet extends HttpServlet {
    UserDAO userDAO= new UserDAOImpl();
    User user=new User();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("submit".equals(action)){
        user.setLastname(req.getParameter("lastname"));
        user.setName(req.getParameter("name"));
        user.setSurname(req.getParameter("surname"));
        user.setBirthday(Date.valueOf(req.getParameter("birthday")));
        user.setCityID(Long.valueOf(req.getParameter("city_id")));
        user.setStreet(req.getParameter("street"));
        user.setNumberOfBuilding(Integer.parseInt(req.getParameter("number_of_building")));
        user.setPhoneNumber(req.getParameter("phone_number"));
        user.setLogin(req.getParameter("login"));
        user.setPassword(req.getParameter("password"));
        }
        req.setAttribute("user", user);
        req.getRequestDispatcher("/pages/regist.jsp").forward(req, resp);

    }
}
