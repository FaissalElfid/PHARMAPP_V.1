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
import java.util.Date;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import util.DateUtil;
import static util.DateUtil.format;
import util.HashUtil;

/**
 *
 * @author Faissal
 */
public class ConnexionService {
    
    HashUtil coder = new HashUtil();
    ConnexionDao ecd = new ConnexionDao();
    EmployeService es = new EmployeService();
    public Connexion findById(long id) throws Exception{
        Connexion ec = new Connexion();
        for (Connexion ecs: ecd.findAll()){
            if(ecs.getId() == id){
                return ecs;
            }
        }
        return null;
       }

    public Connexion findByLogin(String login) throws Exception{
        Employe e = es.findByLogin(login);
        for(Connexion employeConnexion: ecd.findAll()){
            if(employeConnexion.getLogin().equals(login)){
                return employeConnexion;
            }
        }
        return null;   
    }
    public int verifier(Connexion us, String password) {
	String code = coder.encryptPassword(password);
		if(us.getPassword().equals(code) == false) {
			System.out.println("password faux");
			return -2;
		}
		else {
			System.out.println("password true");
			return 1;
		}
	}
    public int deblocker(String login) throws Exception {
		Connexion userLoaded = new Connexion();
		userLoaded = findByLogin(login);
		if (userLoaded == null) {
			System.out.println("le login n'existe pas ");
                        afficherAlertWarning("le Login n'existe pas");
			return -1;
		}
		else {
			if(userLoaded.isBlocked()) {
				userLoaded.setTentative(3);
				userLoaded.setBlocked(false);
				ecd.update(userLoaded);
				System.out.println("le user vient d'etre debloquer");
                                afficherAlertWarning("le user vient d'etre debloquer");
				return 1;
			}
			else {System.out.println("le user est deja debloqué");
                        afficherAlertWarning("le user est deja debloqué");
			userLoaded.setTentative(3);
			ecd.update(userLoaded);
				return 0;
			}
	}
	}
    public int seConnecter(String login,String passwd) throws Exception {
		Connexion userLoaded = new Connexion();
		//HistoriqueConnexion hs = new HistoriqueConnexion();
		userLoaded = findByLogin(login);
		if (userLoaded == null) {
			System.out.println("le login n'existe pas ");
                        afficherAlertWarning("le Login n'existe pas");
			return -1;
		}
		else {
			if(userLoaded.isBlocked() == false) {
			if(userLoaded.getTentative() > 0) {
			if(verifier(userLoaded,passwd) == -2) {
				System.out.println("fail");
                                afficherAlertWarning("le mot de passe est incorrect");
				userLoaded.setConnected(false);
				userLoaded.setTentative(userLoaded.getTentative()-1);
				ecd.save(userLoaded);
				return -2;
			}
			else {
				//Date date_actuel = new Date();
				userLoaded.setConnected(true);
				System.out.println("tout marche");
				ecd.save(userLoaded);
				return 1;
			}
			}
			else {Block(userLoaded);return -3;}
		}
			else {System.out.println("ce user est blocker");
                        afficherAlertWarning("ce user est blocker");

                        return -4;
                        }
		}
	}
    	public int seDeconnecter(String login) throws Exception {
		Connexion userLoaded = new Connexion();
		userLoaded = findByLogin(login);
		if (userLoaded == null) {
			System.out.println("le login n'existe pas ");
                        afficherAlertWarning("le login n'existe pas ");
			return -1;
		}
		else {
			if(userLoaded.isBlocked() == false) {
//				Date date_actuel = new Date();
				userLoaded.setConnected(false);
//				hs= hcd.findByRef(hc);
//				hs.setDatedeconnexion(date_actuel);
//				hcd.save(hs);
				System.out.println("tout marche");
				ecd.update(userLoaded);
				return 1;
			}
			else {System.out.println("ce user est blocker"); 
                            afficherAlertWarning("ce user est blocker");
                            return -4;
                        }
		}
	}
        
	public void crypter(String login) throws Exception { //cette fonction suit le save pour coder le password
		Connexion user = new Connexion();
			user = 	findByLogin(login);
			if(user != null) {
		String code = coder.encryptPassword(user.getPassword());
		user.setPassword(code);
		ecd.update(user);
			}
	}
        //public int changementVerify(String login) 
	public void Block(Connexion user) throws Exception {
		user.setBlocked(true);
		ecd.update(user);
	}
        public int ajouterEmployeConnexion(long id, String login, String previlege, String role, String password, boolean blocked) throws Exception{
            Employe employe = new Employe();
            EmployeDao employeDao = new EmployeDao();
            Connexion employeConnexion = new Connexion();
            employe = employeDao.findById(id);
            employeConnexion = findById(id);
            if(employe == null){
                afficherAlertWarning("L'employe que vous demander n'xiste pas");
                return -1;
            }
            else{
                Date date = new Date();
                employeConnexion.setBlocked(blocked);
                employeConnexion.setChangementPassword(format(date));
                employeConnexion.setLogin(login);
                employeConnexion.setPassword(coder.encryptPassword(password));
                employeConnexion.setPrevilege(previlege);
                employeConnexion.setRole(role);
                employeConnexion.setTentative(3);
                employeConnexion.setConnected(false);
                ecd.update(employeConnexion);
                employeDao.update(employe);
                return 1;
            }
        }
        public int changementVerify(String login) throws Exception {
		Connexion user = new Connexion();
		user = findByLogin(login);
		if (user== null) {
			System.out.println("le login n'existe pas ");
			return -1;
		}
		else{
		DateUtil date = new DateUtil();
		String date_actuel = date.format(new Date());
                
		int periode;
		periode = date.periodMonth(user.getChangementPassword(),date_actuel);
		if(periode > 3) {
			System.out.println("vous devez changer votre mot de passe");
                        afficherAlertWarning("vous devez changer votre mot de passe");
			Block(user);
			return 1;
		}
		else {
			periode = 3- periode; 
			System.out.println("il vous reste "+periode+" mois pour changer avant que votre compte soit bloquer");
			afficherAlertWarning("il vous reste "+periode+" mois pour changer avant que votre compte soit bloquer");
                        return 0;
		}}
	}
        public int changerPassword(String login,String password,String newPassword) throws Exception {
		Connexion userLoaded = new Connexion();
		String date_actuel = format(new Date());
		userLoaded = findByLogin(login);
		if (userLoaded == null) {
			System.out.println("le login n'existe pas ");
			return -1;
		}
		else {
		if(verifier(userLoaded,password) == -2) {
			System.out.println("le password entrer est faux");
			userLoaded.setTentative(userLoaded.getTentative()-1);
			ecd.update(userLoaded);
			return -2;
		}else {
			String code = coder.encryptPassword(userLoaded.getPassword());
			userLoaded.setBlocked(false);
			System.out.println("tout marche");
			userLoaded.setTentative(3);
			userLoaded.setChangementPassword(date_actuel);
			userLoaded.setPassword(code);
			ecd.update(userLoaded);
			return 1;
		}
		}
	}
        void afficherAlertWarning(String message){
        Alert a = new Alert(AlertType.NONE); 
                a.setAlertType(AlertType.WARNING); 
                    a.setContentText(message);
                a.show();
        }

}
