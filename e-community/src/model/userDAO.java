package model;

import java.sql.*;

public class userDAO {


    private Connection con;

    public userDAO(Connection con) {
        this.con = con;
    }
    

    
    public boolean register(String fullName, String email, String password) {
    String sql = "INSERT INTO users (full_name, email, password) VALUES (?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, fullName);
            ps.setString(2, email);
            ps.setString(3, password);

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        return false;
        }
    }
    
        public boolean emailExists(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (SQLException e) {
           e.printStackTrace();
           return false;
        }
    }



    public User login(String email, String password) {
        User user = null;
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setFullName(rs.getString("full_name"));
                user.setEmail(rs.getString("email"));
                user.setRole(rs.getString("role"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    // Method to count total volunteers for the Dashboard
    public int getVolunteerCount() {
        int count = 0;
        String query = "SELECT COUNT(*) FROM users WHERE role = 'Volunteer'";
        
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
}
