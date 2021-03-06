/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.MajorDA;
import Model.Major;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class ManageMajor extends javax.swing.JFrame {

    /**
     * Creates new form ManageMajor1
     */
    private ArrayList<Major> majorList = new ArrayList<>();
    private DefaultTableModel myTableModel;
    MajorDA mDA = new MajorDA();
    
    public ManageMajor() {
        initComponents();
        loadMajor();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMajorName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        btnAddMajor = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMajor = new JTable();
        String[] title = {"ID", "Name", "Description"};
        myTableModel = new DefaultTableModel(title, 0);
        tblMajor.setModel(myTableModel);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jLabel1.setText("Major Name");

        jLabel2.setText("Description");

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jScrollPane1.setViewportView(txtDescription);

        btnAddMajor.setText("Add");
        btnAddMajor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMajorActionPerformed(evt);
            }
        });

        tblMajor.setModel(myTableModel);
        tblMajor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMajorMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblMajor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 790, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnUpdate)
                            .addGap(30, 30, 30)
                            .addComponent(btnDelete)
                            .addGap(34, 34, 34)
                            .addComponent(btnAddMajor))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtMajorName)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(txtMajorName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(36, 36, 36)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnAddMajor)
                                .addComponent(btnDelete)
                                .addComponent(btnUpdate))))
                    .addContainerGap(13, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        //Get the selected index
        int rowIndex = tblMajor.getSelectedRow();
        if (rowIndex != -1) {
            Major m = majorList.get(rowIndex);
            int id = m.getId();
            int nRow = mDA.delete(id);
            if (nRow != 0) {
                JOptionPane.showMessageDialog(rootPane, "Delete Success!");
                loadMajor();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Delete Failed");
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed
    private void loadMajor() {//Error
        majorList = mDA.showAll();
        myTableModel.setRowCount(0);
        for (Major eachMajor : majorList) {
            Object[] aRow = {eachMajor.getId(), eachMajor.getName(), eachMajor.getDescription()};
            myTableModel.addRow(aRow);
        }
    }
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int rowIndex = tblMajor.getSelectedRow();
        if (rowIndex != -1) {//execute
            Major m = majorList.get(rowIndex);
            int id = m.getId();
            String mName = txtMajorName.getText();
            String mDes = txtDescription.getText();
            if (MajorDA.checkStringValidation(mName) && !mDes.equals(" ")) {
                int nRow = mDA.update(mName, mDes, id);
                if (nRow != 0) {
                    JOptionPane.showMessageDialog(rootPane, "Update Success!");
                    loadMajor();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Update Failed");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Incorrect user input");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnAddMajorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMajorActionPerformed
        AddMajor aMajor = new AddMajor();
        aMajor.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAddMajorActionPerformed

    private void tblMajorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMajorMouseClicked
        int rowIndex = tblMajor.getSelectedRow();//Lay index cua row dc chon
        Major selectedMajor = majorList.get(rowIndex);//Truy xuat phan tu thu Row Index trong stdList
        txtMajorName.setText(selectedMajor.getName());
        txtDescription.setText(selectedMajor.getDescription());
    }//GEN-LAST:event_tblMajorMouseClicked

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
//            java.util.logging.Logger.getLogger(ManageMajor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ManageMajor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ManageMajor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ManageMajor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ManageMajor().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddMajor;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblMajor;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtMajorName;
    // End of variables declaration//GEN-END:variables
}
