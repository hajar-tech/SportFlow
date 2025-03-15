package Models;

import java.sql.Time;
import java.sql.Date;

public class WorkoutSession {


        private int idSession;
        private int idCoach;
        private String sportType;
        private Date sessionDate;
        private Time startTime;
        private Time endTime;  // Référence à Member (idUser)

    //constructors

    public WorkoutSession(){}

    public WorkoutSession(int idSession, int idCoach, String sportType, Date sessionDate, Time startTime, Time endTime) {
        this.idSession = idSession;
        this.idCoach = idCoach;
        this.sportType = sportType;
        this.sessionDate = sessionDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public WorkoutSession(int idCoach, String sportType, Date sessionDate, Time startTime, Time endTime) {
        this.idCoach = idCoach;
        this.sportType = sportType;
        this.sessionDate = sessionDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }
//getters && setters


    public int getIdSession() {
        return idSession;
    }

    public void setIdSession(int idSession) {
        this.idSession = idSession;
    }

    public int getIdCoach() {
        return idCoach;
    }

    public void setIdCoach(int idCoach) {
        this.idCoach = idCoach;
    }

    public String getSportType() {
        return sportType;
    }

    public void setSportType(String sportType) {
        this.sportType = sportType;
    }

    public Date getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(Date sessionDate) {
        this.sessionDate = sessionDate;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }
}
