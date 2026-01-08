package controller;

import model.User;
import model.userDAO;
import java.io.IOException;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // JDBC connection
        Connection con = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection(
                "jdbc:derby://localhost:1527/ecommunity", "app", "app"
            );

            userDAO userDAO = new userDAO(con);
            User user = userDAO.login(email, password);

            if (user != null) {
                // Successful login → create session
                HttpSession session = request.getSession();
                session.setAttribute("currentUser", user);
                response.sendRedirect("dashboard.jsp");
            } else {
                // Failed login
                request.setAttribute("message", "Invalid email or password");
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (con != null) con.close(); } catch (Exception e) {}
        }
    }
}
