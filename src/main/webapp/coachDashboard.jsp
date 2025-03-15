<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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

<form action="CreateSessionServlet" method="post">

   <input type="text" name="sportType" placeholder="enter your sport type">
   <input type="date" name="sessionDate" placeholder="session date">
   <input type="time" name="startTime" placeholder="start time">
   <input type="time" name="endTime" placeholder="end time ">

   <button type="submit">create</button>
</form>
 </body>
 </html>