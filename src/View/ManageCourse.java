/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.CourseDA;
import Controller.DBConnect;
import Model.Courses;
import Model.Major;
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
public class ManageCourse extends javax.swing.JFrame {

    /**
     * Creates new form ManageCourse
     */
    ArrayList<Major> mList = new ArrayList<>();
    int id = 0;
    private ArrayList<Courses> courseList;
    private DefaultTableModel myTableModel = new DefaultTableModel();
    CourseDA cDA = new CourseDA();

    public ManageCourse() {
        initComponents();
        fill_Combobox();
        loadCourse();
    }

    private void loadCourse() {//Error
        courseList = cDA.showAll();
        myTableModel.setRowCount(0);
        for (Courses each : courseList) {
            Object[] aRow = {each.getId(), each.getName(), each.getDescription(), each.getMajorName()};
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCourseName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        cbbMajor = new javax.swing.JComboBox<>();
        btnAddCourse = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblCourse = new JTable();
        String[] title = {"ID", "Course name", "Description", "Major"};
        myTableModel = new DefaultTableModel(title, 0);
        tblCourse.setModel(myTableModel);
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manage Course");

        jLabel2.setText("Description");

        jLabel3.setText("Major");

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jScrollPane1.setViewportView(txtDescription);

        cbbMajor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pick a major --" }));
        cbbMajor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMajorActionPerformed(evt);
            }
        });

        btnAddCourse.setText("Add");
        btnAddCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCourseActionPerformed(evt);
            }
        });

        jLabel1.setText("Course name");

        tblCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCourseMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblCourse);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCourseName)
                            .addComponent(jScrollPane1)
                            .addComponent(cbbMajor, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnUpdate)
                        .addGap(50, 50, 50)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddCourse)))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbMajor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnDelete)
                                .addComponent(btnUpdate))
                            .addComponent(btnAddCourse))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCourseActionPerformed
        AddCourse aCourse = new AddCourse();
        aCourse.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAddCourseActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int rowIndex = tblCourse.getSelectedRow();
        if (rowIndex != -1) {
            Courses m = courseList.get(rowIndex);
            int id = m.getId();
            int nRow = cDA.delete(id);
            if (nRow != 0) {
                JOptionPane.showMessageDialog(rootPane, "Delete Success!");
                loadCourse();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Delete Failed");
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblCourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCourseMouseClicked
        int rowIndex = tblCourse.getSelectedRow();//Lay index cua row dc chon
        Courses selectedcourse = courseList.get(rowIndex);//Truy xuat phan tu thu Row Index trong stdList
        txtCourseName.setText(selectedcourse.getName());
        txtDescription.setText(selectedcourse.getDescription());
        cbbMajor.setSelectedItem(selectedcourse.getMajorName());
    }//GEN-LAST:event_tblCourseMouseClicked

    private void cbbMajorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMajorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbMajorActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int rowIndex = tblCourse.getSelectedRow();
        if (rowIndex != -1) {//execute
            Courses m = courseList.get(rowIndex);
            int id = m.getId();
            String mName = txtCourseName.getText();
            String mDes = txtDescription.getText();
            int majorId = getSelectedIndex();
            if (CourseDA.checkStringValidation(mName) && !mDes.equals(" ")) {
                int nRow = cDA.update(mName, mDes, majorId, id);
                if (nRow != 0) {
                    JOptionPane.showMessageDialog(rootPane, "Update Success!");
                    loadCourse();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Update Failed");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Incorrect user input");
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

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
//            java.util.logging.Logger.getLogger(ManageCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ManageCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ManageCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ManageCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ManageCourse().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCourse;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbbMajor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable tblCourse;
    private javax.swing.JTextField txtCourseName;
    private javax.swing.JTextArea txtDescription;
    // End of variables declaration//GEN-END:variables
    public int getSelectedIndex() {
        String name = (String) cbbMajor.getSelectedItem();
        for (Major eachMajor : mList) {
            if (eachMajor.getName().equalsIgnoreCase(name)) {
                id = eachMajor.getId();
                System.out.println(id);
                break;
            }
        }
        return id;
    }

    public void fill_Combobox() {//get the name from the database to show in the combobex
        Connection conn = DBConnect.connectDatabase();  //getting connection to the database
        String sql = "SELECT * FROM Major";           //sql query command
        try {
            Statement stm = conn.createStatement();// PREPARE STATEMENT, a complete command to be executed
            ResultSet rs = stm.executeQuery(sql);//execute sql query
            //loop while the rs.next() != null
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                Major major = new Major(id, name, description);
                mList.add(major);
                cbbMajor.addItem(name);
            }
        } catch (SQLException sqlEx) {
            System.out.println("DB Error: " + sqlEx.getMessage());
        } finally {
            DBConnect.closeConnection(conn);
        }
    }
}