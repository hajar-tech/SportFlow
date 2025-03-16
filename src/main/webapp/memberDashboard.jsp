<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ page import="java.sql.*, Daos.WorkoutSessionDao, Models.WorkoutSession" %>
    <%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body>

<nav class="bg-blue-600 p-4 text-white flex justify-between items-center">
        <a href="index.jsp">  <h1 class="text-2xl font-bold">SportFlow</h1> </a>
        <div class="space-x-4">
            <a href="#contact" class="hover:underline">Contact Us</a>
            <a href="MyBookingsServlet">Mes Réservations</a>
            <a href="logout" class="hover:underline">Logout</a>

        </div>
</nav>


<%
    WorkoutSessionDao dao = new WorkoutSessionDao();
    List<WorkoutSession> sessions = dao.getAllSessions();
%>

<h2>Séances Disponibles</h2>
<table border="1">
    <tr>
        <th>Coach</th>
        <th>Sport</th>
        <th>Date</th>
        <th>Début</th>
        <th>Fin</th>
        <th>Action</th>
    </tr>
    <% for (WorkoutSession s : sessions) { %>
    <tr>
        <td><%= s.getIdCoach() %></td>
        <td><%= s.getSportType() %></td>
        <td><%= s.getSessionDate() %></td>
        <td><%= s.getStartTime() %></td>
        <td><%= s.getEndTime() %></td>
        <td>
            <form action="BookSessionServlet" method="post">
                <input type="hidden" name="idSession" value="<%= s.getIdSession() %>">
                <button type="submit">Réserver</button>
            </form>
        </td>
    </tr>
    <% } %>
</table>


 </body>
 </html>

