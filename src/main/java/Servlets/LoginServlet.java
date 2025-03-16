package Servlets;

import Daos.LoginDao;
import Models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginCheck")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);

        //LoginDao loginDao = new LoginDao();
         User user = LoginDao.checkUser(email,password);

         if(user != null){
             System.out.println("User authenticated: " + user.getFullName() + ", Role: " + user.getRole());
             HttpSession session = req.getSession(true);
             session.setAttribute("idUser",user.getIdUser());
             session.setAttribute("fullName",user.getFullName());
             session.setAttribute("role",user.getRole());

             System.out.println("Session created with ID: " + session.getId());
             System.out.println("full name: " + user.getFullName());
             System.out.println("Role: " + user.getRole());

             if ("member".equalsIgnoreCase(user.getRole())){

                 req.getRequestDispatcher("/memberDashboard.jsp").forward(req, resp);
             } else if ("coach".equalsIgnoreCase(user.getRole())) {
                 req.getRequestDispatcher("coachDashboard.jsp").forward(req, resp);
             }else {
                 PrintWriter out = resp.getWriter();
                 out.println("role not defined");
             }


         }else {
             PrintWriter out = resp.getWriter();
             out.println("user not found");
         }

    }
}
