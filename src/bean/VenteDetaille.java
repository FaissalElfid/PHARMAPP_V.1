/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author hp
 */
public class VenteDetaille {
    private long id;
    private Vente vente;
    private Produit  produit  ; 
    private int qntVendu;   

    public VenteDetaille() {
    }

    public Vente getVente() {
        return vente;
    }

    public void setVente(Vente vente) {
        this.vente = vente;
    }

    public VenteDetaille( Vente vente, Produit produit, int qntVendu) {
       
        this.vente = vente;
        this.produit = produit;
        this.qntVendu = qntVendu;
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

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public int getQntVendu() {
        return qntVendu;
    }

    public void setQntVendu(int qntVendu) {
        this.qntVendu = qntVendu;
    }
    
        
    
    
    
    
}
