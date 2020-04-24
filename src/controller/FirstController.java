/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Client;
import bean.Produit;
import bean.Stock;
import bean.Vente;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import view.table.TableStock;
import view.table.Table_Commande;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import dao.ClientDao;
import dao.ConnectDB;
import dao.ProduitDao;
import dao.StockDao;
import dao.VenteDao;
import dao.VenteDetailleDao;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.PauseTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import service.ProduitService;
import service.VenteService;
import util.PanierLigne;


/**
 * FXML Controller class
 *
 * @author Faissal
 */
public class FirstController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
         @FXML
    private Pane pnl_achats, pnl_ventes, pnl_reglement, pnl_fournisseurs;
    
    @FXML
    private JFXButton btn_ventes,btn_validerVente, btn_achats, btn_commandes, btn_Reglements, btn_menu_medicament;
    
    @FXML
    private JFXButton btn_client, btn_fournisseurs, btn_fileChoser, btn_empl,btn_voir_credit;
    
    @FXML
    private JFXTextField codeProduitField, designationProduitField, prixVenteField, quantiteStockField, marqueProduitField, categorieProduitField;
    
     @FXML
    private Label resultatAjoutProduitLabel,cinVenteClient,nomVenteClient,prenomVenteClient;
     
    @FXML
    private AnchorPane anchor_medic, anchor_client ,anchor_emp,pane_emp;
  @FXML
  private Circle img_emp;
    @FXML
    private AnchorPane anchor_commandes;
    //table client aicha 
     @FXML
    private TableView<Client> table_client;

    @FXML
    private TableColumn<Client ,String> col_cin;

    @FXML
    private TableColumn<Client , String> col_nom;

    @FXML
    private TableColumn<Client , String> col_prenom;

    @FXML
    private TableColumn<Client, String> col_dateNaiss;

    @FXML
    private TableColumn<Client, String> col_tele;

    @FXML
    private TableColumn<Client, String> col_adresse;
     //credit
 @FXML
    private TableView<Vente> table_credit;

    @FXML
    private TableColumn<Vente, Number> colNumvente;

    @FXML
    private TableColumn<Vente, String> colDateVente;

    @FXML
    private TableColumn<Vente, Number> colTotalVente;

    @FXML
    private TableColumn<Vente,Number > colMontantPaye;
