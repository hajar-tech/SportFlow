package Daos;

import Models.User;

import java.sql.*;

public class UserDao {

  public int insertUser(User user , Date dateNaissance, String sportPratique, String speciality){
      int idUser =0;

      try{
          Connection con = DataBaseConnection.getConnection();
          String sql = "insert into Users (fullName, email ,password, role) values (?,?,?,?)";
          PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
          pst.setString(1, user.getFullName());
          pst.setString(2, user.getEmail());
          pst.setString(3, user.getPassword());
          pst.setString(4, user.getRole());
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

           if("member".equalsIgnoreCase(user.getRole())){
               String memberQuery = "insert into Members (idUser , dateOfBirth , sportPratique) values (?,?,?)";
               PreparedStatement pstMember = con.prepareStatement(memberQuery);

               pstMember.setInt(1,idUser);
               pstMember.setDate(2,dateNaissance);
               pstMember.setString(3,sportPratique);

               int memberResult = pstMember.executeUpdate();
               if (memberResult >0){
                   System.out.println("member details added successfully");
               }else {
                   System.out.println("echek inserting member details");
               }

           } else if ("coach".equalsIgnoreCase(user.getRole())) {

               String coachQuery = "insert into Coachs (idUser,speciality) values (?,?)";
               PreparedStatement pstCoach = con.prepareStatement(coachQuery);
               pstCoach.setInt(1,idUser);
               pstCoach.setString(2,speciality);
               int resultCoach = pstCoach.executeUpdate();
               if (resultCoach > 0){
                   System.out.println("coach added successfully");
               }else {
                   System.out.println("failed to add coach");
               }
           }else {
               String adminQuery = "insert into admin (idUser) value (?)";
               PreparedStatement pstAdmin = con.prepareStatement(adminQuery);
               pstAdmin.setInt(1,idUser);
               int adminResult = pstAdmin.executeUpdate();
               if(adminResult > 0){
                   System.out.println("admin added successfully");
               }else {
                   System.out.println("failed to add admin");
               }
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
