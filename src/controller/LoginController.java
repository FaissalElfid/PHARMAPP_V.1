/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Faissal
 */
public class LoginController {
    @FXML
    private JFXButton btn_login;
    @FXML
    void loginInAction(ActionEvent event) {

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

    }
}
