/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import Crud.campCrud;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Brahim
 */
public class SuppressionCController implements Initializable {

    @FXML
    private TextField libelle_C;
    @FXML
    private Button supprimer_C;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void supprimer_C(ActionEvent event) {
        String libelle = libelle_C.getText();
        campCrud cC = new campCrud();
        int status = cC.deleteCampement(libelle);
        if (status > 0){
            Alert alert =new Alert(Alert.AlertType.INFORMATION);
              // get a handle to the stage
    Stage stage = (Stage) supprimer_C.getScene().getWindow();
    // do what you have to do
    stage.close();
           
            alert.setTitle("Suppression Campement");
            alert.setHeaderText("information!");
            alert.setContentText("Campement Supprimé avec succès !");
            alert.showAndWait();
            
        }else {
             Alert alert =new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Suppression Campement");
            alert.setHeaderText("information!");
            alert.setContentText("Campement NON supprimé !");
            alert.showAndWait();
        }
    }
    
}
