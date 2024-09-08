/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.cda.dao;

import fr.cda.model.Classe;
import fr.cda.model.Cours;
import fr.cda.model.Role;
import fr.cda.model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kingafolabi
 */
public class UserDao {

    public static User getByLoginAndPassword(String log, String mdp) throws SQLException {

        User u = null; // on crée une variable u de type User qu'on initialise
        // par null. Ce qui sera changé si on trouve un utilisateur.

        String sql; // on crée une variable sql de type String pour y ajouter la
        // requête SQL qu'on enverra dans la base de données pour récupérer ce qu'on souhaite.
        sql = "SELECT u.*, r.libelle FROM USERS u INNER JOIN ROLES r  ON u.id_role = r.id_role WHERE login_user = ? AND password_user = ?";

        Connection connexion = AccessBd.getConnection();// On crée une variable connexion
        // de type Connection (Variable propre à JavaWEB) pour établir la connexion avec la BD 

        PreparedStatement prepare = connexion.prepareStatement(sql);// on prépare la requête

        prepare.setString(1, log);
        prepare.setString(2, mdp);

        ResultSet rs = prepare.executeQuery(); // Ici on récupère dans rs les 
        // information de l'utilisateur provenant de la base de données.

        if (rs.next()) { // rs.next renvoie un boolean 

            // On fait un mapping ici càd on prend les information de la 
            // base 
            Role r = new Role(); // on crée un role dans notre Class Role
            r.setId(rs.getInt("id_role"));
            r.setLibelleRole(rs.getString("libelle"));

            u = new User(); // on ajoute un utilisateur dans notre Class User
            u.setId(rs.getInt("id_user"));
            u.setNom_user(rs.getString("nom_user"));
            u.setPrenom_user(rs.getString("prenom_user"));
            u.setLogin_user(rs.getString("login_user"));
            u.setRole(r);

        }

        return u;
    }

    public static void ModifyClass(Classe c, String old_nom) throws SQLException {

        String sql;

        sql = "UPDATE CLASSES SET nom_class = ?, niveau_class = ?, nbre_apprenant = ? WHERE nom_class ='" + old_nom + "';";
        Connection connexion = AccessBd.getConnection();// On crée une variable connexion
        // de type Connection (Variable propre à JavaWEB) pour établir la connexion avec la BD 

        PreparedStatement prepare = connexion.prepareStatement(sql);// on prépare la requête

        prepare.setString(1, c.getNomClasse());
        prepare.setString(2, c.getNiveauClasse());
        prepare.setInt(3, c.getNbreApprenant());
        // On execute les codes plus hauts
        prepare.execute();

    }

