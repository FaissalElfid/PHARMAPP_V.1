/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.Date;

/**
 *
 * @author Soulaimane
 */
public class VentePaiement {
    
    private long id;
    private double montant;
    private Date datePaiement;
    private String typePaiement;
    private Vente vente;
    
    //getters

    public long getId() {
        return id;
    }

    public double getMontant() {
        return montant;
    }

    public Date getDatePaiement() {
        return datePaiement;
    }

    public String getTypePaiement() {
        return typePaiement;
    }

    public Vente getVente() {
        return vente;
    }
    
    //setters

    public void setId(long id) {
        this.id = id;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public void setDatePaiement(Date datePaiement) {
        this.datePaiement = datePaiement;
    }

    public void setTypePaiement(String typePaiement) {
        this.typePaiement = typePaiement;
    }

    public void setVente(Vente vente) {
        this.vente = vente;
    }
    
    //constructeurs

    public VentePaiement() {
    }

    public VentePaiement(long id, double montant, Date datePaiement, String typePaiement) {
        this.id = id;
        this.montant = montant;
        this.datePaiement = datePaiement;
        this.typePaiement = typePaiement;
    }

    public VentePaiement(long id, double montant, Date datePaiement, String typePaiement, Vente vente) {
        this.id = id;
        this.montant = montant;
        this.datePaiement = datePaiement;
        this.typePaiement = typePaiement;
        this.vente = vente;
    }
    
    //toString

    @Override
    public String toString() {
        return "VentePaiement{" + "id=" + id + ", montant=" + montant + ", datePaiement=" + datePaiement + ", typePaiement=" + typePaiement + '}';
    }
    
    
    
}
