/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import bean.Connexion;

/**
 *
 * @author Faissal
 */
public class ConnexionDao extends AbstractDao<Connexion> {
    public ConnexionDao() {
        super(Connexion.class);
    }
 
    public Connexion findByEmployeId(Long idEmploye) throws Exception{
           return loadOne("SELECT * FROM 'employeconnexion' WHERE employe='"+idEmploye+"'");
       }
}
