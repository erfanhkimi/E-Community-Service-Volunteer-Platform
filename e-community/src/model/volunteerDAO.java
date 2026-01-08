package model;

import java.sql.*;

public class volunteerDAO {

    public static int getTotalHours() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // 1. Registration Module: Save a new volunteer to the database
    public boolean registerVolunteer(volunteer volunteer) {
        String sql = "INSERT INTO users (full_name, email, password, role) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, volunteer.getFullName());
            ps.setString(2, volunteer.getEmail());
            ps.setString(3, volunteer.getPassword());
            ps.setString(4, volunteer.getRole());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 2. Login Module: Validate user credentials
    public volunteer validateLogin(String email, String password) {
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                volunteer v = new volunteer();
                v.setId(rs.getInt("id"));
                v.setFullName(rs.getString("full_name"));
                v.setEmail(rs.getString("email"));
                v.setRole(rs.getString("role"));
                return v;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Login failed
    }

    // 3. Dashboard Module: Get total volunteer count for display
    public int getVolunteerCount() {
        int count = 0;
        String sql = "SELECT COUNT(*) FROM users";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
    
    public int getUserCount() {
        int count = 0;
        // The SQL query to get the total number of rows in the users table
        String sql = "SELECT COUNT(*) AS total FROM users";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                // Retrieve the result from the "total" column alias
                count = rs.getInt("total");
            }
        } catch (SQLException e) {
            // Log the error for debugging
            System.out.println("Error in getUserCount: " + e.getMessage());
        }
        return count;
    }
    
    public boolean joinEvent(int userId, int eventId) {
    String sql = "INSERT INTO event_registrations (user_id, event_id, registration_date) VALUES (?, ?, NOW())";
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
        ps.setInt(1, userId);
        ps.setInt(2, eventId);
        
        return ps.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
        }
    }
        
        
}