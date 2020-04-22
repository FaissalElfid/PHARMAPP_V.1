/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Produit;
import bean.Stock;
import dao.ProduitDao;
import dao.StockDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a
 */
public class StockService {

    private ProduitDao produitDoa = new ProduitDao();
    private StockDao stockDao = new StockDao();

    public List<Produit> produitAlert() throws Exception {
        return null;//TODO : request from db
    }

    public Stock findByProduitId(Long id) throws Exception {
        
        return stockDao.findByProduitId(id);
    }

    public int save(Stock stock) throws Exception {
        ProduitService produitService= new ProduitService();
        if ( stockDao.findById(stock.getId()) != null) {
            return -1;
        } else {
            if (stock.getProduit() == null) {
                return -2;
            } else {
                Stock loadeStock = findByProduitId(stock.getProduit().getId());
                if (loadeStock == null) {
                    // ila l produi makanech save
                    produitService.save(stock.getProduit());
                    stockDao.save(stock);
                    return 1;
                }else{
                  loadeStock.setQuantite(loadeStock.getQuantite()+stock.getQuantite());
                  stockDao.update(loadeStock);
                  return 2;
                }
            }
        }

    }

    public List<Stock> findAll() throws Exception {
        return stockDao.findAll();
    }

    public Stock findById(Long id) throws Exception {
        return stockDao.findById(id);
    }
}
