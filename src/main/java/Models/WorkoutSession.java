package Models;

import java.util.Date;

public class WorkoutSession {

    private int idWorkout;
    private Date dateWorkout;
    private String heure;
    private int idCoach; // Référence à Coach (idUser)
    private int idUser;  // Référence à Member (idUser)

    //constructors

    public WorkoutSession(){}

    public WorkoutSession(int idWorkout, Date dateWorkout, String heure, int idCoach, int idUser) {
        this.idWorkout = idWorkout;
        this.dateWorkout = dateWorkout;
        this.heure = heure;
        this.idCoach = idCoach;
        this.idUser = idUser;
    }

    public WorkoutSession(Date dateWorkout, String heure, int idCoach, int idUser) {
        this.dateWorkout = dateWorkout;
        this.heure = heure;
        this.idCoach = idCoach;
        this.idUser = idUser;
    }

    //getters && setters

    public int getIdWorkout() {
        return idWorkout;
    }

    public void setIdWorkout(int idWorkout) {
        this.idWorkout = idWorkout;
    }

    public Date getDateWorkout() {
        return dateWorkout;
    }

    public void setDateWorkout(Date dateWorkout) {
        this.dateWorkout = dateWorkout;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public int getIdCoach() {
        return idCoach;
    }

    public void setIdCoach(int idCoach) {
        this.idCoach = idCoach;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
