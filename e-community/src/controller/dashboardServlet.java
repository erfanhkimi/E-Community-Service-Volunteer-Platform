package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.eventDAO;
import model.userDAO;
import model.volunteerDAO;

@WebServlet("/dashboard")
public class dashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. Create instances of your DAOs
        eventDAO eDao = new eventDAO();
        volunteerDAO vDao = new volunteerDAO();

        // 2. Call the methods on the objects (not the class names)
        int totalEvents = eDao.getTotalCount();  
        int totalUsers = vDao.getUserCount();    // This fix solves your error
        int totalHours = vDao.getTotalHours();

        // 3. Set these values as "Request Attributes"
        request.setAttribute("eventCount", totalEvents);
        request.setAttribute("userCount", totalUsers);
        request.setAttribute("hourCount", totalHours);

        // 4. Forward the request to the JSP page
        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
    }
}