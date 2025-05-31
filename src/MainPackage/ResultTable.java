package MainPackage;

import SomeFunctions.MyConnection;
import UserSetting.LoginFrame;
import java.awt.Color;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ResultTable extends javax.swing.JFrame {
            PreparedStatement ps;
            ResultSet rs;
   
            public static String Id;
    public ResultTable() {       
        initComponents();  
        jTable1.getTableHeader().setOpaque(false);
        jTable1.getTableHeader().setBackground(Color.BLACK);
        jTable1.getTableHeader().setForeground(new Color(0,0,0));
        jTable1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jTextFieldSearch = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Std_Id", "Name", "Course", "DSA-LAB", "MP-LAB", "MATH", "FLAC", "SYSTEM-P", "DSA", "MP", "DBMS", "Total", "Average", "Ranking"
            }
        ));
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1.setFocusable(false);
        jTable1.setName(""); // NOI18N
        jTable1.setOpaque(false);
        jTable1.setRowHeight(22);
        jTable1.setSelectionBackground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 73, 1086, 546));

        jPanel2.setBackground(new java.awt.Color(51, 0, 51));
        jPanel2.setForeground(new java.awt.Color(0, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldSearch.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTextFieldSearch.setText("Search");
        jTextFieldSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldSearchFocusLost(evt);
            }
        });
        jPanel2.add(jTextFieldSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 583, 42));

        jButton1.setBackground(new java.awt.Color(0, 51, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Delete");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(714, 12, 101, 42));

        jButton2.setBackground(new java.awt.Color(0, 51, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("GoTo Edit");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(833, 12, 241, 42));

        jButton5.setBackground(new java.awt.Color(0, 51, 51));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Search");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(595, 12, 101, 42));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 4, 1090, 70));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 4, 0);
        getContentPane().add(jPanel1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Frame f = new Frame();
        f.setVisible(true);
        f.pack();
        f.setLocationRelativeTo(null);
        this.dispose();      
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            
            String registerQuery ="SELECT * From resulttable";
            DefaultTableModel modele = (DefaultTableModel) jTable1.getModel();        
            ps = MyConnection.getConnection().prepareStatement(registerQuery);
            rs = ps.executeQuery();
            while(rs.next()){
            Object o[]= {rs.getString("id"), rs.getString("stdName"), rs.getString("Course")
                    ,rs.getString("DSALAB"), rs.getString("MPLAB"), rs.getString("MATH")
                    ,rs.getString("FLAC"), rs.getString("SystemP"), rs.getString("DSA")
                    ,rs.getString("MP"), rs.getString("DBMS"), rs.getString("Total")
                    ,rs.getString("Average"), rs.getString("Ranking")};
            if(jTable1.getRowCount()!= getRowNumber())    
            modele.addRow(o);
                
            }
            
            }
            catch(SQLException ex){
              Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        // ======================When YOu Login As Student =============================
        String Query = "SELECT loginAs FROM login WHERE loginAs ='Student'";
        PreparedStatement psa;
        ResultSet rsa;
        try{
            psa = MyConnection.getConnection().prepareStatement(Query);
            rsa = psa.executeQuery();
            rsa.next();
            if(LoginFrame.SeeUser.equals(rsa.getString("loginAs"))){
                jButton1.setEnabled(false);
                jButton2.setEnabled(false);
            }
        }catch(Exception e){
        }
        
        
    }//GEN-LAST:event_formWindowOpened

    private void jTextFieldSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSearchFocusGained

        if(jTextFieldSearch.getText().trim().equals("Search")){
            jTextFieldSearch.setText("");
            jTextFieldSearch.setForeground(Color.black);

        }
    }//GEN-LAST:event_jTextFieldSearchFocusGained

    private void jTextFieldSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSearchFocusLost

        if(jTextFieldSearch.getText().trim().equals("")||
            jTextFieldSearch.getText().trim().equals("Search")){
        jTextFieldSearch.setText("Search");
        jTextFieldSearch.setForeground(new Color(153,153,153,153));
        }
    }//GEN-LAST:event_jTextFieldSearchFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        if(jTable1.getSelectedRow()==-1){
            if(jTable1.getRowCount()==0){
                JOptionPane.showMessageDialog(null, "No Row has been Selected",
                    "Alert!", JOptionPane.OK_OPTION);
            }else
            JOptionPane.showMessageDialog(null, "Select a Row to be Deleted",
                "Student Records System", JOptionPane.OK_OPTION);
        }
        else{
            String id = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
            try{
                ps = MyConnection.getConnection().prepareStatement("DELETE FROM resulttable WHERE(id ="+'"'+id+'"'+")");
                ps.executeUpdate();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Can Not Delete At this Moment! Try Later"+e.getMessage());
            }
            model.removeRow(jTable1.getSelectedRow());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

//========================Funtion GetNumber of Rows ====================
        
    public int getRowNumber(){

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
}
   
    
    
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
            java.util.logging.Logger.getLogger(ResultTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResultTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResultTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResultTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResultTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldSearch;
    // End of variables declaration//GEN-END:variables
}
