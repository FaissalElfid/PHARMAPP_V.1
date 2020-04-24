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
public class Vente {
    
    private long id;
    private Date dateVente;
    private double total;
    private double totalPaye;
    private Utilisateur utilisateur;
    private List<VenteDetails> venteDetailses;
    private List<VentePaiement> ventePaiements;
    
    //getters

    public long getId() {
        return id;
    }

    public Date getDateVente() {
        return dateVente;
    }

    public double getTotal() {
        return total;
    }

    public double getTotalPaye() {
        return totalPaye;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public List<VenteDetails> getVenteDetailses() {
        return venteDetailses;
    }

    public List<VentePaiement> getVentePaiements() {
        return ventePaiements;
    }
    
    //setters

    public void setId(long id) {
        this.id = id;
    }

    public void setDateVente(Date dateVente) {
        this.dateVente = dateVente;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setTotalPaye(double totalPaye) {
        this.totalPaye = totalPaye;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void setVenteDetailses(List<VenteDetails> venteDetailses) {
        this.venteDetailses = venteDetailses;
    }

    public void setVentePaiements(List<VentePaiement> ventePaiements) {
        this.ventePaiements = ventePaiements;
    }
    
    //constructeurs

    public Vente() {
    }

    public Vente(long id, Date dateVente, double total, double totalPaye) {
        this.id = id;
        this.dateVente = dateVente;
        this.total = total;
        this.totalPaye = totalPaye;
    }

    public Vente(long id, Date dateVente, double total, double totalPaye, Utilisateur utilisateur) {
        this.id = id;
        this.dateVente = dateVente;
        this.total = total;
        this.totalPaye = totalPaye;
        this.utilisateur = utilisateur;
    }

    public Vente(long id, Date dateVente, double total, double totalPaye, List<VenteDetails> venteDetailses) {
        this.id = id;
        this.dateVente = dateVente;
        this.total = total;
        this.totalPaye = totalPaye;
        this.venteDetailses = venteDetailses;
    }

    public Vente(long id, Date dateVente, double total, double totalPaye, Utilisateur utilisateur, List<VenteDetails> venteDetailses, List<VentePaiement> ventePaiements) {
        this.id = id;
        this.dateVente = dateVente;
        this.total = total;
        this.totalPaye = totalPaye;
        this.utilisateur = utilisateur;
        this.venteDetailses = venteDetailses;
        this.ventePaiements = ventePaiements;
    }
    
    //toString

    @Override
    public String toString() {
        return "Vente{" + "id=" + id + ", dateVente=" + dateVente + ", total=" + total + ", totalPaye=" + totalPaye + ", utilisateur=" + utilisateur + ", venteDetailses=" + venteDetailses + ", ventePaiements=" + ventePaiements + '}';
    }
    
    
}
