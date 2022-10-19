package servlet;

import entity.Category;
import entity.Hotel;
import entity.Room;
import service.CityService;
import service.HotelService;
import service.RoomService;
import service.impl.CityServiceImpl;
import service.impl.HotelServiceImpl;
import service.impl.RoomServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

@MultipartConfig
@WebServlet("/addOwnObject")
public class AddOwnObjectPageServlet extends HttpServlet {
    private final RoomService roomService = new RoomServiceImpl();
    private final CityService cityService = new CityServiceImpl();
    private final HotelService hotelService = new HotelServiceImpl();

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
        long cityID = cityService.getCityIdbyName(request.getParameter("cityName"));
        hotel.setCityId(cityID);

        Part filePart = request.getPart("photo");
        hotel.setPhoto(Base64.getEncoder().encodeToString(filePart.getInputStream().readAllBytes()));
        hotelService.addOwnObject(hotel);

        room.setHotelId(hotelService.getHotelIdbyHotelName(name));

        List<Category> categoryList = hotelService.getCategoryList();
        for (Category cl : categoryList) {
            String cost = request.getParameter("cost" + cl.getName());
            room.setCategoryId(cl.getId());
            if (!cost.equals("")) {
                room.setCost(Integer.parseInt(cost));
                roomService.addRoom(room);
            }
        }

        response.sendRedirect("/");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("cityList", cityService.getAllCities());

        req.setAttribute("categoryArrayList", hotelService.getCategoryList());

        getServletContext().getRequestDispatcher("/pages/addOwnObject.jsp").forward(req, resp);

    }
}
