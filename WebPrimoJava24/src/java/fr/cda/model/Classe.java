/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.cda.model;

/**
 *
 * @author kingafolabi
 */
public class Classe {
    
    private int idClasse;
    private String nomClasse;
    private String niveauClasse;
    private int nbreApprenant;

    public Classe() {
    }

    public Classe(String nomClasse) {
        this.nomClasse = nomClasse;
    }
    
    
    

    public Classe(int idClasse, String nomClasse, String niveauClasse, int nbreApprenant) {
        this.idClasse = idClasse;
        this.nomClasse = nomClasse;
        this.niveauClasse = niveauClasse;
        this.nbreApprenant = nbreApprenant;
    }

    public int getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
    }

    public String getNomClasse() {
        return nomClasse;
    }

    public void setNomClasse(String nomClasse) {
        this.nomClasse = nomClasse;
    }

    public String getNiveauClasse() {
        return niveauClasse;
    }

    public void setNiveauClasse(String niveauClasse) {
        this.niveauClasse = niveauClasse;
    }

    public int getNbreApprenant() {
        return nbreApprenant;
    }

    public void setNbreApprenant(int nbreApprenant) {
        this.nbreApprenant = nbreApprenant;
    }
    
    
}
