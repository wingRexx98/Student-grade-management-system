/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Student;
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
public class StudentDA {

    private ArrayList<Student> allStudent = new ArrayList<>();

    public ArrayList<Student> showAll() {
        Connection conn = DBConnect.connectDatabase();  //getting connection to the database
        String sql = "SELECT id, name, phone, email, address, Batch.batchID, batch FROM Student Inner Join Batch on Student.batchId= Batch.batchId";           //sql query command
        ArrayList<Student> stdList = new ArrayList<>(); // create the array list for student
        try {
            Statement stm = conn.createStatement();// PREPARE STATEMENT, a complete command to be executed
            ResultSet rs = stm.executeQuery(sql);//execute sql query
            //loop while the rs.next() != null
            while (rs.next()) {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                int batchId = rs.getInt("batchId");
                String batch = rs.getString("batch");
                String address = rs.getString("address");
                Student student = new Student(id, email, name, phone, batchId, batch, address);
                stdList.add(student);
            }
            allStudent = stdList;
        } catch (SQLException sqlEx) {
            System.out.println("DB Error: " + sqlEx.getMessage());
        } finally {
            DBConnect.closeConnection(conn);
        }
        return stdList;
    }

    public int insert(String email, String name, String phone, int batch, String address) {
        Connection conn = DBConnect.connectDatabase();//getting connection to the database
        String sql = "INSERT INTO Student (email, name, phone, batchId, address) VALUES (?,?,?,?,?)"; //sql query command
        try {
            // Create PREPARE STATEMENT to execute statement multiple times
            PreparedStatement pre_stm = conn.prepareStatement(sql);
            pre_stm.setString(1, email);    //1st value
            pre_stm.setString(2, name);     //2nd value
            pre_stm.setString(3, phone);    //3rd value
            pre_stm.setInt(4, batch);    //4th value
            pre_stm.setString(5, address);  //5th value
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
        String sql = "DELETE FROM Student WHERE id = ?"; //sql query command
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

    public int update(String email, String name, String phone, int batchId, String address, int id) {
        Connection conn = DBConnect.connectDatabase();//getting connection to the database
        String sql = "UPDATE Student SET email = ?, name = ?, phone = ?, batchId = ?, address = ? WHERE id = ?"; //sql query command
        try {
            // Create PREPARE STATEMENT to execute statement multiple times
            PreparedStatement pre_stm = conn.prepareStatement(sql);
            pre_stm.setString(1, email);    //1st value
            pre_stm.setString(2, name);     //2nd value
            pre_stm.setString(3, phone);    //3rd value
            pre_stm.setInt(4, batchId);    //4th value
            pre_stm.setString(5, address);  //5th value
            pre_stm.setInt(6, id);       //6st value
            int nRows = pre_stm.executeUpdate();// Execute the pre_stm
            return nRows;
        } catch (SQLException sqlEx) {
            System.out.println("DB Error: " + sqlEx.getMessage());
        } finally {
            DBConnect.closeConnection(conn);
        }
        return 0;
    }

    public ArrayList<Student> getListByClass(String selectedBatch) {
        ArrayList<Student> listByClass = new ArrayList<>();
        if (selectedBatch.equalsIgnoreCase("--List of batch/classes --")) {
            listByClass = allStudent;
        } else {
            //Loc nhung sinh vien co thuoc tinh lop = selectedClass
            for (Student each : allStudent) {
                if (each.getBatch().equalsIgnoreCase(selectedBatch)) {
                    listByClass.add(each);
                }
            }
        }return listByClass;
    }

    public static boolean checkStringValidation(String... inputStrings) {//String... for cases where there are multiple String
        String patternString = "[a-zA-Z]+([ '-][a-zA-Z]+)*";//work with full name
        Pattern pattern = Pattern.compile(patternString);
        for (String each : inputStrings) {
            if (inputStrings == null) {
                return false;
            }
            if (!pattern.matcher(each).matches()) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkIntegerValidation(String inputStrings) {
        String patternString = "\\d{9}";
        Pattern pattern = Pattern.compile(patternString);
        if (inputStrings == null) {
            return false;
        } else if (!pattern.matcher(inputStrings).matches()) {
            return false;
        }
        return true;
    }

    public static boolean checkEmailValidation(String inputStrings) {
        String patternString = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(patternString);
        if (inputStrings == null) {
            return false;
        } else if (!pattern.matcher(inputStrings).matches()) {
            return false;
        }
        return true;
    }
}
