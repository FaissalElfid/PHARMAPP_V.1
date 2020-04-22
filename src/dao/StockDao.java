/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Stock;

/**
 *
 * @author a
 */
public class StockDao extends AbstractDao<Stock>{
    
    public StockDao() {
        super(Stock.class);
    }
    
       public Stock findByProduitId(Long idProduit) throws Exception{
           return loadOne("SELECT * FROM stock WHERE produit='"+idProduit+"'");
       }
 
}
