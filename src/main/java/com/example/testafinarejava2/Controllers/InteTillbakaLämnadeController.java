package com.example.testafinarejava2.Controllers;

import com.example.testafinarejava2.Driver.DBconnection;
import com.example.testafinarejava2.Entities.KundBok;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class InteTillbakaLämnadeController extends ControllerController implements Initializable {


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
    private KundBok kundBok;
    @FXML
    private Label loggautsak;
    @FXML
    private Label användare;
    @FXML
    private Label inloggadsom;
    @FXML
    private TableView<Object> table;
    @FXML
    private TableColumn<KundBok, String> Item_ID;
    @FXML
    private TableColumn<KundBok, String> Title;
    @FXML
    private TableColumn<KundBok, String> inlämningsdatum;
    @FXML
    private TableColumn<KundBok, String> datumuthyrd;
    @FXML
    private TableColumn<KundBok, String> kundid;
    @FXML
    private TableColumn<KundBok, String> kundensNamn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inloggadFrågetecken(användare,inloggadsom,loggain);
        Item_ID.setCellValueFactory(new PropertyValueFactory<>("ItemID"));
        Title.setCellValueFactory(new PropertyValueFactory<>("Title"));
        inlämningsdatum.setCellValueFactory(new PropertyValueFactory<>("inlämningsdatum"));
        datumuthyrd.setCellValueFactory(new PropertyValueFactory<>("datumuthyrd"));
        kundid.setCellValueFactory(new PropertyValueFactory<>("kundid"));
        kundensNamn.setCellValueFactory(new PropertyValueFactory<>("kundensNamn"));
        table.setItems(FXCollections.observableArrayList());

        try {
            setAllData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        läggTillKnappTillRad();

    }

    public void setAllData() throws SQLException {
        DBconnection.connect();
        String sql = "SELECT Title, IC.Item_ID, Checkout_Date ,@Due_Date := Checkout_Date + INTERVAL Item.Rent_Time_Weeks WEEK as Due_Date , concat(First_Name, ' ',Last_Name) as Namn, User_ID FROM Checkout join Item_Checkout IC on Checkout.Checkout_ID = IC.Checkout_ID join Item on IC.Item_ID = Item.Item_ID join User on Checkout.Patron_ID = User.User_ID\n" +
                "where Return_Date IS NULL And  Due_Date < CURDATE()";
        ResultSet rs = DBconnection.executeQuery(sql);
        while (rs.next()) {
            KundBok kundBok = new KundBok();
            kundBok.setTitle(rs.getString("Title"));
            kundBok.setItemID(rs.getString("Item_ID"));
            kundBok.setDatumuthyrd(rs.getString("Checkout_Date"));
            kundBok.setInlämningsdatum(rs.getString("Due_Date"));
            kundBok.setKundid(rs.getString("User_ID"));
            kundBok.setKundensNamn(rs.getString("Namn"));
            table.getItems().add(kundBok);
        }
        DBconnection.close();


    }
    public void läggTillKnappTillRad() {
        TableColumn<Object, Button> colKnapp = new TableColumn<>("Knapp");
        Callback<TableColumn<Object, Button>, TableCell<Object, Button>> cellFactory = new Callback<TableColumn<Object, Button>, TableCell<Object, Button>>() {
            @Override
            public TableCell<Object, Button> call(TableColumn<Object, Button> itemVoidTableColumn) {
                TableCell<Object, Button> cell = new TableCell<Object, Button>() {
                    private final Button btn = new Button("Edit");


                    {
                        btn.setOnAction((ActionEvent event) -> {
                            Object SelectedItem = getTableView().getItems().get(getIndex());
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("BibliotekarieLämnaTillbaka.fxml"));
                            Parent root = null;
                            try {
                                root = loader.load();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            Scene currentScene = bibliotek.getScene();
                            currentScene.setRoot(root);
                            BibliotekarieLämnaTillbakaController controller = loader.getController();
                            KundBok kundBok = (KundBok) SelectedItem;
                            try {
                                controller.sättData(kundBok.getKundid());
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            }


                            //InteTillbakaLämnadeController controller = loader.getController();
                            //controller.setKundBok((KundBok) SelectedItem);

                        });
                    }

                    @Override
                    protected void updateItem(Button item, boolean empty) {

                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };
        colKnapp.setCellFactory(cellFactory);
        table.getColumns().add(colKnapp);
    }


    @FXML
    public void sökResultat(ActionEvent actionEvent) throws IOException {
        sökResultat(söktext.getText());
    }


}
