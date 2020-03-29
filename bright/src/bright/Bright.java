/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bright;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Database.connectionDB;
import java.sql.Connection;


/**
 *
 * @author HP
 */
public class Bright extends Application {

    @Override
    public void start(Stage stage) throws IOException {
       connectionDB c = connectionDB.getInstance() ; 

        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));

        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
