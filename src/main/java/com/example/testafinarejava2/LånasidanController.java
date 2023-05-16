package com.example.testafinarejava2;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LånasidanController extends ControllerController implements Initializable {
    @FXML
    private TextField söktext;
    @FXML
    private Button sökknapp;
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
    private ImageView bildpåboken;
    @FXML
    private Button Låna;
    @FXML
    private Button Reservera;
    @FXML
    private Label författarnamn;
    @FXML
    private Label ISBN;
    @FXML
    private Label BokensNamn;
    @FXML
    private GridPane topgrid;
    @FXML
    private Label bibliotek;


    public void initialize(URL url, ResourceBundle resourceBundle) {
        inloggadFrågetecken(användare,inloggadsom,loggain);
    }

    @FXML
    public void sökResultat(ActionEvent actionEvent) throws IOException {
        sökResultat(söktext.getText());
    }



    @FXML
    public void lånaKnappen(ActionEvent actionEvent) throws IOException {
        if (SessionManager.isAuthenticated()){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("låna.fxml"));
            Parent root = fxmlLoader.load();
            Scene currentScene = loggautsak.getScene();
            currentScene.setRoot(root);
        }else {
            ButtonType loggain = new ButtonType("Logga in");
            Alert erroralert = new Alert(Alert.AlertType.ERROR, "Du måste vara inloggad för att låna", loggain);
            erroralert.setOnCloseRequest(e -> {
                try {
                    loggaIn();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });

            erroralert.showAndWait();

        }
    }

    @FXML
    public void reserveraKnappen(ActionEvent actionEvent) {
    }

    public void getBokInfo(Bok bok) {
        författarnamn.setText(bok.getAuthor().getFirstName());
        ISBN.setText(bok.getISBN());
        BokensNamn.setText(bok.getNamn());

    }



}
