package com.example.testafinarejava2;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import java.io.FileNotFoundException;
import java.io.IOException;

abstract class ControllerController {
    @FXML
    private Label bibliotek;




    public Label inloggadFrågetecken(Label användare, Label inloggadsom, Label loggain) {
        SessionManager session = new SessionManager();
        if (SessionManager.isAuthenticated()) {
            try {
                användare.setText(session.getUserName());
                användare.setOpacity(1);
                inloggadsom.setOpacity(1);
                inloggadsom.translateXProperty().set(-50);
                loggain.setOpacity(0);
                loggain.setDisable(true);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
        return null;
    }




    private Scene scene() {
        return bibliotek.getScene();
    }

    public Label sättEditBooksKnapp() {
        Label label = new Label("Edit books");
        label.setOpacity(1);
        label.setStyle("-fx-text-fill: #000000; -fx-font-size: 20px; -fx-font-weight: bold; -fx-cursor: hand; -fx-padding: 0 10 0 0;");
        label.setOnMouseClicked(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("läggtill.fxml"));
                Parent root = loader.load();
                Scene currentScene = bibliotek.getScene();
                currentScene.setRoot(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return label;
    }
   public void hem() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("startsidan.fxml"));
        Parent root = loader.load();
        Scene currentScene = bibliotek.getScene();
        currentScene.setRoot(root);
   }
   public void loggaIn() throws IOException {
       if (!SessionManager.isAuthenticated()) {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("logainwalla.fxml"));
           Parent root = loader.load();
           Scene currentScene = bibliotek.getScene();
           currentScene.setRoot(root);
       }


   }
   public void loggaUt() throws IOException {
       if (SessionManager.isAuthenticated()) {
           SessionManager.logout();
           FXMLLoader loader = new FXMLLoader(getClass().getResource("startsidan.fxml"));
           Parent root = loader.load();
           Scene currentScene = bibliotek.getScene();
           currentScene.setRoot(root);
       }
   }
   public void sökResultat(String s) throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("sökresultat.fxml"));
       Parent root = loader.load();
       SökresultatController controller = loader.getController();
       controller.setSöktext(s);
       Scene currentScene = bibliotek.getScene();
       currentScene.setRoot(root);
   }
   public void bytSida(String s) throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource(s));
       Parent root = loader.load();
       Scene currentScene = bibliotek.getScene();
       currentScene.setRoot(root);
   }


}
