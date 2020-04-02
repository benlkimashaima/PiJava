/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import Database.connectionDB;
import Entity.stock;
import Entity.don;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.stage.Stage;

/**
 *
 * @author HP
 */
public class GestionStock  implements Initializable{
   
     Connection con=connectionDB.getInstance().getCnx();

    @FXML private TableView <stock> table ;
    @FXML private TableColumn<stock,Integer> id;
    @FXML private TableColumn<stock,String> type;
     @FXML private TableView <don> tables ;
    @FXML private TableColumn<don,Integer> reference;
    @FXML private TableColumn<don,String> libelle;
    @FXML private TableColumn<don,Integer> quantite;
    @FXML private TableColumn<don,Date> date;
    @FXML private TableColumn<don,Integer> Stock_id;
    
    
    
    
    
      ObservableList<stock> oblist  = FXCollections.observableArrayList();
      ObservableList<don> blist  = FXCollections.observableArrayList();


    

@Override
            public void initialize(URL url, ResourceBundle rb) {
                    try{
                        Connection con=connectionDB.getInstance().getCnx();
                   
ResultSet rs =con.createStatement().executeQuery("SELECT * FROM stock ");
ResultSet rs2 =con.createStatement().executeQuery("SELECT * FROM don ");

while (rs.next()){
    oblist.add(new stock(rs.getInt("id"),rs.getString("type")));
                        
                    }
while (rs2.next()){
    blist.add(new don(rs2.getInt("reference"),rs2.getString("libelle"),rs2.getInt("quantite"),rs2.getDate("date"),rs2.getInt("Stock_id")));
                        
                    }
          }catch (Exception ex) {
            Logger.getLogger(GestionStock.class.getName()).log(Level.SEVERE, null, ex);
        }    
                  
       id.setCellValueFactory(new PropertyValueFactory<stock,Integer>("id"));
       type.setCellValueFactory(new PropertyValueFactory<stock,String>("type"));     
         table.setItems(oblist);








       reference.setCellValueFactory(new PropertyValueFactory<don,Integer>("reference"));
              libelle.setCellValueFactory(new PropertyValueFactory<don,String>("libelle"));
                     quantite.setCellValueFactory(new PropertyValueFactory<don,Integer>("quantite"));
                            date.setCellValueFactory(new PropertyValueFactory<don,Date>("date"));
                                   Stock_id.setCellValueFactory(new PropertyValueFactory<don,Integer>("Stock_id"));
                                   tables.setItems(blist);






            
                }




     @FXML
     public void insertstock() throws IOException {
    Stage stage =new Stage();
    Parent root =FXMLLoader.load(getClass().getResource("/bright/insertStock.fxml"));
    Scene scene =new Scene (root);
    stage.setScene(scene);
    stage.setTitle("Ajouter un stock");
    stage.show();
    
}
     @FXML
     public void update() throws IOException {
    Stage stage =new Stage();
    Parent root =FXMLLoader.load(getClass().getResource("/bright/modifier.fxml"));
    Scene scene =new Scene (root);
    stage.setScene(scene);
    stage.setTitle("Changer ou Supprimer  un stock");
    stage.show();
}
     @FXML
     public void updated() throws IOException {
    Stage stage =new Stage();
    Parent root =FXMLLoader.load(getClass().getResource("/bright/modifierd.fxml"));
    Scene scene =new Scene (root);
    stage.setScene(scene);
    stage.setTitle("Modifier don");
    stage.show();
}

}










