/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DBConnect;
import Controller.ExamDA;
import Model.Subject;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class AddExam extends javax.swing.JFrame {

    /**
     * Creates new form AddExam
     */
    public ArrayList<Subject> subList = new ArrayList<>();
    int id = 0;

    public AddExam() {
        initComponents();
        fill_Combobox();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbbSubject = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        dateExamDate = new org.jdesktop.swingx.JXDatePicker();
        jLabel6 = new javax.swing.JLabel();
        txtExamName = new javax.swing.JTextField();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Exam");

        jLabel1.setText("Subject");

        jLabel4.setText("Date");

        cbbSubject.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- List of subject --" }));

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel6.setText("Exam name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnAdd)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel1))
                            .addGap(35, 35, 35)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cbbSubject, 0, 230, Short.MAX_VALUE)
                                .addComponent(dateExamDate, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                                .addComponent(txtExamName))))
                    .addComponent(jLabel6))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtExamName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(dateExamDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(btnAdd)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        int subjectId = getSelectedIndex();
        String examName = txtExamName.getText();
        java.util.Date utilDate = dateExamDate.getDate();//change java.util.date -> java.sql.date
        java.sql.Date date = new java.sql.Date(utilDate.getTime());
        if (ExamDA.checkStringValidation(examName)) {
            ExamDA eDA = new ExamDA();
            int nRow = eDA.insertNewExam(examName, subjectId, date);
            if (nRow != 0) {
                dispose();//to close just this frame
                ManageExam mExam = new ManageExam();
                mExam.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Error ocurred");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Failed");
        }
    }//GEN-LAST:event_btnAddActionPerformed

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
//            java.util.logging.Logger.getLogger(AddExam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(AddExam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(AddExam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(AddExam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AddExam().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JComboBox<String> cbbSubject;
    private org.jdesktop.swingx.JXDatePicker dateExamDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtExamName;
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
}
