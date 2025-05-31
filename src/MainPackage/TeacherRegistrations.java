package MainPackage;


import static SomeFunctions.Helper.AlreadyExistT;
import SomeFunctions.MyConnection;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class TeacherRegistrations extends javax.swing.JFrame {
        PreparedStatement ps;
        ResultSet rs;
    public TeacherRegistrations() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jRadioButtonF = new javax.swing.JRadioButton();
        jRadioButtonM = new javax.swing.JRadioButton();
        jTextId = new javax.swing.JTextField();
        jTextSalary = new javax.swing.JTextField();
        jTextPhone = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaAddress = new javax.swing.JTextArea();
        jButtonAdd = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableTeacher = new javax.swing.JTable();
        jButtonCancel = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jTextSubject = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextLName = new javax.swing.JTextField();
        jTextFName = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldSearch = new javax.swing.JTextField();
        jButtonAdd1 = new javax.swing.JButton();
        jTextBirth = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(24, 25, 30));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pending incident");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 370, 50));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Teacher_ID:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, 30));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Last Name: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, 30));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Gender:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 100, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Salary:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 80, 30));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("PhoneNo: ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, -1, 30));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Address: ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, -1, -1));

        jRadioButtonF.setBackground(new java.awt.Color(0, 51, 51));
        buttonGroup1.add(jRadioButtonF);
        jRadioButtonF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonF.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonF.setText("Female");
        jPanel1.add(jRadioButtonF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, -1, -1));

        jRadioButtonM.setBackground(new java.awt.Color(0, 51, 51));
        buttonGroup1.add(jRadioButtonM);
        jRadioButtonM.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonM.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonM.setText("Male");
        jRadioButtonM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButtonM, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, -1, -1));
        jPanel1.add(jTextId, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 220, 30));
        jPanel1.add(jTextSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, 220, 30));

        jTextPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextPhoneActionPerformed(evt);
            }
        });
        jTextPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextPhoneKeyTyped(evt);
            }
        });
        jPanel1.add(jTextPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, 220, 30));

        jTextAreaAddress.setColumns(20);
        jTextAreaAddress.setRows(5);
        jScrollPane1.setViewportView(jTextAreaAddress);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 470, 220, 83));

        jButtonAdd.setBackground(new java.awt.Color(0, 204, 51));
        jButtonAdd.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonAdd.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAdd.setText("Add");
        jButtonAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 570, 80, 39));

        jButtonDelete.setBackground(new java.awt.Color(255, 0, 0));
        jButtonDelete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonDelete.setForeground(new java.awt.Color(255, 255, 255));
        jButtonDelete.setText("Delete");
        jButtonDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 570, 100, 39));

        jTableTeacher.setAutoCreateRowSorter(true);
        jTableTeacher.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTableTeacher.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TeacherID", "F-Name", "L-Name", "Gender", "BirthDate", "Subject", "Salary", "Phone", "Address"
            }
        ));
        jTableTeacher.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableTeacher.setFocusable(false);
        jTableTeacher.setName(""); // NOI18N
        jTableTeacher.setOpaque(false);
        jTableTeacher.setRowHeight(22);
        jTableTeacher.setSelectionBackground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(jTableTeacher);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, 640, 450));

        jButtonCancel.setBackground(new java.awt.Color(255, 0, 0));
        jButtonCancel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonCancel.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCancel.setText("Edit");
        jButtonCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, 80, 39));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("BirthDay: ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 110, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 990, 10));
        jPanel1.add(jTextSubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 220, 30));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Subject:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 90, 30));
        jPanel1.add(jTextLName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 220, 30));
        jPanel1.add(jTextFName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 220, 30));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("First Name: ");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, 30));

        jTextFieldSearch.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextFieldSearch.setForeground(new java.awt.Color(153, 153, 153));
        jTextFieldSearch.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldSearch.setText("search");
        jTextFieldSearch.setToolTipText("");
        jTextFieldSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldSearchFocusLost(evt);
            }
        });
        jTextFieldSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSearchActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 640, 40));

        jButtonAdd1.setBackground(new java.awt.Color(0, 204, 51));
        jButtonAdd1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonAdd1.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAdd1.setText("Save");
        jButtonAdd1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAdd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdd1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAdd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 570, 80, 39));
        jPanel1.add(jTextBirth, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 220, 30));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(jPanel1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonMActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
         DefaultTableModel model = (DefaultTableModel) jTableTeacher.getModel();
        if(jTableTeacher.getSelectedRow()==-1){
            if(jTableTeacher.getRowCount()==0){
                JOptionPane.showMessageDialog(null, "No Teacher has been Selected",
                        "Alert!", JOptionPane.OK_OPTION);
            }else
                JOptionPane.showMessageDialog(null, "Select the Teacher to be Deleted",
                        "Records System", JOptionPane.OK_OPTION);
            
        }
        else{
            String id = jTableTeacher.getValueAt(jTableTeacher.getSelectedRow(), 0).toString();
            try{
            ps = MyConnection.getConnection().prepareStatement("DELETE FROM teacher WHERE(teacher_id ="+'"'+id+'"'+")");
            ps.executeUpdate();
            }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Can Not Delete At this Moment! Try Later"+e.getMessage());
            }
            model.removeRow(jTableTeacher.getSelectedRow());
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jTextPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextPhoneActionPerformed

    private void jTextPhoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPhoneKeyTyped
        if(!Character.isDigit(evt.getKeyChar()))
            evt.consume();
    }//GEN-LAST:event_jTextPhoneKeyTyped

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed

        if(jTextId.getText().trim().equals("")
               ||jTextId.getText().trim().equals("")
               ||jTextFName.getText().trim().equals("")
               ||jTextLName.getText().trim().equals(""))
           JOptionPane.showMessageDialog(null, "Please Enter student Name and Id", "Alert",1);
       else if(jTextBirth.getText().isEmpty() || jTextPhone.getText().isEmpty()
               ||jTextAreaAddress.getText().isEmpty()
               ||jTextSalary.getText().isEmpty()||jTextSubject.getText().isEmpty())
           JOptionPane.showMessageDialog(null, "Please Enter the Details","Alert",1);
        
       else{
        String ID = jTextId.getText();
        if(!AlreadyExistT(ID)){
        String query = "insert into teacher(teacher_id, FirstName, LastName, Gender, Birth, Subject, Salary, Phone, Address) values(?,?,?,?,?,?,?,?,?)";
        
        try{
            ps = MyConnection.getConnection().prepareStatement(query);
            ps.setString(1, ID);
            ps.setString(2, jTextFName.getText());
            ps.setString(3, jTextLName.getText());
            ps.setString(4, RadioButton());
            ps.setString(5, jTextBirth.getText());
            ps.setString(6, jTextSubject.getText());
            ps.setString(7, jTextSalary.getText());
            ps.setString(8, jTextPhone.getText());
            ps.setString(9, jTextAreaAddress.getText());
            ps.executeUpdate();
            RegisterTable();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Can not Store tha data at this Time Please Try Later!");
        }        
        }
    }   
    }//GEN-LAST:event_jButtonAddActionPerformed

