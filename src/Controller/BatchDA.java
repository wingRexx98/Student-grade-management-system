/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Batch;
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
public class BatchDA {

    public ArrayList<Batch> showAll() {
        Connection conn = DBConnect.connectDatabase();  //getting connection to the database
        String sql = "select batchId, batch, subject_ID, subjectName from batch inner join subject on subject_ID = id";           //sql query command
        ArrayList<Batch> batchList = new ArrayList<>(); // create the array list for student
        try {
            Statement stm = conn.createStatement();// PREPARE STATEMENT, a complete command to be executed
            ResultSet rs = stm.executeQuery(sql);//execute sql query
            //loop while the rs.next() != null
            while (rs.next()) {
                int batchId = rs.getInt("batchId");
                String batch = rs.getString("batch");
                int subjectId = rs.getInt("subject_ID");
                String subjectName = rs.getString("subjectName");
                Batch exam = new Batch(batchId, batch, subjectId, subjectName);
                batchList.add(exam);
            }
        } catch (SQLException sqlEx) {
            System.out.println("DB Error: " + sqlEx.getMessage());
        } finally {
            DBConnect.closeConnection(conn);
        }
        return batchList;
    }

    public int insert(String batch, int subjectId) {
        Connection conn = DBConnect.connectDatabase();//getting connection to the database
        String sql = "INSERT INTO BATCH(subject_ID, batch) values (?, ?)"; //sql query command
        try {
            // Create PREPARE STATEMENT to execute statement multiple times
            PreparedStatement pre_stm = conn.prepareStatement(sql);
            pre_stm.setInt      (1, subjectId);
            pre_stm.setString   (2, batch);
            int nRows = pre_stm.executeUpdate();// Execute the pre_stm
            return nRows;
        } catch (SQLException sqlEx) {
            System.out.println("DB Error: " + sqlEx.getMessage());
        } finally {
            DBConnect.closeConnection(conn);
        }
        return 0;
    }

    public int delete(int batchId) {
        Connection conn = DBConnect.connectDatabase();//getting connection to the database
        String sql = "DELETE FROM Batch WHERE batchId = ?"; //sql query command
        try {
            // Create PREPARE STATEMENT to execute statement multiple times
            PreparedStatement pre_stm = conn.prepareStatement(sql);
            pre_stm.setInt(1, batchId);
            int nRows = pre_stm.executeUpdate();// Execute the pre_stm
            return nRows;
        } catch (SQLException sqlEx) {
            System.out.println("DB Error: " + sqlEx.getMessage());
        } finally {
            DBConnect.closeConnection(conn);
        }
        return 0;
    }

    public int update(int subjectId, String batch, int batchId) {
        Connection conn = DBConnect.connectDatabase();//getting connection to the database
        String sql = "UPDATE Batch SET subjectID = ?, batch =? Where batchId = ?"; //sql query command
        try {
            // Create PREPARE STATEMENT to execute statement multiple times
            PreparedStatement pre_stm = conn.prepareStatement(sql);
            pre_stm.setInt(1, subjectId);
            pre_stm.setString(2, batch);
            pre_stm.setInt(3, batchId);
            int nRows = pre_stm.executeUpdate();// Execute the pre_stm
            return nRows;
        } catch (SQLException sqlEx) {
            System.out.println("DB Error: " + sqlEx.getMessage());
        } finally {
            DBConnect.closeConnection(conn);
        }
        return 0;
    }
    public static boolean checkStringValidation(String inputStrings) {// change the BatchDA into bDA for views if delee keyword "static"
        String patternString = "GCH\\d{4}";//work with full name
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
