package Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookingDao {

    public boolean bookSession(int idUser, int idSession) {
        boolean success = false;
        String sql = "INSERT INTO Booking (idSession, idUser) VALUES (?, ?)";

        try (Connection con = DataBaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, idSession);
            pst.setInt(2, idUser);
            System.out.println("idUser: " + idUser + ", idSession: " + idSession);

            success = pst.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }
}
