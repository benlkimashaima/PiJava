/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import Crud.campCrud;
import Entity.Campement;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Brahim
 */
public class AjoutCController implements Initializable {

    @FXML
    private TextField libelle_C;
    @FXML
    private TextField adresse_C;
    @FXML
    private TextField capacity_C;
    @FXML
    private Button ajout_C;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void ajouter_C(ActionEvent event) throws IOException  {
           String libelle = libelle_C.getText();
           String location = adresse_C.getText();
           int capacity = Integer.parseInt(capacity_C.getText());
           Campement C = new Campement(libelle,location,capacity);
           campCrud cC = new campCrud();
           int status = cC.addCampement(C);
            if (status > 0){
            Alert alert =new Alert(Alert.AlertType.INFORMATION);
              // get a handle to the stage
    Stage stage = (Stage) ajout_C.getScene().getWindow();
    // do what you have to do
    stage.close();
           
            alert.setTitle("Ajout Campement");
            alert.setHeaderText("information!");
            alert.setContentText("Campement Ajouté avec succès !");
            alert.showAndWait();
            
        }else {
             Alert alert =new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ajout Campement");
            alert.setHeaderText("information!");
            alert.setContentText("Campement NON Ajouté!");
            alert.showAndWait();
        }
            
    
    }

    
}
