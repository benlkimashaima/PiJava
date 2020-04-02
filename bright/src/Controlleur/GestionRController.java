/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import Database.connectionDB;
import Entity.Campement;
import Entity.stock;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Brahim
 */
public class GestionRController implements Initializable {
    Connection con=connectionDB.getInstance().getCnx();

    @FXML
    private TableView<Campement> table_C;
    @FXML
    private Button ajouter_C;
    @FXML
    private Button supprimer_C;
    @FXML
    private Button modifier_C;
    ObservableList<Campement> Clist  = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Campement, String> libelle;
    @FXML
    private TableColumn<Campement, String> adresse;
    @FXML
    private TableColumn<Campement, Integer> capacity;
    @FXML
    private Button refresh_C;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                            try{
                        Connection con=connectionDB.getInstance().getCnx();
                   
ResultSet rs =con.createStatement().executeQuery("SELECT * FROM camp ");
//ResultSet rs2 =con.createStatement().executeQuery("SELECT * FROM don ");

while (rs.next()){
    Clist.add(new Campement(rs.getString("libelle"), rs.getString("location"),rs.getInt("capacity")));
                        
                    }

          }catch (Exception ex) {
            Logger.getLogger(GestionStock.class.getName()).log(Level.SEVERE, null, ex);
        }    
                  
       libelle.setCellValueFactory(new PropertyValueFactory<Campement,String>("libelle"));
       adresse.setCellValueFactory(new PropertyValueFactory<Campement,String>("location"));     
       capacity.setCellValueFactory(new PropertyValueFactory<Campement,Integer>("capacity"));    
       table_C.setItems(Clist);


    }    

    @FXML
    private void ajouter_C(ActionEvent event) throws IOException {
                    Stage stage =new Stage();
    Parent root =FXMLLoader.load(getClass().getResource("/bright/ajoutC.fxml"));
    Scene scene =new Scene (root);
    stage.setScene(scene);
    stage.setTitle("Ajouter Camp");
    stage.show();
    }

    @FXML
    private void supprimer_C(ActionEvent event) throws IOException {
                           Stage stage =new Stage();
    Parent root =FXMLLoader.load(getClass().getResource("/bright/suppressionC.fxml"));
    Scene scene =new Scene (root);
    stage.setScene(scene);
    stage.setTitle("Supprimer Camp");
    stage.show();
    }
    

    @FXML
    private void modifier_C(ActionEvent event) throws IOException {
                                 Stage stage =new Stage();
    Parent root =FXMLLoader.load(getClass().getResource("/bright/modif_C.fxml"));
    Scene scene =new Scene (root);
    stage.setScene(scene);
    stage.setTitle("Modifier Camp");
    stage.show();
    }
    
    @FXML
    private void refresh_TC(ActionEvent event) {
    }
    
}
