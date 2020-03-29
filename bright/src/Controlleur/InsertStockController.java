/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import Database.connectionDB;
import java.net.URL;
import Entity.stock;

import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

/**
 *
 * @author HP
 */
public class InsertStockController implements Initializable{
@FXML private TextField txtT;
//private  ObservableList<String> list =FXCollections.obervableArrayList();
    
   @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    }
    public void insertData (ActionEvent event){
        String type = txtT.getText();
        stock std =new stock();
        std.setType(type);
        int status = connectionDB.save(std);
        if (status > 0){
            Alert alert =new Alert(AlertType.INFORMATION);
            alert.setTitle("Add Stock!");
            alert.setHeaderText("information!");
            alert.setContentText("Stock bien Ajouter!");
            alert.showAndWait();
        }else {
             Alert alert =new Alert(AlertType.ERROR);
            alert.setTitle("Add Stock!");
            alert.setHeaderText("information!");
            alert.setContentText("Stock NON Ajouter!");
            alert.showAndWait();
        }
  
    }
    public void vider (){
        txtT.clear();
    }
}
