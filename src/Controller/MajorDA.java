/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
public class MajorDA {
    public ArrayList<Major> showAll() {
        Connection conn = DBConnect.connectDatabase();  //getting connection to the database
        String sql = "SELECT * FROM Major";           //sql query command
        ArrayList<Major> mList = new ArrayList<>(); // create the array list for student
        try (Statement stm = conn.createStatement()){
            //Statement stm = conn.createStatement();// PREPARE STATEMENT, a complete command to be executed
            ResultSet rs = stm.executeQuery(sql);//execute sql query
            //loop while the rs.next() != null
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                Major major = new Major(id, name, description);
                mList.add(major);
            }
        } catch (SQLException sqlEx) {
            System.out.println("DB Error: " + sqlEx.getMessage());
        } finally {
            DBConnect.closeConnection(conn);
        }
        return mList;
    }
    
    public int insert (String name,String description){
        Connection conn = DBConnect.connectDatabase();//getting connection to the database
        String sql = "INSERT INTO Major ( name, description) VALUES (?,?)"; //sql query command
        try{
            // Create PREPARE STATEMENT to execute statement multiple times
            PreparedStatement pre_stm = conn.prepareStatement(sql);
            pre_stm.setString(1, name);     //1st value
            pre_stm.setString(2, description);    //2nd value
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
        String sql = "DELETE FROM Major WHERE id = ?"; //sql query command
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
    
    public int update(String name,String description, int id){
        Connection conn = DBConnect.connectDatabase();//getting connection to the database
        String sql = "UPDATE Major SET name = ?, description = ? WHERE id = ?"; //sql query command
        try{
            // Create PREPARE STATEMENT to execute statement multiple times
            PreparedStatement pre_stm = conn.prepareStatement(sql);
            pre_stm.setString   (1, name);    //1st value
            pre_stm.setString   (2, description);     //2nd value
            pre_stm.setInt      (3, id);    //3rd value
            int nRows = pre_stm.executeUpdate();// Execute the pre_stm
            return nRows;
        }catch (SQLException sqlEx) {
            System.out.println("DB Error: " + sqlEx.getMessage());
        } finally {
            DBConnect.closeConnection(conn);
        }
        return 0;
    }
    public static boolean checkStringValidation(String inputStrings) {//String... for cases where there are multiple String
        String patternString = "[a-zA-Z]+([ '-][a-zA-Z]+)*";//work with full name
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
