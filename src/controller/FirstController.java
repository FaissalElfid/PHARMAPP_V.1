/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Produit;
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
import view.table.Medicament;
import view.table.Table_Commande;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import dao.ProduitDao;
import java.io.File;
import java.net.MalformedURLException;
import javafx.animation.PauseTransition;
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
import javafx.util.Duration;
import service.ProduitService;

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
    private JFXTextField codeProduitField, designationProduitField, prixVenteField, quantiteStockField, marqueProduitField, categorieProduitField;
    
     @FXML
    private Label resultatAjoutProduitLabel;
     
    @FXML
    private AnchorPane anchor_medic, anchor_client ,anchor_emp;
  @FXML
  private Circle img_emp;
    @FXML
    private AnchorPane anchor_commandes;
    
    @FXML
    private TableView<Produit> table_medic;

    @FXML
    private TableColumn<Produit,String> table_medic_code;

    @FXML
    private TableColumn<Produit, String> table_medic_libelle;

    @FXML
    private TableColumn<Produit, String> table_medic_categorie;
    
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
    private JFXTextArea remarqueProduitArea;

    @FXML
    private JFXDatePicker dateExpirationField;

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
        
        updateTableViewProduits();
 

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
    public void updateTableViewProduits(){
        ProduitService ps = new ProduitService();
             try {
                 ps.affichage(table_medic, table_medic_code, table_medic_libelle, table_medic_categorie);
             } catch (Exception ex) {
                 Logger.getLogger(FirstController.class.getName()).log(Level.SEVERE, null, ex);
             }
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
        private void montrer(Label label, int seconds){
        label.setVisible(true);
        PauseTransition visiblePause = new PauseTransition(
            Duration.seconds(seconds)
            );
            visiblePause.setOnFinished(
            event -> label.setVisible(false)
                );
            visiblePause.play();
    }
    private boolean validate(String text)
    {
        return text.matches("[0-9]*");
    }
    @FXML
    private void saveProduit(ActionEvent e) throws Exception {
        
        if(codeProduitField.getText().length()==0|| categorieProduitField.getText().length()==0 ||designationProduitField.getText().length() ==0||prixVenteField.getText().length() ==0||quantiteStockField.getText().length() ==0 ||dateExpirationField.getValue().equals(null)||remarqueProduitArea.getText().length()==0 || marqueProduitField.getText().length()==0){
         // le message d'erreur pour les champs vides

            resultatAjoutProduitLabel.setStyle("-fx-text-fill : red");
            resultatAjoutProduitLabel.setText("veuillez remplir tous les champs (*) obligatoire");
            
            montrer(resultatAjoutProduitLabel,4);
        }
            else{
             if(validate(prixVenteField.getText())== false || validate(quantiteStockField.getText())== false){
             System.out.println("entrer un nombre a la place reservé");
             resultatAjoutProduitLabel.setStyle("-fx-text-fill : red");
            resultatAjoutProduitLabel.setText("entrer un nombre a la place reservé");
            montrer(resultatAjoutProduitLabel,4);
         }
         else{
            // ici tous les champs sont remplis
            Produit produit = new Produit();
        ProduitDao produitDao = new ProduitDao();
        String code;
        code = codeProduitField.getText();
            if( produitDao.findById(code) != null){
                   // l'exeption pour l'unicité de la clé primaire code produit
            resultatAjoutProduitLabel.setStyle("-fx-text-fill : red");
            resultatAjoutProduitLabel.setText("Le code du produit existe déja");
            montrer(resultatAjoutProduitLabel,4);
        
                    }
        else{
        produit.setCategorie(categorieProduitField.getText());
        produit.setId(code);
        produit.setMarque(marqueProduitField.getText());
        produit.setDesignation(designationProduitField.getText());
        produit.setRemarque(remarqueProduitArea.getText());
        produit.setDateExp(dateExpirationField.getValue().toString());
        produit.setPrixVente(Double.parseDouble(prixVenteField.getText()));
        produit.setQuantiteStock(Integer.parseInt(quantiteStockField.getText()));
        produitDao.save(produit);
        codeProduitField.setText("");
        designationProduitField.setText("");
          prixVenteField.setText("");
          quantiteStockField.setText("");
          marqueProduitField.setText("");
          remarqueProduitArea.setText("");
          categorieProduitField.setText("");
          quantiteStockField.setText("");
          prixVenteField.setText("");
          resultatAjoutProduitLabel.setStyle("-fx-text-fill : green");
          resultatAjoutProduitLabel.setText("Le produit est enregistrer avec succé");
          montrer(resultatAjoutProduitLabel,3); 
          updateTableViewProduits();
        }
    }} 
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
