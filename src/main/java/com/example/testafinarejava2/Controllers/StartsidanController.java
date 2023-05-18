package com.example.testafinarejava2.Controllers;

import com.example.testafinarejava2.Driver.SessionManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
        sökResultat(söktext.getText());
    }



    public void initialize(URL url, ResourceBundle resourceBundle) {
        inloggadFrågetecken(användare, inloggadsom, loggain);
        try {
            setupStaffFeatures();
        } catch (SQLException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            setupUserFeatures();
        } catch (SQLException | FileNotFoundException e) {
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
    private void setupUserFeatures() throws SQLException, FileNotFoundException {
        SessionManager sessionManager = new SessionManager();
        if (sessionManager.isUserUser()) {
            addLämnaBöcker();
        }
    }
    private void addLämnaBöcker(){
        Label lämnaBöcker = new Label("Lämna tillbaka böcker:");
        lämnaBöcker.setStyle("-fx-font-size: 20px;");
        Button lämnaBöckerButton = new Button("Lämna böcker");
        lämnaBöckerButton.setStyle("-fx-font-size: 20px;");
        startsidabody.add(lämnaBöcker, 0, 2);
        startsidabody.add(lämnaBöckerButton, 2, 2);

        lämnaBöckerButton.setOnAction(event -> {
            try {
                bytSida("kundLämnaTillbaka.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

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
                bytSida("inteTillbakaLämnade.fxml");
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
                bytSida("läggtill.fxml");
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
                bytSida("nybok.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }



}