//===================================SomeFunction===============================    
    private Object RegisterTable(){   
        DefaultTableModel model = (DefaultTableModel) jTableTeacher.getModel();
         model.addRow(new Object[]{
           jTextId.getText(),
           jTextFName.getText(),
           jTextLName.getText(),
           RadioButton(),
           jTextBirth.getText(),
           jTextSubject.getText(),
           jTextSalary.getText(),
           jTextPhone.getText(),
           jTextAreaAddress.getText(),                    
       });
         return 0;
    }
    
    public String RadioButton(){
        if(jRadioButtonF.isSelected())
            return jRadioButtonF.getText();
        else
            return jRadioButtonM.getText();
    }
    
    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
    if(jTableTeacher.getSelectedRow()==-1)
    JOptionPane.showMessageDialog(null,"Please Select a Row to Edit!");
    else{
        jTextId.setText(jTableTeacher.getValueAt(jTableTeacher.getSelectedRow(), 0).toString());
        jTextFName.setText(jTableTeacher.getValueAt(jTableTeacher.getSelectedRow(), 1).toString());
        jTextLName.setText(jTableTeacher.getValueAt(jTableTeacher.getSelectedRow(), 2).toString());
        jTextBirth.setText(jTableTeacher.getValueAt(jTableTeacher.getSelectedRow(), 4).toString());
        jTextSubject.setText(jTableTeacher.getValueAt(jTableTeacher.getSelectedRow(), 5).toString());
        jTextSalary.setText(jTableTeacher.getValueAt(jTableTeacher.getSelectedRow(), 6).toString());
        jTextPhone.setText(jTableTeacher.getValueAt(jTableTeacher.getSelectedRow(), 7).toString());
        jTextAreaAddress.setText(jTableTeacher.getValueAt(jTableTeacher.getSelectedRow(), 8).toString());
}
    
    
    
    
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        try {
            String registerQuery ="SELECT * From teacher";
            DefaultTableModel modele = (DefaultTableModel) jTableTeacher.getModel();        
            ps = MyConnection.getConnection().prepareStatement(registerQuery);
            rs = ps.executeQuery();
            while(rs.next()){
            Object o[]= {rs.getString("teacher_id"), rs.getString("FirstName"), rs.getString("LastName")
                    ,rs.getString("Gender"), rs.getString("Birth"), rs.getString("Subject")
                    ,rs.getString("Salary"), rs.getString("Phone"), rs.getString("Address")};
            if(jTableTeacher.getRowCount()!= getRowNumber())    
            modele.addRow(o);    
            }
            }catch(SQLException ex){
              Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }//GEN-LAST:event_formWindowOpened

    private void jTextFieldSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSearchFocusGained
        if(jTextFieldSearch.getText().trim().toLowerCase().equals("search")){
            jTextFieldSearch.setText("");
            jTextFieldSearch.setForeground(Color.black);

        }
    }//GEN-LAST:event_jTextFieldSearchFocusGained

    private void jTextFieldSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSearchFocusLost
        if(jTextFieldSearch.getText().trim().equals("")||
            jTextFieldSearch.getText().trim().toLowerCase().equals("search")){
        jTextFieldSearch.setText("Search");
        jTextFieldSearch.setForeground(new Color(153,153,153,153));
        }

    }//GEN-LAST:event_jTextFieldSearchFocusLost

    private void jTextFieldSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSearchActionPerformed

    }//GEN-LAST:event_jTextFieldSearchActionPerformed

    private void jButtonAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdd1ActionPerformed

        if(jTableTeacher.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(null,"First Select A Row To Be Edited");
        }
        else if(jTableTeacher.getSelectedRow()!=-1){
            if(jTextId.getText().equals("")||jTextFName.getText().equals("")
             ||jTextLName.getText().equals("")||jTextBirth.getText().equals("")
             ||jTextPhone.getText().equals("")||jTextAreaAddress.getText().equals("")
             ||jTextSalary.getText().equals("")||jTextSubject.getText().equals(""))
                JOptionPane.showMessageDialog(null,"This data is already Saved!");
            else{
                String id = jTableTeacher.getValueAt(jTableTeacher.getSelectedRow(), 0).toString();
        String Query = "UPDATE teacher SET teacher_id='"+jTextId.getText()+"',"
                + " FirstName='"+jTextFName.getText()+"', LastName='"+jTextLName.getText()+"', Gender='"+RadioButton()+"',"
                + " Birth='"+jTextBirth.getText()+"',"
                + " Subject='"+jTextSubject.getText()+"', Salary='"+jTextSalary.getText()+"',"
                + " Phone='"+jTextPhone.getText()+"', Address='"+jTextAreaAddress.getText()+"' WHERE teacher_id ="+'"'+id+'"';
        
        if(!AlreadyExistT(jTextId.getText())){
        try{
            ps = MyConnection.getConnection().prepareStatement(Query);
            ps.executeUpdate();
            DeletePre();
            RegisterTable();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Can not Edit at this Time Please Try Later!"+e.getMessage());
        }
        }
        }
        }          
    }//GEN-LAST:event_jButtonAdd1ActionPerformed
    
    public void DeletePre (){
        DefaultTableModel model = (DefaultTableModel) jTableTeacher.getModel();
        model.removeRow(jTableTeacher.getSelectedRow());
}
    
    
    public int getRowNumber(){//============start===============

    int numberRow = 0;
    PreparedStatement ps;
    ResultSet rs;
    String query = "select count(*) from teacher";
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
            java.util.logging.Logger.getLogger(TeacherRegistrations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeacherRegistrations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeacherRegistrations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeacherRegistrations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TeacherRegistrations().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonAdd1;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButtonF;
    private javax.swing.JRadioButton jRadioButtonM;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableTeacher;
    private javax.swing.JTextArea jTextAreaAddress;
    private javax.swing.JTextField jTextBirth;
    private javax.swing.JTextField jTextFName;
    private javax.swing.JTextField jTextFieldSearch;
    private javax.swing.JTextField jTextId;
    private javax.swing.JTextField jTextLName;
    private javax.swing.JTextField jTextPhone;
    private javax.swing.JTextField jTextSalary;
    private javax.swing.JTextField jTextSubject;
    // End of variables declaration//GEN-END:variables
}
