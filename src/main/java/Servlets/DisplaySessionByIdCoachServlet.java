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

@WebServlet("/DisplaySessionByIdCoach")
public class DisplaySessionByIdCoachServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Integer idCoach = (Integer) session.getAttribute("idUser");
        if (idCoach == null) {
            resp.sendRedirect("index.jsp");
            return;
        }

        WorkoutSessionDao dao = new WorkoutSessionDao();
        List<WorkoutSession> sessions = dao.getSessionsByCoach(idCoach);

        req.setAttribute("sessions", sessions);
        req.getRequestDispatcher("coachDashboard.jsp").forward(req, resp);
    }
}
