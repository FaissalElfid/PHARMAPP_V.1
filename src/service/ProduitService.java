/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Produit;
import bean.Stock;
import dao.ProduitDao;
import dao.StockDao;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import util.PanierLigne;
import view.table.TableStock;

/**
 *
 * @author Faissal
 */
//    public Produit(String id, String designation, int quantiteStock, double prixVente, String categorie, String marque, String remarque, Date dateExp) 
//'Wed Jan 01 00:04:00 WET 2020
public class ProduitService {
        
     
    public void affichage(TableView<TableStock> table_medic, TableColumn<TableStock,String> table_medic_code, TableColumn<TableStock, String> table_medic_libelle, TableColumn<TableStock, String> table_medic_categorie, TableColumn<TableStock, Number> table_prod_prix, TableColumn<TableStock, Number> table_prod_quantite, TableColumn<TableStock, String> table_prod_marque, TableColumn<TableStock, String> table_prod_dateExp, TableColumn<TableStock, String> table_prod_remarque) throws Exception{
        
        
        StockService stockservice = new StockService();
        
        ProduitDao pd = new ProduitDao();
        
        List<Stock> stocks = stockservice.findAll();
           List<TableStock> produits = new ArrayList<>();
        for (Stock stck: stocks) {
            TableStock tb = new TableStock();
            Produit produit = new Produit();
            Stock stock = new Stock();
            System.out.println(stck.getId());
            produit = pd.findById(stck.getId());
            tb.setCategorie(produit.getCategorie());
            tb.setMarque(produit.getMarque());
            tb.setId(stck.getId());
            tb.setDateExp(produit.getDateExp());
            tb.setQuantiteStock(stck.getQuantite());
            tb.setPrixVente(produit.getPrixVente());
            tb.setRemarque(produit.getRemarque());
            tb.setDesignation(produit.getDesignation());
            System.out.println(tb);
            produits.add(tb);
        }
        ObservableList<TableStock> medi = FXCollections.observableArrayList(produits);
        table_medic_code.setCellValueFactory(new PropertyValueFactory<>("id"));
        table_medic_libelle.setCellValueFactory(new PropertyValueFactory<>("designation"));
        table_prod_prix.setCellValueFactory(new PropertyValueFactory<>("prixVente"));
        table_prod_marque.setCellValueFactory(new PropertyValueFactory<>("marque"));
        table_prod_dateExp.setCellValueFactory(new PropertyValueFactory<>("dateExp"));
        table_prod_quantite.setCellValueFactory(new PropertyValueFactory<>("quantiteStock"));
        table_prod_remarque.setCellValueFactory(new PropertyValueFactory<>("remarque"));
        table_medic_categorie.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        
        
        table_medic.setItems(medi);    
}
    public double ajouterPanier(TableView<PanierLigne> panierTableView,List<PanierLigne> panier, String codeProduit, double qtt) throws Exception{
        PanierLigne panierLigne = new PanierLigne(); 
        ProduitDao produitDao = new ProduitDao();
        StockDao stockDao = new StockDao();
        Stock stock = new Stock();
        Produit produit = new Produit();
        double total = 0;
        produit = produitDao.findById(codeProduit);
        stock = stockDao.findById(codeProduit);
        if(produit == null){
            System.out.println("le code produit que vous demander est introuvable");
            Alert a = new Alert(Alert.AlertType.NONE); 
                a.setAlertType(Alert.AlertType.WARNING); 
                a.setContentText("Ce code produit n'existe pas dans le stock");
                a.show();
                return 0;
        }
        else{
            if(stock.getQuantite() == 0){
                Alert a = new Alert(Alert.AlertType.NONE); 
                a.setAlertType(Alert.AlertType.WARNING); 
                a.setContentText("Ce produit n'existe plus dans le stock !!");
                a.show();
            }
                else{
            if(stock.getQuantite() > qtt){
               panierLigne.setQuantiteCommande(qtt);
            }
            else if(stock.getQuantite() < qtt){
                panierLigne.setQuantiteCommande(stock.getQuantite());
                Alert a = new Alert(Alert.AlertType.NONE); 
                // set alert type 
                a.setAlertType(Alert.AlertType.WARNING); 
                    // show the dialog 
                    a.setContentText("On ne peut vendre que ce qu'il reste dans le stock !! ");
                a.show();
            }
            
            panierLigne.setCode_prod(produit.getId());
            panierLigne.setCategorie(produit.getCategorie());
            panierLigne.setDesignation(produit.getDesignation());
            panierLigne.setPrixUnitaire(produit.getPrixVente());
            panierLigne.setQuantiteStock(stock.getId());
            panierLigne.setTotal(panierLigne.getTotal());
            panier.add(panierLigne);
            final ObservableList<PanierLigne> obspanier = FXCollections.observableArrayList(
                panier
);
            panierTableView.setItems(obspanier);
            for(PanierLigne pl: panier){
            total = total + pl.getTotal();
            }
            
            }
            return total;
        }
    }
        public Produit findbylibelle(String lib,List<Produit> pros){
        for (Produit pro : pros) {
            if(pro.getDesignation() == lib){
                return pro;
            }
        }
        
        return null;
       
   }
   public  int save(Produit produit) throws Exception{
       ProduitDao produitDao = new ProduitDao();
       if (produitDao.findById(produit.getId()) != null){
           return -1;
       }else {
           produitDao.save(produit);
           return 1;
       }
   }
    
    public Produit findById(String id) throws Exception{
        ProduitDao produitDao = new ProduitDao();
        return produitDao.findById(id);
    }

    
    

    
    
    
    
    
}

