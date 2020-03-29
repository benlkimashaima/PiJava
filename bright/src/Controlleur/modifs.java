/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;
import Database.connectionDB;
import java.net.URL;
import Entity.stock;
import java.io.IOException;
import java.text.ParseException;

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
public class modifs {
     @FXML private TextField idS;
@FXML private TextField typeS;






public void getStock(ActionEvent event )throws IOException ,ParseException{
    
    String sid =idS.getText();
    int id =Integer.parseInt(sid);
    stock std =connectionDB.getStock(id);
    typeS.setText(std.getType());
    
}
public void updateStock (ActionEvent event) throws IOException {
    String sid =idS.getText();
    int id =Integer.parseInt(sid);
    String txtType  = typeS.getText();
    stock std = new stock();
    std.setId(id);
    std.setType(txtType);
    int status = connectionDB.update(std);
    if (status>0){
             Alert alert =new Alert(AlertType.INFORMATION);
            alert.setTitle("update  Stock!");
            alert.setHeaderText("information!");
            alert.setContentText("update ok");
            alert.showAndWait();
        }else {
             Alert alert =new Alert(AlertType.ERROR);
            alert.setTitle("update Stock!");
            alert.setHeaderText("information!");
            alert.setContentText("update NON stock");
            alert.showAndWait();
        }
    }

public void deleteStock (ActionEvent event) throws IOException {
    String sid =idS.getText();
    int id =Integer.parseInt(sid);
    int status  =connectionDB.delete(id);
    if (status>0){
        Alert alert =new Alert(AlertType.INFORMATION);
            alert.setTitle("delete  Stock!");
            alert.setHeaderText("information!");
            alert.setContentText("Stock bien delete!");
            alert.showAndWait();
        }else {
             Alert alert =new Alert(AlertType.ERROR);
            alert.setTitle("update Stock!");
            alert.setHeaderText("information!");
            alert.setContentText("Stock NON delete!");
            alert.showAndWait();
        }
    
}
    
    
    
    
    
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   
    
  
    
    
}
