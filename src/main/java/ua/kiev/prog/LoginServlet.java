package ua.kiev.prog;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

public class LoginServlet extends HttpServlet {
    private static final Map<String, String> regUsers = RegisteredUsers.usersGetInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (regUsers.containsKey(login)) {
            String savedPassword = regUsers.get(login);
            if (password.equalsIgnoreCase(savedPassword)) {
                resp.setStatus(HttpServletResponse.SC_OK);
            } else {
                resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        } else {
            resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }

    }
}
