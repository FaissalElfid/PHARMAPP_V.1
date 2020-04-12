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
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
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
    private JFXButton accueil;
         @FXML
    private Pane pnl_achats, pnl_ventes, pnl_reglement, pnl_fournisseurs;
    
    @FXML
    private JFXButton btn_ventes, btn_achats, btn_commandes, btn_Reglements, btn_menu_medicament;
    
    @FXML
    private JFXButton btn_client, btn_fournisseurs;
    
    @FXML
    private AnchorPane anchor_medic, anchor_client;

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        final ObservableList<Medicament> medicaments = FXCollections.observableArrayList(
                new Medicament(1,"doliprane","blabla"), 
                new Medicament(2, "Aspijique", "jsp"),
                new Medicament(3, "Vitamine C", "faissal"));
        System.out.println(medicaments);
        table_medic_code.setCellValueFactory(new PropertyValueFactory<>("codeProperty"));
        table_medic_libelle.setCellValueFactory(new PropertyValueFactory<>("libelleProperty"));
        table_medic_categorie.setCellValueFactory(new PropertyValueFactory<>("categorieProperty"));
        
        table_medic.setItems(medicaments);       

    } 
    
   @FXML
    private void handleButtonAction(ActionEvent event) {
        if(event.getSource()==btn_ventes){
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
        
    
    }
//@Override
//    public void initialize(URL url, ResourceBundle rb) {
//    }
    @FXML
    void imaneInAction(ActionEvent event) {

 

 accueil.getScene().getWindow().hide();

            Parent root= null;

        try {

            root = FXMLLoader.load(getClass().getResource("/view/imane.fxml"));

        } catch (IOException ex) {

            Logger.getLogger(FirstController.class.getName()).log(Level.SEVERE, null, ex);

        }

            Stage stage = new Stage();

            Scene scene = new Scene(root);

            stage.setScene(scene);

            stage.show();

    }
     
    
}
