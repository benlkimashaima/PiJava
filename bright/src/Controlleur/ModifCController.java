/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import Crud.campCrud;
import Database.connectionDB;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Brahim
 */
public class ModifCController implements Initializable {

    @FXML
    private TextField capacity;
    @FXML
    private Button modifier_C;
    @FXML
    private TextField libelle;
    @FXML
    private ComboBox<String> ComboLib;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //ComboLib.setItems(FXCollections.observableArrayList(getData()));
    }    
    
    /*private List<String> getData() {
        List<String> options = new ArrayList<>();
        connectionDB con = new connectionDB();
        String query = "select artikulli from product_table";
            PreparedStatement statement = con.prepareStatement(query);

            ResultSet set = statement.executeQuery();

            while (set.next()) {
                options.add(set.getString("artikulli"));
            }

            statement.close();
            set.close();

            // Return the List
            return options;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }*/
        
        
    

    @FXML
    private void modifierC(ActionEvent event) {

        campCrud cC = new campCrud();
        int status = cC.deleteCampement(libelle.getText());
        if (status > 0){
            Alert alert =new Alert(Alert.AlertType.INFORMATION);
              // get a handle to the stage
    Stage stage = (Stage) modifier_C.getScene().getWindow();
    // do what you have to do
    stage.close();
           
            alert.setTitle("Modifier Campement");
            alert.setHeaderText("information!");
            alert.setContentText("Campement modifié avec succès !");
            alert.showAndWait();
            
        }else {
             Alert alert =new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Modifier  Campement");
            alert.setHeaderText("information!");
            alert.setContentText("Campement NON modifié !");
            alert.showAndWait();
        }
    }
    
}
