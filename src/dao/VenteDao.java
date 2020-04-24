/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Vente;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class VenteDao extends AbstractDao<Vente>{
       
    public VenteDao () {
        super(Vente.class);
    }
   /* public long getLastIdVente(){
        List<Vente> ventes=new ArrayList<Vente>();
        try {
            ventes=load("select id from vente order by id desc limit 1");
        } catch (Exception ex) {
            Logger.getLogger(VenteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(ventes.get(0).getId());
       return 2;
    }*/
  public void saveVent(double total,double totalpayee,Long idClient) throws SQLException{
      LocalDate datevente = LocalDate.now();
      String requette="";
      if (idClient == null)
            requette ="insert into vente (date_vente,total,totalPayee,clientv) values('"+datevente.toString()+"',"+total+","+totalpayee+","+null+")";
        else
                      requette ="insert into vente (date_vente,total,totalPayee,clientv) values('"+datevente.toString()+"',"+total+","+totalpayee+","+idClient.longValue()+")";

      ConnectDB.exec(requette);
    
  }
}
