/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Employe;
import bean.ConnexionEmp;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import dao.ConnexionDao;
import dao.EmployeDao;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.WindowEvent;
import service.ConnexionService;
import static util.DateUtil.format;
import util.HashUtil;
/**
 *
 * @author Faissal
 */
public class FormulaireConnexionEmployeController  implements Initializable{
     @FXML
    private JFXTextField txtLogin;

    @FXML
    private JFXPasswordField passwordField;

    @FXML
    private JFXPasswordField confirmerPasswordField;

    @FXML
    private JFXComboBox<String> comboRole;

    @FXML
    private JFXComboBox<String> comboPrevilege;

    @FXML
    private JFXButton btnAjouterConnexion;

    @FXML
    private JFXButton btnAnnuler;

     @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboRole.getItems().addAll("Gérant","Administrateur","Vendeur","Pharmacien","Autre");
        comboPrevilege.getItems().addAll("Niveau 1","Niveau 2","Niveau 3");
    }
    @FXML
    void ajoutEmployeConnexion(ActionEvent event) throws Exception {
        ConnexionDao ecd = new ConnexionDao();
        HashUtil coder = new HashUtil();
        //ecs.ajouterEmployeConnexion(id, txtLogin.getText(), comboPrevilege.getSelectionModel().getSelectedItem(), comboRole.getSelectionModel().getSelectedItem(), passwordField.getText(), false);

            ConnexionEmp employeConnexion = new ConnexionEmp();
            employeConnexion = FirstController.getEmployeConnexionId();
            if(employeConnexion == null){
                System.out.println("L employe que vous demander n xiste pas");
                
            }
            else{
                if(passwordField.getText().equals(confirmerPasswordField.getText()) == false){
                    Alert a = new Alert(AlertType.NONE); 
                        a.setAlertType(AlertType.ERROR); 
                        a.setContentText("Veuillez confirmer le mot de passe");
                        a.show();
                }else{
                Date date = new Date();
                employeConnexion.setBlocked(false);
                employeConnexion.setChangementPassword(format(date));
                employeConnexion.setLogin(txtLogin.getText());
                employeConnexion.setPassword(coder.encryptPassword(passwordField.getText()));
                employeConnexion.setPrevilege(comboPrevilege.getSelectionModel().getSelectedItem());
                employeConnexion.setRole(comboRole.getSelectionModel().getSelectedItem());
                employeConnexion.setTentative(3);
                employeConnexion.setConnected(false);
                ecd.update(employeConnexion);

        
        btnAjouterConnexion.getScene().getWindow().fireEvent(new WindowEvent(
            btnAjouterConnexion.getScene().getWindow(), WindowEvent.WINDOW_CLOSE_REQUEST));
            btnAjouterConnexion.getScene().getWindow().hide();
                            }
            }
    }
    
    
    
    @FXML
    void annuler(ActionEvent event) {
        btnAnnuler.getScene().getWindow().fireEvent(new WindowEvent(
            btnAnnuler.getScene().getWindow(), WindowEvent.WINDOW_CLOSE_REQUEST));
            btnAnnuler.getScene().getWindow().hide();
    }
    
}
