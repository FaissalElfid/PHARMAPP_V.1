/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Employe;
import bean.Connexion;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dao.ConnexionDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.WindowEvent;
import service.ConnexionService;
import service.EmployeService;


public class RecupererlePasswordController implements Initializable{

    @FXML
    private AnchorPane pageCodeActivationAnchor;

    @FXML
    private JFXTextField codeField, cinField;

    @FXML
    private AnchorPane affichageAnchor;

    @FXML
    private Label lblLogin;

    @FXML
    private Label lblPassword;

    @FXML
    private AnchorPane pageCin;

    @FXML
    private JFXButton btnRecuperer, btnFermer;
    
    private EmployeService es = new EmployeService();
    private Employe employe = new Employe();
    private Connexion ec = new Connexion();
    private ConnexionDao ecs = new ConnexionDao();
    private ConnexionService ecService = new ConnexionService();
    private double aleatoire;
    private double aleatoire2;

    @FXML
    void fermer(ActionEvent event) {
        btnFermer.getScene().getWindow().fireEvent(new WindowEvent(
            btnFermer.getScene().getWindow(), WindowEvent.WINDOW_CLOSE_REQUEST));
            btnFermer.getScene().getWindow().hide();
    }

    @FXML
    void recupereInAction(ActionEvent event) throws Exception {
        
        String cin = cinField.getText();
        employe = es.findByCin(cin);
        if(employe == null){
            afficherAlertWarning("Le code cin introuvable");
        }
        else{
            aleatoire = Math.random()*(9999 - 0);
            System.out.println("le code d'activation est egale a :" +aleatoire);
            pageCodeActivationAnchor.toFront();
        }

    }

    @FXML
    void validerLeCode(ActionEvent event) throws Exception {
        double nbr = Double.parseDouble(codeField.getText());
        if(nbr != aleatoire){
            afficherAlertWarning("le code est incorrect");
    }
        else{
            String passwd;
            affichageAnchor.toFront();
            //String x = ""+employe.getId();
            ec = ecs.findById(employe.getId());
            lblLogin.setText(ec.getLogin());
            aleatoire2 = Math.random()*(9999 - 0);
            passwd = ""+aleatoire2;
            ecService.changerPassword(ec.getLogin(),ec.getPassword(),passwd);
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //pageCin.toFront();
    }
    void afficherAlertWarning(String message){
        Alert a = new Alert(Alert.AlertType.NONE); 
                a.setAlertType(Alert.AlertType.WARNING); 
                    a.setContentText(message);
                a.show();
        }



    
}
