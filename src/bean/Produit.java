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
    
    private String id;
    private String designation;
    private int quantiteStock;
    private double prixVente;
    private String categorie;
    private String marque;
    private String remarque;
    private String dateExp;

    public Produit() {
    }
    
    

    public Produit(String id, String designation, int quantiteStock, double prixVente, String categorie, String marque, String remarque) {
        this.id = id;
        this.designation = designation;
        this.quantiteStock = quantiteStock;
        this.prixVente = prixVente;
        this.categorie = categorie;
        this.marque = marque;
        this.remarque = remarque;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getQuantiteStock() {
        return quantiteStock;
    }

    public void setQuantiteStock(int quantiteStock) {
        this.quantiteStock = quantiteStock;
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
    
    
    
    
    
}
