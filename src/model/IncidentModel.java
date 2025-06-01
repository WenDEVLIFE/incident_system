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

    String resolve_description;

    String resolvedBy;

    public IncidentModel(String id, String incident, String date, String time, String location,
                          String description, String peopleInvolved, String OfficerInCharge, String status, String resolve_description, String resolvedBy) {
        this.id = id;
        this.incident = incident;
        this.date = date;
        this.time = time;
        this.location = location;
        this.description = description;
        this.peopleInvolved = peopleInvolved;
        this.OfficerInCharge = OfficerInCharge;
        this.status = status;
        this.resolve_description = resolve_description;
        this.resolvedBy = resolvedBy;
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

    public String getResolveDescription() {
        return resolve_description;
    }

    public String getResolvedBy() {
        return resolvedBy;
    }
}
