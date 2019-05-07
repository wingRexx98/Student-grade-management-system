/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.BatchDA;
import Controller.DBConnect;
import Model.Batch;
import Model.Subject;
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
public class ManageBatch extends javax.swing.JFrame {

    /**
     * Creates new form ManageBatch
     */
    ArrayList<Subject> subList = new ArrayList<>();
    private DefaultTableModel myTableModel;
    private ArrayList<Batch> batchList;
    int id = 0;
    BatchDA bDA = new BatchDA();

    public ManageBatch() {
        initComponents();
        fill_Combobox();
        loadBatch();
    }

    private void loadBatch() {//Error
        batchList = bDA.showAll();
        myTableModel.setRowCount(0);
        for (Batch each : batchList) {
            Object[] aRow = {each.getBatchId(), each.getBatch(), each.getSubjectName()};
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
        jLabel2 = new javax.swing.JLabel();
        txtBatch = new javax.swing.JTextField();
        cbbSubject = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBatchList = new JTable();
        String[] title = {"ID", "Batch Name", "Subject"};
        myTableModel = new DefaultTableModel(title, 0);
        tblBatchList.setModel(myTableModel);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manage Batch");

        jLabel1.setText("Batch");

        jLabel2.setText("Subject");

        txtBatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBatchActionPerformed(evt);
            }
        });

        cbbSubject.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- List of Subjects --" }));

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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

        tblBatchList.setModel(myTableModel);
        tblBatchList.setToolTipText("");
        tblBatchList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBatchListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblBatchList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtBatch)
                            .addComponent(cbbSubject, 0, 205, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnUpdate)
                        .addGap(50, 50, 50)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtBatch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbbSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnDelete)
                                .addComponent(btnUpdate))
                            .addComponent(jButton1)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBatchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBatchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        AddBatch aBatch = new AddBatch();
        aBatch.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int rowIndex = tblBatchList.getSelectedRow();
        if (rowIndex != -1) {
            Batch batch = batchList.get(rowIndex);
            int batchId = batch.getBatchId();
            int nRow = bDA.delete(batchId);
            if (nRow != 0) {
                JOptionPane.showMessageDialog(rootPane, "Delete Success!");
                loadBatch();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Delete Failed");
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int rowIndex = tblBatchList.getSelectedRow();
        if (rowIndex != -1) {
            Batch batch = batchList.get(rowIndex);
            int batchId = batch.getBatchId();
            String newName = txtBatch.getText();
            int subjectId = getSelectedIndex();
            if (BatchDA.checkStringValidation(newName)) {
                int nRow = bDA.update(subjectId, newName, batchId);
                if (nRow != 0) {
                    JOptionPane.showMessageDialog(rootPane, "Update Success!");
                    loadBatch();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Update Failed");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Incorrect user input");
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tblBatchListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBatchListMouseClicked
        int rowIndex = tblBatchList.getSelectedRow();//Lay index cua row dc chon
        Batch selectedBatch = batchList.get(rowIndex);//Truy xuat phan tu thu Row Index trong stdList
        txtBatch.setText(selectedBatch.getBatch());
        cbbSubject.setSelectedItem(selectedBatch.getSubjectName());
    }//GEN-LAST:event_tblBatchListMouseClicked

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
//            java.util.logging.Logger.getLogger(ManageBatch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ManageBatch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ManageBatch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ManageBatch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ManageBatch().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbbSubject;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblBatchList;
    private javax.swing.JTextField txtBatch;
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
                cbbSubject.addItem(name);
            }
        } catch (SQLException sqlEx) {
            System.out.println("DB Error: " + sqlEx.getMessage());
        } finally {
            DBConnect.closeConnection(conn);
        }
    }
}