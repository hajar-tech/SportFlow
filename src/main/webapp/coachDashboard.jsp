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
            <a href="logout" class="hover:underline">Logout</a>
            

        </div>
</nav>

<button id="openModal" class="bg-blue-500 text-white font-bold py-2 px-4 rounded m-5">
    Ajouter séance
</button>


<div id="modal" class="fixed inset-0 flex items-center justify-center bg-black bg-opacity-50 hidden">
    <div class="bg-white w-full max-w-lg mx-auto rounded-lg shadow-lg p-6">
        <div class="flex justify-between items-center mb-4">
            <h2 class="text-xl font-bold">Ajouter une séance</h2>
            <button id="closeModal" class="text-gray-500 hover:text-gray-700">&times;</button>
        </div>
        <form action="CreateSessionServlet" method="post" class="space-y-4">
            <div>
                <label for="sportType" class="block text-sm font-medium text-gray-700">Type de sport</label>
                <input type="text" name="sportType" id="sportType" placeholder="Entrez le type de sport" class="mt-1 block w-full border border-gray-300 rounded-md shadow-sm p-2 focus:outline-none focus:ring-blue-500 focus:border-blue-500">
            </div>
            <div>
                <label for="sessionDate" class="block text-sm font-medium text-gray-700">Date de la séance</label>
                <input type="date" name="sessionDate" id="sessionDate" class="mt-1 block w-full border border-gray-300 rounded-md shadow-sm p-2 focus:outline-none focus:ring-blue-500 focus:border-blue-500">
            </div>
            <div>
                <label for="startTime" class="block text-sm font-medium text-gray-700">Heure de début</label>
                <input type="time" name="startTime" id="startTime" class="mt-1 block w-full border border-gray-300 rounded-md shadow-sm p-2 focus:outline-none focus:ring-blue-500 focus:border-blue-500">
            </div>
            <div>
                <label for="endTime" class="block text-sm font-medium text-gray-700">Heure de fin</label>
                <input type="time" name="endTime" id="endTime" class="mt-1 block w-full border border-gray-300 rounded-md shadow-sm p-2 focus:outline-none focus:ring-blue-500 focus:border-blue-500">
            </div>
            <div class="flex justify-end">
                <button type="button" id="cancelButton" class="bg-gray-500 text-white font-bold py-2 px-4 rounded mr-2">
                    Annuler
                </button>
                <button type="submit" class="bg-blue-500 text-white font-bold py-2 px-4 rounded">
                    Créer
                </button>
            </div>
        </form>
    </div>
</div>




<%
    Integer idCoach = (Integer) session.getAttribute("idUser");
    if (idCoach == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    WorkoutSessionDao dao = new WorkoutSessionDao();
    List<WorkoutSession> sessions = dao.getSessionsByCoach(idCoach);
%>

<div class="container mx-auto p-6">
    <h2 class="text-2xl font-bold mb-4">Vos Séances</h2>
    <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
        <% for (WorkoutSession s : sessions) { %>
        <div class="bg-white shadow-lg rounded-lg p-6 border border-gray-200">
            <h3 class="text-xl font-semibold text-blue-600"><%= s.getSportType() %></h3>
            <p class="text-gray-700"><strong>Date :</strong> <%= s.getSessionDate() %></p>
            <p class="text-gray-700"><strong>Début :</strong> <%= s.getStartTime() %></p>
            <p class="text-gray-700"><strong>Fin :</strong> <%= s.getEndTime() %></p>
        </div>
        <% } %>
    </div>
</div>


<script>
    // Sélection des éléments
    const openModalButton = document.getElementById('openModal');
    const closeModalButton = document.getElementById('closeModal');
    const cancelButton = document.getElementById('cancelButton');
    const modal = document.getElementById('modal');

    // Fonction pour ouvrir la modale
    const openModal = () => {
        modal.classList.remove('hidden');
    };

    // Fonction pour fermer la modale
    const closeModal = () => {
        modal.classList.add('hidden');
    };

    // Événements
    openModalButton.addEventListener('click', openModal);
    closeModalButton.addEventListener('click', closeModal);
    cancelButton.addEventListener('click', closeModal);

    // Fermer la modale en cliquant à l'extérieur du contenu
    window.addEventListener('click', (e) => {
        if (e.target === modal) {
            closeModal();
        }
    });
</script>


 </body>
 </html>