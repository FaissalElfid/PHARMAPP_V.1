/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Client;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import dao.ClientDao;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;






public class FormulaireClientController implements Initializable {
    
        
    @FXML
     private  JFXButton btn_saveClient;
    
    @FXML
    private JFXTextField nomClient;

    @FXML
    private JFXTextField prenomClient;

    @FXML
    private JFXTextField cinClient;

    @FXML
    private JFXTextField teleClient;

    @FXML
    private JFXDatePicker dateNaissClient;

   
    @FXML
    private JFXTextField adresseClient;

    @FXML
    // save client "aicha"
     private void saveclient(ActionEvent event) throws Exception{
        ClientDao clientDao = new   ClientDao ();
        Client client = new Client(dateNaissClient.getValue().toString() ,nomClient.getText(),prenomClient.getText(),adresseClient.getText(),cinClient.getText(),teleClient.getText());
        clientDao.save(client);
        

    }
    

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
