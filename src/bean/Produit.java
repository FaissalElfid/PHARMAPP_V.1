/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;


import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Faissal
 */
public class Produit implements Serializable {
    
    private Long id;
    private String designation;
    private double prixVente;
    private String categorie;
    private String marque;
    private String remarque;
    private String dateExp;

    public Produit() {
    }

    public Produit(Long id, String designation, String categorie, String marque ) {
        this.id = id;
        this.designation = designation;

        this.categorie = categorie;
        this.marque = marque;
 
    }
    
    



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    

    public double getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(double prixVente) {
        this.prixVente = prixVente;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    public String getDateExp() {
        return dateExp;
    }

    public void setDateExp(String dateExp) {
        this.dateExp = dateExp;
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", designation=" + designation + ", prixVente=" + prixVente + ", categorie=" + categorie + ", marque=" + marque + ", remarque=" + remarque + ", dateExp=" + dateExp + '}';
    }
    
    
    
    
    
}
