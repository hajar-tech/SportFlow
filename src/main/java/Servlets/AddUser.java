package Servlets;

import Daos.DataBaseConnection;
import Daos.UserDao;
import Models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/register")
public class AddUser extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao = new UserDao();
      int id = userDao.insertUser();
      if(id>0){
          System.out.println("user add with success");
      } else {
          System.out.println("failed to add User");
      }



    }
}