    public static void ModifyUser(User u, String old_login) throws SQLException {

        String sql;

        if (u.getRole() != null) {
            sql = "UPDATE USERS SET nom_user = ?, prenom_user = ?, login_user = ?, id_role = ? WHERE login_user ='" + old_login + "';";
            Connection connexion = AccessBd.getConnection();// On crée une variable connexion
            // de type Connection (Variable propre à JavaWEB) pour établir la connexion avec la BD 

            PreparedStatement prepare = connexion.prepareStatement(sql);// on prépare la requête

            prepare.setString(1, u.getNom_user());
            prepare.setString(2, u.getPrenom_user());
            prepare.setString(3, u.getLogin_user());

            prepare.setInt(4, u.getRole().getId());
            // On execute les codes plus hauts
            prepare.execute();
        } else {
            sql = "UPDATE USERS SET nom_user = ?, prenom_user = ?, login_user = ? WHERE login_user ='" + old_login + "';";
            Connection connexion = AccessBd.getConnection();// On crée une variable connexion
            // de type Connection (Variable propre à JavaWEB) pour établir la connexion avec la BD 

            PreparedStatement prepare = connexion.prepareStatement(sql);// on prépare la requête

            prepare.setString(1, u.getNom_user());
            prepare.setString(2, u.getPrenom_user());
            prepare.setString(3, u.getLogin_user());
            // On execute les codes plus hauts
            prepare.execute();
        }

    }
/*
    // Fonction pour retourner la ligne de la table classe correspondant au nom de la classe
    public static Classe getIdClassByNomClass(String nom_class) throws SQLException {

        Classe c = null; // on crée une variable id de type int  qu'on initialise
        // par null. Ce qui sera changé si on trouve un utilisateur.

        String sql; // on crée une variable sql de type String pour y ajouter la
        // requête SQL qu'on enverra dans la base de données pour récupérer ce qu'on souhaite.
        sql = "SELECT * FROM CLASSES WHERE nom_class = ?";

        Connection connexion = AccessBd.getConnection();// On crée une variable connexion
        // de type Connection (Variable propre à JavaWEB) pour établir la connexion avec la BD 

        PreparedStatement prepare = connexion.prepareStatement(sql);// on prépare la requête

        prepare.setString(1, nom_class);

        ResultSet rs = prepare.executeQuery(); // Ici on récupère dans rs les 
        // information de l'utilisateur provenant de la base de données.

        if (rs.next()) { // rs.next renvoie un boolean 

            c = new Classe(); // on ajoute un utilisateur dans notre Class User
            c.setIdClasse(rs.getInt("id_class"));
            c.setNomClasse(rs.getString("nom_class"));
            c.setNiveauClasse(rs.getString("niveau_class"));
            c.setNbreApprenant(rs.getInt("nbre_apprenant"));

        }

        return c;
    }*/

    public static void Modify_User_Class(User u, String login) throws SQLException {

        String sql;

        sql = "UPDATE USERS u INNER JOIN CLASSES c ON u.id_class = c.id_class SET u.id_class = ? WHERE u.login_user = '" + login + "';";
        Connection connexion = AccessBd.getConnection();// On crée une variable connexion
        // de type Connection (Variable propre à JavaWEB) pour établir la connexion avec la BD 
        PreparedStatement prepare = connexion.prepareStatement(sql);// on prépare la requête

        prepare.setInt(1, u.getClasse().getIdClasse());
        // On execute les codes plus hauts
        prepare.execute();

    }

    public static void saveUser(User u) throws SQLException {

        String sql;
        sql = "INSERT INTO USERS (nom_user, prenom_user, login_user, password_user, id_role) VALUES (?, ?, ?, ?, ?)";

        Connection connexion = AccessBd.getConnection();// On crée une variable connexion
        // de type Connection (Variable propre à JavaWEB) pour établir la connexion avec la BD 

        PreparedStatement prepare = connexion.prepareStatement(sql);// on prépare la requête

        prepare.setString(1, u.getNom_user());
        prepare.setString(2, u.getPrenom_user());
        prepare.setString(3, u.getLogin_user());
        prepare.setString(4, u.getPassword_user());
        prepare.setInt(5, u.getRole().getId());

        // On execute les codes plus hauts
        prepare.execute();

    }

    public static void saveClass(Classe c) throws SQLException {

        String sql;
        sql = "INSERT INTO CLASSES (nom_class, niveau_class, nbre_apprenant) VALUES (?, ?, ?)";

        Connection connexion = AccessBd.getConnection();// On crée une variable connexion
        // de type Connection (Variable propre à JavaWEB) pour établir la connexion avec la BD 

        PreparedStatement prepare = connexion.prepareStatement(sql);// on prépare la requête

        prepare.setString(1, c.getNomClasse());
        prepare.setString(2, c.getNiveauClasse());
        prepare.setInt(3, c.getNbreApprenant());

        // On execute les codes plus hauts
        prepare.execute();

    }

    // fonction qui permet de supprimer un utilisateur
    public static void deletedClass(Classe c) throws SQLException {

        String sql;
        sql = "DELETE FROM CLASSES WHERE nom_class = ? ";

        Connection connexion = AccessBd.getConnection();// On crée une variable connexion
        // de type Connection (Variable propre à JavaWEB) pour établir la connexion avec la BD 

        PreparedStatement prepare = connexion.prepareStatement(sql);// on prépare la requête

        prepare.setString(1, c.getNomClasse());
        // On execute les codes plus hauts
        prepare.execute();

    }

