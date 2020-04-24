/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.VenteDetaille;
import java.sql.SQLException;
import service.VenteService;

/**
 *
 * @author hp
 */
public class VenteDetailleDao extends AbstractDao<VenteDetaille>{
      VenteService venteService =new   VenteService();
    public VenteDetailleDao () {
        super(VenteDetaille.class);
    }
      public void saveVentDetaille(long id_vente,long id_produit,double qnt) throws SQLException {                                 
                           
     String requette="insert into ventedetaille (vente,produit,qntVendu) values("+id_vente+","+id_produit+","+qnt+")";
         ConnectDB.exec(requette);
    
  }
}
