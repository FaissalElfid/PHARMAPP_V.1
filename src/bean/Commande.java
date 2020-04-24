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
public class Commande {
    
    private long id;
    private String reference;
    private Date dateCommande;
    private Utilisateur fournisseur;
    private CommandeEtat commandeEtat;
    private List<CommandeDetails> commandeDetailses;

    //getters

    public long getId() {
        return id;
    }
    
    public String getReference() {
        return reference;
    }
    
    public Date getDateCommande() {
        return dateCommande;
    }
    
    public Utilisateur getFournisseur() {
        return fournisseur;
    }
    
    public CommandeEtat getCommandeEtat() {
        return commandeEtat;
    }

    public List<CommandeDetails> getCommandeDetailses() {
        return commandeDetailses;
    }
    
    //setters

    public void setId(long id) {
        this.id = id;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }
    
    public void setFournisseur(Utilisateur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public void setCommandeEtat(CommandeEtat commandeEtat) {
        this.commandeEtat = commandeEtat;
    }

    public void setCommandeDetailses(List<CommandeDetails> commandeDetailses) {
        this.commandeDetailses = commandeDetailses;
    }
    
    //costructeurs

    public Commande() {
    }

    public Commande(long id, String reference, Date dateCommande) {
        this.id = id;
        this.reference = reference;
        this.dateCommande = dateCommande;
    }

    public Commande(long id, Date dateCommande, Utilisateur fournisseur) {
        this.id = id;
        this.dateCommande = dateCommande;
        this.fournisseur = fournisseur;
    }

    public Commande(long id, String reference, Date dateCommande, Utilisateur fournisseur, CommandeEtat commandeEtat) {
        this.id = id;
        this.reference = reference;
        this.dateCommande = dateCommande;
        this.fournisseur = fournisseur;
        this.commandeEtat = commandeEtat;
    }
   
    public Commande(long id, String reference, Date dateCommande, Utilisateur fournisseur, CommandeEtat commandeEtat, List<CommandeDetails> commandeDetailses) {
        this.id = id;
        this.reference = reference;
        this.dateCommande = dateCommande;
        this.fournisseur = fournisseur;
        this.commandeEtat = commandeEtat;
        this.commandeDetailses = commandeDetailses;
    }
    
    //toString

    @Override
    public String toString() {
        return "Commande{" + "id=" + id + ", dateCommande=" + dateCommande + ", commandeEtat=" + commandeEtat + ", commandeDetailses=" + commandeDetailses + '}';
    }

    

    
    
}
