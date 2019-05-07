/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Admin
 */
import Model.Exam;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class ReportDA {

    public ArrayList<Exam> allList = new ArrayList<>();

    public ArrayList<Exam> showAll(int examId, int batchId) {
        Connection conn = DBConnect.connectDatabase();  //getting connection to the database
        String sql = "SELECT Exam.examid, examName, studentId, subject_Id, Student.name as studentName, subjectName, examDate, mark, examStatus FROM Exam \n"
                + "inner join Student_exam on exam.examid = student_exam.examId\n"
                + "Inner Join Student on Student.id = student_exam.studentId \n"
                + "inner join Subject on subject.id = exam.subject_ID\n"
                + "where batchId = ? AND Exam.examId = ?";
        ArrayList<Exam> rList = new ArrayList<>(); // create the array list for student
        try {
            PreparedStatement pre_stm = conn.prepareStatement(sql);// PREPARE STATEMENT, a complete command to be executed
            pre_stm.setInt(1, batchId);
            pre_stm.setInt(2, examId);
            ResultSet rs = pre_stm.executeQuery();//execute sql query
            //loop while the rs.next() != null
            while (rs.next()) {
                int examID = rs.getInt("examid");
                String examName = rs.getString("examName");
                int studentId = rs.getInt("studentId");
                int subjectID = rs.getInt("subject_Id");
                String studentName = rs.getString("studentName");
                String subjectName = rs.getString("subjectName");
                Date date = rs.getDate("examDate");
                int mark = rs.getInt("mark");
                String status = rs.getString("examStatus");
                Exam report = new Exam(examId, examName, studentId, subjectID, subjectName, studentName, date, mark, status);
                rList.add(report);
            }
            allList = rList;
        } catch (SQLException sqlEx) {
            System.out.println("DB Error: " + sqlEx.getMessage());
        } finally {
            DBConnect.closeConnection(conn);
        }
        return rList;
    }
}
