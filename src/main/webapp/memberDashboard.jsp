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

<h2 class ="m-5 rounded bg-gray-400 hover:bg-blue-500 p-5">Séances Disponibles</h2>
<ul class="space-y-4">
    <% for (WorkoutSession s : sessions) { %>
    <li class="bg-white shadow-md rounded-lg p-6 flex flex-col md:flex-row md:justify-between items-center">
        <div class="flex flex-col md:flex-row md:items-center md:space-x-6">
            <div>
                <span class="font-semibold">Coach :</span> <%= s.getIdCoach() %>
            </div>
            <div>
                <span class="font-semibold">Sport :</span> <%= s.getSportType() %>
            </div>
            <div>
                <span class="font-semibold">Date :</span> <%= s.getSessionDate() %>
            </div>
            <div>
                <span class="font-semibold">Début :</span> <%= s.getStartTime() %>
            </div>
            <div>
                <span class="font-semibold">Fin :</span> <%= s.getEndTime() %>
            </div>
        </div>
        <form action="BookSessionServlet" method="post" class="mt-4 md:mt-0">
            <input type="hidden" name="idSession" value="<%= s.getIdSession() %>">
            <button type="submit" class="bg-blue-500 text-white font-bold py-2 px-4 rounded hover:bg-blue-600">
                Réserver
            </button>
        </form>
    </li>
    <% } %>
</ul>


 </body>
 </html>

