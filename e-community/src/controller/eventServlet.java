package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import model.Event;
import model.eventDAO;

@WebServlet("/eventServlet")
public class eventServlet extends HttpServlet {

    // Handles Viewing the List and Deleting (Actions triggered by links)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        eventDAO dao = new eventDAO();

        if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            dao.deleteEvent(id);
            // After deleting, refresh the list
            response.sendRedirect("eventServlet?action=list");
        } else {
            // Default action: Fetch from PROGRAMS table and show event_list.jsp
            List<Event> events = dao.getAllEvents();
            request.setAttribute("events", events);
            request.getRequestDispatcher("event_list.jsp").forward(request, response);
        }
    }

    // Handles Form Submission (Creating a new event)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. Get data from the form (Ensure these match your <input name="...">)
        String name = request.getParameter("eventName");
        String date = request.getParameter("eventDate");
        String location = request.getParameter("location"); // Added to match your DB schema
        String desc = request.getParameter("description");

        // 2. Populate the JavaBean
        Event newEvent = new Event();
        newEvent.setEventName(name);
        newEvent.setEventDate(date);
        newEvent.setDescription(desc);
        // If your Event bean has a location field, add: newEvent.setLocation(location);

        // 3. Use DAO to save to database
        eventDAO dao = new eventDAO();
        boolean success = dao.addEvent(newEvent);

        // 4. Redirect to the LIST action to see the new entry
        if (success) {
            response.sendRedirect("eventServlet?action=list"); 
        } else {
            request.setAttribute("message", "Error adding event.");
            request.getRequestDispatcher("event_create.jsp").forward(request, response);
        }
    }
}