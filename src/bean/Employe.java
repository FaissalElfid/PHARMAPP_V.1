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
public class Employe {
    private long id;
    private int age;
    private String nom;
    private String prenom;
    private String email;
    private String adress;
    private String cin;
    private String rib;
    private String telephone;
    
    

    public Employe() {
    }
    

    
    

    public Employe(int age, String nom, String prenom, String email, String cin, String telephone, String login,String password) {
        this.age = age;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.cin = cin;
        this.telephone = telephone;
    }

    public Employe(long id, int age, String nom, String prenom, String email, String adress, String cin, String rib, String telephone, String login, String password) {
        this.id = id;
        this.age = age;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adress = adress;
        this.cin = cin;
        this.rib = rib;
        this.telephone = telephone;
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

    public long getId() {
        return id;
    }
    

    public void setId(long id) {
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


    @Override
    public String toString() {
        return "Personne{" + "age=" + age + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", cin=" + cin + ", telephone=" + telephone + '}';
    }
       
    
    
    
    
    
}
