package controller;

import model.userDAO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String message;

        // Basic validation
        if (fullName.isEmpty() || email.isEmpty() || password.isEmpty()) {
            message = "All fields are required.";
        } else if (password.length() < 6) {
            message = "Password must be at least 6 characters.";
        } else {

            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                Connection con = DriverManager.getConnection(
                        "jdbc:derby://localhost:1527/ecommunity", "app", "app"
                );

                userDAO dao = new userDAO(con);

                if (dao.emailExists(email)) {
                    message = "Email already registered.";
                } else {
                    boolean success = dao.register(fullName, email, password);

                    if (success) {
                        message = "Registration successful. You can now login.";
                    } else {
                        message = "Registration failed. Try again.";
                    }
                }

                con.close();

            } catch (Exception e) {
                e.printStackTrace();
                message = "Database error.";
            }
        }

        request.setAttribute("message", message);
        RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
        rd.forward(request, response);
    }
}
