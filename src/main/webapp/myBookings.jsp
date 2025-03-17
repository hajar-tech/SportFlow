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
            <a href="logout" class="hover:underline">Logout</a>


        </div>
</nav>



<%
    List<WorkoutSession> bookings = (List<WorkoutSession>) request.getAttribute("bookings");
%>

<h2 class="text-center text-2xl font-bold my-8">Mes Seances Reservees</h2>

<div class="flex justify-center">
  <ul class="space-y-4 w-full max-w-2xl">
    <% if (bookings != null) { %>
      <% for (WorkoutSession s : bookings) { %>
        <li class="bg-white shadow-md rounded-lg p-6">
          <div class="flex flex-col md:flex-row md:justify-between md:items-center">
            <div class="flex flex-col space-y-2">
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
          </div>
        </li>
      <% } %>
    <% } else { %>
      <li class="bg-white shadow-md rounded-lg p-6 text-center">
        Aucune réservation
      </li>
    <% } %>
  </ul>
</div>

</body>
</html>