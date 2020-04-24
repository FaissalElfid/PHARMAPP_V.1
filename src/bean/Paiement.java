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
public class Paiement {
    
    private long id;
    private Vente vente ;
    private String date_paiement;
    private double montant;
    private String typePaiement ;

    public Paiement() {
    }

    public Paiement(Vente vente, String date_paiement, double montant, String typePaiement) {
        this.vente = vente;
        this.date_paiement = date_paiement;
        this.montant = montant;
        this.typePaiement = typePaiement;
    }
    
    
    
    
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Vente getVente() {
        return vente;
    }

    public void setVente(Vente vente) {
        this.vente = vente;
    }

    public String getDate_paiement() {
        return date_paiement;
    }

    public void setDate_paiement(String date_paiement) {
        this.date_paiement = date_paiement;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getTypePaiement() {
        return typePaiement;
    }

    public void setTypePaiement(String typePaiement) {
        this.typePaiement = typePaiement;
    }
 
    
    
}
