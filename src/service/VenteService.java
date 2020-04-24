/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Vente;
import dao.VenteDao;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class VenteService {
    private VenteDao  venteDao= new VenteDao();
   
    public List<Vente> venteClient( long idClient) throws Exception{
        List<Vente> ventes=new ArrayList<Vente>();
          List<Vente> ventesClient=new ArrayList<Vente>();
        ventes=venteDao.findAll();
        for( Vente v :ventes){
            if(v.getClientv().getId()==idClient){
                
                 ventesClient.add(v);
            } 
               
            
        }
        return ventesClient;
    }
    public long getLastIdVente() throws Exception{
        List<Vente> ventes=new ArrayList<Vente>();
        ventes=venteDao.findAll();
        
      return ventes.get(ventes.size()-1).getId();
              
            
    }
       /*public void  saveVente(long id,double total,double totalpayee) throws Exception{
           //LocalDate datevente = LocalDate.now(); // Create a date object
           //System.out.println(datevente.toString());

          venteDao.save(new Vente(id,null,null,total,totalpayee));
           
           
           
           
       }   */
}
