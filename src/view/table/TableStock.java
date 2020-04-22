/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.table;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Faissal
 */
public class TableStock {
        private Long id;
    private  String designation;
    private  double prixVente;
    private  String marque;
    private  String dateExp;
    private  double quantiteStock;
    private  String categorie;
    private String remarque;

    public TableStock() {
    }

    public TableStock(Long id, String designation, double prixVente, String marque, String dateExp, double quantiteStock, String categorie, String remarque) {
        this.id = id;
        this.designation = designation;
        this.prixVente = prixVente;
        this.marque = marque;
        this.dateExp = dateExp;
        this.quantiteStock = quantiteStock;
        this.categorie = categorie;
        this.remarque = remarque;
    }

  

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(double prixVente) {
        this.prixVente = prixVente;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getDateExp() {
        return dateExp;
    }

    public void setDateExp(String dateExp) {
        this.dateExp = dateExp;
    }

    public double getQuantiteStock() {
        return quantiteStock;
    }

    public void setQuantiteStock(double quantiteStock) {
        this.quantiteStock = quantiteStock;
    }


    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
         
}
