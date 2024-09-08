/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.cda.dao;

import fr.cda.model.Classe;
import fr.cda.model.Role;
import fr.cda.model.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kingafolabi
 */
public class FormateurDao {
    
    public static List<User> getUsersByClass(int id_class) throws SQLException {

        List<User> users = new ArrayList<>(); // on crée une variable users de type List des liste de User
        //Ce qui sera changé si on trouve un utilisateur.

        String sql; // on crée une variable sql de type String pour y ajouter la
        // requête SQL qu'on enverra dans la base de données pour récupérer ce qu'on souhaite.
        sql = "SELECT u.*, r.libelle, c.nom_class, c.niveau_class, c.nbre_apprenant FROM USERS  u INNER JOIN ROLES r  ON u.id_role = r.id_role INNER JOIN CLASSES c  ON u.id_class = c.id_class WHERE u.id_class = " + id_class + ";";

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
            
            Classe c = new Classe();
            c.setIdClasse(rs.getInt("id_class"));
            c.setNomClasse(rs.getString("nom_class"));
            c.setNiveauClasse(rs.getString("niveau_class"));
            c.setNbreApprenant(rs.getInt("nbre_apprenant"));

            User u = new User(); // on ajoute un utilisateur dans notre Class User
            u.setId(rs.getInt("id_user"));
            u.setNom_user(rs.getString("nom_user"));
            u.setPrenom_user(rs.getString("prenom_user"));
            u.setLogin_user(rs.getString("login_user"));

            u.setRole(r);// on ajouter le role dans user

            u.setClasse(c);
            users.add(u);

        }

        return users;
    }
    
}
