/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import Database.connectionDB;
import Entity.don;
import java.io.IOException;
import java.text.ParseException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 *
 * @author HP
 */
public class modifd {
    @FXML private TextField referenced;
@FXML private TextField libelled;
@FXML private TextField quantited;
@FXML private TextField dated;
@FXML private TextField stockd;


public void getDon(ActionEvent event )throws IOException ,ParseException{
    
    String sid =referenced.getText();
    int id =Integer.parseInt(sid);
    don std =connectionDB.getDon(id);
    
    libelled.setText(std.getLibelle());
   
   
    
}

    
}
