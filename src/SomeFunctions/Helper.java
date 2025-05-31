package SomeFunctions;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

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
    
    
}
