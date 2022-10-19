package servlet;

import service.CityService;
import service.impl.CityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("")
public class MainPageServlet extends HttpServlet {
   private final CityService cityService=new CityServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setAttribute("cityList", cityService.getAllCities());

        getServletContext().getRequestDispatcher("/pages/index.jsp").forward(req, resp);
    }
}
