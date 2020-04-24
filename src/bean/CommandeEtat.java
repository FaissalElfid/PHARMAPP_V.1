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
public class CommandeEtat {
    
    private long id;
    private String libelle;
    private int code;
    
    //getters

    public long getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public int getCode() {
        return code;
    }
    
    //setters

    public void setId(long id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setCode(int code) {
        this.code = code;
    }
    
    //contructeurs

    public CommandeEtat() {
    }

    public CommandeEtat(long id, String libelle, int code) {
        this.id = id;
        this.libelle = libelle;
        this.code = code;
    }
    
    //toString

    @Override
    public String toString() {
        return "CommandeEtat{" + "id=" + id + ", libelle=" + libelle + ", code=" + code + '}';
    }
    
    
    
}
