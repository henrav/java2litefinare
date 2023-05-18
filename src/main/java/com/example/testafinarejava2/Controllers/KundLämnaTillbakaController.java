package com.example.testafinarejava2.Controllers;

import com.example.testafinarejava2.Driver.DBconnection;
import com.example.testafinarejava2.Driver.SessionManager;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class KundLämnaTillbakaController extends ControllerController implements Initializable {

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
    private String kundID;
    private List<Label> boknam;
    private List<Label> status;
    private List<Button> tillbakaLämnad;
    private List<Integer> itemID;

    @FXML
    public void sök(ActionEvent actionEvent) throws IOException {
        sökResultat(söktext.getText());
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inloggadFrågetecken(användare, inloggadsom, loggain);
        initInitialize();
        try {
            setKundID();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            setData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        tillbaka.setOnAction(event -> {
            try {
                bytSida("startsidan.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void setData() throws SQLException {
        DBconnection.connect();
        String sql = "SELECT concat(First_Name, ' ', Last_Name) as Namn, Item.Item_ID, Item.Title, Status FROM User Join Checkout on User.User_ID = Checkout.Patron_ID Join Item_Checkout on Checkout.Checkout_ID = Item_Checkout.Checkout_ID Join Item on Item_Checkout.Item_ID = Item.Item_ID WHERE User.User_ID = '" + kundID + "'ORDER BY Checkout_Date DESC LIMIT 5";
        ResultSet rs = DBconnection.executeQuery(sql);
        addUserDetails(rs);
        DBconnection.close();
    }
    public void initInitialize(){
        boknam = new ArrayList<>();
        status = new ArrayList<>();
        tillbakaLämnad = new ArrayList<>();
        itemID = new ArrayList<>();
        boknam.add(bokensNamn1);
        boknam.add(bokensNamn2);
        boknam.add(bokensNamn3);
        boknam.add(bokensNamn4);
        boknam.add(bokensNamn5);
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

        for (int i = 0; i < 5; i++) {
            boknam.get(i).setVisible(false);
            boknam.get(i).setDisable(true);
            status.get(i).setVisible(false);
            status.get(i).setDisable(true);
            tillbakaLämnad.get(i).setVisible(false);
            tillbakaLämnad.get(i).setDisable(true);

        }
    }
    private void addUserDetails(ResultSet rs) throws SQLException {
        int i = 0;
        while (rs.next()){
            itemID.add(rs.getInt("Item_ID"));
            KundensNamn.setText(rs.getString("Namn"));
            boknam.get(i).setText(rs.getString("Title"));
            boknam.get(i).setVisible(true);
            boknam.get(i).setDisable(false);
            status.get(i).setText(rs.getString("Status"));
            status.get(i).setVisible(true);
            status.get(i).setDisable(false);
            tillbakaLämnad.get(i).setVisible(true);
            tillbakaLämnad.get(i).setDisable(false);
            i++;
        }
        setKnappar();
    }

    private void setKundID() throws FileNotFoundException {
        this.kundID = SessionManager.getUser_ID();
    }
    private void lämnaTillbakaKnapp(Integer itemID) throws SQLException {
        DBconnection.connect();
        String sql = "UPDATE Checkout JOIN Item_Checkout ON Checkout.Checkout_ID = Item_Checkout.Checkout_ID SET Return_Date = CURRENT_DATE, Status = 0 WHERE Item_ID = '" + itemID + "' AND Patron_ID= '" + kundID + "' LIMIT 1;";
        DBconnection.executeUpdate(sql);
        String sql2 = "UPDATE Patron SET Items_Rented = Items_Rented - 1 WHERE Patron_ID = '" + kundID + "';";
        DBconnection.executeUpdate(sql2);
        DBconnection.close();

    }
    private void setKnappar(){
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            tillbakaLämnad.get(i).setOnAction(event -> {
                try {
                    lämnaTillbakaKnapp(itemID.get(finalI));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
        }
    }


}