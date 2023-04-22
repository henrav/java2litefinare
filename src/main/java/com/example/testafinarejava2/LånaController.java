package com.example.testafinarejava2;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LånaController extends ControllerController implements Initializable {
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
    private GridPane topgrid;
    @FXML
    private Label bibliotek;
    @FXML
    private Label KundensNamn;
    @FXML
    private Label SakensNamn;
    @FXML
    private Label KvittoNR;

    @FXML
    public void sökResultat(ActionEvent actionEvent) {
    }

    @FXML
    public void loggaIn(Event event) {
        Label label = new Label("Eeeehm ");
        //ähm det är här eftersom dålig design, måste vara inloggad för att komma hit
    }

    @Deprecated
    public void loggaUtSaken(Event event) throws IOException {
        loggaUt(loggautsak.getScene());
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inloggadFrågetecken(användare, inloggadsom, loggain);

    }


    public void hemKnapp(MouseEvent mouseEvent) throws IOException {
        hemKnapp(loggautsak.getScene());
    }




}
