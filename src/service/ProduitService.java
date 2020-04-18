/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Produit;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import dao.ProduitDao;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import view.table.Medicament;

/**
 *
 * @author Faissal
 */
//    public Produit(String id, String designation, int quantiteStock, double prixVente, String categorie, String marque, String remarque, Date dateExp) 
//'Wed Jan 01 00:04:00 WET 2020
public class ProduitService {
    private ProduitDao produitDao= new ProduitDao();
    Date date = Calendar.getInstance().getTime();

        // Display a date in day, month, year format
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String today = formatter.format(date);
    public void initDb() throws Exception{
         Produit prod = new Produit("2","doliprane",30,50,"comprimé de fievre","jsp","boite de 5 piece");
         prod.setDateExp(today);
        produitDao.save(prod);
    }

    public void affichage(TableView<Produit> table_medic, TableColumn<Produit,String> table_medic_code, TableColumn<Produit, String> table_medic_libelle, TableColumn<Produit, String> table_medic_categorie, TableColumn<Produit, Number> table_prod_prix, TableColumn<Produit, Number> table_prod_quantite, TableColumn<Produit, String> table_prod_marque, TableColumn<Produit, String> table_prod_dateExp, TableColumn<Produit, String> table_prod_remarque) throws Exception{
        
final ObservableList<Produit> produits = FXCollections.observableArrayList(
                produitDao.findAll()
);
        System.out.println(produits);
        table_medic_code.setCellValueFactory(new PropertyValueFactory<>("id"));
        table_medic_libelle.setCellValueFactory(new PropertyValueFactory<>("designation"));
        table_prod_prix.setCellValueFactory(new PropertyValueFactory<>("prixVente"));
        table_prod_marque.setCellValueFactory(new PropertyValueFactory<>("marque"));
        table_prod_dateExp.setCellValueFactory(new PropertyValueFactory<>("dateExp"));
        table_prod_quantite.setCellValueFactory(new PropertyValueFactory<>("quantiteStock"));
        table_prod_remarque.setCellValueFactory(new PropertyValueFactory<>("remarque"));
        table_medic_categorie.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        
        
        table_medic.setItems(produits);    
}

    
    
    
    
    
}

