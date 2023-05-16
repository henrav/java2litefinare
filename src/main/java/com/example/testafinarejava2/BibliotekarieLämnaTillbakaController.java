package com.example.testafinarejava2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class BibliotekarieLämnaTillbakaController extends ControllerController implements Initializable {

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
    private ImageView bildPåKunden;
    @FXML
    private Button tillbaka;
    @FXML
    private Label KundensNamn;
    @FXML
    private Label LånHistorik;
    @FXML
    private Label bokensNamn1;
    @FXML
    private Label bokensNamn2;
    @FXML
    private Label bokensNamn4;
    @FXML
    private Label bokensNamn3;
    @FXML
    private Label bokensNamn5;
    @FXML
    private Label status1;
    @FXML
    private Button tillbakaLämnad1;
    @FXML
    private Button tillbakaLämnad2;
    @FXML
    private Button tillbakaLämnad3;
    @FXML
    private Button tillbakaLämnad4;
    @FXML
    private Button tillbakaLämnad5;
    @FXML
    private Label status2;
    @FXML
    private Label status3;
    @FXML
    private Label status4;
    @FXML
    private Label status5;
    private final List<Label> bokensNamn = List.of(bokensNamn1, bokensNamn2, bokensNamn3, bokensNamn4, bokensNamn5);
    private final List<Label> status = List.of(status1, status2, status3, status4, status5);


    @FXML
    public void sök(ActionEvent actionEvent) throws IOException {
        sökResultat(söktext.getText());

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inloggadFrågetecken(användare,inloggadsom,loggain);
        tillbaka.setOnAction(e -> {
            try {
                bytSida("inteTillbakaLämnade.fxml");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        try {
            sättData("1");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void sättData(String kundID) throws SQLException {
        DBconnection.connect();
        String sql = "SELECT concat(First_Name, ' ', Last_Name) as Namn, Item.Title, Status FROM User Join Checkout on User.User_ID = Checkout.Patron_ID Join Item_Checkout on Checkout.Checkout_ID = Item_Checkout.Checkout_ID Join Item on Item_Checkout.Item_ID = Item.Item_ID WHERE User.User_ID = " + kundID;
        ResultSet rs = DBconnection.executeQuery(sql);
        KundensNamn.setText(rs.getString("Namn"));
        int i = 1;
        while (rs.next()){
            bokensNamn.get(i).setText(rs.getString("Title"));
            status.get(i).setText(rs.getString("Status"));
            i++;
        }


    }
}


