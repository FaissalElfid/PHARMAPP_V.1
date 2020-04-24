/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;


/**
 *
 * @author a
 */
public class Stock {

    private long id;
    private Produit produit;
    private double quantite;
    private double quantitemin;
    private double quantitDefectueise;
    

    public Stock() {
    }

    public Stock(long id, Produit produit, double quantite, double quantitemin) {
        this.id = id;
        this.produit = produit;
        this.quantite = quantite;
        this.quantitemin = quantitemin;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


   

    public Produit getProduit() {
        
        return produit;
    }

    public Stock(Produit produit, double quantite) {
        this.produit = produit;
        this.quantite = quantite;
    }
    

    public void setProduit(Produit produit) {
        if (produit == null ){
             new Produit();
        }else
        this.produit = produit;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public double getQuantitemin() {
        return quantitemin;
    }

    public void setQuantitemin(double quantitemin) {
        this.quantitemin = quantitemin;
    }

    public double getQuantitDefectueise() {
        return quantitDefectueise;
    }

    public void setQuantitDefectueise(double quantitDefectueise) {
        this.quantitDefectueise = quantitDefectueise;
    }

    @Override
    public String toString() {
        return "Stock{" + "id=" + id + ", produit=" + produit + ", quantite=" + quantite + ", quantitemin=" + quantitemin + ", quantitDefectueise=" + quantitDefectueise + '}';
    }


}
