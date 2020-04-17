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
public class Utilisateur {
    private String id;
    private static long count =0 ;
    private int age;
    private String nom;
    private String prenom;
    private String email;
    private String adress;
    private String cin;
    private String rib;
    private String telephone;
    private String login;
    private String password;
    

    public Utilisateur(int age, String nom, String prenom, String email, String cin, String telephone, String login,String password) {
        id =""+count;
        this.age = age;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.cin = cin;
        this.telephone = telephone;
        this.login = login;
    }

    public Utilisateur(String id, int age, String nom, String prenom, String email, String adress, String cin, String rib, String telephone, String login, String password) {
        this.id = id;
        this.age = age;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adress = adress;
        this.cin = cin;
        this.rib = rib;
        this.telephone = telephone;
        this.login = login;
        this.password = password;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }
    

    public static long getCount() {
        return count;
    }

    public static void setCount(long count) {
        Utilisateur.count = count;
    }
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Personne{" + "age=" + age + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", cin=" + cin + ", telephone=" + telephone + ", login=" + login + '}';
    }
       
    
    
    
    
    
}
