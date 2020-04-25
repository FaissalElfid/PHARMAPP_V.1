/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Utilisateur;
import dao.UtilisateurDao;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Faissal
 */
//    public Utilisateur(String id, int age, String nom, String prenom, String email, String adress, String cin, String rib, String telephone, String login, String password) {

public class UtilisateurService {

    public UtilisateurService() {
    }
    
    UtilisateurDao userDao = new UtilisateurDao();
    public void initDb() throws Exception{
       
        //userDao.save(new Utilisateur("f1", 29,"el fid","faissal","@gmail.com","taza","Z12345","erhtl","0682484660","Faissalelfid","mot de passe"));
    }
}
