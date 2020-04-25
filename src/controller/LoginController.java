/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import service.ConnexionService;

/**
 *
 * @author Faissal
 */
public class LoginController {
    @FXML
    private JFXButton btn_login;
     @FXML
    private JFXTextField loginField;

    @FXML
    private JFXPasswordField passwordField;
    
    @FXML
    void loginInAction(ActionEvent event) throws Exception {
//        ConnexionService ecs = new ConnexionService();
//        int res = ecs.seConnecter(loginField.getText(), passwordField.getText());
        //if(res != 1){
//                        Alert a = new Alert(Alert.AlertType.NONE); 
//                        a.setAlertType(Alert.AlertType.ERROR); 
//                        a.setContentText("Echec de connexion");
//                        a.show();
        //}else if(res == 1 || loginField.getText().length()==0 ){
        btn_login.getScene().getWindow().hide();

            Parent root= null;

        try {

            root = FXMLLoader.load(getClass().getResource("/pharmapp_test/FXMLDocument.fxml"));
            

        } catch (IOException ex) {

            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);

        }

            Stage stage = new Stage();

            Scene scene = new Scene(root);

            stage.setScene(scene);
            Image icon = new Image("/images/logo.png");
        stage.getIcons().add(icon);
        stage.setTitle("PHARMAPP");

            stage.show();
       // }
    }
    @FXML
    void informationOublier(ActionEvent event) {
        Parent root= null;
        try {
            root = FXMLLoader.load(getClass().getResource("/view/RecupererLePassword.fxml"));            
        } catch (IOException ex) {
           Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Informations oublier");
            stage.show();

    }
}
