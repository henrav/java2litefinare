package com.example.testafinarejava2.Controllers;

import com.example.testafinarejava2.Driver.DBconnection;
import com.example.testafinarejava2.Entities.Bok;
import com.example.testafinarejava2.Driver.SessionManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class LånasidanController extends ControllerController implements Initializable {
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
    private ImageView bildpåboken;
    @FXML
    private Button Låna;
    @FXML
    private Button Reservera;
    @FXML
    private Label författarnamn;
    @FXML
    private Label ISBN;
    @FXML
    private Label BokensNamn;
    @FXML
    private GridPane topgrid;
    @FXML
    private Label bibliotek;
    private Bok bok;



    public void initialize(URL url, ResourceBundle resourceBundle) {
        inloggadFrågetecken(användare,inloggadsom,loggain);
    }

    @FXML
    public void sökResultat(ActionEvent actionEvent) throws IOException {
        sökResultat(söktext.getText());
    }



    @FXML
    public void lånaKnappen(ActionEvent actionEvent) throws IOException, SQLException {
        if (SessionManager.getUser_ID() == null){
            errorBox("Du måste logga in för att låna böcker");
        }else {
            try{
                lånaKnappenLåna();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("låna.fxml"));
                Parent root = loader.load();
                Scene currentscene = Låna.getScene();
                currentscene.setRoot(root);
                LånaController controller = loader.getController();
                controller.setBok(bok);

            } catch (SQLException e) {
                e.printStackTrace();
                errorBox(e.getMessage());
            }

        }

    }

    @FXML
    public void reserveraKnappen(ActionEvent actionEvent) {
    }

    public void getBokInfo(Bok bok) {
        författarnamn.setText(bok.getAuthor().getFirstName());
        ISBN.setText(bok.getISBN());
        BokensNamn.setText(bok.getNamn());
        this.bok = bok;
    }
    private void lånaKnappenLåna() throws SQLException, IOException {
        DBconnection.connect();
        String sql = "CALL låna_final(?,?)";
        PreparedStatement ps = DBconnection.prepareStatement(sql);
        ps.setInt(1, parseInt(SessionManager.getUser_ID()));
        ps.setString(2, bok.getNamn());
        ps.execute();
        DBconnection.close();
    }

    private void errorBox(String error){
        Alert erroralert = new Alert(Alert.AlertType.ERROR,error , ButtonType.OK);
        erroralert.showAndWait();
    }




}
