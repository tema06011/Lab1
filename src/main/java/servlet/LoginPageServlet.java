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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/login")
public class LoginPageServlet extends HttpServlet {
    public static final int NOT_AUTHORIZED_HTTP_EXCEPTION = 401;
    public static final int FORBIDDEN_HTTP_EXCEPTION = 403;
    private final  CityService cityService = new CityServiceImpl();
    private final UserService userService = new UserServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println(request.getSession(false).getAttribute("login"));
        request.getRequestDispatcher("pages/login.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        User user = userService.login(login);
        if (Objects.nonNull(user.getLogin())) {
            boolean validPassword = HashPasswordUtil.checkPassword(password, user.getPassword());

            if (validPassword) {
                HttpSession session = req.getSession();
                session.setAttribute("login", login);
                session.setAttribute("id", user.getId());
                System.out.println("successful login");

                req.setAttribute("cityList", cityService.getAllCities());

                getServletContext().getRequestDispatcher("/pages/index.jsp").forward(req, resp);
            } else {
                resp.sendError(NOT_AUTHORIZED_HTTP_EXCEPTION);
            }
        } else {
            resp.sendError(FORBIDDEN_HTTP_EXCEPTION);

        }
    }
}
