/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keep_that_smile;

import entities.Evenement;
import entities.EvenementCrud;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author YURI
 */
public class EvenementController implements Initializable {

    @FXML
    private TextField tritre;
    @FXML
    private TextField tville;
    @FXML
    private TextField tdescription;
    @FXML
    private TextField tdate;
    @FXML
    private TextField tnbr;
    @FXML
    private Button bAjouter;
    @FXML
    private TableView<Evenement> table;
    
    @FXML
    private TableColumn<Evenement, String> col_titre;
    @FXML
    private TableColumn<Evenement, String> col_ville;
    @FXML
    private TableColumn<Evenement, String> col_description;
    @FXML
    private TableColumn<Evenement, String> col_date;
    @FXML
    private TableColumn<Evenement, Integer> col_nbr;

    
    
    @FXML
    private TextField recherche1;
    public ObservableList<Evenement> tables = FXCollections.observableArrayList();
    @FXML
    private TableColumn<?, ?> col_iduser;
    @FXML
    private Button retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {                
      
    }

    @FXML
    private void ajouter(ActionEvent event) {
        String a = tritre.getText();
        String b = tville.getText();
        String c = tdate.getText();
        String d = tdescription.getText();
        String e = tnbr.getText();

        int nbrr;
        nbrr = Integer.parseInt(e);

        EvenementCrud ac = new EvenementCrud();
        Evenement aaa = new Evenement(nbrr, a, d, c, b);
        ac.ajouter(aaa);

    }

    @FXML
    private void SelectItemes(MouseEvent event) {
         ObservableList<Evenement> oblist;
        oblist = table.getSelectionModel().getSelectedItems();
        if (oblist != null) {
            tritre.setText(oblist.get(0).getTitre());

            int max = oblist.get(0).getRef();
            tdescription.setText(oblist.get(0).getDescription());
            tdate.setText(oblist.get(0).getDate());
            tville.setText(oblist.get(0).getVille());
            tnbr.setText("" + oblist.get(0).getNbPart());

        }
    }

    @FXML
    private void modifier(ActionEvent event) {
        Evenement A = new Evenement();
        A.setTitre(tritre.getText());
        A.setNbPart(Integer.parseInt(tnbr.getText()));
        A.setDescription(tdescription.getText());
        A.setDate(tdate.getText());
        A.setVille(tville.getText());

        ObservableList<Evenement> oblist;
        oblist = table.getSelectionModel().getSelectedItems();
        int max = oblist.get(0).getRef();

        EvenementCrud act = new EvenementCrud();
        try {          

            act.modifier(A, max);
            System.out.println(max);

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        
    }

    @FXML
    private void supp(ActionEvent event) {
        ObservableList<Evenement> oblist;
        oblist = table.getSelectionModel().getSelectedItems();
        int max = oblist.get(0).getRef();

        Evenement A = new Evenement();
        EvenementCrud act = new EvenementCrud();
        try {
            act.supprimer(max);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    @FXML
    private void afficher(ActionEvent event) {

        col_titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
        col_ville.setCellValueFactory(new PropertyValueFactory<>("ville"));
        col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        col_nbr.setCellValueFactory(new PropertyValueFactory<>("nbrPart"));

        try {
            EvenementCrud act = new EvenementCrud();
            Evenement An = new Evenement();

            tables = act.afficher(An);

        } catch (SQLException ex) {

        }
        table.setItems((ObservableList<Evenement>) tables);
        FilteredList<Evenement> filteredData = new FilteredList<>(tables, b -> true);

    }
    @FXML
    private void retour(ActionEvent event) throws IOException {
      Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        //stage.setMaximized(true);
        stage.close();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/keep_that_smile/categorie.fxml")));
        stage.setScene(scene);
        stage.show();
    }
    
}
