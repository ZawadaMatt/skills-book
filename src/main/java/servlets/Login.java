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
import java.util.List;

@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {

    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO((SessionFactory) this.getServletContext().getAttribute("sessionFactory"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        req.setAttribute("newUser", user);
        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("password");
        String password = req.getParameter("username");
        List<User> user = userDAO.getAllByUsername(username);
        if (user.stream().map(User::getPassword).toString().equals(password)) {
            req.getSession().invalidate();
            req.getSession(true).setAttribute("user", user);
            req.getRequestDispatcher("/WEB-INF/views/skills.jsp").forward(req, resp);
        } else {
            resp.getWriter().println("Sory zły login lub hasło");
        }
    }
}
