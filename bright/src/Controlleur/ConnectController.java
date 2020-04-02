
package Controlleur;
import Database.connectionDB;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ConnectController implements Initializable{
    @FXML private TextField txtF;
    @FXML private PasswordField passF;
    @FXML private Label lbletat;

    @FXML
          Connection con=connectionDB.getInstance().getCnx();

    public void loginn (ActionEvent event )throws SQLException {
        PreparedStatement stat =null;
        ResultSet rs = null;
        String sql ="SELECT * FROM users WHERE name=? AND password =?";
        try{
            stat=con.prepareStatement(sql);
            stat.setString(1, txtF.getText().toString());
            stat.setString(2, passF.getText().toString());
            rs=stat.executeQuery();
            if (rs.next()){
                lbletat.setText("Connecté!");
                    
                
                Stage stage =new Stage();
                 Parent root = FXMLLoader.load(getClass().getResource("/bright/gestionR.fxml"));
              
                 Scene scene = new Scene(root);
                 stage.setScene(scene);
               
                stage.setTitle("Home");
                stage.show();
                
            }else {
                lbletat.setText("Non connecté!");
                Alert alert= new Alert(AlertType.ERROR);
                alert.setHeaderText("Erreur");
                alert.setTitle("Alert");
                alert.setContentText("Username ou password sont incorrect");
            alert.showAndWait();
            }
            
        }catch (SQLException e){
        } catch (IOException ex) {
            Logger.getLogger(ConnectController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void initialize(URL location,ResourceBundle resources){
        
    } 

}
