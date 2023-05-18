package com.example.testafinarejava2.Controllers;

import com.example.testafinarejava2.Driver.DBconnection;
import com.example.testafinarejava2.Entities.Author;
import com.example.testafinarejava2.Entities.Bok;
import com.example.testafinarejava2.Entities.BokAuthorRow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class LäggtillController extends ControllerController implements Initializable {
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
    private BokAuthorRow bokAuthorRow;
    @FXML
    private TableView<Object> table;
    @FXML
    private TableColumn<BokAuthorRow, String> Item_ID;
    @FXML
    private TableColumn<BokAuthorRow, String> Title;
    @FXML
    private TableColumn<BokAuthorRow, String> ISBN;
    @FXML
    private TableColumn<BokAuthorRow, String> Barcode;
    @FXML
    private TableColumn<BokAuthorRow, String> Location;
    @FXML
    private TableColumn<BokAuthorRow, String> Description;
    @FXML
    private TableColumn<BokAuthorRow, String> Item_Type;
    @FXML
    private TableColumn<BokAuthorRow, String> Rent_Time_Weeks;
    @FXML
    private TableColumn<BokAuthorRow, String> Item_Status;
    @FXML
    private TableColumn<BokAuthorRow, String> Author_FirstName;
    @FXML
    private TableColumn<BokAuthorRow, String> Author_LastName;
    @FXML
    private GridPane topgrid;


    @FXML
    public void sökResultat(ActionEvent actionEvent) throws IOException {
        sökResultat(söktext.getText());
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inloggadFrågetecken(användare, inloggadsom, loggain);
        Item_ID.setCellValueFactory(new PropertyValueFactory<>("ItemID"));
        Title.setCellValueFactory(new PropertyValueFactory<>("namn"));
        ISBN.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
        Barcode.setCellValueFactory(new PropertyValueFactory<>("Barcode"));
        Location.setCellValueFactory(new PropertyValueFactory<>("Location"));
        Description.setCellValueFactory(new PropertyValueFactory<>("description"));
        Item_Type.setCellValueFactory(new PropertyValueFactory<>("Itemtype"));
        Rent_Time_Weeks.setCellValueFactory(new PropertyValueFactory<>("Renttime"));
        Item_Status.setCellValueFactory(new PropertyValueFactory<>("Itemstatus"));
        Author_FirstName.setCellValueFactory(new PropertyValueFactory<>("AuthorFirstName"));
        Author_LastName.setCellValueFactory(new PropertyValueFactory<>("AuthorLastName"));



        table.setItems(FXCollections.observableArrayList());
        sättAllData();
        läggTillKnappTillRad();
    }

    public void sättAllData() {
        try {
            DBconnection.connect();
            String sql = "SELECT Item.Item_ID, Title, ISBN, Barcode, Location, Item.Description, Item_Type, Rent_Time_Weeks, Item_Status, Author.Author_ID, First_Name, Last_Name, Date_Of_Birth, Author.Description FROM sys.Item JOIN Item_Author on Item.Item_ID = Item_Author.Item_ID JOIN Author ON Author.Author_ID = Item_Author.Author_ID";
            ResultSet rs = DBconnection.executeQuery(sql);
            ObservableList<Object> items = FXCollections.observableArrayList();
            int i = 0;
            while (rs.next() && i < 50) {
                Bok bok = new Bok();
                Author author = new Author();
                bok.setAuthor(author);
                bok.setItemID(rs.getString("Item_ID"));
                bok.setNamn(rs.getString("Title"));
                bok.setISBN(rs.getString("ISBN"));
                bok.setBarcode(rs.getString("Barcode"));
                bok.setLocation(rs.getString("Location"));
                bok.setDescription(rs.getString("Item.Description"));
                bok.setItemtype(rs.getString("Item_Type"));
                bok.setRenttime(rs.getString("Rent_Time_Weeks"));
                bok.setItemstatus(rs.getString("Item_Status"));
                author.setFirstName(rs.getString("First_Name"));
                author.setLastName(rs.getString("Last_Name"));
                author.setDOB(rs.getString("Date_Of_Birth"));
                author.setDescription(rs.getString("Author.Description"));
                BokAuthorRow bokAuthorRow = new BokAuthorRow(bok, author);
                table.getItems().add(bokAuthorRow);


            }
            //vill lägga till knappar för varje rad i tabellen
            this.bokAuthorRow = bokAuthorRow;
            DBconnection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("Edit.fxml"));
                            Parent root = null;
                            try {
                                root = loader.load();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            Scene currentScene = bibliotek.getScene();
                            currentScene.setRoot(root);

                            EditController editController = loader.getController();
                            editController.setItemData((BokAuthorRow) SelectedItem);


                            System.out.println("selectedData: ");
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


}


