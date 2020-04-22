/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Faissal
 */
public class PanierLigne {
    private Long code_prod;
    private String designation;
    private String categorie;
    private double quantiteStock;
    private double prixUnitaire;
    private double quantiteCommande;
    private double total;

    public PanierLigne() {
    }

    public PanierLigne(Long code_prod, String designation, String categorie, int quantiteStock, double prixUnitaire, int quantiteCommande) {
        this.code_prod = code_prod;
        this.designation = designation;
        this.categorie = categorie;
        this.quantiteStock = quantiteStock;
        this.prixUnitaire = prixUnitaire;
        this.quantiteCommande = quantiteCommande;
        this.total = prixUnitaire * quantiteCommande;
    }
    

    public Long getCode_prod() {
        return code_prod;
    }

    public void setCode_prod(Long code_prod) {
        this.code_prod = code_prod;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public double getQuantiteStock() {
        return quantiteStock;
    }

    public void setQuantiteStock(double quantiteStock) {
        this.quantiteStock = quantiteStock;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public double getQuantiteCommande() {
        return quantiteCommande;
    }

    public void setQuantiteCommande(double quantiteCommande) {
        this.quantiteCommande = quantiteCommande;
    }

    public double getTotal() {
        return total = prixUnitaire * quantiteCommande;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
}