    // fonction qui permet de supprimer un utilisateur
    public static void deletedUser(User u) throws SQLException {

        String sql;
        sql = "DELETE FROM USERS WHERE login_user = ? ";

        Connection connexion = AccessBd.getConnection();// On crée une variable connexion
        // de type Connection (Variable propre à JavaWEB) pour établir la connexion avec la BD 

        PreparedStatement prepare = connexion.prepareStatement(sql);// on prépare la requête

        prepare.setString(1, u.getLogin_user());
        // On execute les codes plus hauts
        prepare.execute();

    }

    // fonction qui permet d'afficher tous les utilisateurs
    public static List<User> getAllUsers() throws SQLException {

        List<User> users = new ArrayList<>(); // on crée une variable users de type List des liste de User
        //Ce qui sera changé si on trouve un utilisateur.

        String sql; // on crée une variable sql de type String pour y ajouter la
        // requête SQL qu'on enverra dans la base de données pour récupérer ce qu'on souhaite.
        sql = "SELECT u.*, r.libelle FROM USERS u INNER JOIN ROLES r  ON u.id_role = r.id_role";

        Connection connexion = AccessBd.getConnection();// On crée une variable connexion
        // de type Connection (Variable propre à JavaWEB) pour établir la connexion avec la BD 

        Statement state = connexion.createStatement();// on prépare la requête

        ResultSet rs = state.executeQuery(sql); // Ici on récupère dans rs les 
        // information de l'utilisateur provenant de la base de données.

        while (rs.next()) { // rs.next renvoie un boolean 

            // On fait un mapping ici càd on prend les information de la 
            // base 
            Role r = new Role(); // on crée un role dans notre Class Role
            r.setId(rs.getInt("id_role"));
            r.setLibelleRole(rs.getString("libelle"));

            User u = new User(); // on ajoute un utilisateur dans notre Class User
            u.setId(rs.getInt("id_user"));
            u.setNom_user(rs.getString("nom_user"));
            u.setPrenom_user(rs.getString("prenom_user"));
            u.setLogin_user(rs.getString("login_user"));

            u.setRole(r);// on ajouter le role dans user

            users.add(u);

        }

        return users;
    }

    // fonction qui permet d'afficher toutes les classes
    public static List<Classe> getAllClass() throws SQLException {

        List<Classe> classes = new ArrayList<>(); // on crée une variable users de type List des liste de User
        //Ce qui sera changé si on trouve un utilisateur.

        String sql; // on crée une variable sql de type String pour y ajouter la
        // requête SQL qu'on enverra dans la base de données pour récupérer ce qu'on souhaite.
        sql = "SELECT * FROM CLASSES";

        Connection connexion = AccessBd.getConnection();// On crée une variable connexion
        // de type Connection (Variable propre à JavaWEB) pour établir la connexion avec la BD 

        Statement state = connexion.createStatement();// on prépare la requête

        ResultSet rs = state.executeQuery(sql); // Ici on récupère dans rs les 
        // information de l'utilisateur provenant de la base de données.

        while (rs.next()) { // rs.next renvoie un boolean 

            // On fait un mapping ici càd on prend les information de la 
            // base 
            Classe c = new Classe(); // on ajoute un utilisateur dans notre Class User
            c.setIdClasse(rs.getInt("id_class"));
            c.setNomClasse(rs.getString("nom_class"));
            c.setNiveauClasse(rs.getString("niveau_class"));
            c.setNbreApprenant(rs.getInt("nbre_apprenant"));

            classes.add(c);

        }

        return classes;
    }
    
    
    public static List<Cours> getAllCours() throws SQLException {

        List<Cours> cours = new ArrayList<>(); // on crée une variable users de type List des liste de User
        //Ce qui sera changé si on trouve un utilisateur.

        String sql; // on crée une variable sql de type String pour y ajouter la
        // requête SQL qu'on enverra dans la base de données pour récupérer ce qu'on souhaite.
        sql = "SELECT * FROM COURS";

        Connection connexion = AccessBd.getConnection();// On crée une variable connexion
        // de type Connection (Variable propre à JavaWEB) pour établir la connexion avec la BD 

        Statement state = connexion.createStatement();// on prépare la requête

        ResultSet rs = state.executeQuery(sql); // Ici on récupère dans rs les 
        // information de l'utilisateur provenant de la base de données.

        while (rs.next()) { // rs.next renvoie un boolean 

            // On fait un mapping ici càd on prend les information de la 
            // base 
            Cours cr = new Cours(); // on ajoute un utilisateur dans notre Class User
            cr.setId_cours(rs.getInt("id_cours"));
            cr.setNom_cours(rs.getString("nom_cours"));
            cr.setId_user(rs.getInt("id_user"));
            

            cours.add(cr);

        }

        return cours;
    }
    
    
    
    
    
    
    
    
    

