/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Courses;
import Model.Major;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Pattern;
/**
 *
 * @author Admin
 */
public class CourseDA {
    public ArrayList<Courses> showAll() {
        Connection conn = DBConnect.connectDatabase();  //getting connection to the database
        String sql = "SELECT COURSE.id as courseId,COURSE.majorID, courseName, COURSE.description, Major.name As mayjorName "
                + "from COURSE INNER JOIN MAJOR ON COURSE.majorID = MAJOR.id";
        ArrayList<Courses> cList = new ArrayList<>(); // create the array list for student
        try {
            Statement stm = conn.createStatement();// PREPARE STATEMENT, a complete command to be executed
            ResultSet rs = stm.executeQuery(sql);//execute sql query
            //loop while the rs.next() != null
            while (rs.next()) {
                int id = rs.getInt("courseId");
                int majorId = rs.getInt("majorId");
                String name = rs.getString("courseName");
                String description = rs.getString("description");
                String majorName = rs.getString("mayjorName");
                Courses course = new Courses(id, majorId, name, description, majorName);
                cList.add(course);
            }
        } catch (SQLException sqlEx) {
            System.out.println("DB Error: " + sqlEx.getMessage());
        } finally {
            DBConnect.closeConnection(conn);
        }
        return cList;
    }

    
    public int insert (int majorId, String name,String description){
        Connection conn = DBConnect.connectDatabase();//getting connection to the database
        String sql = "INSERT INTO Course (majorID, courseName, description) VALUES (?, ?, ?)"; //sql query command
        try{
            // Create PREPARE STATEMENT to execute statement multiple times
            PreparedStatement pre_stm = conn.prepareStatement(sql);
            pre_stm.setInt(1, majorId);            //1st value
            pre_stm.setString(2, name);            //2nd value
            pre_stm.setString(3, description);    //3rd value
            int nRows = pre_stm.executeUpdate();// Execute the pre_stm
            return nRows;
        }catch (SQLException sqlEx) {
            System.out.println("DB Error: " + sqlEx.getMessage());
        } finally {
            DBConnect.closeConnection(conn);
        }
        return 0;
    }
    
    public int delete(int id){
        Connection conn = DBConnect.connectDatabase();//getting connection to the database
        String sql = "DELETE FROM Course WHERE id = ?"; //sql query command
        try{
            // Create PREPARE STATEMENT to execute statement multiple times
            PreparedStatement pre_stm = conn.prepareStatement(sql);
            pre_stm.setInt(1, id);    //1st value
            int nRows = pre_stm.executeUpdate();// Execute the pre_stm
            return nRows;
        }catch (SQLException sqlEx) {
            System.out.println("DB Error: " + sqlEx.getMessage());
        } finally {
            DBConnect.closeConnection(conn);
        }
        return 0;
    }
    
    public int update(String name,String description, int majorId, int id){
        Connection conn = DBConnect.connectDatabase();//getting connection to the database
        String sql = "UPDATE Course SET name = ?, description = ?, majorID = ? WHERE id = ?"; //sql query command
        try{
            // Create PREPARE STATEMENT to execute statement multiple times
            PreparedStatement pre_stm = conn.prepareStatement(sql);
            pre_stm.setString   (1, name);    //1st value
            pre_stm.setString   (2, description);     //2nd value
            pre_stm.setInt      (3, majorId);
            pre_stm.setInt      (4, id);    //3rd value
            int nRows = pre_stm.executeUpdate();// Execute the pre_stm
            return nRows;
        }catch (SQLException sqlEx) {
            System.out.println("DB Error: " + sqlEx.getMessage());
        } finally {
            DBConnect.closeConnection(conn);
        }
        return 0;
    }
    
    public static boolean checkStringValidation(String inputStrings) {
        String patternString = "[a-zA-Z]+([ '-][a-zA-Z0-9]+)*";
        Pattern pattern = Pattern.compile(patternString);
        if (inputStrings == null) {
            return false;
        }
        else if (!pattern.matcher(inputStrings).matches()) {
            return false;
        }
        return true;
    }
}
