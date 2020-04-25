/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Employe;
import bean.Connexion;
import dao.ConnexionDao;
import dao.EmployeDao;
import java.util.List;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Faissal
 */
public class EmployeService {
        EmployeDao employeDao = new EmployeDao();
        ConnexionDao employeConnexionDao = new ConnexionDao();
        

     public Employe findByLogin(String login) throws Exception{
        
        Employe e = new Employe();
        List<Employe> employes;
        employes = employeDao.findAll();
        for(Employe employe: employes){
            Connexion ec = new Connexion();
            ConnexionService ecs = new ConnexionService();
            ec = employeConnexionDao.findById(employe.getId());
            if(ec.getLogin().equals(login)){
                return employe;
            }
        }
        return null;
        
    }
     public Employe findByCin(String cin) throws Exception{
        List<Employe> employes;
        employes = employeDao.findAll();
        for(Employe employe: employes){
            if(employe.getCin().equals(cin)){
                return employe;
            }
        }
        return null;
     }
     //    public Employe(String id, int age, String nom, String prenom, String email, String adress, String cin, String rib, String telephone, EmployeConnexion employeConnexion) {

//     public long ajouterEmploye (String id, int age, String nom,  String prenom, String email, String adress, String cin, String rib, String telephone) throws Exception{
//         Employe employe = new Employe();
//         employe = employeDao.findById(id);
//         if(cin.length() == 0 || id.length() ==0){
//         afficherAlertWarning("Erreur : Veillez verifier le numero cin, age et le code employe que vous avez entrez");
//         return 0;
//         
//     }
//         else{
//         if(employe != null){
//             afficherAlertWarning("L'id de l'employe existe déja !!");
//             return 0;
//             
//         }
//         else{
//         //employe.setEmployeConnexion(new EmployeConnexion(id, "none","none","none",false,"none","none",false));
//         employe.setAdress(adress);
//         employe.setAge(age);
//         employe.setCin(cin);
//         employe.setEmail(email);
//         employe.setId(id);
//         employe.setNom(nom);
//         employe.setPrenom(prenom);
//         employe.setTelephone(telephone);
//         employe.setRib(rib);
//         employeDao.save(employe);
////         FXMLLoader fxmlLoader = new  FXMLLoader(getClass().getResource("/view/FormulaireConnexionEmploye.fxml"));
////               Parent root1=(Parent)fxmlLoader.load();
////               Stage stage=new Stage();
////              stage.setTitle("Connexion");
////              stage.setScene(new Scene(root1));
////              stage.setResizable(false);
////              stage.show();
////              stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
////            @Override
////            public void handle(WindowEvent event) {
////                //System.out.println("");
////            }
////         });
//          return id;       }     }
//     }
    public void afficherAlertWarning(String message){
        Alert a = new Alert(Alert.AlertType.NONE); 
                a.setAlertType(Alert.AlertType.WARNING); 
                a.setContentText(message);
                a.show();
        }
     
     
     
}
