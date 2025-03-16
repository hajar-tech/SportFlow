<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  <%@ page import="java.sql.*, Daos.WorkoutSessionDao, Models.WorkoutSession" %>
  <%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<nav class="bg-blue-600 p-4 text-white flex justify-between items-center">
        <a href="index.jsp">  <h1 class="text-2xl font-bold">SportFlow</h1> </a>
        <div class="space-x-4">
            <a href="#contact" class="hover:underline">Contact Us</a>
            <a href="logout" class="hover:underline">Logout</a>
            <a href="DisplaySessionByIdCoach">Mes Séances Créées</a>

        </div>
</nav>
//model pour ajouter une séance
<section class="model">
        <form action="CreateSessionServlet" method="post">

            <input type="text" name="sportType" placeholder="enter your sport type">
            <input type="date" name="sessionDate" placeholder="session date">
            <input type="time" name="startTime" placeholder="start time">
            <input type="time" name="endTime" placeholder="end time ">

            <button type="submit">create</button>
         </form>

</section>
//section main pour afficher les séances crée par un coach


<%
    Integer idCoach = (Integer) session.getAttribute("idUser");
    if (idCoach == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    WorkoutSessionDao dao = new WorkoutSessionDao();
    List<WorkoutSession> sessions = dao.getSessionsByCoach(idCoach);
%>

<h2>Vos Séances</h2>
<table border="1">
    <tr>
        <th>Sport</th>
        <th>Date</th>
        <th>Début</th>
        <th>Fin</th>
    </tr>
    <% for (WorkoutSession s : sessions) { %>
    <tr>
        <td><%= s.getSportType() %></td>
        <td><%= s.getSessionDate() %></td>
        <td><%= s.getStartTime() %></td>
        <td><%= s.getEndTime() %></td>
    </tr>
    <% } %>
</table>


 </body>
 </html>