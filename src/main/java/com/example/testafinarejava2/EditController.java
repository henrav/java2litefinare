package com.example.testafinarejava2;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EditController extends ControllerController implements Initializable {
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
    private TextField idText;
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
    private String förstaItemID;
    private Bok bok;
    @FXML
    private Button Återställ;

    private void setFörstaItemID(String förstaItemID) {
        this.förstaItemID = förstaItemID;
    }
    private String getFörstaItemID() {
        return förstaItemID;
    }

    public void sök() throws IOException {
        sökResultat(söktext.getText());
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sättKnappar();
    }
    public void setItemData(BokAuthorRow item){
        this.bok = item.getBok();
        setFörstaItemID(item.getItemID());
        BokensNamn.setText(item.getNamn());
        idText.setText(item.getItemID());
        barcodeText.setText(item.getBarcode());
        titleText.setText(item.getNamn());
        isbnText.setText(item.getISBN());
        locationText.setText(item.getLocation());
        descriptionText.setText(item.getDescription());
        itemtypeText.setText(item.getItemtype());
        itemstatusText.setText(item.getItemstatus());
        renttimeText.setText(item.getRenttime());

    }
    public void updateNamn() throws SQLException {
        String namn = titleText.getText();
        Integer id = Integer.parseInt(idText.getText());
        DBconnection.updateItemTitle(namn, id);
    }
    public void sättKnappar(){
        idSave.setOnAction(event -> {
            try {
                DBconnection.updateItemID(Integer.parseInt(idText.getText()), Integer.parseInt(getFörstaItemID()));
            } catch (SQLException e) {
                showAllert(e.getMessage());
                throw new RuntimeException(e);
            }
        });
        TitleSave.setOnAction(event -> {
            try {
                DBconnection.updateItemTitle(titleText.getText(), Integer.parseInt(getFörstaItemID()));
            } catch (SQLException e) {
                showAllert(e.getMessage());
                throw new RuntimeException(e);
            }
        });
        isbnSave.setOnAction(event -> {
            try {
                DBconnection.updateItemISBN(isbnText.getText(), Integer.parseInt(getFörstaItemID()));
            } catch (SQLException e) {
                showAllert(e.getMessage());
                throw new RuntimeException(e);
            }
        });
        barcodeSave.setOnAction(event -> {
            try {
                DBconnection.updateBarcode(barcodeText.getText(), Integer.parseInt(getFörstaItemID()));
            } catch (SQLException e) {
                showAllert(e.getMessage());
                throw new RuntimeException(e);
            }
        });
        locationSave.setOnAction(event -> {
            try {
                DBconnection.updateLocation(locationText.getText(), Integer.parseInt(getFörstaItemID()));
            } catch (SQLException e) {
                showAllert(e.getMessage());
                throw new RuntimeException(e);
            }
        });
        descriptionSave.setOnAction(event -> {
            try {
                DBconnection.updateDescription(descriptionText.getText(), Integer.parseInt(getFörstaItemID()));
            } catch (SQLException e) {
                showAllert(e.getMessage());
                throw new RuntimeException(e);
            }
        });
        itemtypeSave.setOnAction(event -> {
            try {
                DBconnection.updateItemType(itemtypeText.getText(), Integer.parseInt(getFörstaItemID()));
            } catch (SQLException e) {
                showAllert(e.getMessage());
                throw new RuntimeException(e);
            }
        });
        renttimeSave.setOnAction(event -> {
            try {
                DBconnection.updateRentTimeWeeks(renttimeText.getText(), Integer.parseInt(getFörstaItemID()));
            } catch (SQLException e) {
                showAllert(e.getMessage());
                throw new RuntimeException(e);
            }
        });
        itemstatusSave.setOnAction(event -> {
            try {
                DBconnection.updateItemStatus(itemstatusText.getText(), Integer.parseInt(getFörstaItemID()));
            } catch (SQLException e) {
                showAllert(e.getMessage());
                throw new RuntimeException(e);
            }
        });
        Återställ.setOnAction(event -> {
            resetToDefault();
        });
        tillbaka.setOnAction(event -> {
            try {
                bytSida("läggtill.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }
    private void showAllert(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("SQL Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    private void resetToDefault() {
        idText.setText(bok.getItemID());
        titleText.setText(bok.getNamn());
        isbnText.setText(bok.getISBN());
        barcodeText.setText(bok.getBarcode());
        locationText.setText(bok.getLocation());
        descriptionText.setText(bok.getDescription());
        itemtypeText.setText(bok.getItemtype());
        itemstatusText.setText(bok.getItemstatus());
        renttimeText.setText(bok.getRenttime());
    }


}
