/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Soulaimane
 */
public class ProduitCategorie {
    
    private long id;
    private String libelle;
    
    //getters

    public long getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }
    
    //setters

    public void setId(long id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    
    //constructeurs

    public ProduitCategorie() {
    }

    public ProduitCategorie(long id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }
    
    //toString

    @Override
    public String toString() {
        return "ProduitCategorie{" + "id=" + id + ", libelle=" + libelle + '}';
    }
    
    
    
}
