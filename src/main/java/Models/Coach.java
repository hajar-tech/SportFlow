package Models;

public class Coach {
    private int idUser;
    private String speciality;


    //constructors
    public Coach(){}

    public Coach(String speciality, int idUser) {
        this.speciality = speciality;
        this.idUser = idUser;
    }

    //getters && setters

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
