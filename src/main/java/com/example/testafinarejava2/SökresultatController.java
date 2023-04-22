package com.example.testafinarejava2;
import com.example.testafinarejava2.ControllerController;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SökresultatController extends ControllerController implements Initializable {
    @FXML
    private Label sakensnamn1;
    @FXML
    private Label sakensnamn2;
    @FXML
    private Label sakensnamn3;
    @FXML
    private Label sakensnamn4;
    @FXML
    private Label sakensnamn5;
    @FXML
    private Button låna1;
    @FXML
    private Button låna2;
    @FXML
    private Button låna3;
    @FXML
    private Button låna4;
    @FXML
    private Button låna5;
    @FXML
    private Label författare1;
    @FXML
    private Label visarresultat;
    @FXML
    private Label författare2;
    @FXML
    private Label författare3;
    @FXML
    private Label författare4;
    @FXML
    private Label författare5;
    @FXML
    private Button sökknapp1;
    @FXML
    private TextField söktext1;
    private List<Label> författareLabels = new ArrayList();
    private List<Label> sakensnamn = new ArrayList();
    private List<Button> lånaKnappar = new ArrayList();
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
    private GridPane topgrid;
    @FXML
    private TextField söktext;
    @FXML
    private Button sökknapp;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inloggadFrågetecken(användare, inloggadsom, loggain);


        författareLabels.add(författare1);
        författareLabels.add(författare2);
        författareLabels.add(författare3);
        författareLabels.add(författare4);
        författareLabels.add(författare5);

        sakensnamn.add(sakensnamn1);
        sakensnamn.add(sakensnamn2);
        sakensnamn.add(sakensnamn3);
        sakensnamn.add(sakensnamn4);
        sakensnamn.add(sakensnamn5);
        lånaKnappar.add(låna1);
        lånaKnappar.add(låna2);
        lånaKnappar.add(låna3);
        lånaKnappar.add(låna4);
        lånaKnappar.add(låna5);
        removeLastSearch();

    }


    private void removeLastSearch() {
        for (Label författare : författareLabels) {
            författare.setVisible(false);
            författare.setDisable(true);
        }
        for (Label sakensnamn : sakensnamn) {
            sakensnamn.setVisible(false);
            sakensnamn.setDisable(true);
        }
        for (Button låna : lånaKnappar) {
            låna.setVisible(false);
            låna.setDisable(true);
        }
    }


    @FXML
    public void sökNågot(ActionEvent actionEvent) {
        try{

            removeLastSearch();
            DBconnection.connect();
            söktext.setOpacity(0);
            sökknapp.setOpacity(0);
            söktext.setDisable(true);
            sökknapp.setDisable(true);

            String sql = "SELECT ISBN, MIN(Title) as Title, MIN(First_Name) as First_Name FROM sys.Item JOIN Item_Author ON Item_Author.Item_ID = Item.Item_ID JOIN Author on Author.Author_ID = Item_Author.Author_ID WHERE Title LIKE '%"+söktext1.getText()+"%' GROUP BY ISBN";
            ResultSet result = DBconnection.executeQuery(sql);

            if (!result.next()){
                visarresultat.setText("Inga resultat");
                visarresultat.translateXProperty().set(50);
            }else{
                visarresultat.setText(söktext1.getText());

            }

            sättResultat(result, sakensnamn);
            DBconnection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Deprecated
    private void sättResultat(ResultSet resultat, List<Label> labels) throws SQLException {
        int i = 0;
        while (resultat.next() && i < labels.size()) {
            Bok bok = new Bok();
            Author author = new Author();
            author.setFirstName(resultat.getString("First_Name"));
            bok.setAuthor(author);
            bok.setNamn(resultat.getString("Title"));
            bok.setISBN(resultat.getString("ISBN"));
            labels.get(i).setText(bok.getNamn());
            labels.get(i).setVisible(true);
            labels.get(i).setDisable(false);
            författareLabels.get(i).setText(bok.getAuthor().getFirstName());
            lånaKnappar.get(i).setVisible(true);
            lånaKnappar.get(i).setDisable(false);
            författareLabels.get(i).setVisible(true);
            författareLabels.get(i).setDisable(false);

            lånaKnappar.get(i).setOnAction(e -> {
                try{
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("lånasidan.fxml"));
                    Parent root = loader.load();
                    LånasidanController controller = loader.getController();
                    controller.getBokInfo(bok);
                    Scene currentScene = loggain.getScene();
                    currentScene.setRoot(root);

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });

            labels.get(i).setTooltip(new Tooltip(bok.getNamn()));
            i++;
        }
    }
    @FXML
    public void loggaIn(ActionEvent actionEvent) throws IOException {
        loggaIn(loggain.getScene());
    }

    @FXML
    private void hemKnapp() throws IOException {
        hemKnapp(bibliotek.getScene());
    }
    public void setSöktext(String text){
        söktext1.setText(text);
        sökknapp1.fire();
    }
    public void loggaUtSak(MouseEvent mouseEvent) throws IOException {
        loggaUt(loggain.getScene());
    }


    @FXML
    public void loggaUtSak(Event event) {
    }
}
