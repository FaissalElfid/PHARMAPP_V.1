/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.List;

/**
 *
 * @author Soulaimane
 */
public class Role {
    
    private long id;
    private String libelle;
    private List<Privilege> privileges;
    
    //getters

    public long getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public List<Privilege> getPrivileges() {
        return privileges;
    }

    //setters
    
    public void setId(long id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }
    
    //constructeurs

    public Role() {
    }

    public Role(long id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public Role(long id, String libelle, List<Privilege> privileges) {
        this.id = id;
        this.libelle = libelle;
        this.privileges = privileges;
    }
    
    //toString

    @Override
    public String toString() {
        return "Role{" + "id=" + id + ", libelle=" + libelle + ", privileges=" + privileges + '}';
    }
    
    
}
