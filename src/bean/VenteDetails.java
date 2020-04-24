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
public class VenteDetails {
    
    private long id;
    private int quantiteVendu;
    private Produit produit;
    private Vente vente; 
    
    //getters

    public long getId() {
        return id;
    }

    public int getQuantiteVendu() {
        return quantiteVendu;
    }

    public Produit getProduit() {
        return produit;
    }

    public Vente getVente() {
        return vente;
    }
    
    //setters

    public void setId(long id) {
        this.id = id;
    }

    public void setQuantiteVendu(int quantiteVendu) {
        this.quantiteVendu = quantiteVendu;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public void setVente(Vente vente) {
        this.vente = vente;
    }
    
    //constructeurs

    public VenteDetails() {
    }

    public VenteDetails(long id, int quantiteVendu) {
        this.id = id;
        this.quantiteVendu = quantiteVendu;
    }

    public VenteDetails(long id, int quantiteVendu, Produit produit) {
        this.id = id;
        this.quantiteVendu = quantiteVendu;
        this.produit = produit;
    }

    public VenteDetails(long id, int quantiteVendu, Produit produit, Vente vente) {
        this.id = id;
        this.quantiteVendu = quantiteVendu;
        this.produit = produit;
        this.vente = vente;
    }
    
    //toString

    @Override
    public String toString() {
        return "VenteDetails{" + "id=" + id + ", quantiteVendu=" + quantiteVendu + ", produit=" + produit + '}';
    }
    
    
}
