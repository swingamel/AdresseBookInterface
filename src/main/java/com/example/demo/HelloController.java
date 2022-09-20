package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private TextField adresse;

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private TableColumn<Personne, String> edit;

    @FXML
    private TableColumn<Personne, String> setAdresse;

    @FXML
    private TableColumn<Personne, String> setNom;

    @FXML
    private TableColumn<Personne, String> setPrenom;

    @FXML
    private TableView<Personne> table;

    String query = null;
    Personne personne = null;

    public void AddRecord() {
        Personne personne = new Personne();
        personne.setNom(nom.getText());
        personne.setPrenom(prenom.getText());
        personne.setAdresse(adresse.getText());
        table.getItems().add(personne);
        nom.clear();
        prenom.clear();
        adresse.clear();
    }

    public void Supprimer() {
        ObservableList<Personne> selectedRows, allPeople;
        allPeople = table.getItems();
        selectedRows = table.getSelectionModel().getSelectedItems();
        for (Personne personne : selectedRows) {
            allPeople.remove(personne);
        }

    }

    ObservableList<Personne> list = FXCollections.observableArrayList(
            new Personne("Bourgeois", "Agnes", "Valadon"),
            new Personne("Bogusz", "Thierry", "Retraite"),
            new Personne("Pasqualini", "Claude", "Retraite"),
            new Personne("Jaouen", "Francoise", "valadon"),
            new Personne("Garnier", "Tristan", "Neop"),
            new Personne("Paulhiac", "Quentin", "Neop"),
            new Personne("Laporte", "Benjamin", "Neop"),
            new Personne("Marcuzzi", "Quentin", "iut"),
            new Personne("Nouillaguet", "Jeremy", "valadonIut")
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        setPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        setAdresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));

        table.setItems(list);
    }



    @FXML
    void close(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();

    }

    @FXML
    void print(MouseEvent event) {

    }


    @FXML
    void RefreshTable() {
        table.getItems().clear();
        table.setItems(list);

    }
}