    // fonction qui permet de sélectionner un role particulier
    public static List<User> getOneTypeUser(String type) throws SQLException {

        List<User> users = new ArrayList<>(); // on crée une variable users de type List des liste de User
        //Ce qui sera changé si on trouve un utilisateur.

        String sql; // on crée une variable sql de type String pour y ajouter la
        // requête SQL qu'on enverra dans la base de données pour récupérer ce qu'on souhaite.

        if (("formateur".equals(type)) || ("apprenant".equals(type)) || ("admin".equals(type))) {
            sql = "SELECT u.*, r.libelle FROM USERS u INNER JOIN ROLES r  ON u.id_role = r.id_role WHERE r.libelle = \""
                    + type
                    + "\"";
        }else if ("formateur_apprenant".equals(type)) {
            sql= "SELECT u.*, r.libelle, c.nom_class, c.niveau_class, c.nbre_apprenant   FROM USERS u INNER JOIN ROLES r  ON u.id_role = r.id_role INNER JOIN CLASSES c ON u.id_class = c.id_class WHERE r.libelle = 'formateur' OR r.libelle = 'apprenant'";
            
        }  else {
            sql = "SELECT u.*, r.libelle FROM USERS u INNER JOIN ROLES r  ON u.id_role = r.id_role";
        }

        Connection connexion = AccessBd.getConnection();// On crée une variable connexion
        // de type Connection (Variable propre à JavaWEB) pour établir la connexion avec la BD 

        Statement state = connexion.createStatement();// on prépare la requête

        ResultSet rs = state.executeQuery(sql); // Ici on récupère dans rs les 
        // information de l'utilisateur provenant de la base de données.

        while (rs.next()) { // rs.next renvoie un boolean 
            
            User u = new User(); // on ajoute un utilisateur dans notre Class User
            
            if("formateur_apprenant".equals(type)){
            Classe c = new Classe();
            c.setIdClasse(rs.getInt("id_class"));
            c.setNomClasse(rs.getString("nom_class"));
            c.setNiveauClasse(rs.getString("niveau_class"));
            c.setNbreApprenant(rs.getInt("nbre_apprenant"));
            
            u.setClasse(c);
            }
            // On fait un mapping ici càd on prend les information de la 
            // base 
            Role r = new Role(); // on crée un role dans notre Class Role
            r.setId(rs.getInt("id_role"));
            r.setLibelleRole(rs.getString("libelle"));
            
            u.setRole(r);// on ajouter le role dans user

            
            u.setId(rs.getInt("id_user"));
            u.setNom_user(rs.getString("nom_user"));
            u.setPrenom_user(rs.getString("prenom_user"));
            u.setLogin_user(rs.getString("login_user"));


            users.add(u);

        }

        return users;
    }

}
