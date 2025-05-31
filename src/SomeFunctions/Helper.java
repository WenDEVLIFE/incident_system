package SomeFunctions;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import javax.swing.*;

public class Helper {

    
    public static boolean AlreadyExist(String StudentID){
        PreparedStatement st;
        ResultSet rs;
        boolean alreadyExist = false;
        String query = "SELECT * FROM student_registration where student_id =?";
        
        try{
            st = MyConnection.getConnection().prepareStatement(query);
            st.setString(1, StudentID);
            rs = st.executeQuery();
            
            if(rs.next()){
                alreadyExist = true;
                JOptionPane.showMessageDialog(null,"Student with this Id is Already Exist","Error",2);
            }    
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error please Try Again Later!");
        }
        return alreadyExist;
    }
    
    public static boolean incidentExist(String incident){
        PreparedStatement st;
        ResultSet rs;
        boolean alreadyExist = false;
        String query = "SELECT * FROM student_registration where incident =?";
        
        try{
            st = MyConnection.getConnection().prepareStatement(query);
            st.setString(1, incident);
            rs = st.executeQuery();
            
            if(rs.next()){
                alreadyExist = true;
                JOptionPane.showMessageDialog(null,"Incident Already Exsit","Error",2);
            }    
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error please Try Again Later!");
        }
        return alreadyExist;
    }
    //================  Check for ForeignKey and delete one of AlreadyExistFunction========
    public static boolean AlreadyExistR(String ID){
        PreparedStatement st;
        ResultSet rs;
        boolean alreadyExist = false;
        String query = "SELECT * FROM resulttable where id =?";
        
        try{
            st = MyConnection.getConnection().prepareStatement(query);
            st.setString(1, ID);
            rs = st.executeQuery();
            
            if(rs.next()){
                alreadyExist = true;
                JOptionPane.showMessageDialog(null,"Student with this Id is Already Exist","Error",2);
            }    
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error please Try Again Later!");
        }
        return alreadyExist;
    }
    
    public static boolean AlreadyExistT(String TeacherID){
        PreparedStatement st;
        ResultSet rs;
        boolean alreadyExist = false;
        String query = "SELECT * FROM teacher where teacher_id =?";
        
        try{
            st = MyConnection.getConnection().prepareStatement(query);
            st.setString(1, TeacherID);
            rs = st.executeQuery();
            
            if(rs.next()){
                alreadyExist = true;
                JOptionPane.showMessageDialog(null,"This Id is Already Exist","Error",2);
            }    
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error please Try Again Later!");
        }
        return alreadyExist;
    }
    
    
    public static boolean AcountExist(String username){
        PreparedStatement st;
        ResultSet rs;
        boolean alreadyExist = false;
        String query = "SELECT * FROM login where userName =?";
        
        try{
            st = MyConnection.getConnection().prepareStatement(query);
            st.setString(1, username);
            rs = st.executeQuery();
            
            if(rs.next()){
                alreadyExist = true;
                JOptionPane.showMessageDialog(null,"The UserName is Already Taken","Error",2);
            }    
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Can Not Create Account At This Time Please Try Later!");
        }
        return alreadyExist;
    }

    // check if an incident with the same name already exists in the database
    public boolean isIncidentExist(String incident) {
        PreparedStatement st;
        ResultSet rs;
        boolean alreadyExist = false;
        String query = "SELECT * FROM incident_table WHERE incident = ?";

        try {
            st = MyConnection.getConnection().prepareStatement(query);
            st.setString(1, incident);
            rs = st.executeQuery();

            if (rs.next()) {
                alreadyExist = true;
                JOptionPane.showMessageDialog(null, "Incident with this name already exists", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return alreadyExist;
    }

// This will insert an incident into the database
    public void insertIncident(Map<String, Object> incidentData, JDialog addIncidentDialog) {
        String query = "INSERT INTO incident_table (incident, date, time, location, description, people_involved, officer, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        String incident = (String) incidentData.get("incidentType");
        String date = (String) incidentData.get("date");
        String time = (String) incidentData.get("time");
        String location = (String) incidentData.get("location");
        String description = (String) incidentData.get("description");
        String peopleInvolved = (String) incidentData.get("peopleInvolved");
        String officer = (String) incidentData.get("officer");


        try {
            PreparedStatement st = MyConnection.getConnection().prepareStatement(query);
            st.setString(1, incident);
            st.setString(2, date);
            st.setString(3, time);
            st.setString(4, location);
            st.setString(5, description);
            st.setString(6, peopleInvolved);
            st.setString(7, officer);
            st.setString(8, "Pending"); // Default status

            if (st.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(addIncidentDialog, "Incident added successfully!");
                addIncidentDialog.dispose();
            } else {
                JOptionPane.showMessageDialog(addIncidentDialog, "Failed to add incident. Please try again.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(addIncidentDialog, "Error: " + e.getMessage());
        }

    }
}
