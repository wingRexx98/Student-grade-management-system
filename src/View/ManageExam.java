/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DBConnect;
import Controller.ExamDA;
import Model.Batch;
import Model.Exam;
import Model.Student;
import Model.Subject;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class ManageExam extends javax.swing.JFrame {

    /**
     * Creates new form ManageExam
     */
    private DefaultTableModel myTableModel;
    public ArrayList<Subject> subList = new ArrayList<>();
    int id = 0;
    ArrayList<Student> sList = new ArrayList<>();
    ArrayList<Exam> eList = new ArrayList<>();
    private int sId = 0;
    private int eId = 0;
    private ArrayList<Exam> examList;
    ExamDA eDA = new ExamDA();

    public ManageExam() {
        initComponents();
        loadExamList();
        fill_Combobox();
        fillExamCombobox();
        fillStudentCombobox();
    }

    public void loadExamList() {
        examList = eDA.showAll();
        myTableModel.setRowCount(0);
        for (Exam each : examList) {
            Object[] aRow = {each.getExamId(), each.getExamName(), each.getSubjectName(), each.getStudentName(), each.getDate(), each.getMark()};
            myTableModel.addRow(aRow);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        cbbSubject = new javax.swing.JComboBox<>();
        cbbStudent = new javax.swing.JComboBox<>();
        txtMark = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblExam = new JTable();
        String[] title = {"Exam ID","Exam Name","Subject", "Student", "Date"};
        myTableModel = new DefaultTableModel(title, 0);
        tblExam.setModel(myTableModel);
        ;
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnAddStudentToExam = new javax.swing.JButton();
        cbbExamName = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manage Exam");

        jLabel5.setText("Mark/Score");

        cbbSubject.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- List of subject --" }));
        cbbSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbSubjectActionPerformed(evt);
            }
        });

        cbbStudent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- List of student --" }));

        btnAdd.setText("Add Exam");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel1.setText("Subject");

        jLabel3.setText("Student");

        jLabel4.setText("Exam name");

        tblExam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblExamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblExam);

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnAddStudentToExam.setText("Add student to exam");
        btnAddStudentToExam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStudentToExamActionPerformed(evt);
            }
        });

        cbbExamName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- List of exam --" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btnUpdate)
                        .addGap(35, 35, 35)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addComponent(btnAdd))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddStudentToExam)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtMark)
                                .addComponent(cbbExamName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbbStudent, 0, 230, Short.MAX_VALUE)
                                .addComponent(cbbSubject, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cbbSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbbStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbbExamName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtMark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnUpdate)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnAdd)
                                .addComponent(btnDelete)))
                        .addGap(18, 18, 18)
                        .addComponent(btnAddStudentToExam)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int rowIndex = tblExam.getSelectedRow();
        cbbExamName.disable();
        cbbStudent.disable();
        cbbSubject.disable();
        if (rowIndex != -1) {
            Exam exam = examList.get(rowIndex);
            int studentId = getSelectedStudentIndex();
            int examId = getSelectedExamIndex();
            int nRow = eDA.deleteStudentScore(studentId, examId);
            if (rowIndex != 0) {
                JOptionPane.showMessageDialog(rootPane, "Delete Success!");
                loadExamList();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Delete Failed");
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        AddExam aExam = new AddExam();
        aExam.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnAddStudentToExamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStudentToExamActionPerformed
        AddStudentToExam addStoE = new AddStudentToExam();
        addStoE.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAddStudentToExamActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            int rowIndex = tblExam.getSelectedRow();
            if (rowIndex != -1) {
                Exam exam = examList.get(rowIndex);
                int studentId = getSelectedStudentIndex();
                int subjectId = getSelectedIndex();
                cbbExamName.disable();
                cbbStudent.disable();
                cbbSubject.disable();
                int mark = parseInt(txtMark.getText());
                String status;
                if (mark >= 90) {
                    status = "Distinction";
                } else if (mark >= 80 && mark < 90) {
                    status = "Merit";
                } else if (mark >= 60 && mark < 80) {
                    status = "Pass";
                } else {
                    status = "Fail";
                }
                int nRow = eDA.updateStudentMark(mark, status, studentId, subjectId);
                if (nRow != 0) {
                    JOptionPane.showMessageDialog(rootPane, "Update Success!");
                    loadExamList();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Update Failed");
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tblExamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblExamMouseClicked
        int rowIndex = tblExam.getSelectedRow();//Lay index cua row dc chon
        Exam selectedItem = examList.get(rowIndex);//Truy xuat phan tu thu Row Index trong stdList
        cbbStudent.setSelectedItem(selectedItem.getStudentName());
        cbbSubject.setSelectedItem(selectedItem.getSubjectName());
        cbbExamName.setSelectedItem(selectedItem.getExamName());
        cbbExamName.disable();
        cbbStudent.disable();
        cbbSubject.disable();
        txtMark.setText(selectedItem.getMark() + "");
    }//GEN-LAST:event_tblExamMouseClicked

    private void cbbSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbSubjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbSubjectActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ManageExam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ManageExam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ManageExam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ManageExam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ManageExam().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddStudentToExam;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbbExamName;
    private javax.swing.JComboBox<String> cbbStudent;
    private javax.swing.JComboBox<String> cbbSubject;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblExam;
    private javax.swing.JTextField txtMark;
    // End of variables declaration//GEN-END:variables
public int getSelectedIndex() {
        String name = (String) cbbSubject.getSelectedItem();
        for (Subject each : subList) {
            if (each.getName().equalsIgnoreCase(name)) {
                id = each.getId();
                System.out.println(id);
                break;
            }
        }
        return id;
    }

    public void fill_Combobox() {//get the name from the database to show in the combobex
        Connection conn = DBConnect.connectDatabase();  //getting connection to the database
        String sql = "SELECT Subject.id as sub_Id, Subject.courseID, Subject.subjectName, "
                + "Subject.description, Course.courseName \n"
                + " from Subject INNER JOIN Course ON "
                + "Subject.courseID = Course.id";           //sql query command
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
                cbbSubject.addItem(name);
            }
        } catch (SQLException sqlEx) {
            System.out.println("DB Error: " + sqlEx.getMessage());
        } finally {
            DBConnect.closeConnection(conn);
        }
    }

    public int getSelectedStudentIndex() {
        String name = (String) cbbStudent.getSelectedItem();
        for (Student each : sList) {
            if (each.getName().equalsIgnoreCase(name)) {
                sId = each.getId();
                System.out.println(sId);
                break;
            }
        }
        return sId;
    }

    public void fillStudentCombobox() {//get the name from the database to show in the combobex
        Connection conn = DBConnect.connectDatabase();  //getting connection to the database
        String sql = "SELECT id, name FROM Student";           //sql query command
        try {
            Statement stm = conn.createStatement();// PREPARE STATEMENT, a complete command to be executed
            ResultSet rs = stm.executeQuery(sql);//execute sql query
            //loop while the rs.next() != null
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Student student = new Student(id, name);
                sList.add(student);
                cbbStudent.addItem(name);
            }
        } catch (SQLException sqlEx) {
            System.out.println("DB Error: " + sqlEx.getMessage());
        } finally {
            DBConnect.closeConnection(conn);
        }
    }

    public int getSelectedExamIndex() {
        String name = (String) cbbExamName.getSelectedItem();
        for (Exam each : eList) {
            if (each.getExamName().equalsIgnoreCase(name)) {
                eId = each.getExamId();
                System.out.println(eId);
                break;
            }
        }
        return eId;
    }

    public void fillExamCombobox() {//get the name from the database to show in the combobex
        Connection conn = DBConnect.connectDatabase();  //getting connection to the database
        String sql = "SELECT examId, examName from Exam";           //sql query command
        try {
            Statement stm = conn.createStatement();// PREPARE STATEMENT, a complete command to be executed
            ResultSet rs = stm.executeQuery(sql);//execute sql query
            //loop while the rs.next() != null
            while (rs.next()) {
                int examId = rs.getInt("examid");
                String examName = rs.getString("examName");
                Exam exam = new Exam(examId, examName);
                eList.add(exam);
                cbbExamName.addItem(examName);
            }
        } catch (SQLException sqlEx) {
            System.out.println("DB Error: " + sqlEx.getMessage());
        } finally {
            DBConnect.closeConnection(conn);
        }
    }
}
