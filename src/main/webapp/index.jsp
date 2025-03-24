<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SportFlow - Accueil</title>


    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100">
    <!-- Navbar -->
    <nav class="bg-blue-600 p-4 text-white flex justify-between items-center">
        <a href="index.jsp">  <h1 class="text-2xl font-bold">SportFlow</h1> </a>
        <div class="space-x-4">
            <a href="admin.jsp" class="hover:underline">Admin</a>
            <a href="registration.jsp" class="hover:underline">Sign Up</a>
            <a href="#login" class="hover:underline">Sign In</a>
        </div>
    </nav>

    <!-- Login Section -->
    <section id="login" class="flex items-center justify-center min-h-screen">
            <div class="bg-white p-6 rounded-lg shadow-lg w-96">
                <h2 class="text-2xl font-bold text-center mb-4">Connexion</h2>
                <form action="loginCheck" method="post" class="space-y-4">
                    <input type="email" name="email" placeholder="Email" class="w-full p-2 border rounded">
                    <input type="password" name="password" placeholder="Mot de passe" class="w-full p-2 border rounded">
                    <button type="submit" class="w-full bg-blue-500 text-white p-2 rounded">Se connecter</button>
                </form>
                <p class="text-center mt-4">Pas de compte ? <a href="registration.jsp" class="text-blue-500 hover:underline">Inscrivez-vous</a></p>
            </div>
        </section>
        <form action="#" method="post">
            <input type="submit" value="Inscrire un utilisateur">
        </form>

    <!-- Footer -->
    <footer id="contact" class="bg-gray-800 text-white text-center p-4">
        <p>&copy; 2025 SportFlow. Tous droits réservés.</p>
    </footer>
</body>
</html>

