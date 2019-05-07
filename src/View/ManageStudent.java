/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DBConnect;
import Controller.StudentDA;
import Model.Batch;
import Model.Student;
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
public class ManageStudent extends javax.swing.JFrame {

    /**
     * Creates new form ManageStudent
     */
    ArrayList<Batch> bList = new ArrayList<>();
    int id = 0;
    private DefaultTableModel myTableModel;
    public ArrayList<Student> studentList;
    StudentDA studentDA = new StudentDA();

    public ManageStudent() {
        initComponents();
        fill_Combobox();
        studentList = studentDA.showAll();
        loadStudent();
    }

    public void loadStudent() {
        myTableModel.setRowCount(0);
        for (Student each : studentList) {
            Object[] aRow = {each.getId(), each.getName(), each.getPhone(), each.getEmail(), each.getAddress(), each.getBatch()};
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

        jLabel1 = new javax.swing.JLabel();
        txtStudentName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtStudentPhone = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtStudentEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbbStudentBatch = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudent = new JTable();
        String[] title={"ID", "Name", "Phone number", "Email", "Address", "Batch"};
        myTableModel = new DefaultTableModel(title, 0);
        tblStudent.setModel(myTableModel);
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        btnListByBatch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Student Management");

        jLabel1.setText("Student name");

        jLabel2.setText("Student phone");

        jLabel3.setText("Student Email");

        jLabel4.setText("Student Batch");

        cbbStudentBatch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--List of batch/classes --" }));
        cbbStudentBatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbStudentBatchActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        tblStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStudentMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblStudent);

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jLabel5.setText("Student Address");

        txtAddress.setColumns(20);
        txtAddress.setRows(5);
        jScrollPane2.setViewportView(txtAddress);

        btnListByBatch.setText("List of Student in Batch");
        btnListByBatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListByBatchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnUpdate)
                                .addGap(48, 48, 48)
                                .addComponent(btnDelete)
                                .addGap(48, 48, 48)
                                .addComponent(btnAdd))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel3))
                                        .addGap(44, 44, 44))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(39, 39, 39)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                                    .addComponent(txtStudentEmail)
                                    .addComponent(txtStudentPhone)
                                    .addComponent(txtStudentName)
                                    .addComponent(cbbStudentBatch, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(btnListByBatch)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtStudentName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtStudentPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtStudentEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbbStudentBatch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDelete)
                            .addComponent(btnUpdate)
                            .addComponent(btnAdd)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnListByBatch)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbbStudentBatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbStudentBatchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbStudentBatchActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int rowIndex = tblStudent.getSelectedRow();
        if (rowIndex != -1) {
            Student student = studentList.get(rowIndex);
            int Id = student.getBatchId();
            int nRow = studentDA.delete(id);
            if (nRow != 0) {
                JOptionPane.showMessageDialog(rootPane, "Delete Success!");
                loadStudent();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Delete Failed");
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        AddStudent aStudent = new AddStudent();
        aStudent.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudentMouseClicked
        int rowIndex = tblStudent.getSelectedRow();//Lay index cua row dc chon
        Student selectedStudent = studentList.get(rowIndex);//Truy xuat phan tu thu Row Index trong stdList
        txtStudentName.setText(selectedStudent.getName());
        txtStudentEmail.setText(selectedStudent.getEmail());
        txtStudentPhone.setText(selectedStudent.getPhone());
        txtAddress.setText(selectedStudent.getAddress());
        cbbStudentBatch.setSelectedItem(selectedStudent.getBatch());
    }//GEN-LAST:event_tblStudentMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int rowIndex = tblStudent.getSelectedRow();//must change something
        if (rowIndex != -1) {
            Student student = studentList.get(rowIndex);

            int Id = student.getId();
            int batchId = getSelectedIndex();
            String newName = txtStudentName.getText();
            String newEmail = txtStudentEmail.getText();
            String newPhone = txtStudentPhone.getText();
            String newAddress = txtAddress.getText();
            int subjectId = getSelectedIndex();
            if (StudentDA.checkStringValidation(newName) && StudentDA.checkEmailValidation(newEmail) && StudentDA.checkIntegerValidation(newPhone) 
                    && !newAddress.equals(" ")) {
                int nRow = studentDA.update(newEmail, newName, newPhone, batchId, newAddress, Id);
                if (nRow != 0) {
                    JOptionPane.showMessageDialog(rootPane, "Update Success!");
                    loadStudent();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Update Failed");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Incorrect user input");
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnListByBatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListByBatchActionPerformed
        String selectedBatch = (String) cbbStudentBatch.getSelectedItem();
        studentList = studentDA.getListByClass(selectedBatch);
        loadStudent();
    }//GEN-LAST:event_btnListByBatchActionPerformed

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
//            java.util.logging.Logger.getLogger(ManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ManageStudent().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnListByBatch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbbStudentBatch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblStudent;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtStudentEmail;
    private javax.swing.JTextField txtStudentName;
    private javax.swing.JTextField txtStudentPhone;
    // End of variables declaration//GEN-END:variables
public int getSelectedIndex() {
        String name = (String) cbbStudentBatch.getSelectedItem();
        for (Batch each : bList) {
            if (each.getBatch().equalsIgnoreCase(name)) {
                id = each.getBatchId();
                System.out.println(id);
                break;
            }
        }
        return id;
    }

    public void fill_Combobox() {//get the name from the database to show in the combobex
        Connection conn = DBConnect.connectDatabase();  //getting connection to the database
        String sql = "select batchId, batch, subject_ID, subjectName from batch inner join subject on subject_ID = id"; //sql query command
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
                bList.add(exam);
                cbbStudentBatch.addItem(batch);
            }
        } catch (SQLException sqlEx) {
            System.out.println("DB Error: " + sqlEx.getMessage());
        } finally {
            DBConnect.closeConnection(conn);
        }
    }
}
