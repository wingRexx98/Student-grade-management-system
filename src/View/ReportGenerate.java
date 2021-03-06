/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DBConnect;
import Controller.ReportDA;
import Model.Batch;
import Model.Exam;
import Model.Subject;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.TextAnchor;

/**
 *
 * @author Admin
 */
public class ReportGenerate extends javax.swing.JFrame {

    /**
     * Creates new form ReportGenerate
     */
    private DefaultTableModel myTableModel;
    public ArrayList<Batch> bList = new ArrayList<>();
    public ArrayList<Subject> subList = new ArrayList<>();
    ArrayList<Exam> eList = new ArrayList<>();
    private int eId = 0;
    public int batchId = 0;
    int subId = 0;
    public ArrayList<Exam> reportList;
    ReportDA rDA = new ReportDA();
    private int dNumber = 0;
    private int mNumber = 0;
    private int pNumber = 0;
    private int fNumber = 0;

    public ReportGenerate() {
        initComponents();
        fill_Batch_Combobox();
        fillExamCombobox();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCreateReport = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cbbBatch = new javax.swing.JComboBox<>();
        cbbExamName = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblReport = new JTable();
        String[] title = { "Student Name", "Exam Mark", "Student Status"};
        myTableModel = new DefaultTableModel(title, 0);
        tblReport.setModel(myTableModel);
        markPanel = new javax.swing.JPanel();
        pieChartPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Report Generater");

        btnCreateReport.setText("Start");
        btnCreateReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateReportActionPerformed(evt);
            }
        });

        jLabel5.setText("Exam Name");

        jLabel1.setText("Batch");

        cbbBatch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- List of batch/classes --" }));

        cbbExamName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- List of exam --" }));

        tblReport.setModel(myTableModel);
        tblReport.setToolTipText("");
        jScrollPane2.setViewportView(tblReport);

        markPanel.setBackground(new java.awt.Color(204, 214, 223));
        markPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Student marks", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("VNI-Lydi", 2, 14))); // NOI18N
        markPanel.setLayout(new javax.swing.BoxLayout(markPanel, javax.swing.BoxLayout.LINE_AXIS));

        pieChartPanel.setBackground(new java.awt.Color(204, 214, 223));
        pieChartPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pie chart", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("VNI-Lydi", 0, 14))); // NOI18N
        pieChartPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(168, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel5)
                        .addGap(34, 34, 34)
                        .addComponent(cbbExamName, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cbbBatch, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCreateReport, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(pieChartPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(markPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbExamName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbBatch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1)
                    .addComponent(btnCreateReport))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(markPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                    .addComponent(pieChartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateReportActionPerformed
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();// creating data set to use in the bar chart
        DefaultPieDataset pieDataSet = new DefaultPieDataset();
        int examId = getSelectedExamIndex();
        int batchID = getSelectedBatchIndex();
        if (examId != 0 && batchID != 0) {
            reportList = rDA.showAll(examId, batchID);
            myTableModel.setRowCount(0);

            for (Exam each : reportList) {//loop to fill bar chart and table 
                Object[] aRow = { each.getStudentName(), each.getMark(), each.getStatus()};
                dataSet.setValue(each.getMark(), "Student's mark", each.getStudentName());//input data set for bar chart
                myTableModel.addRow(aRow);
                //Get the numbers for each status type
                if (each.getStatus().equalsIgnoreCase("Distinction")) {
                    dNumber += 1;
                } else if (each.getStatus().equalsIgnoreCase("Merit")) {
                    mNumber += 1;
                } else if (each.getStatus().equalsIgnoreCase("Pass")) {
                    pNumber += 1;
                } else if (each.getStatus().equalsIgnoreCase("Fail")) {
                    fNumber += 1;
                }
            }
            //get percentage for each status type
            double dPer = dNumber * 100 / reportList.size();
            double mPer = mNumber * 100 / reportList.size();
            double pPer = pNumber * 100 / reportList.size();
            double fPer = fNumber * 100 / reportList.size();
//            Input data set for pie chart
            pieDataSet.setValue("Distinction", new Double(dPer));
            pieDataSet.setValue("Merit", new Double(mPer));
            pieDataSet.setValue("Pass", new Double(pPer));
            pieDataSet.setValue("Fail", new Double(fPer));
//            Test output
//            System.out.println(dPer + "-" + mPer + "-" + pPer + "-" + fPer);
//            System.out.println(reportList.size());
            //return the count back to 0
            dNumber = 0; mNumber = 0; pNumber = 0; fNumber = 0;
            //Create bar char
            JFreeChart barChart = ChartFactory.createBarChart3D(
                    "Student's mark in exam", //Chart name
                    "Studnet's name", //X name
                    "Student's mark", //Y name
                    dataSet,// data set
                    PlotOrientation.VERTICAL,//chart dsplay direction
                    false, true, false);
            // Create pie chart
            JFreeChart pieChart = ChartFactory.createPieChart3D(
                    "Batch marks percentage",//name
                    pieDataSet,//data
                    true,// subtitle legend
                    true,
                    false);
            final CategoryPlot plot = barChart.getCategoryPlot();
            //Decorating pie chart -- not needed
            final PiePlot3D pPlot = (PiePlot3D) pieChart.getPlot();
            pPlot.setForegroundAlpha(0.60f);//set color scheme
            pPlot.setStartAngle(0);//begin angle
            pPlot.setInteriorGap(0.02);
            //Place mark number on top of each bar-- not fully understood
            BarRenderer render = (BarRenderer) plot.getRenderer();// create a new renderer
            DecimalFormat decimal = new DecimalFormat("###");// format for the mark to apear like: 99.99, 99.9, etc
            render.setItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}", decimal));// getting the mark
            plot.setRenderer(render);
            // Location to place Place the mark
            render.setBasePositiveItemLabelPosition(new ItemLabelPosition(
                    ItemLabelAnchor.OUTSIDE12,
                    TextAnchor.HALF_ASCENT_CENTER)); //text placement style
            render.setItemLabelsVisible(true);
            barChart.getCategoryPlot().setRenderer(render);// place the render on top of the bar

            plot.setRangeGridlinePaint(Color.BLACK);//Decoration for bar chart
            //Place bar chart into panel
            ChartPanel panel1 = new ChartPanel(barChart);
            markPanel.removeAll();
            markPanel.add(panel1);
//            markPanel.updateUI();// works the same as validate() below
            markPanel.validate();//refresh the panel to display the chart
            //test the pie chart
//            ChartFrame frameMain = new ChartFrame("Piechart", pieChart);
//            frameMain.setVisible(true);
//            frameMain.setSize(500, 500);
            //place pie chart into panel
            ChartPanel panelPieChart = new ChartPanel(pieChart);//doesn't work
            pieChartPanel.removeAll();
            pieChartPanel.add(panelPieChart);
            pieChartPanel.updateUI();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Please choose both the exam name and batch name");
        }
    }//GEN-LAST:event_btnCreateReportActionPerformed

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
//            java.util.logging.Logger.getLogger(ReportGenerate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ReportGenerate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ReportGenerate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ReportGenerate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ReportGenerate().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateReport;
    private javax.swing.JComboBox<String> cbbBatch;
    private javax.swing.JComboBox<String> cbbExamName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel markPanel;
    private javax.swing.JPanel pieChartPanel;
    private javax.swing.JTable tblReport;
    // End of variables declaration//GEN-END:variables

    public int getSelectedBatchIndex() {
        String name = (String) cbbBatch.getSelectedItem();
        if (name.equalsIgnoreCase("-- List of batch/classes --")) {
            batchId = 0;
        } else {
            for (Batch each : bList) {
                if (each.getBatch().equalsIgnoreCase(name)) {
                    batchId = each.getBatchId();
                    System.out.println(batchId);
                    break;
                }
            }
        }
        return batchId;
    }

    public void fill_Batch_Combobox() {//get the name from the database to show in the combobex
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
                cbbBatch.addItem(batch);
            }
        } catch (SQLException sqlEx) {
            System.out.println("DB Error: " + sqlEx.getMessage());
        } finally {
            DBConnect.closeConnection(conn);
        }
    }

    public int getSelectedExamIndex() {
        String name = (String) cbbExamName.getSelectedItem();
        if (name.equalsIgnoreCase("-- List of exam --")) {
            eId = 0;
        } else {
            for (Exam each : eList) {
                if (each.getExamName().equalsIgnoreCase(name)) {
                    eId = each.getExamId();
                    System.out.println(eId);
                    break;
                }
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
