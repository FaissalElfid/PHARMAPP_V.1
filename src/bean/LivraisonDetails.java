/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Soulaimane
 */
public class LivraisonDetails {
    
    private long id;
    private int quantiteRecu;
    private Produit produit;
    private Livraison livraison;
    
    //getters

    public long getId() {
        return id;
    }

    public int getQuantiteRecu() {
        return quantiteRecu;
    }

    public Produit getProduit() {
        return produit;
    }

    public Livraison getLivraison() {
        return livraison;
    }
    
    //setters

    public void setId(long id) {
        this.id = id;
    }

    public void setQuantiteRecu(int quantiteRecu) {
        this.quantiteRecu = quantiteRecu;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public void setLivraison(Livraison livraison) {
        this.livraison = livraison;
    }
    
    //constructeurs

    public LivraisonDetails() {
    }

    public LivraisonDetails(long id, int quantiteRecu) {
        this.id = id;
        this.quantiteRecu = quantiteRecu;
    }

    public LivraisonDetails(long id, int quantiteRecu, Produit produit) {
        this.id = id;
        this.quantiteRecu = quantiteRecu;
        this.produit = produit;
    }

    public LivraisonDetails(long id, int quantiteRecu, Produit produit, Livraison livraison) {
        this.id = id;
        this.quantiteRecu = quantiteRecu;
        this.produit = produit;
        this.livraison = livraison;
    }
    
    //toString

    @Override
    public String toString() {
        return "LivraisonDetails{" + "id=" + id + ", quantiteRecu=" + quantiteRecu + ", produit=" + produit + '}';
    }
    
    
}
