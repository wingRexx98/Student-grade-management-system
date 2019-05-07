/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Exam {
    private int examId;
    private String examName;
    private int studentId;
    private int subjectId;
    private String subjectName;
    private String studentName;
    private Date date;
    private int mark;
    private String status;

    public String getStatus() {
        return status;
    }

    public Exam(int examId, int studentId) {
        this.examId = examId;
        this.studentId = studentId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Exam(int examId, String examName, int studentId, int subjectId, String subjectName, String studentName, Date date, int mark, String status) {
        this.examId = examId;
        this.examName = examName;
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.studentName = studentName;
        this.date = date;
        this.mark = mark;
        this.status = status;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public Exam(int examId, String examName) {
        this.examId = examId;
        this.examName = examName;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public Exam() {
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
    
}
