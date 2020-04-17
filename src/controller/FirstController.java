/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import Bean.Medicament;
import Bean.Table_Commande;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import java.io.File;
import java.net.MalformedURLException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Faissal
 */
public class FirstController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
         @FXML
    private Pane pnl_achats, pnl_ventes, pnl_reglement, pnl_fournisseurs;
    
    @FXML
    private JFXButton btn_ventes, btn_achats, btn_commandes, btn_Reglements, btn_menu_medicament;
    
    @FXML
    private JFXButton btn_client, btn_fournisseurs, btn_fileChoser, btn_empl;
    
    
    @FXML
    private AnchorPane anchor_medic, anchor_client ,anchor_emp;
  @FXML
  private Circle img_emp;
    @FXML
    private AnchorPane anchor_commandes;
    
    @FXML
    private TableView<Medicament> table_medic;

    @FXML
    private TableColumn<Medicament,Number> table_medic_code;

    @FXML
    private TableColumn<Medicament, String> table_medic_libelle;

    @FXML
    private TableColumn<Medicament, String> table_medic_categorie;
    
    @FXML
    private TableView<Table_Commande> table_alerts;

    @FXML
    private TableColumn<Table_Commande, Number> alert_id_produit;

    @FXML
    private TableColumn<Table_Commande, String> alert_libelle_produit;

    @FXML
    private TableColumn<Table_Commande, Number> alert_quantite;

    @FXML
    private TableColumn<Table_Commande, Boolean> alert_select;

    @FXML
    private JFXToggleButton toggle_btn_passager;
    
     @FXML
    private JFXTextField text_vente_code_client;
    @FXML
    private JFXComboBox combobox_emp;

    @FXML
    private Hyperlink text_vente_link_client;
     private String imageFile;
     
     ObservableList<String> emploi = FXCollections.observableArrayList("Gérant","Vendeur","Administrateur","Pharmacien");
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         Image image = new Image("/images/cravata.jpg");
         img_emp.setFill(new ImagePattern(image));
                 
        //ajoute des emploi dans combobox
        combobox_emp.setItems(emploi);
        
        /*table medicament dans alert commande*/
        final ObservableList<Table_Commande> alerts = FXCollections.observableArrayList(
        new Table_Commande(1,"doliprane",3),
        new Table_Commande(12,"EVOX 500 MG, ComprimÃ© pelliculÃ©",1),
        new Table_Commande(3,"Bavettes",2),
        new Table_Commande(5,"ALKERAN 2 MG, ComprimÃ©",0),   
        new Table_Commande(2,"INNOHEP 3500 UI ANTI-XA / 0,35 ML, Solution injectable",0),
        new Table_Commande(25,"DIETAZ, Solution buvable",2),   
        new Table_Commande(115,"ETOPOSIDE COOPER 50 MG, Capsule, Boite 4",01)   
        );
        System.out.println(alerts);
        table_alerts.setItems(alerts);
        alert_id_produit.setCellValueFactory(new PropertyValueFactory<>("idProperty"));
        alert_libelle_produit.setCellValueFactory(new PropertyValueFactory<>("libelleProperty"));
        alert_quantite.setCellValueFactory(new PropertyValueFactory<>("quantiteProperty"));
         alert_select.setEditable(true);
        alert_select.setCellValueFactory(new PropertyValueFactory<>("statutProperty"));
        alert_select.setCellFactory(CheckBoxTableCell.forTableColumn(alert_select));
        table_alerts.setEditable(true);
        
        /*table Medicament dans la rubrique table*/
        final ObservableList<Medicament> medicaments = FXCollections.observableArrayList(
                new Medicament(1,"doliprane","blabla"), 
                new Medicament(2, "Aspijique", "jsp"),
                new Medicament(3, "Vitamine C", "faissal"));
        System.out.println(medicaments);
        table_medic_code.setCellValueFactory(new PropertyValueFactory<>("codeProperty"));
        table_medic_libelle.setCellValueFactory(new PropertyValueFactory<>("libelleProperty"));
        table_medic_categorie.setCellValueFactory(new PropertyValueFactory<>("categorieProperty"));
        
        table_medic.setItems(medicaments);       

    toggle_btn_passager.selectedProperty().addListener(new ChangeListener < Boolean >()
        {
        @Override
        public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2){
         if (toggle_btn_passager.isSelected() == true){
             toggle_btn_passager.setText("Client passager");
             text_vente_code_client.setVisible(false);
             text_vente_link_client.setVisible(false);
         }   
         else{
             toggle_btn_passager.setText("Endettement client");
             text_vente_code_client.setVisible(true);
             text_vente_link_client.setVisible(true);
         }
        }
        });
    
    
    } 
    
   @FXML
    private void handleButtonAction(ActionEvent event) {
         System.out.println(event.getSource());
        if(event.getSource()== btn_ventes){
            pnl_ventes.toFront();
        }
        else if(event.getSource() == btn_achats){
            pnl_achats.toFront();
        }
        else if(event.getSource() == btn_commandes){
            anchor_commandes.toFront();
        }
        else if(event.getSource() == btn_menu_medicament){
            anchor_medic.toFront();
           
        }
        else if(event.getSource() == btn_client){
            anchor_client.toFront();
        }
        else if(event.getSource() == btn_fournisseurs){
            pnl_fournisseurs.toFront();
        }
        else if(event.getSource() == btn_Reglements){
            pnl_reglement.toFront();
        }
        else if(event.getSource() == btn_empl){
            
            anchor_emp.toFront();
            
        
        }
       
    
    }
   
   @FXML
   private void handleOnMouseClicked(MouseEvent event) throws MalformedURLException {
	   FileChooser fc=new  FileChooser();
                  fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files",
                        "*.bmp", "*.png", "*.jpg", "*.gif")); 
	   File f=fc.showOpenDialog(null);
	   if(f!=null) {
         imageFile = f.toURI().toURL().toString();
          Image image = new Image(imageFile);
         img_emp.setFill(new ImagePattern(image));

        } 
    }
		   
	   
	   
	   
  
//@Override
//    public void initialize(URL url, ResourceBundle rb) {
//    }
    
     
    
}
