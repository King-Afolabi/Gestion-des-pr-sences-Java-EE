/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.cda.model;

/**
 *
 * @author kingafolabi
 */
public class Cours {
    
    private int id_cours;
    private String nom_cours;
    private int id_user;

    
    public Cours() {
    }

    public Cours(int id_cours, String nom_cours, int id_user) {
        this.id_cours = id_cours;
        this.nom_cours = nom_cours;
        this.id_user = id_user;
    }
    

    public Cours(int id_cours, String nom_cours) {
        this.id_cours = id_cours;
        this.nom_cours = nom_cours;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_cours() {
        return id_cours;
    }

    public void setId_cours(int id_cours) {
        this.id_cours = id_cours;
    }

    public String getNom_cours() {
        return nom_cours;
    }

    public void setNom_cours(String nom_cours) {
        this.nom_cours = nom_cours;
    }
    
    
}
