package Servlets;

import Daos.LoginDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/AdminCheck")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String emailAdmin = req.getParameter("emailAdmin");
        String passwordAdmin = req.getParameter("passwordAdmin");
        LoginDao loginDao = new LoginDao();
        boolean admin = loginDao.checkAdmin(emailAdmin , passwordAdmin);
        if (admin){
            HttpSession session = req.getSession(true);
            session.setAttribute("emailAdmin",emailAdmin);
            session.setAttribute("passwordAdmin",passwordAdmin);
            req.getRequestDispatcher("/adminDashboard.jsp").forward(req,resp);
        }
        else {

            PrintWriter out = resp.getWriter();
            out.println("email or password  not defined");
        }
    }
}
