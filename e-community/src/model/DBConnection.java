package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // 1. Load the Apache Derby Client Driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            
            // 2. Use your Derby URL 
            // Note: Use "app" for both user and password if you haven't changed them
            String url = "jdbc:derby://localhost:1527/ecommunity"; 
            String user = "app"; 
            String password = "app"; 
            
            conn = DriverManager.getConnection(url, user, password);
            
        } catch (Exception e) {
            System.out.println("Derby Connection Failed! Error: " + e.getMessage());
            e.printStackTrace(); 
        }
        return conn;
    }
}