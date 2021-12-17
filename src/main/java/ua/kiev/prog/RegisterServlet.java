package ua.kiev.prog;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

public class RegisterServlet extends HttpServlet {
    private static final Map<String, String> regUsers = RegisteredUsers.usersGetInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (regUsers.containsKey(login)) {
            resp.setStatus(HttpServletResponse.SC_CONFLICT);
        } else {
            regUsers.put(login, password);
            resp.setStatus(HttpServletResponse.SC_OK);
        }
    }
}
