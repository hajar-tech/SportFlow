package Servlets;

import Daos.WorkoutSessionDao;
import Models.WorkoutSession;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/MyBookingsServlet")
public class DisplayBookingServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException, IOException {
        HttpSession session = request.getSession();
        Integer idUser = (Integer) session.getAttribute("idUser");

        if (idUser == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        WorkoutSessionDao dao = new WorkoutSessionDao();
        List<WorkoutSession> bookings = dao.getSessionsByMember(idUser);

        request.setAttribute("bookings", bookings);
        request.getRequestDispatcher("myBookings.jsp").forward(request, response);
    }
}
