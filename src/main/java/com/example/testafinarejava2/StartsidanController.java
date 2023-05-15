package com.example.testafinarejava2;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StartsidanController extends ControllerController implements Initializable {
    @FXML
    private TextField söktext;
    @FXML
    private Button sökknapp;
    @FXML
    private Label bibliotek;
    @FXML
    private Label omoss;
    @FXML
    private Label loggain;
    @FXML
    private Label loggautsak;
    @FXML
    private Label användare;
    @FXML
    private Label inloggadsom;
    @FXML
    private GridPane topgrid;
    @FXML
    private GridPane startsidabody;

    @FXML
    public void sökResultat(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sökresultat.fxml"));
        Parent root = loader.load();
        Scene currentScene = sökknapp.getScene();
        currentScene.setRoot(root);
        SökresultatController controller = loader.getController();
        controller.setSöktext(söktext.getText());
    }



    @FXML
    public void loggaIn(Event event) throws IOException {
        loggaIn(bibliotek.getScene());
    }
    @FXML
    public void loggaUtSak() throws IOException {
        loggaUt(bibliotek.getScene());
    }
    public void hemKnapp() throws IOException {
        hemKnapp(bibliotek.getScene());
    }



    public void initialize(URL url, ResourceBundle resourceBundle) {
        inloggadFrågetecken(användare, inloggadsom, loggain);
        try {
            setupStaffFeatures();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void setupStaffFeatures() throws SQLException, FileNotFoundException {
        SessionManager sessionManager = new SessionManager();
        if (sessionManager.isUserStaff()) {
            addStyggaknapp();
            addEditButton();
            addAddButton();
        }
    }

    private void addStyggaknapp() {
        Label styggalabel = new Label("kolla vilka som e stygga och inte lämnat tillbaka böcker i tid:");
        styggalabel.setStyle("-fx-font-size: 20px;");
        Button styggaknapp = new Button("kolla stygga");
        styggaknapp.setStyle("-fx-font-size: 20px;");
        startsidabody.add(styggalabel, 0, 1);
        startsidabody.add(styggaknapp, 2, 1);

        styggaknapp.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("styggakunder.fxml"));
                Parent root = loader.load();
                Scene currentScene = styggaknapp.getScene();
                currentScene.setRoot(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void addEditButton() {
        Label editLabel = new Label("Edit books:");
        editLabel.setStyle("-fx-font-size: 20px;");
        Button editButton = new Button("Edit");
        editButton.setStyle("-fx-font-size: 20px;");
        startsidabody.add(editLabel, 0, 2);
        startsidabody.add(editButton, 2, 2);

        editButton.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("läggtill.fxml"));
                Parent root = loader.load();
                Scene currentScene = editButton.getScene();
                currentScene.setRoot(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void addAddButton() {
        Label addLabel = new Label("Add books:");
        addLabel.setStyle("-fx-font-size: 20px;");
        Button addButton = new Button("Add");
        addButton.setStyle("-fx-font-size: 20px;");
        startsidabody.add(addLabel, 0, 3);
        startsidabody.add(addButton, 2, 3);

        addButton.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("nybok.fxml"));
                Parent root = loader.load();
                Scene currentScene = addButton.getScene();
                currentScene.setRoot(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }


    @FXML
    public void hemKnapp(Event event) {
    }
}
