package MainPackage;


import static SomeFunctions.Helper.AlreadyExist;
import static SomeFunctions.Helper.AlreadyExistR;
import static SomeFunctions.Helper.AlreadyExistT;
import SomeFunctions.MyConnection;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Frame extends javax.swing.JFrame {

    
    public Frame() {
        initComponents();
        jButtonSave.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jTextStudentID = new javax.swing.JTextField();
        jTextFirstName = new javax.swing.JTextField();
        jTextLastName = new javax.swing.JTextField();
        jTextTotal = new javax.swing.JTextField();
        jTextAverage = new javax.swing.JTextField();
        jTextRanking = new javax.swing.JTextField();
        jTextMPLAB = new javax.swing.JTextField();
        jTextLab1 = new javax.swing.JTextField();
        jTextFLAC = new javax.swing.JTextField();
        jTextDSA = new javax.swing.JTextField();
        jTextMP = new javax.swing.JTextField();
        jTextDBMS = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextMath = new javax.swing.JTextField();
        jTextSP = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jComboBox = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButtonClear = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableResult = new javax.swing.JTable();
        jButtonDetails = new javax.swing.JButton();
        jButtonRanking = new javax.swing.JButton();
        jButtonTranscript = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonReset = new javax.swing.JButton();
        jButtonEdit = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("StudentSheet");
        setBackground(new java.awt.Color(204, 255, 204));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel4.setBackground(new java.awt.Color(32, 38, 55));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));
        jPanel4.setToolTipText("");
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextStudentID.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel1.add(jTextStudentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 110, -1));

        jTextFirstName.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextFirstName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFirstNameKeyTyped(evt);
            }
        });
        jPanel1.add(jTextFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 110, -1));

        jTextLastName.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel1.add(jTextLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 110, -1));

        jTextTotal.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(jTextTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 100, -1));

        jTextAverage.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextAverage.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(jTextAverage, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 100, -1));

        jTextRanking.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextRanking.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(jTextRanking, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 100, -1));

        jTextMPLAB.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextMPLAB.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextMPLAB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextMPLABKeyTyped(evt);
            }
        });
        jPanel1.add(jTextMPLAB, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 70, -1));

        jTextLab1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextLab1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextLab1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextLab1ActionPerformed(evt);
            }
        });
        jTextLab1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextLab1KeyTyped(evt);
            }
        });
        jPanel1.add(jTextLab1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, 70, -1));

        jTextFLAC.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextFLAC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFLAC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFLACKeyTyped(evt);
            }
        });
        jPanel1.add(jTextFLAC, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 70, -1));

        jTextDSA.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextDSA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextDSA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextDSAActionPerformed(evt);
            }
        });
        jTextDSA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextDSAKeyTyped(evt);
            }
        });
        jPanel1.add(jTextDSA, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, 70, -1));

        jTextMP.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextMP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextMP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextMPKeyTyped(evt);
            }
        });
        jPanel1.add(jTextMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, 70, -1));

        jTextDBMS.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextDBMS.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextDBMS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextDBMSKeyTyped(evt);
            }
        });
        jPanel1.add(jTextDBMS, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 70, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Student_id");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 30));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("First_Name");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 30));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Last_Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, 30));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Course");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 90, 40));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Total");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 212, -1, 30));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("Average");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, 30));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("Ranking");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, 30));

        jTextMath.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextMath.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextMath.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextMathKeyTyped(evt);
            }
        });
        jPanel1.add(jTextMath, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, 70, -1));

        jTextSP.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextSP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextSPKeyTyped(evt);
            }
        });
        jPanel1.add(jTextSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 70, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setText("DSA-LAB");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, -1, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setText("MP-LAB");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, -1, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setText("Math");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, -1, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setText("FLAC");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, -1, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel12.setText("SystemP");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, -1, -1));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setText("DSA");
        jLabel13.setToolTipText("");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, -1, -1));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setText("MP");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, -1, -1));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel15.setText("DBMS");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, -1, -1));

        jComboBox.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Firsth Year", "Second Year", "Third Year", "Fourth Year" }));
        jComboBox.setToolTipText("");
        jPanel1.add(jComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 150, 40));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 210, 10));

        jPanel4.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 340));

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        jTextArea.setEditable(false);
        jTextArea.setColumns(20);
        jTextArea.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        jTextArea.setRows(5);
        jScrollPane1.setViewportView(jTextArea);

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        jButton2.setText("Null");

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        jButton3.setText("Print");

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        jButton4.setText("Null");

        jButtonClear.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        jButtonClear.setText("Clear");
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonClear)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        jPanel4.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 310, 390));

        jTableResult.setAutoCreateRowSorter(true);
        jTableResult.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTableResult.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTableResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S_id", "Name", "Course", "DSA-LAB", "MP-LAB", "MATH", "FLAC", "SystemP", "DSA", "MP", "DBMS", "Total", "Average", "Ranking"
            }
        ));
        jTableResult.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableResult.setRowHeight(20);
        jTableResult.setSelectionBackground(new java.awt.Color(0, 0, 0));
        jTableResult.setShowHorizontalLines(false);
        jTableResult.setShowVerticalLines(false);
        jScrollPane2.setViewportView(jTableResult);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 840, 100));

        jButtonDetails.setBackground(new java.awt.Color(0, 102, 51));
        jButtonDetails.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonDetails.setForeground(new java.awt.Color(255, 255, 255));
        jButtonDetails.setText("Results");
        jButtonDetails.setBorder(null);
        jButtonDetails.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDetailsActionPerformed(evt);
            }
        });
        jPanel4.add(jButtonDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 510, 120, 50));

        jButtonRanking.setBackground(new java.awt.Color(0, 102, 51));
        jButtonRanking.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonRanking.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRanking.setText("Ranking");
        jButtonRanking.setBorder(null);
        jButtonRanking.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRanking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRankingActionPerformed(evt);
            }
        });
        jPanel4.add(jButtonRanking, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 100, 50));

        jButtonTranscript.setBackground(new java.awt.Color(0, 102, 51));
        jButtonTranscript.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jButtonTranscript.setForeground(new java.awt.Color(255, 255, 255));
        jButtonTranscript.setText("Transcript");
        jButtonTranscript.setBorder(null);
        jButtonTranscript.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonTranscript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTranscriptActionPerformed(evt);
            }
        });
        jPanel4.add(jButtonTranscript, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 510, 110, 50));

        jButtonDelete.setBackground(new java.awt.Color(0, 102, 51));
        jButtonDelete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonDelete.setForeground(new java.awt.Color(255, 255, 255));
        jButtonDelete.setText("Delete");
        jButtonDelete.setBorder(null);
        jButtonDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });
        jPanel4.add(jButtonDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 510, 110, 50));

        jButtonReset.setBackground(new java.awt.Color(0, 102, 51));
        jButtonReset.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonReset.setForeground(new java.awt.Color(255, 255, 255));
        jButtonReset.setText("Reset");
        jButtonReset.setBorder(null);
        jButtonReset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });
        jPanel4.add(jButtonReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 510, 110, 50));

        jButtonEdit.setBackground(new java.awt.Color(204, 0, 0));
        jButtonEdit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonEdit.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEdit.setText("Edit");
        jButtonEdit.setBorder(null);
        jButtonEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });
        jPanel4.add(jButtonEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 510, 110, 50));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.setToolTipText("");
        jPanel4.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 370, 40));

        jButton1.setText("Search");
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 350, 130, 40));

        jButtonSave.setBackground(new java.awt.Color(0, 102, 51));
        jButtonSave.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonSave.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSave.setText("Update");
        jButtonSave.setBorder(null);
        jButtonSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });
        jPanel4.add(jButtonSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 510, 110, 50));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(jPanel4, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
        public Object ob;
    private void jButtonRankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRankingActionPerformed
       double R[] = new double[14];
       if(jTextStudentID.getText().trim().equals("")
               ||jTextFirstName.getText().trim().equals("")
               ||jTextLastName.getText().trim().equals(""))
           JOptionPane.showMessageDialog(null, "Please Enter Your Name", "Alert",1);
       else if(jTextDSA.getText().isEmpty()||jTextMPLAB.getText().isEmpty()
               ||jTextDBMS.getText().isEmpty()||jTextSP.getText().isEmpty()
               ||jTextFLAC.getText().isEmpty()||jTextMP.getText().isEmpty()
               ||jTextLab1.getText().isEmpty()||jTextMath.getText().isEmpty())
           JOptionPane.showMessageDialog(null, "Please Enter the Marks","Alert",1);
       else{ 
           
       R[0] = Double.parseDouble(jTextLab1.getText());
       R[1] = Double.parseDouble(jTextMPLAB.getText());
       R[2] = Double.parseDouble(jTextFLAC.getText());
       R[3] = Double.parseDouble(jTextMath.getText());
       R[4] = Double.parseDouble(jTextDSA.getText());
       R[5] = Double.parseDouble(jTextDBMS.getText());
       R[6] = Double.parseDouble(jTextMP.getText());
       R[7] = Double.parseDouble(jTextSP.getText());
       R[8] = R[0]+R[1]+R[2]+R[3]+R[4]+R[5]+R[6]+R[7];
       R[9] = R[8]/8;
       
       String Total = String.format("%.0f", R[8]);
       jTextTotal.setText(Total);
       String Average = String.format("%.0f", R[9]);
       jTextAverage.setText(Average);
       String DSALAB = String.format("%.0f", R[0]);       
       String MPLAB = String.format("%.0f", R[1]);
       String FLAC = String.format("%.0f", R[2]);
       String MATH = String.format("%.0f", R[3]);
       String DSA = String.format("%.0f", R[4]);
       String DBMS = String.format("%.0f", R[5]);       
       String MP = String.format("%.0f", R[6]);
       String SP = String.format("%.0f", R[7]);
       String id = String.format(jTextStudentID.getText());
       String stdName = jTextFirstName.getText();
       
       
       
       if(R[0]<50||R[1]<50||R[2]<50||R[3]<50||R[4]<50||R[5]<50||R[6]<50||R[7]<50)
           jTextRanking.setText("Fail");
       else if(R[9] >= 90)
           jTextRanking.setText("A+");
       else if(R[9]<90 && R[9]>=85)
           jTextRanking.setText("A");
       else if(R[9]<85 && R[9]>=70)
           jTextRanking.setText("B");
       else if(R[9]<70 && R[9]>=60)
           jTextRanking.setText("c");
       else if(R[9]<60 && R[9]>=50)
           jTextRanking.setText("D");
       else
           jTextRanking.setText("fail"); 
       String Ranking = String.format(jTextRanking.getText());
       String Course = String.valueOf(jComboBox.getSelectedItem());
       
//==========================SQL CONNECTION===========================
       if(!AlreadyExistR(id)){
            PreparedStatement ps;
            ResultSet rs;
            String registerQuery = "insert into resulttable(id, stdName, Course, DSALAB, MPLAB, MATH, FLAC, SystemP, DSA, MP, DBMS, Total, Average, Ranking) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            try {
            ps = MyConnection.getConnection().prepareStatement(registerQuery);
            ps.setString(1,  id);
            ps.setString(2,  stdName);
            ps.setString(3,  Course);
            ps.setString(4,  DSALAB);
            ps.setString(5,  MPLAB);
            ps.setString(6,  FLAC);
            ps.setString(7,  MATH);
            ps.setString(8,  DSA);
            ps.setString(9,  DBMS);
            ps.setString(10, MP);
            ps.setString(11, SP);
            ps.setString(12, Total);
            ps.setString(13, Average);
            ps.setString(14, Ranking); 
            ps.executeUpdate();
            Rank();
            }
            catch(SQLException ex){
              JOptionPane.showMessageDialog(null, "An Error occured Please try Again Later!"+ex.getMessage());
            }           
       }
       }
    }//GEN-LAST:event_jButtonRankingActionPerformed
