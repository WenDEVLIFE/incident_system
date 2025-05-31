package UserSetting;

import MainPackage.MainFrame;
import SomeFunctions.MyConnection;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import javax.swing.border.Border;
import javax.swing.*;

public class LoginFrame extends JFrame{
    public static String SeeUser;

    int loginAttempt = 1;
    public LoginFrame() {
        initComponents();
    this.setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextUserName = new javax.swing.JTextField();
        jLabelLoginAs = new javax.swing.JLabel();
        jLogin = new javax.swing.JButton();
        jPassword = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login");
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(228, 228, 228), 6));
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPanel1KeyTyped(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextUserName.setBackground(new java.awt.Color(204, 204, 255));
        jTextUserName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextUserName.setForeground(new java.awt.Color(51, 51, 51));
        jTextUserName.setText("username");
        jTextUserName.setBorder(null);
        jTextUserName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextUserNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextUserNameFocusLost(evt);
            }
        });
        jTextUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextUserNameActionPerformed(evt);
            }
        });
        jTextUserName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextUserNameKeyTyped(evt);
            }
        });
        jPanel1.add(jTextUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, 290, 30));

        jLabelLoginAs.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabelLoginAs.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLoginAs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLoginAs.setText("Login As :");
        jPanel1.add(jLabelLoginAs, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 100, 40));

        jLogin.setBackground(new java.awt.Color(204, 204, 255));
        jLogin.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLogin.setForeground(new java.awt.Color(51, 51, 51));
        jLogin.setText("Login");
        jLogin.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        jLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLoginMouseExited(evt);
            }
        });
        jLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLoginActionPerformed(evt);
            }
        });
        jLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jLoginKeyTyped(evt);
            }
        });
        jPanel1.add(jLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, 100, 40));

        jPassword.setBackground(new java.awt.Color(204, 204, 255));
        jPassword.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPassword.setForeground(new java.awt.Color(51, 51, 51));
        jPassword.setText(" passwor");
        jPassword.setBorder(null);
        jPassword.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordFocusLost(evt);
            }
        });
        jPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordActionPerformed(evt);
            }
        });
        jPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPasswordKeyTyped(evt);
            }
        });
        jPanel1.add(jPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, 290, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Create a new acount");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel6MouseExited(evt);
            }
        });
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, 340, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Forgot Password");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel7MouseExited(evt);
            }
        });
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 210, 120, 150));

        jComboBox1.setBackground(new java.awt.Color(204, 204, 255));
        jComboBox1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(51, 51, 51));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Barangay.Secretary", "Chief brgy.police officer" }));
        jComboBox1.setBorder(null);
        jComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, 180, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Log in");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 510, 50));

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("WELCOME!");
        jPanel2.add(jLabel1);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 330, 340));

        getContentPane().add(jPanel1, new java.awt.GridBagConstraints());

        pack();
    }// </editor-fold>//GEN-END:initComponents
        
    private void jLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLoginActionPerformed
        if(loginAttempt <= 3){
            loginAttempt++;
        PreparedStatement st;
        ResultSet rs;
        String loginAs = String.valueOf(jComboBox1.getSelectedItem());
        String username = jTextUserName.getText();
        String Password = String.valueOf(jPassword.getPassword());
        
        String query ="SELECT * FROM login where userName=? AND userpassword=? And LoginAs=?" ;
        
        try {
            
        st = MyConnection.getConnection().prepareStatement(query);
        st.setString(1, username);
        st.setString(2, Password);
        st.setString(3, loginAs);
        
        rs = st.executeQuery();
        
        rs.next();        
            if(rs.getRow() == 1){
                SeeUser = jComboBox1.getSelectedItem().toString();
                MainFrame mf = new MainFrame();
                mf.setVisible(true);
                mf.pack();
                mf.setLocationRelativeTo(null);
                mf.setExtendedState(MainFrame.MAXIMIZED_BOTH);
                this.dispose();        
        }
        else{
            JOptionPane.showMessageDialog(null, 
                    "Invalid UserName and Password","Error",2);
        }
        }
        catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            
        }
        }
        else{
            JOptionPane.showMessageDialog(this,"You Attempt more than 3 times");
            System.exit(0);
        }
    }//GEN-LAST:event_jLoginActionPerformed
    
    private void jLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLoginMouseEntered
        
        jLogin.setBackground(Color.GREEN);
    }//GEN-LAST:event_jLoginMouseEntered

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        Admin ad = new Admin();
        ad.setVisible(true);
        ad.pack();
        ad.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
        jLabel6.setForeground(Color.red);
        Border border = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.red);
        jLabel6.setBorder(border);
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
      jLabel6.setForeground(Color.white);
      jLabel6.setBorder(null);
    }//GEN-LAST:event_jLabel6MouseExited

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
      Hint hint = new Hint();
      hint.setVisible(true);
      hint.setLocationRelativeTo(null);
      
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered
        jLabel7.setForeground(Color.red);
        Border border = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.red);
        jLabel7.setBorder(border);
    }//GEN-LAST:event_jLabel7MouseEntered

    private void jLabel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseExited
        jLabel7.setForeground(Color.white);
        jLabel7.setBorder(null);
    }//GEN-LAST:event_jLabel7MouseExited

    private void jLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLoginMouseExited
        
        jLogin.setBackground(Color.black);
    }//GEN-LAST:event_jLoginMouseExited

    private void jPanel1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyTyped
        
    }//GEN-LAST:event_jPanel1KeyTyped

    private void jLoginKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLoginKeyTyped
     
    }//GEN-LAST:event_jLoginKeyTyped

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
      // DataAcces d = new DataAcces();
        
    }//GEN-LAST:event_formWindowOpened

    private void jPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordKeyTyped
        char num = evt.getKeyChar();
        if(num == KeyEvent.VK_ENTER)
            jLoginActionPerformed(null);
    }//GEN-LAST:event_jPasswordKeyTyped

    private void jTextUserNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextUserNameKeyTyped
        char num = evt.getKeyChar();
        if(num == KeyEvent.VK_ENTER)
            jTextUserName.nextFocus();
    }//GEN-LAST:event_jTextUserNameKeyTyped

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextUserNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextUserNameFocusGained

        if(jTextUserName.getText().trim().equals("username")){
            jTextUserName.setText("");
            jTextUserName.setForeground(Color.white);

        }
    }//GEN-LAST:event_jTextUserNameFocusGained

    private void jTextUserNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextUserNameFocusLost

        if(jTextUserName.getText().trim().equals("")||
            jTextUserName.getText().trim().equals("username")){
        jTextUserName.setText("username");
        jTextUserName.setForeground(new Color(153,153,153,153));
        }
    }//GEN-LAST:event_jTextUserNameFocusLost

    private void jPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordFocusGained
        
        if(jPassword.getText().equals("password")){
            jPassword.setText("");
            jPassword.setForeground(Color.white);
        }
    }//GEN-LAST:event_jPasswordFocusGained

    private void jPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordFocusLost
        
        if(jPassword.getText().equals("")||
           jPassword.getText().equals("password")){
        jPassword.setText("password");
        jPassword.setForeground(new Color(153,153,153,153));
        }
    }//GEN-LAST:event_jPasswordFocusLost

    private void jPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordActionPerformed

    private void jTextUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextUserNameActionPerformed

    
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
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelLoginAs;
    private javax.swing.JButton jLogin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JTextField jTextUserName;
    // End of variables declaration//GEN-END:variables
}
