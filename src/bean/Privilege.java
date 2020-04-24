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
public class Privilege {
    
    private long id;    
    private int page;
    private Role role;
    
    //getters

    public long getId() {
        return id;
    }

    public int getPage() {
        return page;
    }

    public Role getRole() {
        return role;
    }
    
    //setters

    public void setId(long id) {
        this.id = id;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
    //constructeurs

    public Privilege() {
    }

    public Privilege(long id, int page) {
        this.id = id;
        this.page = page;
    }

    public Privilege(long id, int page, Role role) {
        this.id = id;
        this.page = page;
        this.role = role;
    }
    
    //toString

    @Override
    public String toString() {
        return "Privilege{" + "id=" + id + ", page=" + page + '}';
    }
    
    
    
}
