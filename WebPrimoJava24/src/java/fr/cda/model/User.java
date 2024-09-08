/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.cda.model;

/**
 *
 * @author kingafolabi
 */
public class User {
    
    private int id;
    private String nom_user;
    private String prenom_user;
    private String login_user;
    private String password_user;
    
    
    private Classe classe;
    private Role role;
    
    
    
    public User() {
    }

    public User(String login_user) {
        this.login_user = login_user;
    }

    public User(String nom_user, String prenom_user, String login_user) {
        this.nom_user = nom_user;
        this.prenom_user = prenom_user;
        this.login_user = login_user;
    }
    

    public User(String nom_user, String prenom_user) {
        this.nom_user = nom_user;
        this.prenom_user = prenom_user;
    }

    
    
    public User(int id, String nom_user, String prenom_user, String login_user, String password_user) {
        this.id = id;
        this.nom_user = nom_user;
        this.prenom_user = prenom_user;
        this.login_user = login_user;
        this.password_user = password_user;
    }

    public User(int id, String nom_user, String prenom_user, String login_user, String password_user, Classe classe, Role role) {
        this.id = id;
        this.nom_user = nom_user;
        this.prenom_user = prenom_user;
        this.login_user = login_user;
        this.password_user = password_user;
        this.classe = classe;
        this.role = role;
    }

    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_user() {
        return nom_user;
    }

    public void setNom_user(String nom_user) {
        this.nom_user = nom_user;
    }

    public String getPrenom_user() {
        return prenom_user;
    }

    public void setPrenom_user(String prenom_user) {
        this.prenom_user = prenom_user;
    }

    public String getLogin_user() {
        return login_user;
    }

    public void setLogin_user(String login_user) {
        this.login_user = login_user;
    }

    public String getPassword_user() {
        return password_user;
    }

    public void setPassword_user(String password_user) {
        this.password_user = password_user;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
    
    
    
    
    
}
