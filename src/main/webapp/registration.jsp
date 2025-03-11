<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   <!DOCTYPE html>
   <html lang="fr">
   <head>
       <meta charset="UTF-8">
       <meta name="viewport" content="width=device-width, initial-scale=1.0">
       <title>Inscription</title>
       <script src="https://cdn.tailwindcss.com"></script>
   </head>
   <body class="bg-gray-100">
       <nav class="bg-blue-600 p-4 text-white flex justify-between items-center">
           <a href="index.jsp">  <h1 class="text-2xl font-bold">SportFlow</h1> </a>
           <div class="space-x-4">
               <a href="#contact" class="hover:underline">Contact Us</a>
               <a href="registration.jsp" class="hover:underline">Sign Up</a>
               <a href="#login" class="hover:underline">Sign In</a>
           </div>
       </nav>
<section class="flex items-center justify-center min-h-screen bg-gray-100">
       <div class="bg-white p-6 rounded-lg shadow-lg w-96">
           <h2 class="text-2xl font-bold text-center mb-4">Inscription</h2>
           <form action="register" method="post" class="space-y-4">
               <input type="text" name="fullname" placeholder="Nom Complet" class="w-full p-2 border rounded">
               <input type="email" name="email" placeholder="Email" class="w-full p-2 border rounded">
               <input type="password" name="password" placeholder="Mot de passe" class="w-full p-2 border rounded">

               <select name="role" id="role" class="w-full p-2 border rounded" onchange="toggleFields()">
                   <option value="">Sélectionner un rôle</option>
                   <option value="admin">Admin</option>
                   <option value="member">Membre</option>
                   <option value="coach">Coach</option>
               </select>

               <div id="memberFields" class="hidden space-y-2">
                   <input type="date" name="dateNaissance" placeholder="Date de naissance" class="w-full p-2 border rounded">
                   <input type="text" name="sportPratique" placeholder="Sport pratiqué" class="w-full p-2 border rounded">
               </div>

               <div id="coachFields" class="hidden">
                   <input type="text" name="speciality" placeholder="Spécialité" class="w-full p-2 border rounded">
               </div>

               <button type="submit" class="w-full bg-blue-500 text-white p-2 rounded">S'inscrire</button>
           </form>
       </div>
  </section>

       <script>
       function toggleFields() {
           let role = document.getElementById("role").value;

           document.getElementById("memberFields").classList.add("hidden");
           document.getElementById("coachFields").classList.add("hidden");

           if (role === "member") {
               document.getElementById("memberFields").classList.remove("hidden");
           } else if (role === "coach") {
               document.getElementById("coachFields").classList.remove("hidden");
           }
       }
       </script>
   </body>
   </html>
