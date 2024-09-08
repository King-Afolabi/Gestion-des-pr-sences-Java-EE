/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.cda.model;

/**
 *
 * @author kingafolabi
 */
public class Role {
    
    private int id;
    
    private String libelleRole;

    
    
    public Role() {
    }

    public Role(int id, String libelleRole) {
        this.id = id;
        this.libelleRole = libelleRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelleRole() {
        return libelleRole;
    }

    public void setLibelleRole(String libelleRole) {
        this.libelleRole = libelleRole;
    }
    
    

    
    
    
    
}
