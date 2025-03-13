package Filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebFilter({ "/coachDashboard" ,"/memberDashboard" , "/adminDashboard"})
public class FilterSession implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession(false);
        if (session == null) {
            System.out.println("Aucune session trouvée !");
            resp.sendRedirect("index.jsp?error=session");
            return;  // STOP ici, sinon le code continue
        }
        System.out.println("[FilterSession] ✅ Session trouvée : " + session.getId());
        Object userId = session.getAttribute("idUser");
        Object role = session.getAttribute("role");




        // Vérification que l'utilisateur est bien authentifié
        if (userId == null) {
            System.out.println("[FilterSession]  idUser est NULL, redirection vers login.jsp");
            resp.sendRedirect("index.jsp?error=session");
            return;
        }

        System.out.println("[FilterSession] Utilisateur connecté, idUser: " + userId + ", Role: " + role);
        filterChain.doFilter(req, resp);
    }
    public void init(FilterConfig filterConfig) throws ServletException {}
    public void destroy() {}
}

