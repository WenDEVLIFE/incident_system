package model;

public class IncidentModel {
    String id;

    String incident;

    String date;

    String time;

    String location;

    String description;

    String peopleInvolved;

    String OfficerInCharge;

    String status;

    public IncidentModel(String id, String incident, String date, String time, String location,
                          String description, String peopleInvolved, String OfficerInCharge, String status) {
        this.id = id;
        this.incident = incident;
        this.date = date;
        this.time = time;
        this.location = location;
        this.description = description;
        this.peopleInvolved = peopleInvolved;
        this.OfficerInCharge = OfficerInCharge;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getIncident() {
        return incident;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public String getPeopleInvolved() {
        return peopleInvolved;
    }

    public String getOfficerInCharge() {
        return OfficerInCharge;
    }


    public String getStatus() {
        return status;
    }
}
