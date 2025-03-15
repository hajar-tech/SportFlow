package Daos;

import Models.WorkoutSession;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WorkoutSessionDao {
    //fonction to create a workoutSession
     public boolean createSession(WorkoutSession session){
       boolean success = false;
       String sql = "insert into WorkoutSession (idCoach,sportType,sessionDate,startTime,endTime) values (?,?,?,?,?) ";
       try{
           Connection connection = DataBaseConnection.getConnection();
           PreparedStatement pst  = connection.prepareStatement(sql);
           pst.setInt(1,session.getIdSession());
           pst.setString(2,session.getSportType());
           pst.setDate(3,session.getSessionDate());
           pst.setTime(4,session.getStartTime());
           pst.setTime(5,session.getEndTime());

           success = pst.executeUpdate()>0;

       } catch (SQLException e) {
           e.printStackTrace();
       }

         return success;

     }

}
