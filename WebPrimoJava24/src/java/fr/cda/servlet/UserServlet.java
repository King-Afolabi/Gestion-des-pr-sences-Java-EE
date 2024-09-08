/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package fr.cda.servlet;

import fr.cda.dao.UserDao;
import fr.cda.model.Role;
import fr.cda.model.User;
import fr.cda.model.Classe;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.List;

/**
 *
 * @author kingafolabi
 */
@WebServlet(name = "UserServlet", urlPatterns = {"/user"})
public class UserServlet extends HttpServlet {

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
            out.println("<title>Servlet UserServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserServlet at " + request.getContextPath() + "</h1>");
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

        String action = request.getParameter("action");// dans le get paramètre l'argument correspond à son correspondant dans la page HTML

        if ("list".equals(action)) {
            // Je récupère un message venant de DoPost après un sendRedirectory
            String message = request.getParameter("message");
            if (message != null) {
                request.setAttribute("msg", message);
            }

            try { // Le try est pour un élément dans la ligne qui suit à cause de connexion et accesbd 
                List<User> allUsers = UserDao.getAllUsers();
                request.setAttribute("users", allUsers);
                request.getRequestDispatcher("WEB-INF/ADMIN/list_user.jsp").forward(request, response);
            } catch (Exception e) {
                PrintWriter out = response.getWriter();
                out.print(e.getMessage());
            }
        } else if ("type".equals(action)) {
            String statut = request.getParameter("statut");
            try { // Le try est pour un élément dans la ligne qui suit à cause de connexion et accesbd 
                List<User> oneTypeUser = UserDao.getOneTypeUser(statut);
                request.setAttribute("users", oneTypeUser);
                request.getRequestDispatcher("WEB-INF/ADMIN/list_user.jsp").forward(request, response);
            } catch (Exception e) {
                PrintWriter out = response.getWriter();
                out.print(e.getMessage());
            }
        } else if (action.equals("add")) {
            request.getRequestDispatcher("WEB-INF/ADMIN/add_user.jsp").forward(request, response);
        } else if (action.equals("class")) {
            // Je récupère un message venant de DoPost après un sendRedirectory
            String message = request.getParameter("message");
            if (message != null) {
                request.setAttribute("msg", message);
            }

            try { // Le try est pour un élément dans la ligne qui suit à cause de connexion et accesbd 
                List<Classe> allClass = UserDao.getAllClass();
                request.setAttribute("classes", allClass);
                request.getRequestDispatcher("WEB-INF/ADMIN/list_classe.jsp").forward(request, response);
            } catch (Exception e) {
                PrintWriter out = response.getWriter();
                out.print(e.getMessage());
            }

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
                List<Classe> allClass = UserDao.getAllClass();
                request.setAttribute("classes", allClass);
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
        String add = request.getParameter("add");
        if (add.equals("utilisateur")) {

            String nom = request.getParameter("nom_user");
            String prenom = request.getParameter("prenom_user");
            String log = request.getParameter("login_user");
            String mdp = request.getParameter("password_user");
            String role = request.getParameter("role_user");

            int id_role = Integer.parseInt(role);

            Role r = new Role();
            r.setId(id_role);

            User u = new User();
            u.setNom_user(nom);
            u.setPrenom_user(prenom);
            u.setLogin_user(log);
            u.setPassword_user(mdp);
            u.setRole(r);

            if (nom != null && prenom != null && log != null && mdp != null) {

                try {
                    UserDao.saveUser(u);
                    request.setAttribute("msg", "<div class=\"container mt-5\">"
                            + "    <div class=\"row justify-content-center\">"
                            + "            <div class=\"alert alert-success alert-dismissible fade show\" role=\"alert\" style=\"background-color: #d4edda;\">"
                            + "                <p class=\"text-center mb-0\"d-inline>" + UserDao.getByLoginAndPassword(log, mdp).getRole().getLibelleRole() + " "
                            + prenom + " " + " <b>" + nom + "</b>" + " enregistré" + "</p>"
                            // + "<a href=\"user\"> <button type=\"button\"  class=\"btn-close btn-close-sm\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button> </a>"
                            + "            </div>"
                            + "    </div>"
                            + "</div>");

                    request.getRequestDispatcher("WEB-INF/ADMIN/add_user.jsp").forward(request, response);
                } catch (Exception e) {

                    request.setAttribute("msg1", "Login existe déjà");
                    request.getRequestDispatcher("WEB-INF/ADMIN/add_user.jsp").forward(request, response);
                    /*
                PrintWriter out = response.getWriter();
                out.print(e.getMessage());
                     */
                }
            } else {
                request.setAttribute("msg1", "Tous les champs sont obligatoire !");

                request.getRequestDispatcher("WEB-INF/ADMIN/add_user.jsp").forward(request, response);

            }

        } else if (add.equals("classe")) {

            String nomClasse = request.getParameter("nom_class");
            String niveauClasse = request.getParameter("niveau_class");
            String nbre = request.getParameter("nbre_apprenant");

            int nbreApprenant = Integer.parseInt(nbre);

            Classe c = new Classe();
            c.setNomClasse(nomClasse);
            c.setNiveauClasse(nomClasse);
            c.setNbreApprenant(nbreApprenant);

            if (nomClasse != null && niveauClasse != null) {

                try {
                    UserDao.saveClass(c);
                    request.setAttribute("msg", "<div class=\"container mt-5\">"
                            + "    <div class=\"row justify-content-center\">"
                            + "            <div class=\"alert alert-success alert-dismissible fade show\" role=\"alert\" style=\"background-color: #d4edda;\">"
                            + "                <p class=\"text-center mb-0\"d-inline>" + " "
                            + " " + " <b>" + nomClasse + "</b>" + " enregistré" + "</p>"
                            // + "<a href=\"user\"> <button type=\"button\"  class=\"btn-close btn-close-sm\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button> </a>"
                            + "            </div>"
                            + "    </div>"
                            + "</div>");

                    request.getRequestDispatcher("WEB-INF/ADMIN/add_classe.jsp").forward(request, response);
                } catch (Exception e) {

                    request.setAttribute("msg1", "Nom classe existe déjà");
                    request.getRequestDispatcher("WEB-INF/ADMIN/add_classe.jsp").forward(request, response);
                    /*
                PrintWriter out = response.getWriter();
                out.print(e.getMessage());
                     */
                }
            } else {
                request.setAttribute("msg1", "Tous les champs sont obligatoire !");

                request.getRequestDispatcher("WEB-INF/ADMIN/add_classe.jsp").forward(request, response);

            }

        } else if (add.equals("drop_user")) {

            String login = request.getParameter("login_user");
            String nom_user = request.getParameter("nom_user");
            String prenom_user = request.getParameter("prenom_user");

            User u = new User();
            u.setLogin_user(login);

            try {
                UserDao.deletedUser(u);

                String message = "<div class=\"container mt-5\">"
                        + "    <div class=\"row justify-content-center\">"
                        + "            <div class=\"alert alert-success alert-dismissible fade show\" role=\"alert\" style=\"background-color: #d4edda;\">"
                        + "                <p class=\"text-center mb-0\"d-inline>" + " " + prenom_user
                        + " " + " <b>" + nom_user + "</b>" + " deleted" + "</p>"
                        + "            </div>"
                        + "    </div>"
                        + "</div>";
                // J'ai inclus dans mon sendRedirect un méssage que je souhaite afficher dans user Doget avec action = list 
                response.sendRedirect("user?action=list&message=" + URLEncoder.encode(message, "UTF-8"));

            } catch (Exception e) {

                PrintWriter out = response.getWriter();
                out.print(e.getMessage());

            }

        } else if (add.equals("drop_classe")) {

            String nom_class = request.getParameter("nom_class");
            String niveau_class = request.getParameter("niveau_class");

            Classe c = new Classe();
            c.setNomClasse(nom_class);

            try {
                UserDao.deletedClass(c);

                String message = "<div class=\"container mt-5\">"
                        + "    <div class=\"row justify-content-center\">"
                        + "            <div class=\"alert alert-success alert-dismissible fade show\" role=\"alert\" style=\"background-color: #d4edda;\">"
                        + "                <p class=\"text-center mb-0\"d-inline>" + " " + nom_class
                        + " " + " <b>" + niveau_class + "</b>" + " deleted" + "</p>"
                        + "            </div>"
                        + "    </div>"
                        + "</div>";
                // J'ai inclus dans mon sendRedirect un méssage que je souhaite afficher dans user Doget avec action = list 
                response.sendRedirect("user?action=class&message=" + URLEncoder.encode(message, "UTF-8"));

            } catch (Exception e) {

                PrintWriter out = response.getWriter();
                out.print(e.getMessage());

            }

        } else if (add.equals("modify_user")) {

            String old_login_user = request.getParameter("old_login_user");
            String nom_user = request.getParameter("new_nom_user");
            String prenom_user = request.getParameter("new_prenom_user");
            String login = request.getParameter("new_login_user");

            String role = request.getParameter("new_role_user");

            User u = new User();

            if (role.equals("")) {

                u.setNom_user(nom_user);
                u.setPrenom_user(prenom_user);
                u.setLogin_user(login);

            } else {
                int id_role = Integer.parseInt(role);

                Role r = new Role();
                r.setId(id_role);

                u.setNom_user(nom_user);
                u.setPrenom_user(prenom_user);
                u.setLogin_user(login);

                u.setRole(r);

            }

            if (nom_user != null && prenom_user != null && login != null) {

                try {
                    UserDao.ModifyUser(u, old_login_user);

                    String message = "<div class=\"container mt-5\">"
                            + "    <div class=\"row justify-content-center\">"
                            + "            <div class=\"alert alert-success alert-dismissible fade show\" role=\"alert\" style=\"background-color: #d4edda;\">"
                            + "                <p class=\"text-center mb-0\"d-inline>" + " " + prenom_user
                            + " " + " <b>" + nom_user + "</b>" + " modified" + "</p>"
                            + "            </div>"
                            + "    </div>"
                            + "</div>";
                    // J'ai inclus dans mon sendRedirect un méssage que je souhaite afficher dans user Doget avec action = list 
                    response.sendRedirect("user?action=list&message=" + URLEncoder.encode(message, "UTF-8"));

                } catch (Exception e) {

                    PrintWriter out = response.getWriter();
                    out.print(e.getMessage());

                }
            } else {
                String message = "Tous les champs sont obligatoire !";

                response.sendRedirect("user?action=list&message=" + URLEncoder.encode(message, "UTF-8"));
            }

        } else if (add.equals("modify_class")) {

            String old_nom_class = request.getParameter("old_nom_class");
            String nom_class = request.getParameter("new_nom_class");
            String niveau_class = request.getParameter("new_niveau_class");
            String nbre = request.getParameter("new_nbre_apprenant");

            int nbre_apprenant = Integer.parseInt(nbre);

            Classe c = new Classe();
            c.setNomClasse(nom_class);
            c.setNiveauClasse(niveau_class);
            c.setNbreApprenant(nbre_apprenant);

            if (nom_class != null && niveau_class != null) {

                try {
                    UserDao.ModifyClass(c, old_nom_class);

                    String message = "<div class=\"container mt-5\">"
                            + "    <div class=\"row justify-content-center\">"
                            + "            <div class=\"alert alert-success alert-dismissible fade show\" role=\"alert\" style=\"background-color: #d4edda;\">"
                            + "                <p class=\"text-center mb-0\"d-inline>" + " " + nom_class
                            + " " + " <b>" + niveau_class + "</b>" + " modified" + "</p>"
                            + "            </div>"
                            + "    </div>"
                            + "</div>";
                    // J'ai inclus dans mon sendRedirect un méssage que je souhaite afficher dans user Doget avec action = list 
                    response.sendRedirect("user?action=class&message=" + URLEncoder.encode(message, "UTF-8"));

                } catch (Exception e) {

                    PrintWriter out = response.getWriter();
                    out.print(e.getMessage());

                }
            } else {
                String message = "Tous les champs sont obligatoire !";

                response.sendRedirect("user?action=list&message=" + URLEncoder.encode(message, "UTF-8"));
            }

        } else if (add.equals("user_add_class")) {

            String nom_user = request.getParameter("nom_user");
            String prenom_user = request.getParameter("prenom_user");
            String login = request.getParameter("login_user");

            String new_user_class = request.getParameter("new_user_class");
            int id_new_user_class = Integer.parseInt(new_user_class);

            try {
                Classe c = new Classe();
                c.setIdClasse(id_new_user_class);

                // Classe c = UserDao.getIdClassByNomClass(new_user_class);
                User u = new User();
                u.setClasse(c);
                UserDao.Modify_User_Class(u, login);

                String message = "<div class=\"container mt-5\">"
                        + "    <div class=\"row justify-content-center\">"
                        + "            <div class=\"alert alert-success alert-dismissible fade show\" role=\"alert\" style=\"background-color: #d4edda;\">"
                        + "                <p class=\"text-center mb-0\"d-inline>" + " " + prenom_user
                        + " " + " <b>" + nom_user + "</b>" + " added  succefuly </p>"
                        + "            </div>"
                        + "    </div>"
                        + "</div>";
                response.sendRedirect("user?action=user_class&message=" + URLEncoder.encode(message, "UTF-8"));
                // request.getRequestDispatcher("WEB-INF/ADMIN/user_add_classe.jsp").forward(request, response);

            } catch (Exception e) {
                
                String message = "<div class=\"container mt-5\">"
                        + "    <div class=\"row justify-content-center\">"
                        + "            <div class=\"alert alert-danger alert-dismissible fade show\" role=\"alert\" style=\"background-color: #f8d7da;\">"
                        + "                <p class=\"text-center mb-0\"d-inline>" + " " + prenom_user
                        + " " + " <b>" + nom_user + "</b>" + " failed to add ! Class name does not exist" + "</p>"
                        + "            </div>"
                        + "    </div>"
                        + "</div>";
                response.sendRedirect("user?action=user_class&message=" + URLEncoder.encode(message, "UTF-8"));
            }

        } else {
            response.sendRedirect("home");
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