//=============================end====================================
//===========================RankFuntion==============================    
    public Object Rank(){
            
            DefaultTableModel modele = (DefaultTableModel) jTableResult.getModel();
            modele.addRow(new Object[]{
                jTextStudentID.getText(),
                jComboBox.getSelectedItem(),
                jTextLab1.getText(),
                jTextMPLAB.getText(),
                jTextMath.getText(),
                jTextFLAC.getText(),
                jTextSP.getText(),
                jTextDSA.getText(),           
                jTextMP.getText(),
                jTextDBMS.getText(),        
                jTextTotal.getText(),
                jTextAverage.getText(),
                jTextRanking.getText(),
       });
                
                return 0;
}
//=============================End of RankFuntion==============================

    private JFrame frame;
    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
        
       JTextField clearText = null;
       for(Component c:jPanel1.getComponents()){
           if (c.getClass().toString().contains("javax.swing.JTextField")){
               clearText = (JTextField)c;
               clearText.setText(null);
           }
       }
    }//GEN-LAST:event_jButtonResetActionPerformed

    private void jTextDSAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextDSAActionPerformed
               
    }//GEN-LAST:event_jTextDSAActionPerformed

    private void jButtonTranscriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTranscriptActionPerformed

        jTextArea.append("\t"+"***Transcript***"+"\n"+"========================="+"\n");
        jTextArea.append("Name : "+ jTextFirstName.getText()+"\n");
        jTextArea.append("LastName: "+ jTextLastName.getText()+"\n\n");
        jTextArea.append("Math: " + jTextLab1.getText()+"\n");
        jTextArea.append("Biology : "+ jTextMPLAB.getText()+"\n");
        jTextArea.append("Dari : "+ jTextMath.getText()+"\n");
        jTextArea.append("English : "+ jTextFLAC.getText()+"\n");
        jTextArea.append("Computer : "+ jTextSP.getText()+"\n");
        jTextArea.append("Chemestry : "+ jTextDSA.getText()+"\n");
        jTextArea.append("Physics : "+ jTextMP.getText()+"\n");
        jTextArea.append("History : "+ jTextDBMS.getText()+"\n\n");
        jTextArea.append("Total : "+jTextTotal.getText()+"\n");
        jTextArea.append("Average : "+jTextAverage.getText()+"\n");
        jTextArea.append("Ranking : "+jTextRanking.getText()+"\n");
       
    }//GEN-LAST:event_jButtonTranscriptActionPerformed

    private void jTextLab1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextLab1KeyTyped
        char number = evt.getKeyChar();
        if(!(Character.isDigit(number))
                ||(number == KeyEvent.VK_BACK_SPACE)
                ||(number == KeyEvent.VK_DELETE))
            evt.consume();
    }//GEN-LAST:event_jTextLab1KeyTyped

    private void jTextMPLABKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextMPLABKeyTyped
        char number = evt.getKeyChar();
        if(!(Character.isDigit(number))
                ||(number == KeyEvent.VK_BACK_SPACE)
                ||(number == KeyEvent.VK_DELETE))
            evt.consume();
    }//GEN-LAST:event_jTextMPLABKeyTyped

    private void jTextMathKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextMathKeyTyped
        char number = evt.getKeyChar();
        if(!(Character.isDigit(number))
                ||(number == KeyEvent.VK_BACK_SPACE)
                ||(number == KeyEvent.VK_DELETE))
            evt.consume();
    }//GEN-LAST:event_jTextMathKeyTyped

    private void jTextFLACKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFLACKeyTyped
        char number = evt.getKeyChar();
        if(!(Character.isDigit(number))
                ||(number == KeyEvent.VK_BACK_SPACE)
                ||(number == KeyEvent.VK_DELETE))
            evt.consume();
    }//GEN-LAST:event_jTextFLACKeyTyped

    private void jTextSPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextSPKeyTyped
        char number = evt.getKeyChar();
        if(!(Character.isDigit(number))
                ||(number == KeyEvent.VK_BACK_SPACE)
                ||(number == KeyEvent.VK_DELETE))
            evt.consume();
    }//GEN-LAST:event_jTextSPKeyTyped

    private void jTextDSAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextDSAKeyTyped
        char number = evt.getKeyChar();
        if(!(Character.isDigit(number))
                ||(number == KeyEvent.VK_BACK_SPACE)
                ||(number == KeyEvent.VK_DELETE))
            evt.consume();
    }//GEN-LAST:event_jTextDSAKeyTyped

    private void jTextMPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextMPKeyTyped
       char number = evt.getKeyChar();
        if(!(Character.isDigit(number))
                ||(number == KeyEvent.VK_BACK_SPACE)
                ||(number == KeyEvent.VK_DELETE))
                
            evt.consume();
    }//GEN-LAST:event_jTextMPKeyTyped

    private void jTextDBMSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextDBMSKeyTyped
        char number = evt.getKeyChar();
        if(!(Character.isDigit(number))
                ||(number == KeyEvent.VK_BACK_SPACE)
                ||(number == KeyEvent.VK_DELETE))
            evt.consume();
    }//GEN-LAST:event_jTextDBMSKeyTyped

    private void jTextFirstNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFirstNameKeyTyped
       
    }//GEN-LAST:event_jTextFirstNameKeyTyped

    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        jTextArea.setText(null);
    }//GEN-LAST:event_jButtonClearActionPerformed

    private void jTextLab1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextLab1ActionPerformed

    }//GEN-LAST:event_jTextLab1ActionPerformed
        
    private void jButtonDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDetailsActionPerformed
       ResultTable rt = new ResultTable();
       rt.setVisible(true);
       rt.pack();
       rt.setLocationRelativeTo(null);
       this.dispose();
    }//GEN-LAST:event_jButtonDetailsActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        jButtonSave.setVisible(true);
        
        if(jTableResult.getSelectedRow()==-1)
            JOptionPane.showMessageDialog(null,"Please Select a Row to Edit!");
    else{
        jTextStudentID.setText(jTableResult.getValueAt(jTableResult.getSelectedRow(), 0).toString());
        jTextFirstName.setText(jTableResult.getValueAt(jTableResult.getSelectedRow(), 1).toString());
        
        jTextLab1.setText(jTableResult.getValueAt(jTableResult.getSelectedRow(), 3).toString());
        jTextMPLAB.setText(jTableResult.getValueAt(jTableResult.getSelectedRow(), 4).toString());
        jTextMath.setText(jTableResult.getValueAt(jTableResult.getSelectedRow(), 5).toString());
        jTextFLAC.setText(jTableResult.getValueAt(jTableResult.getSelectedRow(), 6).toString());
        jTextSP.setText(jTableResult.getValueAt(jTableResult.getSelectedRow(), 7).toString());
        jTextDSA.setText(jTableResult.getValueAt(jTableResult.getSelectedRow(), 8).toString());
        jTextMP.setText(jTableResult.getValueAt(jTableResult.getSelectedRow(), 9).toString());
        jTextDBMS.setText(jTableResult.getValueAt(jTableResult.getSelectedRow(), 10).toString());
        
        jTextTotal.setText(jTableResult.getValueAt(jTableResult.getSelectedRow(), 11).toString());
        jTextAverage.setText(jTableResult.getValueAt(jTableResult.getSelectedRow(), 12).toString());
        jTextRanking.setText(jTableResult.getValueAt(jTableResult.getSelectedRow(), 13).toString());
        }       

        
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
    
        DefaultTableModel model = (DefaultTableModel) jTableResult.getModel();
    if(jTableResult.getSelectedRow()==-1){
    JOptionPane.showMessageDialog(null,"Select a Student to Edit!");
    }
    else{
    String id = jTableResult.getValueAt(jTableResult.getSelectedRow(), 0).toString();
    PreparedStatement ps;
    ResultSet rs;
    try{
            ps = MyConnection.getConnection().prepareStatement("DELETE FROM resulttable WHERE(id ="+'"'+id+'"'+")");
            ps.executeUpdate();
            }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Can Not Delete At this Moment! Try Later"+e.getMessage());
            }
    }
            model.removeRow(jTableResult.getSelectedRow());
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        try {
            String registerQuery ="SELECT * From resulttable";
            DefaultTableModel modele = (DefaultTableModel) jTableResult.getModel();        
            PreparedStatement ps;
            ResultSet rs;
            ps = MyConnection.getConnection().prepareStatement(registerQuery);
            rs = ps.executeQuery();
            while(rs.next()){
            Object o[]= {rs.getString("id"), rs.getString("stdName"), rs.getString("Course")
                    ,rs.getString("DSALAB"), rs.getString("MPLAB"), rs.getString("MATH")
                    ,rs.getString("FLAC"), rs.getString("SystemP"), rs.getString("DSA")
                    , rs.getString("MP") , rs.getString("DBMS") , rs.getString("Total") 
                    , rs.getString("Average") , rs.getString("Ranking")};
            if(jTableResult.getRowCount()!= getRowNumber())    
            modele.addRow(o);    
            }
            }catch(SQLException ex){
              JOptionPane.showMessageDialog(null, "Please Try Again Later!");
            }
    }//GEN-LAST:event_formWindowOpened
    
    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
