/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Exam;
import java.sql.Connection;
import java.sql.Date;
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
public class ExamDA {

    public ArrayList<Exam> showAll() {
        Connection conn = DBConnect.connectDatabase();  //getting connection to the database
        String sql = "SELECT Exam.examid, examName, studentId, subject_Id, Student.name as studentName, subjectName, examDate, mark, examStatus FROM Exam \n"
                + "inner join Student_exam on exam.examid = student_exam.examId\n"
                + "Inner Join Student on Student.id = student_exam.studentId \n"
                + "inner join Subject on subject.id = exam.subject_ID\n"
                + "group by exam.examid, examName, student_exam.studentId,exam.subject_Id, Student.name, subjectName,examDate, mark, examStatus";
        ArrayList<Exam> examList = new ArrayList<>(); // create the array list for student
        try {
            Statement stm = conn.createStatement();// PREPARE STATEMENT, a complete command to be executed
            ResultSet rs = stm.executeQuery(sql);//execute sql query
            //loop while the rs.next() != null
            while (rs.next()) {
                int examId = rs.getInt("examid");
                String examName = rs.getString("examName");
                int studentId = rs.getInt("studentId");
                int subjectId = rs.getInt("subject_Id");
                String studentName = rs.getString("studentName");
                String subjectName = rs.getString("subjectName");
                Date date = rs.getDate("examDate");
                int mark = rs.getInt("mark");
                String status = rs.getString("examStatus");
                Exam exam = new Exam(examId, examName, studentId, subjectId, subjectName, studentName, date, mark, status);
                examList.add(exam);
            }
        } catch (SQLException sqlEx) {
            System.out.println("DB Error: " + sqlEx.getMessage());
        } finally {
            DBConnect.closeConnection(conn);
        }
        return examList;
    }

    public int insertNewExam(String examName, int subjectId, Date date) {
        Connection conn = DBConnect.connectDatabase();//getting connection to the database
        String sql = "INSERT INTO Exam (examName, subject_ID, examDate) VALUES (?, ?,?)"; //sql query command
        try {
            // Create PREPARE STATEMENT to execute statement multiple times
            PreparedStatement pre_stm = conn.prepareStatement(sql);
            pre_stm.setString(1, examName);
            pre_stm.setInt(2, subjectId);
            pre_stm.setDate(3, date);
            int nRows = pre_stm.executeUpdate();// Execute the pre_stm
            return nRows;
        } catch (SQLException sqlEx) {
            System.out.println("DB Error: " + sqlEx.getMessage());
        } finally {
            DBConnect.closeConnection(conn);
        }
        return 0;
    }

    public int insertStudentIntoExam(int examId, int studentId) {
        Connection conn = DBConnect.connectDatabase();//getting connection to the database
        String sql = "INSERT INTO Student_Exam (examId, studentID) VALUES (?, ?)"; //sql query command
        try {
            // Create PREPARE STATEMENT to execute statement multiple times
            PreparedStatement pre_stm = conn.prepareStatement(sql);
            pre_stm.setInt(1, examId);
            pre_stm.setInt(2, studentId);
            int nRows = pre_stm.executeUpdate();// Execute the pre_stm
            return nRows;
        } catch (SQLException sqlEx) {
            System.out.println("DB Error: " + sqlEx.getMessage());
        } finally {
            DBConnect.closeConnection(conn);
        }
        return 0;
    }
    
    public int deleteStudentScore(int studentId, int examId) {
        Connection conn = DBConnect.connectDatabase();//getting connection to the database
        String sql = "DELETE FROM Student_Exam WHERE studentID = ? AND examID = ?"; //sql query command
        try {
            // Create PREPARE STATEMENT to execute statement multiple times
            PreparedStatement pre_stm = conn.prepareStatement(sql);
            pre_stm.setInt(1, studentId);
            pre_stm.setInt(2, examId);
            int nRows = pre_stm.executeUpdate();// Execute the pre_stm
            return nRows;
        } catch (SQLException sqlEx) {
            System.out.println("DB Error: " + sqlEx.getMessage());
        } finally {
            DBConnect.closeConnection(conn);
        }
        return 0;
    }

    public int updateStudentMark(int mark, String status, int studentId, int subjectId) {
        Connection conn = DBConnect.connectDatabase();//getting connection to the database
        String sql = "UPDATE Student_Exam SET mark = ?, examStatus = ? WHERE studentID = ? AND examID = ?"; //sql query command
        try {
            // Create PREPARE STATEMENT to execute statement multiple times
            PreparedStatement pre_stm = conn.prepareStatement(sql);
            pre_stm.setInt(1, mark);
            pre_stm.setString(2, status);
            pre_stm.setInt(3, studentId);
            pre_stm.setInt(4, subjectId);
            int nRows = pre_stm.executeUpdate();// Execute the pre_stm
            return nRows;
        } catch (SQLException sqlEx) {
            System.out.println("DB Error: " + sqlEx.getMessage());
        } finally {
            DBConnect.closeConnection(conn);
        }
        return 0;
    }
    
    public ArrayList<Exam> existEntry() {
        Connection conn = DBConnect.connectDatabase();  //getting connection to the database
        String sql = "SELECT examId, studentId FROM Student_Exam";
        ArrayList<Exam> examList = new ArrayList<>(); // create the array list for student
        try {
            Statement stm = conn.createStatement();// PREPARE STATEMENT, a complete command to be executed
            ResultSet rs = stm.executeQuery(sql);//execute sql query
            //loop while the rs.next() != null
            while (rs.next()) {
                int examId = rs.getInt("examid");
                int studentId = rs.getInt("studentId");
                Exam exam = new Exam(examId, studentId);
                examList.add(exam);
            }
        } catch (SQLException sqlEx) {
            System.out.println("DB Error: " + sqlEx.getMessage());
        } finally {
            DBConnect.closeConnection(conn);
        }
        return examList;
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
