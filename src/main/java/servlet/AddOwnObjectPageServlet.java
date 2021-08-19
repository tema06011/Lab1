package servlet;

import dao.CityDAO;
import dao.HotelDAO;
import dao.RoomDAO;
import dao.impl.CityDAOImpl;
import dao.impl.HotelDAOImpl;
import dao.impl.RoomDAOImpl;
import entity.Category;
import entity.Hotel;
import entity.Room;
import org.apache.commons.compress.utils.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

@MultipartConfig
@WebServlet("/addOwnObject")
public class AddOwnObjectPageServlet extends HttpServlet {
    CityDAO cityDAO = new CityDAOImpl();
    HotelDAO hotelDAO = new HotelDAOImpl();
    RoomDAO roomDAO = new RoomDAOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Room room = new Room();
        Hotel hotel = new Hotel();
        String name = request.getParameter("name");
        hotel.setName(name);
        int starAmount = Integer.parseInt(request.getParameter("star_amount"));
        hotel.setStarAmount(starAmount);
        String street = request.getParameter("street");
        hotel.setStreet(street);
        int numberOfBuilding = Integer.parseInt(request.getParameter("number_of_building"));
        hotel.setNumberOfBuilding(numberOfBuilding);
        String phoneNumber = request.getParameter("phone_number");
        hotel.setPhoneNumber(phoneNumber);
        String about = request.getParameter("about");
        hotel.setAbout(about);


        try {
            long cityID = cityDAO.getCityIdbyName(request.getParameter("cityName"));
            hotel.setCityID(cityID);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        Part filePart = request.getPart("photo"); // Retrieves <input type="file" name="file">
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        InputStream fileContent = filePart.getInputStream();
        hotel.setPhoto(Base64.getEncoder().encodeToString(filePart.getInputStream().readAllBytes()));
        try {
            hotelDAO.addOwnObject(hotel);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            room.setHotelID(hotelDAO.getHotelIdbyHotelName(name));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            List<Category> categoryList = hotelDAO.getCategoryList();
            for (Category cl : categoryList) {
                String cost = request.getParameter("cost" + cl.getName());
                room.setCategoryID(cl.getId());
                if (!cost.equals("")) {
                    room.setCost(Integer.parseInt(cost));
                    roomDAO.addRoom(room);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/pages/index.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("cityList", cityDAO.getAllCities());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            req.setAttribute("categoryArrayList", hotelDAO.getCategoryList());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/pages/addOwnObject.jsp").forward(req, resp);

    }


    public String img2Text(String photo) {
        String base64 = "";
        try {
            InputStream iSteamReader = new FileInputStream(photo);
            byte[] imageBytes = IOUtils.toByteArray(iSteamReader);
            base64 = Base64.getEncoder().encodeToString(imageBytes);
            System.out.println(base64);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return base64;
    }
}
