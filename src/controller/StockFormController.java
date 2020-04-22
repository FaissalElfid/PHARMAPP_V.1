/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Stock;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dao.StockDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 *
 * @author Faissal
 */
public class StockFormController {
    @FXML
    private JFXTextField quantite;

    @FXML
    private JFXTextField seuilMin;

    @FXML
    private JFXTextField quantiteDefec;

    @FXML
    private JFXButton ajouter;

    @FXML
    void saveProduit(ActionEvent event) throws Exception {
        ajouter.getScene().getWindow().hide();
        FirstController fc = new FirstController();
        Stock stock = new Stock();
        Long code = fc.getCode();
        StockDao stockDao= new StockDao();
        stock = stockDao.findById(code);
        stock.setQuantitDefectueise(Double.parseDouble(quantiteDefec.getText()));
        stock.setQuantitemin(Double.parseDouble(seuilMin.getText()));
        stock.setQuantite(Double.parseDouble(quantite.getText()));
        stockDao.update(stock);

    }
    
    
}
