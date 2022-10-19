//package servlet;
//
//import entity.User;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.sql.Date;
//
//@WebServlet("/user")
//public class UserPageServlet extends HttpServlet {
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String action = req.getParameter("action");
//        User user = new User();
//        if ("submit".equals(action)) { // TODO WHAT IF NOT SUBMIT?
//            user.setLastname(req.getParameter("lastname"));
//            user.setName(req.getParameter("name"));
//            user.setSurname(req.getParameter("surname"));
//            user.setBirthday(Date.valueOf(req.getParameter("birthday")));
//            user.setCityId(Long.valueOf(req.getParameter("city_id")));
//            user.setStreet(req.getParameter("street"));
//            user.setNumberOfBuilding(Integer.parseInt(req.getParameter("number_of_building")));
//            user.setPhoneNumber(req.getParameter("phone_number"));
//            user.setLogin(req.getParameter("login"));
//            user.setPassword(req.getParameter("password"));
//        }
//        req.setAttribute("user", user);
//        req.getRequestDispatcher("/pages/regist.jsp").forward(req, resp);
//
//    }
//}
