/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Subject;
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
public class SubjectDA {

    public ArrayList<Subject> showAll() {
        Connection conn = DBConnect.connectDatabase();  //getting connection to the database
        String sql = "SELECT Subject.id as sub_Id, Subject.courseID, Subject.subjectName, "
                + "Subject.description, Course.courseName \n"
                + " from Subject INNER JOIN Course ON "
                + "Subject.courseID = Course.id";           //sql query command
        ArrayList<Subject> subList = new ArrayList<>(); // create the array list for student
        try {
            Statement stm = conn.createStatement();// PREPARE STATEMENT, a complete command to be executed
            ResultSet rs = stm.executeQuery(sql);//execute sql query
            //loop while the rs.next() != null
            while (rs.next()) {
                int id = rs.getInt("sub_Id");
                int courseId = rs.getInt("courseID");
                String name = rs.getString("subjectName");
                String description = rs.getString("description");
                String courseName = rs.getString("courseName");
                Subject subject = new Subject(id, courseId, name, description, courseName);
                subList.add(subject);
            }
        } catch (SQLException sqlEx) {
            System.out.println("DB Error: " + sqlEx.getMessage());
        } finally {
            DBConnect.closeConnection(conn);
        }
        return subList;
    }

    public int insert(int courseId, String name, String description) {
        Connection conn = DBConnect.connectDatabase();//getting connection to the database
        String sql = "INSERT INTO Subject (courseID, subjectName, description) VALUES (?, ?,?)"; //sql query command
        try {
            // Create PREPARE STATEMENT to execute statement multiple times
            PreparedStatement pre_stm = conn.prepareStatement(sql);
            pre_stm.setInt      (1, courseId);            //1st value
            pre_stm.setString   (2, name);            //2nd value
            pre_stm.setString   (3, description);    //3rd value
            int nRows = pre_stm.executeUpdate();// Execute the pre_stm
            return nRows;
        } catch (SQLException sqlEx) {
            System.out.println("DB Error: " + sqlEx.getMessage());
        } finally {
            DBConnect.closeConnection(conn);
        }
        return 0;
    }

    public int delete(int id) {
        Connection conn = DBConnect.connectDatabase();//getting connection to the database
        String sql = "DELETE FROM Subject WHERE id = ?"; //sql query command
        try {
            // Create PREPARE STATEMENT to execute statement multiple times
            PreparedStatement pre_stm = conn.prepareStatement(sql);
            pre_stm.setInt(1, id);    //1st value
            int nRows = pre_stm.executeUpdate();// Execute the pre_stm
            return nRows;
        } catch (SQLException sqlEx) {
            System.out.println("DB Error: " + sqlEx.getMessage());
        } finally {
            DBConnect.closeConnection(conn);
        }
        return 0;
    }

    public int update(String name, String description, int courseId, int id) {
        Connection conn = DBConnect.connectDatabase();//getting connection to the database
        String sql = "UPDATE Subject SET subjectName = ?, description = ?, courseId = ? WHERE id = ?"; //sql query command
        try {
            // Create PREPARE STATEMENT to execute statement multiple times
            PreparedStatement pre_stm = conn.prepareStatement(sql);
            pre_stm.setString(1, name);    //1st value
            pre_stm.setString(2, description);     //2nd value
            pre_stm.setInt(3, courseId);
            pre_stm.setInt(4, id);    //3rd value
            int nRows = pre_stm.executeUpdate();// Execute the pre_stm
            return nRows;
        } catch (SQLException sqlEx) {
            System.out.println("DB Error: " + sqlEx.getMessage());
        } finally {
            DBConnect.closeConnection(conn);
        }
        return 0;
    }
    
    public static boolean checkStringValidation(String inputStrings) {
        String patternString = "[a-zA-Z]+([ '-][a-zA-Z]+)*";
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
