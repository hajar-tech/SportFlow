package Servlets;


import Daos.BookingDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/BookSessionServlet")
public class BookSessionServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String role = (String) session.getAttribute("role");

        if (role == null || !role.equals("member")) {
            response.sendRedirect("index.jsp");
            return;
        }

        int idUser = (int) session.getAttribute("idUser");
        int idSession = Integer.parseInt(request.getParameter("idSession"));
        System.out.println("idSession reçu : " + idSession);

        BookingDao bookingDao = new BookingDao();
        boolean success = bookingDao.bookSession(idUser, idSession);

        if (success) {
            response.sendRedirect("memberDashboard.jsp?message=Séance réservée avec succès");
        } else {
            response.sendRedirect("myBookings.jsp?error=Erreur lors de la réservation");
        }
    }
}
