package com.example.testafinarejava2;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private Button idSave;
    @FXML
    private Button TitleSave;
    @FXML
    private Button isbnSave;
    @FXML
    private Button barcodeSave;
    @FXML
    private Button locationSave;
    @FXML
    private Button descriptionSave;
    @FXML
    private Button itemtypeSave;
    @FXML
    private Button renttimeSave;
    @FXML
    private Button itemstatusSave;
    @FXML
    private Button tillbaka;
    @FXML
    private Button Återställ;

    @FXML
    private TextField författare;
    @FXML
    private Button läggtill;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inloggadFrågetecken(användare,inloggadsom,loggain);
    }

    @FXML
    public void sökResultat(ActionEvent actionEvent) {
    }

    @FXML
    public void hemKnapp(Event event) throws IOException {
        hemKnapp(bibliotek.getScene());
    }

    @FXML
    public void loggaIn(Event event) throws IOException {
        loggaIn(bibliotek.getScene());
    }

    @FXML
    public void loggautsaken(Event event) throws IOException {
        loggaIn(bibliotek.getScene());
    }
    public void läggTill() throws SQLException {
        Bok bok = new Bok();
        Author author = new Author();
        author.setFirstName(författare.getText().trim());
        author.setLastName(författare.getText().trim() + " " + författare.getText().trim());
        bok.setBarcode(barcodeText.getText());
        bok.setNamn(titleText.getText());
        bok.setISBN(isbnText.getText());
        bok.setLocation(locationText.getText());
        bok.setDescription(descriptionText.getText());
        bok.setItemtype(itemtypeText.getText());
        bok.setItemstatus(itemstatusText.getText());
        bok.setRenttime(renttimeText.getText());
        bok.setAuthor(author);
        DBconnection.addNewBok(bok);
    }

}