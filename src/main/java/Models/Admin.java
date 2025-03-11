package Models;

public class Admin {
    private int idUser;

    //constructors
    public Admin(){}

    public Admin(int idUser) {
        this.idUser = idUser;
    }

    //getters && setters

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
