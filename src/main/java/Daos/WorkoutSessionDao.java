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


    public List<WorkoutSession> getCoachSessionsWithMembers(int idCoach) {
        List<WorkoutSession> sessions = new ArrayList<>();
        String sql = "SELECT w.idSession, w.sportType, w.sessionDate, w.startTime, w.endTime, u.fullName AS MemberName " +
                "FROM WorkoutSession w LEFT JOIN Booking b ON w.idSession = b.idSession " +
                "LEFT JOIN Users u ON b.idUser = u.idUser WHERE w.idCoach = ?";

        try (Connection con = DataBaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, idCoach);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                WorkoutSession session = new WorkoutSession(
                        rs.getInt("idSession"),
                        rs.getString("sportType"),
                        rs.getDate("sessionDate"),
                        rs.getTime("startTime"),
                        rs.getTime("endTime")
                );
                session.setMemberName(rs.getString("MemberName"));
                sessions.add(session);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sessions;
    }



    public List<WorkoutSession> getSessionsByCoach(int idCoach) {
        List<WorkoutSession> sessions = new ArrayList<>();
        String sql = "SELECT * FROM WorkoutSession WHERE idCoach = ?";

        try (Connection con = DataBaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, idCoach);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                sessions.add(new WorkoutSession(
                        rs.getInt("idCoach"),
                        rs.getString("sportType"),
                        rs.getDate("sessionDate"),
                        rs.getTime("startTime"),
                        rs.getTime("endTime")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sessions;
    }


    public List<WorkoutSession> getAllSessions() {
        List<WorkoutSession> sessions = new ArrayList<>();
        String sql = "SELECT * FROM WorkoutSession";

        try (Connection con = DataBaseConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                sessions.add(new WorkoutSession(
                        rs.getInt("idSession"),
                        rs.getInt("idCoach"),
                        rs.getString("sportType"),
                        rs.getDate("sessionDate"),
                        rs.getTime("startTime"),
                        rs.getTime("endTime")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sessions;
    }

    public List<WorkoutSession> getSessionsByMember(int idUser) {
        List<WorkoutSession> sessions = new ArrayList<>();
        String sql = "SELECT w.sportType, w.sessionDate, w.startTime, w.endTime " +
                "FROM Booking b JOIN WorkoutSession w ON b.idSession = w.idSession " +
                "WHERE b.idUser = ?";

        try (Connection con = DataBaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, idUser);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                sessions.add(new WorkoutSession(
                        rs.getString("sportType"),
                        rs.getDate("sessionDate"),
                        rs.getTime("startTime"),
                        rs.getTime("endTime")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sessions;
    }
}

