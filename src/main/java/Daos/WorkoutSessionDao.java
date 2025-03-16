package Daos;

import Models.WorkoutSession;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorkoutSessionDao {
    //fonction to create a workoutSession
     public boolean createSession(WorkoutSession session){
       boolean success = false;
       String sql = "insert into WorkoutSession (idCoach,sportType,sessionDate,startTime,endTime) values (?,?,?,?,?) ";
       try{
           Connection connection = DataBaseConnection.getConnection();
           PreparedStatement pst  = connection.prepareStatement(sql);
           pst.setInt(1,session.getIdCoach());
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


     public List DisplaySessionByIdCoach(int idCoach){
         ArrayList<WorkoutSession> workoutSessions = new ArrayList<>();
         String sql = "select sportType,sessionDate,startTime,endTime from WorkoutSession where  idCoach = ?";
         try{
             Connection connection = DataBaseConnection.getConnection();
             PreparedStatement pst = connection.prepareStatement(sql);
             pst.setInt(1,idCoach);
             ResultSet rs = pst.executeQuery();
             while (rs.next()){
                 WorkoutSession workoutSession = new WorkoutSession();
                 workoutSession.setSportType(rs.getString("sportType"));
                 workoutSession.setSessionDate(rs.getDate("sessionDate"));
                 workoutSession.setStartTime(rs.getTime("startTime"));
                 workoutSession.setEndTime(rs.getTime("endTine"));

                 workoutSessions.add(workoutSession);
             }

         } catch (SQLException e) {
             e.printStackTrace();
         }

          return workoutSessions;
     }
}

