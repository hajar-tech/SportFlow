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


        </div>
</nav>



<%
    List<WorkoutSession> bookings = (List<WorkoutSession>) request.getAttribute("bookings");
%>

<h2>Mes Séances Réservées</h2>
<table border="1">
    <tr>
        <th>Sport</th>
        <th>Date</th>
        <th>Début</th>
        <th>Fin</th>
    </tr>
    <% if (bookings != null) {
        for (WorkoutSession s : bookings) { %>
        <tr>
            <td><%= s.getSportType() %></td>
            <td><%= s.getSessionDate() %></td>
            <td><%= s.getStartTime() %></td>
            <td><%= s.getEndTime() %></td>
        </tr>
    <% }} else { %>
        <tr><td colspan="4">Aucune réservation</td></tr>
    <% } %>
</table>

</body>
</html>