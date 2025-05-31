/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SomeFunctions;

import UserSetting.LoginFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class LoginFunction {
    
    
    public void LoginUser(String username, String password, LoginFrame frame){
        
        String sql ="SELECT * FROM login WHERE userName=? AND userpassword =?";
        
        try (java.sql.Connection connection = MyConnection.getConnection();
             java.sql.PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            java.sql.ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
              
                // Handle successful login
                    JOptionPane.showMessageDialog(null, "Login Sucess");
            } else {
                System.out.println("Invalid username or password");
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                // Handle invalid login
            }
        } catch (Exception e) {
            System.out.println("Error during login: " + e.getMessage());
        }
    }
}
