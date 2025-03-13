package Models;

import java.util.Date;

public class Member {
    private int idUser; // idUser est la clé primaire
    private Date dateOfBirth;
    private String sportPratique;

    //constructors

    public Member(){}

    public Member(int idUser, Date dateOfBirth, String sportPratique) {
        this.idUser = idUser;
        this.dateOfBirth = dateOfBirth;
        this.sportPratique = sportPratique;
    }

    public Member(Date dateOfBirth, String sportPratique) {
        this.dateOfBirth = dateOfBirth;
        this.sportPratique = sportPratique;
    }

    //getters && setters

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSportPratique() {
        return sportPratique;
    }

    public void setSportPratique(String sportPratique) {
        this.sportPratique = sportPratique;
    }
}
