package com.example.testafinarejava2.Controllers;

import com.example.testafinarejava2.Driver.DBconnection;
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
import java.util.ArrayList;
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
    private String personensid;
    @FXML
    private Label status2;
    @FXML
    private Label status3;
    @FXML
    private Label status4;
    @FXML
    private Label status5;
    private List<Label> bokensNamn = new ArrayList<>();
    private List<Label> status = new ArrayList<>();
    private List<Button> tillbakaLämnad = new ArrayList<>();


    @FXML
    public void sök(ActionEvent actionEvent) throws IOException {
        sökResultat(söktext.getText());

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inloggadFrågetecken(användare,inloggadsom,loggain);
        initInitialize();

        tillbaka.setOnAction(e -> {
            try {
                bytSida("inteTillbakaLämnade.fxml");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    public void sättData(String kundID) throws SQLException {
        DBconnection.connect();
        String sql = "SELECT concat(First_Name, ' ', Last_Name) as Namn, Item.Title, Status FROM User Join Checkout on User.User_ID = Checkout.Patron_ID Join Item_Checkout on Checkout.Checkout_ID = Item_Checkout.Checkout_ID Join Item on Item_Checkout.Item_ID = Item.Item_ID WHERE User.User_ID = '" + kundID + "'Limit 5;";
        ResultSet rs = DBconnection.executeQuery(sql);
        visaEndastSåMånga(rs);
        DBconnection.close();

    }

    public void visaEndastSåMånga(ResultSet rs){
        int i = 0;
        try {
            while (rs.next()) {
                bokensNamn.get(i).setText(rs.getString("Item.Title"));
                bokensNamn.get(i).setDisable(false);
                bokensNamn.get(i).setVisible(true);
                status.get(i).setText(rs.getString("Status"));
                status.get(i).setDisable(false);
                status.get(i).setVisible(true);
                tillbakaLämnad.get(i).setDisable(false);
                tillbakaLämnad.get(i).setVisible(true);
                i++;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void initInitialize(){
        bokensNamn.add(bokensNamn1);
        bokensNamn.add(bokensNamn2);
        bokensNamn.add(bokensNamn3);
        bokensNamn.add(bokensNamn4);
        bokensNamn.add(bokensNamn5);
        status.add(status1);
        status.add(status2);
        status.add(status3);
        status.add(status4);
        status.add(status5);
        tillbakaLämnad.add(tillbakaLämnad1);
        tillbakaLämnad.add(tillbakaLämnad2);
        tillbakaLämnad.add(tillbakaLämnad3);
        tillbakaLämnad.add(tillbakaLämnad4);
        tillbakaLämnad.add(tillbakaLämnad5);


        for (int i = 0; i < bokensNamn.size(); i++) {
            bokensNamn.get(i).setDisable(true);
            bokensNamn.get(i).setVisible(false);
            status.get(i).setDisable(true);
            status.get(i).setVisible(false);
            tillbakaLämnad.get(i).setDisable(true);
            tillbakaLämnad.get(i).setVisible(false);

        }
    }

}


