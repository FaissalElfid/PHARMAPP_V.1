/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.awt.Checkbox;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Faissal
 */
public class Table_Commande{
         private final SimpleIntegerProperty idProperty;
         private final SimpleStringProperty libelleProperty;
         private final SimpleIntegerProperty quantiteProperty;
         private final SimpleBooleanProperty statutProperty;
         private Checkbox select;

    public Table_Commande(Integer id, String libelleProperty, Integer quantiteProperty) {
        this.idProperty = new SimpleIntegerProperty(id);
        this.libelleProperty = new SimpleStringProperty(libelleProperty);
        this.statutProperty = new SimpleBooleanProperty(true);
        this.quantiteProperty = new SimpleIntegerProperty(quantiteProperty);
    }

    public Integer getIdProperty() {
        return idProperty.get();
    }

    public void setIdProperty(Integer id) {
        idProperty.set(id);
    }


    public String getLibelleProperty() {
        return libelleProperty.get();
    }

    public void setLibelleProperty(String libelle) {
        this.libelleProperty.set(libelle);
    }
    public Integer getQuantiteProperty() {
        return quantiteProperty.get();
    }

    public void setQuantiteProperty(Integer qtt) {
        this.quantiteProperty.set(qtt);
    }
    public Boolean getStatutProperty() {
        return statutProperty.get();
    }

    public void setStatutProperty(Boolean qtt) {
        this.statutProperty.set(qtt);
    }

    public Checkbox getSelect() {
        return select;
    }

    public void setSelect(Checkbox select) {
        this.select = select;
    }
    
    
         
         
         
         
         
}