//        JOptionPane.showMessageDialog(null, "IT is Not Working now");
 
        
        if(jTableResult.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(null,"First Select A Row To Be Edited");
        }
        else if(jTableResult.getSelectedRow()!=-1){
            if(jTextStudentID.getText().equals("") || jTextFirstName.getText().equals("")
                    ||jTextLastName.getText().equals("") || jTextLab1.getText().equals("")
                    ||jTextMPLAB.getText().equals("") || jTextMath.getText().equals("")
                    ||jTextFLAC.getText().equals("") || jTextSP.getText().equals("")
                    ||jTextDSA.getText().equals("") || jTextMP.getText().equals("")
                    ||jTextDBMS.getText().equals(""))
                JOptionPane.showMessageDialog(null,"The data is Already Saved!");
            
            else{
            String combo = jComboBox.getSelectedItem().toString();        
            String id = jTableResult.getValueAt(jTableResult.getSelectedRow(), 0).toString();        
            String Query = "UPDATE resulttable SET stdName= '"+jTextFirstName.getText()+"',"
                + " Course='"+combo+"',"
                + " DSALAB='"+jTextLab1.getText()+"',"
                + " MPLAB='"+jTextMPLAB.getText()+"',"
                + " MATH='"+jTextMath.getText()+"',"
                + " FLAC='"+jTextFLAC.getText()+"',"
                + " SystemP='"+jTextSP.getText()+"',"
                + " DSA='"+jTextDSA.getText()+"',"
                + " MP='"+jTextMP.getText()+"',"
                + " DBMS='"+jTextDBMS.getText()+"',"
                + " Total='"+jTextTotal.getText()+"',"
                + " Average='"+jTextAverage.getText()+"',"
                + " Ranking='"+jTextRanking.getText()+"'"
                + " WHERE id = "+'"'+id+'"';
        
        try{
            PreparedStatement ps;
            ps = MyConnection.getConnection().prepareStatement(Query);
            ps.executeUpdate();
            DeletePreEditedRowFromTable();
            RegisterTable();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Can not Edit at this Time Please Try Later!"+e.getMessage()); 

        }
        }
        }
    }//GEN-LAST:event_jButtonSaveActionPerformed

    public void DeletePreEditedRowFromTable (){
        DefaultTableModel model = (DefaultTableModel) jTableResult.getModel();
        model.removeRow(jTableResult.getSelectedRow());
    }
    
    private Object RegisterTable(){
        DefaultTableModel model = (DefaultTableModel) jTableResult.getModel();
       model.addRow(new Object[]{
           jTextStudentID.getText(),
           jTextFirstName.getText(),          
           jComboBox.getSelectedItem(),
           jTextLab1.getText(),
           jTextMPLAB.getText(),           
           jTextMath.getText(),
           jTextFLAC.getText(),
           jTextSP.getText(),
           jTextDSA.getText(),
           jTextMP.getText(),  
           jTextDBMS.getText(),
           jTextTotal.getText(),
           jTextAverage.getText(),
           jTextRanking.getText()
       });
       return 0;
    }
    
     public int getRowNumber(){//============start===============

    int numberRow = 0;
    PreparedStatement ps;
    ResultSet rs;
    String query = "select count(*) from resulttable";
        try{
            ps = MyConnection.getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                numberRow = rs.getInt("count(*)");
            }
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Error ");
        }
    return numberRow;
}//===========================end================================

