/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class Vente {
    
       private long id;
    private Client  clientv  ;
    private String date_vente;
    private double total;
    private double totalPayee;
    private List<VenteDetaille> ventedetaille=new ArrayList<VenteDetaille>();
    private  List<Paiement> paiements=new ArrayList<Paiement>();

   /* public Vente(long id,String date_vente, double total, double totalPayee) {
        this.id=id;
        this.date_vente = date_vente;
        this.total = total;
        this.totalPayee = totalPayee;
    }*/

   public Vente( long id,Client clientv, String date_vente, double total, double totalPayee) {
        this.id=id;
        this.clientv = clientv;
        this.date_vente = date_vente;
        this.total = total;
        this.totalPayee = totalPayee;
    }

    public Vente() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Client getClientv() {
        return clientv;
    }

    public void setClientv(Client clientv) {
        if( clientv == null){
            new Client();
        }
        this.clientv = clientv;
    }

    public String getDate_vente() {
        return date_vente;
    }

    public void setDate_vente(String date_vente) {
        this.date_vente = date_vente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotalPayee() {
        return totalPayee;
    }

    public void setTotalPayee(double totalPayee) {
        this.totalPayee = totalPayee;
    }

    public List<VenteDetaille> getVentedetaille() {
        return ventedetaille;
    }

    public void setVentedetaille(List<VenteDetaille> ventedetaille) {
        this.ventedetaille = ventedetaille;
    }

    public List<Paiement> getPaiements() {
        return paiements;
    }

    public void setPaiements(List<Paiement> paiements) {
        this.paiements = paiements;
    }
  
    

}
