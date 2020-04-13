/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXToggleButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;

/**
 *
 * @author Faissal
 */
public class VentesController implements Initializable {
    
     @FXML
    private JFXToggleButton toggle_btn_passager;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        toggle_btn_passager.selectedProperty().addListener(new ChangeListener < Boolean >()
        {
        @Override
        public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2){
         if (toggle_btn_passager.isSelected() == true){
             toggle_btn_passager.setText("passager");
         }   
         else{
             toggle_btn_passager.setText("Demande de credit");
         }
        }
        });

    
}
}
