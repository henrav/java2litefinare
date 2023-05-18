package com.example.testafinarejava2.Controllers;

import com.example.testafinarejava2.Entities.Author;
import com.example.testafinarejava2.Entities.Bok;
import com.example.testafinarejava2.Driver.DBconnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class NybokController extends ControllerController implements Initializable {
    @FXML
    private GridPane topgrid;
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
    private ImageView bildpåboken;
    @FXML
    private Label BokensNamn;
    @FXML
    private TextField barcodeText;
    @FXML
    private TextField titleText;
    @FXML
    private TextField isbnText;
    @FXML
    private TextField locationText;
    @FXML
    private TextField descriptionText;
    @FXML
    private TextField itemtypeText;
    @FXML
    private TextField itemstatusText;
    @FXML
    private TextField renttimeText;

    @FXML
    private Button tillbaka;
    @FXML
    private Button Återställ;
    private Bok bok;

    @FXML
    private Button läggtill;
    @FXML
    private TextField författareFörNamn;
    @FXML
    private TextField författareEfterNamn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inloggadFrågetecken(användare,inloggadsom,loggain);
    }

    @FXML
    public void sökResultat(ActionEvent actionEvent) throws IOException {
        sökResultat(söktext.getText());
    }




    public void läggTill() throws SQLException {
        Bok bok = new Bok();
        Author author = new Author();
        author.setFirstName(författareFörNamn.getText().trim());
        author.setLastName(författareEfterNamn.getText().trim());
        bok.setBarcode(barcodeText.getText());
        bok.setNamn(titleText.getText());
        bok.setISBN(isbnText.getText());
        bok.setLocation(locationText.getText());
        bok.setDescription(descriptionText.getText());
        bok.setItemtype(itemtypeText.getText());
        bok.setItemstatus(itemstatusText.getText());
        bok.setRenttime(renttimeText.getText());
        bok.setAuthor(author);
        try {
            DBconnection.addNewBok(bok);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Bok tillagd");
            alert.setHeaderText("Boken är tillagd");
            alert.setContentText("Boken är tillagd");
            alert.showAndWait();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Bok Inte Tillagd");
            alert.setHeaderText("Boken är inte tillagd");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }
    public void återställ() {
        författareEfterNamn.setText("");
        författareFörNamn.setText("");
        barcodeText.setText("");
        titleText.setText("");
        isbnText.setText("");
        locationText.setText("");
        descriptionText.setText("");
        itemtypeText.setText("");
        itemstatusText.setText("");
        renttimeText.setText("");
    }





}