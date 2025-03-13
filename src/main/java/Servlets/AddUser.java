package Servlets;


import Daos.UserDao;
import Models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/register")
public class AddUser extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String fullName = req.getParameter("fullname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        String dateStr = req.getParameter("dateNaissance"); // Ex: "2025-02-22"
       java.sql.Date dateOfBirth = java.sql.Date.valueOf(dateStr);

        String sportPratique = req.getParameter("sportPratique");
        String speciality = req.getParameter("speciality");

        User user = new User();
        user.setFullName(fullName);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);
        UserDao userDao = new UserDao();
        int id=userDao.insertUser(user, dateOfBirth,sportPratique,speciality);
        HttpSession session = req.getSession();
      if(id > 0){
          session.setAttribute("error","user added successflly");
          System.out.println("user add with success");
          resp.sendRedirect("index.jsp");
      } else {
          session.setAttribute("error","user not added successflly");
          System.out.println("failed to add User");
          resp.sendRedirect("registration.jsp");
      }



    }
}
