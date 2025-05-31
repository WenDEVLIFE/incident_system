package model;

public class StudentModel {

    String id;
    String studentNumber;
    String firstname;
    String lastname;
    String gender;
    String time;
    String date;
    String involved;
    String location;

    public StudentModel(String id, String studentNumber, String firstname, String lastname, String gender,
                        String date,  String time, String involved, String location){
        this.id = id;
        this.studentNumber = studentNumber;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.time = time;
        this.date = date;
        this.involved = involved;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getGender() {
        return gender;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public String getInvolved() {
        return involved;
    }

    public String getLocation() {
        return location;
    }

    public Object getIncidentName() {
       
        return null;
       
    }
}


   

   
   