package com.example.testafinarejava2.Controllers;

import com.example.testafinarejava2.Driver.SessionManager;
import com.example.testafinarejava2.Entities.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LogainwallaController extends ControllerController implements Initializable {
    @FXML
    private AnchorPane ankare;
    @FXML
    private GridPane grid;
    @FXML
    private TextField användarnamn;
    @FXML
    private PasswordField lösenord;
    @FXML
    private Button loggain;
    @FXML
    private Button glömt;
    @FXML
    private Button registrera;
    @FXML
    private GridPane xd;
    @FXML
    private Button startsida;
    @FXML
    private Label bibliotek;

    @FXML
    public void loggaInWalla(ActionEvent actionEvent) throws IOException, SQLException {
        String användarnamn = this.användarnamn.getText();
        String lösenord = this.lösenord.getText();
        User user = new User();
        user.setUsername(användarnamn);
        user.setPassword(lösenord);
        if (SessionManager.login(user)) {
            System.out.println("Du är inloggad");
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Startsidan.fxml"));
            Parent root = fxmlLoader.load();
            Scene currentScene = loggain.getScene();
            currentScene.setRoot(root);
        } else {
            Label label = new Label("Fel användarnamn eller lösenord");
            xd.add(label, 1, 1);
            label.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");
            label.setUnderline(true);
            label.setAlignment(javafx.geometry.Pos.CENTER);
            System.out.println("Du är inte inloggad");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        startsida.setOnAction(event -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Startsidan.fxml"));
                Parent root = fxmlLoader.load();
                Scene currentScene = startsida.getScene();
                currentScene.setRoot(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }



}