//fin
    
     @FXML
    private TableView<TableStock> table_produits;

    @FXML
    private TableColumn<TableStock, String> table_prod_code;

    @FXML
    private TableColumn<TableStock, String> table_prod_libelle;

    @FXML
    private TableColumn<TableStock, String> table_prod_categorie;

    @FXML
    private TableColumn<TableStock, Number> table_prod_prix;
    
        @FXML
    private TableColumn<TableStock, Number> table_prod_quantite;

    @FXML
    private TableColumn<TableStock, String> table_prod_marque;

    @FXML
    private TableColumn<TableStock, String> table_prod_dateExp;

    @FXML
    private TableColumn<TableStock, String> table_prod_remarque;
    
    @FXML
    private TableView<Table_Commande> table_alerts;

    @FXML
    private TableColumn<Table_Commande, Number> alert_id_produit;

    @FXML
    private TableColumn<Table_Commande, String> alert_libelle_produit;

    @FXML
    private TableColumn<Table_Commande, Number> alert_quantite;

    @FXML
    private TableColumn<Table_Commande, Boolean> alert_select;
  


    @FXML
    private JFXToggleButton toggle_btn_passager;
    
     @FXML
    private JFXTextField text_vente_code_client;
    @FXML
    private JFXComboBox combobox_emp;
    
         @FXML
    private JFXTextArea remarqueProduitArea;

    @FXML
    private JFXDatePicker dateExpirationField;

    @FXML
    private Hyperlink text_vente_link_client;
     private String imageFile;
     
     /*nouveaux*/
     @FXML
    private AnchorPane modifierAnchorPane;

    @FXML
    private Label codeProduitModifier;

    @FXML
    private JFXDatePicker dateExpirationModifierField;

    @FXML
    private JFXTextField designationProduitModifierField, quantiteStockModifierField, marqueProduitModifierField, categorieProduitModifierField, prixVenteModifierField;

    @FXML
    private JFXTextArea remarqueProduitModifierArea;
    
    @FXML
    private JFXTextField findCodeProduit, findDesignation ,nom_emp,prenom_emp,adresse_emp;

    @FXML
    private AnchorPane modifierHomeAnchorPane;
    
    @FXML
    private JFXTabPane tabpane_medicament;
     @FXML
    private Tab tabMedicamentModifier,tabCredit;
     //faissal les objets ajouter le 22/04/2020
          @FXML
    private TableView<PanierLigne> panierTableView;

    @FXML
    private TableColumn<PanierLigne, String> codeProduitPanier;

    @FXML
    private TableColumn<PanierLigne, String> designationPanier;

    @FXML
    private TableColumn<PanierLigne, String> categoriePanier;

    @FXML
    private TableColumn<PanierLigne, Number> stockPanier;

    @FXML
    private TableColumn<PanierLigne, String> commandePanier;

    @FXML
    private TableColumn<PanierLigne, Number> prixPanier;

    @FXML
    private TableColumn<PanierLigne, Number> totalPanierTableau;
    
    @FXML
    private JFXTextField codeProduiPanier;

    @FXML
    private JFXTextField quantiteCommandePanier;
    @FXML
    private Label totalPrixPanier;
     @FXML
    private JFXTextField montantPayerPanier;
     
    
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        //aicha
        VenteService venteService =new VenteService();
          
             try {
                  long a;
                 a = venteService.getLastIdVente();
                 System.out.println(a);
             } catch (Exception ex) {
                 Logger.getLogger(FirstController.class.getName()).log(Level.SEVERE, null, ex);
             }
           
        
        
     //fin
   //par defaut   on vois pas le code et le toogle est de type)"cleint passaere
   toggle_btn_passager.setSelected(true);
   text_vente_code_client.setVisible(false);
        // tab credit cacher par defaut  aicha
        tabCredit.setDisable(true);
        tabCredit.setText("");
     
         Image image = new Image("/images/cravata.jpg");
         img_emp.setFill(new ImagePattern(image));
                 
        //ajoute des emploi dans combobox
         ObservableList<String> emploi = FXCollections.observableArrayList("Gérant","Vendeur","Administrateur","Pharmacien");
        combobox_emp.setItems(emploi);
        //link n'existe pas aud debut 
         text_vente_link_client.setVisible(false);
        modifierHomeAnchorPane.toFront();
        /*table employe
        
        */
        
        /*table medicament dans alert commande*/
        final ObservableList<Table_Commande> alerts = FXCollections.observableArrayList(
        new Table_Commande(1,"doliprane",3),
        new Table_Commande(12,"EVOX 500 MG, ComprimÃ© pelliculÃ©",1),
        new Table_Commande(3,"Bavettes",2),
        new Table_Commande(5,"ALKERAN 2 MG, ComprimÃ©",0),   
        new Table_Commande(2,"INNOHEP 3500 UI ANTI-XA / 0,35 ML, Solution injectable",0),
        new Table_Commande(25,"DIETAZ, Solution buvable",2),   
        new Table_Commande(115,"ETOPOSIDE COOPER 50 MG, Capsule, Boite 4",01)   
        );
      
        table_alerts.setItems(alerts);
        alert_id_produit.setCellValueFactory(new PropertyValueFactory<>("idProperty"));
        alert_libelle_produit.setCellValueFactory(new PropertyValueFactory<>("libelleProperty"));
        alert_quantite.setCellValueFactory(new PropertyValueFactory<>("quantiteProperty"));
         alert_select.setEditable(true);
        alert_select.setCellValueFactory(new PropertyValueFactory<>("statutProperty"));
        alert_select.setCellFactory(CheckBoxTableCell.forTableColumn(alert_select));
        table_alerts.setEditable(true);
        configTabPanier(panierTableView, codeProduitPanier, designationPanier,  categoriePanier , stockPanier,  commandePanier, prixPanier,  totalPanierTableau);

        updateTableViewProduits();
 

    toggle_btn_passager.selectedProperty().addListener(new ChangeListener < Boolean >()
        {
        @Override
        public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2){
         if (toggle_btn_passager.isSelected() == true){
             toggle_btn_passager.setText("Client passager");
             text_vente_code_client.setVisible(false);
             text_vente_link_client.setVisible(false);
         }   
         else{
             toggle_btn_passager.setText("Endettement client");
             text_vente_code_client.setVisible(true);
         
         }
        }
        });
    
    
    } 
    public void updateTableViewProduits(){
        ProduitService ps = new ProduitService();
             try {
                 ps.affichage(table_produits, table_prod_code, table_prod_libelle, table_prod_categorie, table_prod_prix, table_prod_quantite, table_prod_marque, table_prod_dateExp, table_prod_remarque);
             } catch (Exception ex) {
                 Logger.getLogger(FirstController.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
   /// aihcaa
    @FXML
        private  void btn_voir_credit(ActionEvent event){
         tabCredit.setDisable(false);
         tabCredit.setText(" Le Crédit");
         
        // anchor_credit.toBack();
         
    }
    
    //credit aicha:debut
        @FXML
        private void displaySelected(MouseEvent event) throws Exception{
            System.out.println("controller.FirstController.displaySelected()");
            Client client=table_client.getSelectionModel().getSelectedItem();
            if(client == null){
                System.out.println("nothing selected");
            }
            
            else{
                 cinVenteClient.setText(client.getCin());
                       nomVenteClient.setText(client.getNom());
                     prenomVenteClient .setText(client.getPrenom());
                     VenteService venteService =new VenteService ();
                        
                    VenteDao venteDao =new VenteDao();
         colNumvente.setCellValueFactory(new PropertyValueFactory<>("id"));
          colDateVente.setCellValueFactory(new PropertyValueFactory<>("date_vente"));
           colTotalVente.setCellValueFactory(new PropertyValueFactory<>("total"));
            colMontantPaye.setCellValueFactory(new PropertyValueFactory<>("totalPayee"));
            ObservableList<Vente> ventes = FXCollections.observableArrayList(venteService.venteClient(client.getId()));
                  table_credit.setItems(ventes);
            
            }
            
            
        }
        
        //fin aicha*/
   @FXML
    private void handleButtonAction(ActionEvent event) {
         System.out.println(event.getSource());
        if(event.getSource()== btn_ventes){
            pnl_ventes.toFront();
        }
        else if(event.getSource() == btn_achats){
            pnl_achats.toFront();
        }
        else if(event.getSource() == btn_commandes){
            anchor_commandes.toFront();
        }
        else if(event.getSource() == btn_menu_medicament){
            anchor_medic.toFront();
           
        }
        else if(event.getSource() == btn_client){
            //affichage du table client "aicha"
        ClientDao clientDao =new  ClientDao();
             try {
                 //client
                 final ObservableList<Client> clients = FXCollections.observableArrayList(clientDao.findAll());
                 
                 table_client.setItems(clients);
                 
                 
             } catch (Exception ex) {
                 Logger.getLogger(FirstController.class.getName()).log(Level.SEVERE, null, ex);
             }
             col_cin.setCellValueFactory(new PropertyValueFactory<>("cin"));
         col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
          col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
           col_dateNaiss.setCellValueFactory(new PropertyValueFactory<>("dateNaissance"));
            col_adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
             col_tele.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        
        
        
            anchor_client.toFront();
        }
        else if(event.getSource() == btn_fournisseurs){
            pnl_fournisseurs.toFront();
        }
        else if(event.getSource() == btn_Reglements){
            pnl_reglement.toFront();
        }
        else if(event.getSource() == btn_empl){
            
            anchor_emp.toFront();
            
        
        }
       
    
    }
    /* cette fonction est util pour ajouter un label pour un lapse de temps*/
        private void montrer(Label label, int seconds){
        label.setVisible(true);
        PauseTransition visiblePause = new PauseTransition(
            Duration.seconds(seconds)
            );
            visiblePause.setOnFinished(
            event -> label.setVisible(false)
                );
            visiblePause.play();
    }
    private boolean validate(String text)
    {
        return text.matches("[0-9]*");
    }
    private Long code;

    public Long getCode() {
        return code;
    }

    @FXML
    private void saveProduit(ActionEvent e) throws Exception {
        
        if(codeProduitField.getText().length()==0|| categorieProduitField.getText().length()==0 ||designationProduitField.getText().length() ==0||prixVenteField.getText().length() ==0||quantiteStockField.getText().length() ==0 ||dateExpirationField.getValue().equals(null)||remarqueProduitArea.getText().length()==0 || marqueProduitField.getText().length()==0){
         // le message d'erreur pour les champs vides

            resultatAjoutProduitLabel.setStyle("-fx-text-fill : red");
            resultatAjoutProduitLabel.setText("veuillez remplir tous les champs (*) obligatoire");
            
            montrer(resultatAjoutProduitLabel,4);
        }
            else{
             if(validate(prixVenteField.getText())== false || validate(quantiteStockField.getText())== false){
             System.out.println("entrer un nombre a la place reservé");
             resultatAjoutProduitLabel.setStyle("-fx-text-fill : red");
            resultatAjoutProduitLabel.setText("entrer un nombre a la place reservé");
            montrer(resultatAjoutProduitLabel,4);
         }
         else{
            // ici tous les champs sont remplis
            Produit produit = new Produit();
        ProduitDao produitDao = new ProduitDao();
        StockDao stockDao = new StockDao();
        Stock stock = new Stock();
        code = Long.parseLong(codeProduitField.getText());
            if( produitDao.findById(code) != null){
                   // l'exeption pour l'unicité de la clé primaire code produit
            resultatAjoutProduitLabel.setStyle("-fx-text-fill : red");
            resultatAjoutProduitLabel.setText("Le code du produit existe déja");
            montrer(resultatAjoutProduitLabel,4);
        
                    }
        else{
        produit.setCategorie(categorieProduitField.getText());
        produit.setId(code);
        produit.setMarque(marqueProduitField.getText());
        produit.setDesignation(designationProduitField.getText());
        produit.setRemarque(remarqueProduitArea.getText());
        produit.setDateExp(dateExpirationField.getValue().toString());
        produit.setPrixVente(Double.parseDouble(prixVenteField.getText()));
        produitDao.save(produit);
        stock.setProduit(produit);
        stock.setId(code);
        stock.setQuantite(0);
        stock.setQuantitDefectueise(0);
        stock.setQuantitemin(0);
        stockDao.save(stock);
        codeProduitField.setText("");
        designationProduitField.setText("");
          prixVenteField.setText("");
          quantiteStockField.setText("");
          marqueProduitField.setText("");
          remarqueProduitArea.setText("");
          categorieProduitField.setText("");
          quantiteStockField.setText("");
          prixVenteField.setText("");
          
          
          FXMLLoader fxmlLoader = new  FXMLLoader(getClass().getResource("/view/ProduitStockView.fxml"));
               Parent root1=(Parent)fxmlLoader.load();
               Stage stage=new Stage();
              stage.setTitle("ajouter un client");
              stage.setScene(new Scene(root1));
              stage.setResizable(false);
              stage.show(); 
          resultatAjoutProduitLabel.setStyle("-fx-text-fill : green");
          resultatAjoutProduitLabel.setText("Le produit est enregistrer avec succé");
          montrer(resultatAjoutProduitLabel,3); 
          updateTableViewProduits();
        }
    }} 
    }

   //filechosser  pour interface employe aicha
   @FXML
   private void handleOnMouseClicked(MouseEvent event) throws MalformedURLException {
	   FileChooser fc=new  FileChooser();
                  fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files",
                        "*.bmp", "*.png", "*.jpg", "*.gif")); 
	   File f=fc.showOpenDialog(null);
	   if(f!=null) {
         imageFile = f.toURI().toURL().toString();
          Image image = new Image(imageFile);
         img_emp.setFill(new ImagePattern(image));

        } 
    } 
   // cette fonction sert a afficher les alerts dans le cas d'existance des clietns ou non 
   @FXML
     private void  validerVente(ActionEvent event) throws Exception{
         
         
         if ( idproduits.size() > 0 ) {

               ClientDao clientdao = new  ClientDao();
               
              Long idclient=null;
              if(!montantPayerPanier.getText().toString().equals("")) {
                    //le cas ou  ya pas de credit
                    if(Double.parseDouble(totalPrixPanier.getText())==Double.parseDouble(montantPayerPanier.getText())){
                        //commandepasse
                        ventepasser(idclient);
                        Alert a = new Alert(AlertType.NONE); 
                        // set alert type 
                        a.setAlertType(AlertType.CONFIRMATION); 
                        // show the dialog 
                        a.setContentText("la vente est valider ");
                        a.show();
                    }
                    //le cas de credit
                    else{
                    //cas1: le cleitn deja exister
                        if (!text_vente_code_client.getText().toString().equals("")) {
                            if( clientdao.findById(Long.parseLong(text_vente_code_client.getText ()))!= null)   {
                            Client client =new Client();
                            client= clientdao.findById(Long.parseLong(text_vente_code_client.getText ()));
                            idclient=client.getId();
                            //vente passe
                            ventepasser(idclient);
                                Alert a = new Alert(AlertType.NONE); 
                                // set alert type 
                                a.setAlertType(AlertType.CONFIRMATION); 
                                // show the dialog 
                                a.setContentText("la vente est valider ");
                                a.show();
                                toggle_btn_passager.setSelected(true);
                                text_vente_link_client.setVisible(false);
                            }
                            //cas 2: le client n'existe pas
                            else{
                                Alert a = new Alert(AlertType.NONE); 
                                    a.setAlertType(AlertType.WARNING); 
                                // show the dialog 
                                    a.setContentText("le client n'existe pas ");
                                    a.show();
                                    text_vente_link_client.setVisible(true); 
                                    text_vente_code_client.setVisible(true);
                                
                            }
                        } else {
                            Alert a = new Alert(AlertType.NONE); 
                                    a.setAlertType(AlertType.WARNING); 
                                // show the dialog 
                                    a.setContentText("vous avez pas saisie aucun client");
                                    a.show();
                                   
                        }
                    
                    
                    }
              }else {
                    Alert b = new Alert(AlertType.NONE); 
                    b.setAlertType(AlertType.WARNING); 
                    // show the dialog 
                    b.setContentText("vous avez oublier de saisir le montant payee ");
                    b.show();
              }
                
        } else {
                        Alert b = new Alert(AlertType.NONE); 
                        b.setAlertType(AlertType.WARNING); 
                        // show the dialog 
                        b.setContentText("vous avez pas saisie aucun produits dans la liste");
                        b.show();
        }
            
               /*  if(!montantPayerPanier.getText().toString().equals("")){
              //creation de la vente
              if( Double.parseDouble(totalPrixPanier.getText())==Double.parseDouble(montantPayerPanier.getText()) ||  clientdao.findById(Long.parseLong(text_vente_code_client.getText ()))!= null){
                 VenteDao venteDao =new VenteDao();
                  VenteService venteService =new VenteService();
                 VenteDetailleDao venteDetailleDao=new VenteDetailleDao();
                 
                 venteDao.saveVent(Double.parseDouble(totalPrixPanier.getText()),Double.parseDouble(montantPayerPanier.getText()), idclient);
                    //creation ensemeble des detaille vente de la vente
                 long idlastvente=venteService.getLastIdVente();
                 for(int i=0;i<idproduits.size();i++){
                     venteDetailleDao.saveVentDetaille( idlastvente,idproduits.get(i),qntCommande.get(i)) ; 
      
                }      
                //vider tous 
                totalPrixPanier.setText("Total"); 
                montantPayerPanier.setText("");
                montantPayerPanier.setPromptText("montant payee");
                quantiteCommandePanier.setText("");
                codeProduiPanier.setText("");
                idproduits.clear(); 
                qntCommande.clear();  
                panier.clear();
                panierTableView.getItems().clear();
                System.out.println(idproduits);
                System.out.println(qntCommande);
              }
                 }
                 
                 else{
                     
                 }*/
                 
    }

    public void ventepasser(Long idClient) {
        System.out.println("hre =>" +Double.parseDouble(totalPrixPanier.getText()) );
        
        try{ 
            VenteDao venteDao =new VenteDao();
                  VenteService venteService =new VenteService();
                 VenteDetailleDao venteDetailleDao=new VenteDetailleDao();
                 venteDao.saveVent(Double.parseDouble(totalPrixPanier.getText()),Double.parseDouble(montantPayerPanier.getText()), idClient);
                    //creation ensemeble des detaille vente de la vente
                 long idlastvente=venteService.getLastIdVente();
                 for(int i=0;i<idproduits.size();i++){
                     venteDetailleDao.saveVentDetaille(idlastvente,idproduits.get(i),qntCommande.get(i)) ; 
      
                }      
                //vider tous 
                totalPrixPanier.setText("Total"); 
                montantPayerPanier.setText("");
                montantPayerPanier.setPromptText("montant payee");
                quantiteCommandePanier.setText("");
                codeProduiPanier.setText("");
                idproduits.clear(); 
                qntCommande.clear();  
                panier.clear();
                panierTableView.getItems().clear();
            
        }catch(Exception e) {
            System.out.println("erreur--sauvgarde");
        }
               
    }      
           //cette fonction permet d'afficher la fromulaire du client 
            @FXML
           private void  ajoutClient(ActionEvent event) throws IOException{
               
               FXMLLoader fxmlLoader = new  FXMLLoader(getClass().getResource("/view/formulaireClient.fxml"));
               Parent root1=(Parent)fxmlLoader.load();
               Stage stage=new Stage();
              stage.setTitle("ajouter un client");
              stage.setScene(new Scene(root1));
              stage.show(); 
              
           }
	 @FXML
          private void ajoutEmploye(ActionEvent event){
            
          }
   
    @FXML
    void modifierSupprimerHyperLink(ActionEvent event) {

        findCodeProduit.setText(""+table_produits.getSelectionModel().getSelectedItem().getId());
        findDesignation.setText(table_produits.getSelectionModel().getSelectedItem().getDesignation());
        tabpane_medicament.getSelectionModel().select(tabMedicamentModifier);
        // modifierHomeAnchorPane.toFront();
    } 
    @FXML
    void modifierSelected(ActionEvent event) {
        modifierHomeAnchorPane.toFront();
    }

    @FXML
    void deleteFindProduit(ActionEvent event) throws Exception {
        ProduitDao produitDao = new ProduitDao();
        StockDao sd = new StockDao();
        Produit produit = new Produit();
        Stock stock = new Stock();
        produit = produitDao.findById(findCodeProduit.getText());
        stock = sd.findById(findCodeProduit.getText());
        
        if(produit == null){
            System.out.println("le code produit que vous demander est introuvable");
        }
        else{
            produitDao.delete(produit);
            sd.delete(stock);
            updateTableViewProduits();
        }
    }

    @FXML
    void modifierFindProduit(ActionEvent event) throws Exception {//modifierFindProduit
        StockDao stockDao = new StockDao();
        ProduitDao produitDao = new ProduitDao();
        Stock stock = new Stock();
        Produit produit = new Produit(); 
        stock = stockDao.findById(findCodeProduit.getText());
        produit = produitDao.findById(findCodeProduit.getText());
        if (stock == null) {
            System.out.println("le code produit que vous demander est introuvable");
        } else {
            modifierAnchorPane.toFront();
            designationProduitModifierField.setText(stock.getProduit().getDesignation());
            quantiteStockModifierField.setText("" + stock.getQuantite());
            marqueProduitModifierField.setText(stock.getProduit().getMarque());
            categorieProduitModifierField.setText(stock.getProduit().getCategorie());
            prixVenteModifierField.setText("" + stock.getProduit().getPrixVente());
            codeProduitModifier.setText(""+stock.getProduit().getId());
            remarqueProduitModifierArea.setText(stock.getProduit().getRemarque());

        }
    }
    @FXML
    void updateFindProduit(ActionEvent event) throws Exception {//modifierFindProduit
        ProduitDao produitDao = new ProduitDao();
        Produit produit = new Produit();
        produit = produitDao.findById(findCodeProduit.getText());
        if(produit == null){
            System.out.println("le code produit que vous demander est introuvable");
        }
        else{
        produit.setDesignation(designationProduitModifierField.getText());
        produit.setMarque(marqueProduitModifierField.getText());
        produit.setCategorie(categorieProduitModifierField.getText());
        produitDao.update(produit);
        updateTableViewProduits();
        PauseTransition visiblePause = new PauseTransition(
            Duration.seconds(3)
            );
            visiblePause.setOnFinished(
            e -> modifierHomeAnchorPane.toFront()
                );
            visiblePause.play();
        
        }
    }
     List<PanierLigne> panier = new ArrayList<>();
     public List<Long> idproduits = new ArrayList<Long>();
    public List<Double> qntCommande=new ArrayList<Double>();
    
      @FXML
    void ajouterPanier(ActionEvent event) throws Exception {
        double qtt;
        double total;
        ProduitService ps = new ProduitService();
        qtt = Double.parseDouble(quantiteCommandePanier.getText()); 

        total = ps.ajouterPanier(panierTableView,panier, codeProduiPanier.getText() , qtt);
        totalPrixPanier.setText(""+total);
         idproduits.add(Long.parseLong(codeProduiPanier.getText()));
        qntCommande.add(qtt);
       
    }
      @FXML
    void payerPanierTxt(ActionEvent event) {
        double x = Double.parseDouble(totalPrixPanier.getText());
        if(x != Double.parseDouble(montantPayerPanier.getText())){
            toggle_btn_passager.setSelected(false);
        }
        else{
            toggle_btn_passager.setSelected(true);
        }
    }
        public void configTabPanier(TableView<PanierLigne> table, TableColumn<PanierLigne, String> codeProduitPanier, TableColumn<PanierLigne, String> designationPanier, TableColumn<PanierLigne, String> categoriePanier ,TableColumn<PanierLigne, Number> stockPanier, TableColumn<PanierLigne, String> commandePanier, TableColumn<PanierLigne, Number> prixPanier, TableColumn<PanierLigne, Number> totalPanierTableau){
        codeProduitPanier.setCellValueFactory(new PropertyValueFactory<>("code_prod"));
        designationPanier.setCellValueFactory(new PropertyValueFactory<>("designation"));
        stockPanier.setCellValueFactory(new PropertyValueFactory<>("quantiteStock"));
        commandePanier.setCellValueFactory(new PropertyValueFactory<>("quantiteCommande"));
        prixPanier.setCellValueFactory(new PropertyValueFactory<>("prixUnitaire"));
        totalPanierTableau.setCellValueFactory(new PropertyValueFactory<>("total"));
        categoriePanier.setCellValueFactory(new PropertyValueFactory<>("categorie"));

    }
    
    
     
    
    
    
     
    
}
