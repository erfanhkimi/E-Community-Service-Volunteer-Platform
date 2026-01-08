package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class eventDAO {

    public static int getTotalCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    // Method to count total events for the Dashboard
    public int getTotalEventCount() {
        int count = 0;
        String query = "SELECT COUNT(*) FROM events";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
    
    // Create: Function to add a new event
public boolean addEvent(Event event) {
    // Correct table: PROGRAMS | Correct column: TITLE
    String query = "INSERT INTO APP.PROGRAMS (TITLE, EVENT_DATE, DESCRIPTION, LOCATION) VALUES (?, ?, ?, ?)";
    
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(query)) {
        
        ps.setString(1, event.getEventName());
        ps.setString(2, event.getEventDate());
        ps.setString(3, event.getDescription());
        ps.setString(4, "General"); // Location is required in your schema
        
        return ps.executeUpdate() > 0;
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}
    
public List<Event> getAllEvents() {
    List<Event> list = new ArrayList<>();
    // Use the exact table name from your image: PROGRAMS
    String sql = "SELECT * FROM APP.PROGRAMS"; 
    
    try (Connection conn = DBConnection.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {
        
        while (rs.next()) {
            Event e = new Event();
            // Match the column names from your image
            e.setId(rs.getInt("ID"));
            e.setEventName(rs.getString("TITLE")); // Image shows 'TITLE' instead of 'EVENT_NAME'
            e.setEventDate(rs.getString("EVENT_DATE"));
            e.setDescription(rs.getString("DESCRIPTION"));
            list.add(e);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}

    public boolean deleteEvent(int id) {
        String sql = "DELETE FROM events WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
        return ps.executeUpdate() > 0;
    } catch (SQLException e) { e.printStackTrace(); return false; }
    }
}