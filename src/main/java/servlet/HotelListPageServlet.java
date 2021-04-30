package servlet;

import dao.HotelDAO;
import dao.impl.HotelDAOImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/hotelList")
public class HotelListPageServlet extends HttpServlet {
       HotelDAO hotelDAO= new HotelDAOImpl();
       @Override
       protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
              String city = req.getParameter("city");
              System.out.println(city);
              String entry=req.getParameter("entry");
              String departure=req.getParameter("departure");
             /* DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
              Date dDeparture = null;
              Date dEntry = null;
              try {
                     dEntry = date.parse(entry);
                     dDeparture = date.parse(departure);
              } catch (ParseException e) {
                     e.printStackTrace();
              }
              System.out.println(date.format(dEntry));
              System.out.println(date.format(dDeparture));*/

              try {
                     req.setAttribute("hotelList", hotelDAO.hotelList(city));
              } catch (SQLException throwables) {
                     throwables.printStackTrace();
              }
              getServletContext().getRequestDispatcher("/pages/hotelList.jsp").forward(req, resp);
             // super.doPost(req, resp);
       }
}



