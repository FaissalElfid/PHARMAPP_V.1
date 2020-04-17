/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.table;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Faissal
 */
public class Medicament {
         private String id;
         private final SimpleIntegerProperty codeProperty;
         private final  SimpleStringProperty libelleProperty;
         private final SimpleStringProperty categorieProperty;

        public Medicament(Integer codeProperty, String libelleProperty, String categorieProperty) {
            this.codeProperty = new SimpleIntegerProperty(codeProperty);
            this.libelleProperty =new SimpleStringProperty(libelleProperty);
            this.categorieProperty = new SimpleStringProperty(categorieProperty);
        }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
        

        public Integer getCodeProperty() {
            return codeProperty.get();
        }

        public void setCodeProperty(Integer code) {
           codeProperty.set(code);
        }

        public String getLibelleProperty() {
            return libelleProperty.get();
        }

        public void setLibelleProperty(String libelle) {
            libelleProperty.set(libelle);
        }

        public String getCategorieProperty() {
            return categorieProperty.get();
        }

        public void setCategorieProperty(String categorie) {
            categorieProperty.set(categorie);
        }
         
}