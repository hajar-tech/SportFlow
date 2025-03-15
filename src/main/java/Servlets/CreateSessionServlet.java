package Servlets;

import Daos.WorkoutSessionDao;
import Models.Coach;
import Models.WorkoutSession;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
@WebServlet("/CreateSessionServlet")
public class CreateSessionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session != null){
            System.out.println("Session created with ID: " + session.getId());
            System.out.println("full name: " + session.getAttribute("idUser"));
            System.out.println("Role: " + session.getAttribute("role"));
        }

        String role = (String) session.getAttribute("role");
        System.out.println(role);
        if(role == null || !role.equalsIgnoreCase("coach")){
            resp.sendRedirect("index.jsp");
            return;
        }

        int idCoach =(int) session.getAttribute("idUser");
        System.out.println(idCoach);
        String sportType = req.getParameter("sportType");
        System.out.println(sportType);
        Date sessionDate = Date.valueOf(req.getParameter("sessionDate"));
        Time startTime = Time.valueOf(req.getParameter("startTime") + ":00");
        Time endTime = Time.valueOf(req.getParameter("endTime") + ":00");

        WorkoutSession workoutSession = new WorkoutSession(idCoach,sportType,sessionDate,startTime,endTime);
        System.out.println(workoutSession);
        WorkoutSessionDao workoutSessionDao = new WorkoutSessionDao();
        boolean success = workoutSessionDao.createSession(workoutSession);
        if(success){
            resp.sendRedirect("coachDashboard.jsp?message=Session créée avec succès");
        }else {
            resp.sendRedirect("createSession.jsp?error=Erreur lors de la création de la séance");
        }

    }


}
