package servlets;

import dao.UserDAO;
import database.User;
import org.hibernate.SessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(urlPatterns = "/register")
public class RegistrationServlet extends HttpServlet {
    private UserDAO userDAO;
    private Logger logger = Logger.getLogger(RegistrationServlet.class.getName());

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO((SessionFactory) this.getServletContext().getAttribute("sessionFactory"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        if (userDAO.isUsernameAvailable(user.getUsername())) {
            userDAO.save(user);
        } else {
            resp.getWriter().println("Użytkownik już istnieje !");
        }
    }
}