//========================Delete From jTable Funtion======================   
    public void Delete() {       
        DefaultTableModel model = (DefaultTableModel) jTableResult.getModel();        
        if(jTableResult.getSelectedRow()==-1){
            if(jTableResult.getRowCount()==0){
                JOptionPane.showMessageDialog(null, "No Row has been Selected",
                        "Alert!", JOptionPane.OK_OPTION);
            }else
                JOptionPane.showMessageDialog(null, "Select a Row to be Deleted",
                        "Student Records System", JOptionPane.OK_OPTION);
        }
        else{    
             model.removeRow(jTableResult.getSelectedRow());
        } 
}
//===========================end Funtion==================================
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonClear;
    public javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonDetails;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonRanking;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonTranscript;
    private javax.swing.JComboBox<String> jComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableResult;
    private javax.swing.JTextArea jTextArea;
    private javax.swing.JTextField jTextAverage;
    private javax.swing.JTextField jTextDBMS;
    private javax.swing.JTextField jTextDSA;
    private javax.swing.JTextField jTextFLAC;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextFirstName;
    private javax.swing.JTextField jTextLab1;
    private javax.swing.JTextField jTextLastName;
    private javax.swing.JTextField jTextMP;
    private javax.swing.JTextField jTextMPLAB;
    private javax.swing.JTextField jTextMath;
    private javax.swing.JTextField jTextRanking;
    private javax.swing.JTextField jTextSP;
    private javax.swing.JTextField jTextStudentID;
    private javax.swing.JTextField jTextTotal;
    // End of variables declaration//GEN-END:variables
}
