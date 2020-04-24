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
public class CommandeDetails {
    
    private long id;
    private int quantiteCommande;
    private int quantiteLivre;
    private Produit produit;
    private Commande commande;
    
    //getters

    public long getId() {
        return id;
    }

    public int getQuantiteCommande() {
        return quantiteCommande;
    }

    public int getQuantiteLivre() {
        return quantiteLivre;
    }

    public Produit getProduit() {
        return produit;
    }

    public Commande getCommande() {
        return commande;
    }
    
    //setters

    public void setId(long id) {
        this.id = id;
    }

    public void setQuantiteCommande(int quantiteCommande) {
        this.quantiteCommande = quantiteCommande;
    }

    public void setQuantiteLivre(int quantiteLivre) {
        this.quantiteLivre = quantiteLivre;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }
    
    //constructeurs

    public CommandeDetails() {
    }

    public CommandeDetails(long id, int quantiteCommande, int quantiteLivre) {
        this.id = id;
        this.quantiteCommande = quantiteCommande;
        this.quantiteLivre = quantiteLivre;
    }

    public CommandeDetails(long id, int quantiteCommande, int quantiteLivre, Produit produit) {
        this.id = id;
        this.quantiteCommande = quantiteCommande;
        this.quantiteLivre = quantiteLivre;
        this.produit = produit;
    }

    public CommandeDetails(long id, int quantiteCommande, int quantiteLivre, Produit produit, Commande commande) {
        this.id = id;
        this.quantiteCommande = quantiteCommande;
        this.quantiteLivre = quantiteLivre;
        this.produit = produit;
        this.commande = commande;
    }
    
    //toString

    @Override
    public String toString() {
        return "CommandeDetails{" + "id=" + id + ", quantiteCommande=" + quantiteCommande + ", quantiteLivre=" + quantiteLivre + ", produit=" + produit + '}';
    }
    
    
}
