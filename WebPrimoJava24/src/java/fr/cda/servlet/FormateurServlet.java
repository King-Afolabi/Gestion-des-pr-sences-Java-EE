/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package fr.cda.servlet;

import fr.cda.dao.FormateurDao;
import fr.cda.dao.UserDao;
import fr.cda.model.Classe;
import fr.cda.model.Cours;
import fr.cda.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author kingafolabi
 */
@WebServlet(name = "FormateurServlet", urlPatterns = {"/formateur"})
public class FormateurServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FormateurServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FormateurServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("list_presence".equals(action)) {

            String id_class = request.getParameter("id_class");
            String id_cours = request.getParameter("id_cours");
            String date_list = request.getParameter("date_list");
            String time_list = request.getParameter("time_list");

            HttpSession session = request.getSession();
            session.setAttribute("id_class", id_class);
            session.setAttribute("id_cours", id_cours);
            session.setAttribute("date_list", date_list);
            session.setAttribute("time_list", time_list);

            try { // Le try est pour un élément dans la ligne qui suit à cause de connexion et accesbd 
                List<Classe> allClass = UserDao.getAllClass();
                request.setAttribute("classes", allClass);

                List<Cours> allCours = UserDao.getAllCours();
                request.setAttribute("cours", allCours);

                request.getRequestDispatcher("WEB-INF/FORMATEUR/list_presence.jsp").forward(request, response);
            } catch (Exception e) {
                PrintWriter out = response.getWriter();
                out.print(e.getMessage());
            }

        } else if (action.equals("add")) {
            request.getRequestDispatcher("WEB-INF/ADMIN/add_user.jsp").forward(request, response);
        } else if (action.equals("add_class")) {
            request.getRequestDispatcher("WEB-INF/ADMIN/add_classe.jsp").forward(request, response);
        } else if (action.equals("user_class")) {

            // Je récupère un message venant de DoPost après un sendRedirectory
            String message = request.getParameter("message");
            if (message != null) {
                request.setAttribute("msg", message);
            }
            try {
                List<User> formateurApprenant = UserDao.getOneTypeUser("formateur_apprenant");
                request.setAttribute("users", formateurApprenant);
                request.getRequestDispatcher("WEB-INF/ADMIN/user_add_classe.jsp").forward(request, response);

            } catch (Exception e) {
                PrintWriter out = response.getWriter();
                out.print(e.getMessage());
            }
        } else {
            response.sendRedirect("home"); // différent de request .getRsquestDispach c'est que en pasant par home on fera toute les vérifications
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String id_class = (String) session.getAttribute("id_class");
        String id_cours = (String) session.getAttribute("id_cours");
        String date_list = (String) session.getAttribute("date_list");
        String time_list = (String) session.getAttribute("time_list");

        String added = request.getParameter("added");
        if (added.equals("create")) {
            try {

                int id = Integer.parseInt(request.getParameter("id_class"));

                List<User> listByClass = FormateurDao.getUsersByClass(id);
                request.setAttribute("users", listByClass);
                request.getRequestDispatcher("WEB-INF/FORMATEUR/reunion_presence.jsp").forward(request, response);
            } catch (Exception e) {
            }
        }else if (added.equals("reunion")) {
            
            
            
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
