/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.cda.model;

import java.time.*;

/**
 *
 * @author kingafolabi
 */
public class ListePresence {
    
    private int id_class;
    private int id_cours;
    
    private LocalDate date_list;
    private LocalTime heure_list;
    
    private Classe classe_list;
    private Cours cours_list;

    public ListePresence() {
    }

    public ListePresence(int id_class, int id_cours, LocalDate date_list, LocalTime heure_list, Classe classe_list, Cours cours_list) {
        this.id_class = id_class;
        this.id_cours = id_cours;
        this.date_list = date_list;
        this.heure_list = heure_list;
        this.classe_list = classe_list;
        this.cours_list = cours_list;
    }

    public int getId_class() {
        return id_class;
    }

    public void setId_class(int id_class) {
        this.id_class = id_class;
    }

    public int getId_cours() {
        return id_cours;
    }

    public void setId_cours(int id_cours) {
        this.id_cours = id_cours;
    }

    public LocalDate getDate_list() {
        return date_list;
    }

    public void setDate_list(LocalDate date_list) {
        this.date_list = date_list;
    }

    public LocalTime getHeure_list() {
        return heure_list;
    }

    public void setHeure_list(LocalTime heure_list) {
        this.heure_list = heure_list;
    }

    public Classe getClasse_list() {
        return classe_list;
    }

    public void setClasse_list(Classe classe_list) {
        this.classe_list = classe_list;
    }

    public Cours getCours_list() {
        return cours_list;
    }

    public void setCours_list(Cours cours_list) {
        this.cours_list = cours_list;
    }

    
    
    
}
