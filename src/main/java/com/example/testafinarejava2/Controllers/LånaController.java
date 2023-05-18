package com.example.testafinarejava2.Controllers;

import com.example.testafinarejava2.Driver.SessionManager;
import com.example.testafinarejava2.Entities.Bok;
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

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Random;

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
    private Bok bok;

    @FXML
    public void sökResultat(ActionEvent actionEvent) throws IOException {
        sökResultat(söktext.getText());

    }





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inloggadFrågetecken(användare, inloggadsom, loggain);

    }

    public void initInitialize(Bok bok) throws FileNotFoundException {
        KundensNamn.setText(SessionManager.getUserName());
        SakensNamn.setText(bok.getNamn());
        double random = new Random().nextDouble(1);
        int randomInt = (int) (random * 1000000000);
        KvittoNR.setText(String.valueOf(randomInt));

    }
    public void setBok(Bok bok) throws FileNotFoundException {
        this.bok = bok;
        initInitialize(bok);
    }







}
