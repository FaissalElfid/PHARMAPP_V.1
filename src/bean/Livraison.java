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
public class Livraison {
    
    private long id;
    private Date dateLivraison;
    private double totale;
    private Utilisateur fournisseur;
    private List<LivraisonDetails> livraisonDetailses;
    
    //getters

    public long getId() {
        return id;
    }

    public Date getDateLivraison() {
        return dateLivraison;
    }

    public double getTotale() {
        return totale;
    }

    public Utilisateur getUtilisateur() {
        return fournisseur;
    }

    public List<LivraisonDetails> getLivraisonDetailses() {
        return livraisonDetailses;
    }
    
    //setters

    public void setId(long id) {
        this.id = id;
    }

    public void setDateLivraison(Date dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public void setTotale(double totale) {
        this.totale = totale;
    }

    public void setUtilisateur(Utilisateur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public void setLivraisonDetailses(List<LivraisonDetails> livraisonDetailses) {
        this.livraisonDetailses = livraisonDetailses;
    }
    
    //constructeurs

    public Livraison() {
    }

    public Livraison(long id, Date dateLivraison, double totale) {
        this.id = id;
        this.dateLivraison = dateLivraison;
        this.totale = totale;
    }

    public Livraison(long id, Date dateLivraison, double totale, Utilisateur fournisseur) {
        this.id = id;
        this.dateLivraison = dateLivraison;
        this.totale = totale;
        this.fournisseur = fournisseur;
    }

    public Livraison(long id, Date dateLivraison, double totale, Utilisateur fournisseur, List<LivraisonDetails> livraisonDetailses) {
        this.id = id;
        this.dateLivraison = dateLivraison;
        this.totale = totale;
        this.fournisseur = fournisseur;
        this.livraisonDetailses = livraisonDetailses;
    }
    
    //toString

    @Override
    public String toString() {
        return "Livraison{" + "id=" + id + ", dateLivraison=" + dateLivraison + ", totale=" + totale + ", fournisseur=" + fournisseur + ", livraisonDetailses=" + livraisonDetailses + '}';
    }
    
    
}
