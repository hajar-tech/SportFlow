package Daos;

import Models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {

    public static User checkUser(String email , String password){

        User user = null;

        String sql = "select idUser , fullName , role from Users where email = ? and password = ?";
        try {
            Connection connection = DataBaseConnection.getConnection();
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,email);
            pst.setString(2,password);

            ResultSet rs = pst.executeQuery();
            if (rs.next()){
                user = new User();
                user.setIdUser(rs.getInt("idUser"));
                user.setFullName(rs.getString("fullName"));
                user.setRole(rs.getString("role"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(user);
        return user;
    }

    public boolean checkAdmin(String email , String password){
        boolean admin = false;
           if ( "admin@gmail.com".equalsIgnoreCase(email) && "admin123".equalsIgnoreCase(password)){
               admin = true;
           }
        return admin;
    }
}
