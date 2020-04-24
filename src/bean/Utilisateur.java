/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Soulaimane
 */
public class Utilisateur {
    
    private long id;
    private String login;
    private String password;
    private String cne;
    private String nom;
    private String prenom;
    private String adresse;
    private String email;
    private String rib;
    private String telephone;
    private Role role;
    
    //getters

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getCne() {
        return cne;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getEmail() {
        return email;
    }

    public String getRib() {
        return rib;
    }

    public String getTelephone() {
        return telephone;
    }

    public Role getRole() {
        return role;
    }
    
    //setters

    public void setId(long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
    //constructeurs

    public Utilisateur() {
    }

    public Utilisateur(String login, String password, String cne, String nom, String prenom, String adresse, String email, String rib, String telephone) {
        this.login = login;
        this.password = password;
        this.cne = cne;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.rib = rib;
        this.telephone = telephone;
    }

    public Utilisateur(long id, String login, String password, String cne, String nom, String prenom, String adresse, String email, String rib, String telephone, Role role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.cne = cne;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.rib = rib;
        this.telephone = telephone;
        this.role = role;
    }
    
    //toString

    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", login=" + login + ", password=" + password + ", cne=" + cne + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", email=" + email + ", rib=" + rib + ", telephone=" + telephone + ", role=" + role + '}';
    }
    
    
}
