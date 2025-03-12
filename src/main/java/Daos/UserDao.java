package Daos;

import java.sql.*;

public class UserDao {

  public int insertUser(){
      int idUser =0;

      try{
          Connection con = DataBaseConnection.getConnection();
          String sql = "insert into Users (fullName, email ,password, role) values (?,?,?,?)";
          PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
          pst.setString(1,"amir");
          pst.setString(2, "amir@gmail.com");
          pst.setString(3,"amir123");
          pst.setString(4,"admin");
           int affecteRows = pst.executeUpdate();

           if (affecteRows >0){
               ResultSet rs = pst.getGeneratedKeys();
               if (rs.next()){
                   idUser = rs.getInt(1);
                   System.out.println(" Utilisateur inséré avec l'ID : " + idUser);
               }
           } else {
               System.out.println(" Aucune ligne insérée !");
           }


      }catch (SQLException e){
          e.printStackTrace();
      }
      System.out.println(idUser);
      return idUser;
  }




    //fonction pour récupérer le dernier idUser entrer
    public int getLastId(){
        int idUser = 0;
        try {
            Connection connection = DataBaseConnection.getConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT LAST_INSERT_ID()");

            if(rs.next()){
                idUser = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return idUser;
    }



}
