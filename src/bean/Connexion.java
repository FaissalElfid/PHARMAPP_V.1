/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Faissal
 */
public class Connexion {
    private long id;
    private String login;
    private String previlege;
    private String role;
    private boolean connected;
    /*information concernant le passwoord*/
    private String password;
    private int tentative = 3;
    private String changementPassword;
    private boolean blocked;
    private Employe employe;

    public Connexion() {

    }
    public Connexion(long id, String login, String previlege, String role, boolean connected, String password, String changementPassword, boolean blocked) {
        this.id = id;
        this.login = login;
        this.previlege = previlege;
        this.role = role;
        this.connected = connected;
        this.password = password;
        this.changementPassword = changementPassword;
        this.blocked = blocked;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

        public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }
    

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPrevilege() {
        return previlege;
    }

    public void setPrevilege(String previlege) {
        this.previlege = previlege;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTentative() {
        return tentative;
    }

    public void setTentative(int tentative) {
        this.tentative = tentative;
    }

    public String getChangementPassword() {
        return changementPassword;
    }

    public void setChangementPassword(String changementPassword) {
        this.changementPassword = changementPassword;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }
    

    @Override
    public String toString() {
        return "EmployeConnexion{" + "id=" + id + ", login=" + login + ", previlege=" + previlege + ", role=" + role + ", password=" + password + ", tentative=" + tentative + ", changementPassword=" + changementPassword + ", blocked=" + blocked + '}';
    }
    
    
    
    
    
    
    
    
    
    
}

