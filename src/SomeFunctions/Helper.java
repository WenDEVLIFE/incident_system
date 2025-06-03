package SomeFunctions;
import model.IncidentModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
        String query = "INSERT INTO incident_table (incident, date, time, location, description, people_involved, officer, status, resolve_description, resolved_by, date_passed, date_finished, narrative) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ? , ?, ?, ?)";
        String incident = (String) incidentData.get("incidentType");
        String date = (String) incidentData.get("date");
        String time = (String) incidentData.get("time");
        String location = (String) incidentData.get("location");
        String description = (String) incidentData.get("description");
        String peopleInvolved = (String) incidentData.get("peopleInvolved");
        String officer = (String) incidentData.get("officer");
        String narratives = (String) incidentData.get("narrative");
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
            st.setString(9, "n/a"); // Default resolve description
            st.setString(10, "n/a"); // Default resolve by
            LocalDate currentDate = LocalDate.now();
            st.setString(11, currentDate.toString()); // Date passed
            st.setString(12, "n/a"); // Date finished
            st.setString(13, narratives); // Narrative

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

    public List<IncidentModel> getAllIncidents() {
        List<IncidentModel> incidents = new ArrayList<>();
        String query = "SELECT * FROM incident_table";

        try (PreparedStatement st = MyConnection.getConnection().prepareStatement(query);
             ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                String id = rs.getString("id");
                String incident = rs.getString("incident");
                String date = rs.getString("date");
                String time = rs.getString("time");
                String location = rs.getString("location");
                String description = rs.getString("description");
                String peopleInvolved = rs.getString("people_involved");
                String officerInCharge = rs.getString("officer");
                String status = rs.getString("status");
                String resolvedDescription = rs.getString("resolve_description");
                String resolvedBy = rs.getString("resolved_by");
                String narratives = rs.getString("narrative");

                IncidentModel incidentModel = new IncidentModel(id, incident, date, time, location, description, narratives, peopleInvolved, officerInCharge, status, resolvedDescription, resolvedBy);
                incidents.add(incidentModel);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error fetching incidents: " + e.getMessage());
        }

        return incidents;
    }

    public List<IncidentModel> getPendingIncidents() {
        List<IncidentModel> pendingIncidents = new ArrayList<>();
        String query = "SELECT * FROM incident_table WHERE status = 'Pending'";

        try (PreparedStatement st = MyConnection.getConnection().prepareStatement(query);
             ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                String id = rs.getString("id");
                String incident = rs.getString("incident");
                String date = rs.getString("date");
                String time = rs.getString("time");
                String location = rs.getString("location");
                String description = rs.getString("description");
                String peopleInvolved = rs.getString("people_involved");
                String officerInCharge = rs.getString("officer");
                String status = rs.getString("status");
                String resolvedDescription = rs.getString("resolve_description");
                String resolvedBy = rs.getString("resolved_by");
                String narratives = rs.getString("narrative");

                IncidentModel incidentModel = new IncidentModel(id, incident, date, time, location, description, narratives, peopleInvolved, officerInCharge, status, resolvedDescription, resolvedBy);
                pendingIncidents.add(incidentModel);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error fetching pending incidents: " + e.getMessage());
        }

        return pendingIncidents;
    }

    public List<IncidentModel> getUnderInvestigationIncidents() {
        List<IncidentModel> underInvestigationIncidents = new ArrayList<>();
        String query = "SELECT * FROM incident_table WHERE status = 'Under Investigation'";

        try (PreparedStatement st = MyConnection.getConnection().prepareStatement(query);
             ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                String id = rs.getString("id");
                String incident = rs.getString("incident");
                String date = rs.getString("date");
                String time = rs.getString("time");
                String location = rs.getString("location");
                String description = rs.getString("description");
                String peopleInvolved = rs.getString("people_involved");
                String officerInCharge = rs.getString("officer");
                String status = rs.getString("status");
                String resolvedDescription = rs.getString("resolve_description");
                String resolvedBy = rs.getString("resolved_by");
                String narratives = rs.getString("narrative");

                IncidentModel incidentModel = new IncidentModel(id, incident, date, time, location, description, narratives, peopleInvolved, officerInCharge, status, resolvedDescription, resolvedBy);
                underInvestigationIncidents.add(incidentModel);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error fetching under investigation incidents: " + e.getMessage());
        }

        return underInvestigationIncidents;
    }

    public List<IncidentModel> getResolvedIncidents() {
        List<IncidentModel> resolvedIncidents = new ArrayList<>();
        String query = "SELECT * FROM incident_table WHERE status = 'Resolved'";

        try (PreparedStatement st = MyConnection.getConnection().prepareStatement(query);
             ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                String id = rs.getString("id");
                String incident = rs.getString("incident");
                String date = rs.getString("date");
                String time = rs.getString("time");
                String location = rs.getString("location");
                String description = rs.getString("description");
                String peopleInvolved = rs.getString("people_involved");
                String officerInCharge = rs.getString("officer");
                String status = rs.getString("status");
                String resolvedDescription = rs.getString("resolve_description");
                String narratives = rs.getString("narrative");
                String resolvedBy = rs.getString("resolved_by");

                IncidentModel incidentModel = new IncidentModel(id, incident, date, time, location, description, narratives, peopleInvolved, officerInCharge, status, resolvedDescription, resolvedBy);
                resolvedIncidents.add(incidentModel);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error fetching resolved incidents: " + e.getMessage());
        }

        return resolvedIncidents;
    }

    public void updateIncident(Map<String, Object> incidentData, int selectedRow, JDialog updateIncidentDialog) {
        String query = "UPDATE incident_table SET incident = ?, date = ?, time = ?, location = ?, description = ?, people_involved = ?, officer = ?, narrative = ? WHERE id = ?";
        String incident = (String) incidentData.get("incidentType");
        String date = (String) incidentData.get("date");
        String time = (String) incidentData.get("time");
        String location = (String) incidentData.get("location");
        String description = (String) incidentData.get("description");
        String peopleInvolved = (String) incidentData.get("peopleInvolved");
        String officer = (String) incidentData.get("officer");
        String id = (String) incidentData.get("id");
        String narratives = (String) incidentData.get("narrative");

        try {
            PreparedStatement st = MyConnection.getConnection().prepareStatement(query);
            st.setString(1, incident);
            st.setString(2, date);
            st.setString(3, time);
            st.setString(4, location);
            st.setString(5, description);
            st.setString(6, peopleInvolved);
            st.setString(7, officer);
            st.setString(8, narratives);
            st.setString(9, id);

            if (st.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(updateIncidentDialog, "Incident updated successfully!");
                updateIncidentDialog.dispose();
            } else {
                JOptionPane.showMessageDialog(updateIncidentDialog, "Failed to update incident. Please try again.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(updateIncidentDialog, "Error: " + e.getMessage());
        }
    }

    public void deleteIncident(String incidentId) {
        String query = "DELETE FROM incident_table WHERE id = ?";

        try {
            PreparedStatement st = MyConnection.getConnection().prepareStatement(query);
            st.setString(1, incidentId);

            if (st.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Incident deleted successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to delete incident. Please try again.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void updateIncidentStatus(String incidentId, String underInvestigation, String resolvedDescription, String resolvedBy) {
        String query = "UPDATE incident_table SET status = ? WHERE id =?";

        try {
            PreparedStatement st = MyConnection.getConnection().prepareStatement(query);
            st.setString(1, underInvestigation);
            st.setString(2, incidentId);

            if (st.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Incident status updated successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to update incident status. Please try again.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void updateIncidentToResolved(String incidentId, String status, String resolvedDescription, String resolvedBy) {
        String query = "UPDATE incident_table SET status = ?, resolve_description = ?, resolved_by = ?, date_finished = ? WHERE id = ?";

        try {
            int incidentIdInt = Integer.parseInt(incidentId); // ID is INT

            PreparedStatement st = MyConnection.getConnection().prepareStatement(query);
            st.setString(1, status);
            st.setString(2, resolvedDescription);
            st.setString(3, resolvedBy);
            st.setString(4, LocalDate.now().toString()); // Use String for date
            st.setInt(5, incidentIdInt);

            int rows = st.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "✅ Incident updated successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "⚠️ No incident found with ID " + incidentIdInt);
            }

            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ SQL Error: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "❗ Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<IncidentModel> getAllPendingAndUnderInvestigationIncidents() {
        List<IncidentModel> incidents = new ArrayList<>();
        String query = "SELECT * FROM incident_table WHERE status = 'Pending' OR status = 'Under Investigation'";

        try (PreparedStatement st = MyConnection.getConnection().prepareStatement(query);
             ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                String id = rs.getString("id");
                String incident = rs.getString("incident");
                String date = rs.getString("date");
                String time = rs.getString("time");
                String location = rs.getString("location");
                String description = rs.getString("description");
                String peopleInvolved = rs.getString("people_involved");
                String officerInCharge = rs.getString("officer");
                String status = rs.getString("status");
                String resolvedDescription = rs.getString("resolve_description");
                String resolvedBy = rs.getString("resolved_by");
                String narratives = rs.getString("narrative");

                IncidentModel incidentModel = new IncidentModel(id, incident, date, time, location, description, narratives, peopleInvolved, officerInCharge, status, resolvedDescription, resolvedBy);
                incidents.add(incidentModel);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error fetching incidents: " + e.getMessage());
        }

        return incidents;
    }

    public int getPendingCount() {
        int count = 0;
        String query = "SELECT COUNT(*) FROM incident_table WHERE status = 'Pending'";

        try (PreparedStatement st = MyConnection.getConnection().prepareStatement(query);
             ResultSet rs = st.executeQuery()) {

            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error fetching pending count: " + e.getMessage());
        }

        return count;
    }

    public int getUnderInvestigationCount() {
        int count = 0;
        String query = "SELECT COUNT(*) FROM incident_table WHERE status = 'Under Investigation'";

        try (PreparedStatement st = MyConnection.getConnection().prepareStatement(query);
             ResultSet rs = st.executeQuery()) {

            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error fetching under investigation count: " + e.getMessage());
        }

        return count;
    }
}
