package Servlets;

import Daos.DataBaseConnection;
import Daos.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

@WebServlet("/testConnection")
public class TestConnection extends HttpServlet {

    private Connection connection;

    @Override
    public void init() throws ServletException {
        connection = DataBaseConnection.getConnection();
        if (connection != null){
            System.out.println("connection réussite");
        }else{
            System.out.println("connection échouer");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        if (connection != null) {
            out.println("<h3> Connection réussie à la base de données !</h3>");
        } else {
            out.println("<h3> Échec de la connexion à la base de données.</h3>");
        }

        UserDao userDao = new UserDao();
        int lastId = userDao.getLastId();
        out.println("<h3>🔍 ID du dernier utilisateur inséré : " + lastId + "</h3>");
    }



}
