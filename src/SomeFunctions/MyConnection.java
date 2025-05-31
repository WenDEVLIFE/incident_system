package SomeFunctions;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class MyConnection {
   
    static String databaseUrl = "jdbc:mysql://localhost:3306/incident_db";
    static String user="root";
    static String password="";
    
    public static void main(String [] args){
        MyConnection conn = new MyConnection();
        conn.getConnection();
    }
    void intializeConenction(){
       try{
              System.out.println("Loading MySQL driver...");
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully.");
            java.sql.Connection connection = java.sql.DriverManager.getConnection(databaseUrl, user, password);
            System.out.println("Connection established successfully");
            connection.close();
       } catch(Exception e){
           e.printStackTrace();
       }
    }
    
    
    
    
    public static Connection getConnection(){
                Connection connection = null;
          try {
            System.out.println("Loading MySQL driver...");
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully.");
            connection = java.sql.DriverManager.getConnection(databaseUrl, user, password);
            System.out.println("Connection established successfully");
        } catch (Exception e) {
            System.out.println("Error establishing connection: " + e.getMessage());
            e.printStackTrace(); // Print stack trace for debugging
        }
          
          return connection;
    }
}
