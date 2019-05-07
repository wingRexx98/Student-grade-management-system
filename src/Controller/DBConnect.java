/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class DBConnect {

    public static Connection connectDatabase() {
        try {
            String url = "jdbc:sqlserver://localhost:1433;databaseName=JavaProject";
            String user = "huy1998";// need to find out
            String password = "1234";// need to find out
            Connection conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (SQLException ex) {
            System.out.println("Error connecting Database: " + ex.getMessage());
            System.exit(0);
            return null;
        }
    }
    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) conn.close();
        } catch (SQLException ex) {
            System.out.println("Error closing Database: " + ex.getMessage());
        }
    }
}
